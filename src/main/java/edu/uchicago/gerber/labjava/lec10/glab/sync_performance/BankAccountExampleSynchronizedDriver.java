package edu.uchicago.gerber.labjava.lec10.glab.sync_performance;

public class BankAccountExampleSynchronizedDriver {

    /**
     * @param args
     */
    public static void main(String[] args) {

        BankAccount bnk = new BankAccount();
        final double AMOUNT = 100.0;
        final int REPS = 100;
        final int THREADS = 100;

        long lStart = System.currentTimeMillis();

        Thread th1, th2;
        for (int nC = 0; nC < THREADS; nC++) {
            th1 = new Thread(new Depositer(bnk, AMOUNT, REPS));
            th2 = new Thread(new Withdrawer(bnk, AMOUNT, REPS));

            th1.start();
            th2.start();
            try {
                th1.join();
                th2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        long lEnd = System.currentTimeMillis();
        System.out.println(lEnd - lStart);

    }

}

class Depositer implements Runnable {

    private static final int DELAY = 1;
    private BankAccount bnk;
    private double dAmount;
    private int nCount;

    public Depositer(BankAccount bnk, double dAmount, int nCount) {
        super();
        this.bnk = bnk;
        this.dAmount = dAmount;
        this.nCount = nCount;
    }

    public void run() {

        try {
            for (int nC = 0; nC < nCount; nC++) {

                bnk.deposit(dAmount);
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException exp) {
            // TODO Auto-generated catch block
            exp.printStackTrace();
        }
    }

}

class BankAccount {

    private double dBalance;

    public BankAccount() {

        this.dBalance = 0;
    }


    /*
    Try removing the synchronized keyword from the signature of these methods and run the
    BankAccountExampleSynchronizedDriver example to see what will happen.
     */

    public synchronized void deposit(double dAmount) {
        System.out.print("Depositing " + dAmount);
        double dNewBal = getBalance() + dAmount;
        System.out.println(", the new balance is " + dNewBal);
        setBalance(dNewBal);
    }

    public synchronized void withdraw(double dAmount) {
        System.out.print("Withdrawing " + dAmount);
        double dNewBal = getBalance() - dAmount;
        System.out.println(", the new balance is " + dNewBal);
        setBalance(dNewBal);
    }


    public double getBalance() {
        return this.dBalance;
    }

    public void setBalance(double dBalance) {
        this.dBalance = dBalance;
    }


}

class Withdrawer implements Runnable {

    private static final int DELAY = 1;
    private BankAccount bnk;
    private double dAmount;
    private int nCount;

    public Withdrawer(BankAccount bnk, double dAmount, int nCount) {
        super();
        this.bnk = bnk;
        this.dAmount = dAmount;
        this.nCount = nCount;
    }

    public void run() {

        try {
            for (int nC = 0; nC < nCount; nC++) {

                bnk.withdraw(dAmount);
                Thread.sleep(DELAY);
            }
        } catch (InterruptedException exp) {
            // TODO Auto-generated catch block
            exp.printStackTrace();
        }
    }

}
