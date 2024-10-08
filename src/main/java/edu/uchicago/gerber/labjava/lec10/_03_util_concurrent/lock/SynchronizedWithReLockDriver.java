package edu.uchicago.gerber.labjava.lec10._03_util_concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedWithReLockDriver {

    public static void main(String[] args) {

        final ReentrantLock lock = new ReentrantLock();
        BankAccount account = new BankAccount(50, lock); // Initial balance is 50

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
        }, "depositor");

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
        }, "withdrawer");

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

    private double balance;
    private ReentrantLock lock;

    public BankAccount(double balance, ReentrantLock lock) {
        this.balance = balance;
        this.lock = lock;

    }
    public void deposit(double amount) {
        lock.lock();
        try {
            System.out.print(Thread.currentThread().getName() + " holds this lock : ");
            System.out.println("ContentionQueue length -> " + lock.getQueueLength());
            System.out.println("Fair?  -> " + lock.isFair());
            System.out.println("Held by current thread?  -> " + lock.isHeldByCurrentThread());

            balance += amount;
            System.out.println("Deposited " + amount + ". Current balance: " + balance);
        } finally {
            lock.unlock();
        }


    }

    public void withdraw(double amount) {
        lock.lock();

        try {
            balance -= amount;
            System.out.println("Withdrew " + amount + ". Current balance: " + balance);
        } finally {
            lock.unlock();
        }



    }

    public double getBalance() {
        return balance;
    }
}
