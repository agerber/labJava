package edu.uchicago.gerber.labjava.lec02.this_new_keywords;



public class TrackClassWide {
    public static void main(String[] args) {

        BankAccount bankAccount1 = new BankAccount("Adam", 25.12);
        BankAccount bankAccount2 = new BankAccount("Bobby", 35.12);
        BankAccount bankAccount3 = new BankAccount("Charlie", 45.12);

        System.out.println(BankAccount.numberOfAccounts);

    }




}



class BankAccount {
    private String accountName;
    private double balance;

    //static member to keep track of accounts
    public static int numberOfAccounts;

    //constant -- this is a good use of the .class object
    public static double OVERDRAFT_FEE = 50.00;


    public BankAccount(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
        numberOfAccounts++;
    }


    @Override
    public String toString() {
        return "BankAccount{" +
                "accountName='" + accountName + '\'' +
                ", balance=" + balance +
                '}' + "Overdraft Fee is " + OVERDRAFT_FEE;
    }
}
