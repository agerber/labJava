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

    //static member to keep track of accounts (Academic only).
    //there are better ways to do this, for example, using a singleton.
    //leave the .class-object alone, it's there to load the meta-data of the class pior to runtime

    public static int numberOfAccounts;


    public BankAccount(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
        numberOfAccounts++;
    }
}
