package edu.uchicago.gerber.labjava.lec10._03_util_concurrent.atomic;
import java.util.concurrent.atomic.AtomicLong;
class AtomicDouble {

    private AtomicLong bits;

    public AtomicDouble() {
        bits = new AtomicLong();
    }

    public AtomicDouble(double initialValue) {
        this();
        bits.set(Double.doubleToRawLongBits(initialValue));
    }

    public String getRawBitsAsString() {
        return String.valueOf(bits.get());
    }

    public final double get() {
        return Double.longBitsToDouble(bits.get());
    }

    public final void set(double newValue) {
        bits.set(Double.doubleToRawLongBits(newValue));
    }


    public final boolean compareAndSet(double expect, double update) {
        return bits.compareAndSet(Double.doubleToRawLongBits(expect), Double.doubleToRawLongBits(update));
    }

    public boolean add(double delta) {
        while (true) {
            double current = get();
            double next = current + delta;
            if (compareAndSet(current, next)) {
                return true;
            }
        }
    }
}
public class AtomicBankAccount {

    //Gerber's custom AtomicDouble
    private AtomicDouble balance;


    public AtomicBankAccount(double initialBalance) {
        balance = new AtomicDouble(initialBalance);
    }

    public void deposit(double amount) {
        balance.add(amount);
        System.out.println("Deposited " + amount + ". Current balance: "  + balance.get() +  " Raw bits " + balance.getRawBitsAsString());
    }

    public void withdraw(double amount) {
        balance.add(-amount);
        System.out.println("Withdrew " + amount + ". Current balance: "  + balance.get() +  " Raw bits " + balance.getRawBitsAsString());
    }

    public double getBalance() {
        return balance.get();
    }

    public static void main(String[] args) {
        AtomicBankAccount account = new AtomicBankAccount(50.0);
        // Depositor thread
        Thread depositor = new Thread(() -> {
            int count = 200;
            while (count-- > 0){
                account.deposit(1.0);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Withdrawer thread
        Thread withdrawer = new Thread(() -> {
            int count = 200;
            while (count-- > 0){
                account.withdraw(1.0);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        depositor.start();
        withdrawer.start();

        try {
            depositor.join();
            withdrawer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final account balance: " + account.getBalance());
    }
}
