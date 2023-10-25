package edu.uchicago.gerber.labjava.lec10._02_classic.contention_sync_with_lock;

public class SynchronizedWithLockDriver {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(50); // Initial balance is 50

        // Depositor thread
        Thread depositor = new Thread(() -> {
            int count = 200;
            while (count-- > 0){
                account.deposit(1);
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
                account.withdraw(1);
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

 class BankAccount {

    private final Object lock = new Object();

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {

        synchronized (lock){
            balance += amount;
        }

        System.out.println("Deposited " + amount + ". Current balance: " + balance);
    }

    public void withdraw(double amount) {

        synchronized (lock){
            balance -= amount;
        }

        System.out.println("Withdrew " + amount + ". Current balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}
