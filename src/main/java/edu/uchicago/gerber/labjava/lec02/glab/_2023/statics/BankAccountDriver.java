package edu.uchicago.gerber.labjava.lec02.glab._2023.statics;


public class BankAccountDriver{
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(45.52);
        System.out.println(account1);


        BankAccount account2 = new BankAccount(564654.87);
        System.out.println(account2);


        BankAccount account3 = new BankAccount(784.01);
        System.out.println(account3);

        //get the serial number of this class-objecct
        System.out.println("The next available accont-id is " + BankAccount.getNextSerialId());


    }
}

class BankAccount {

    private double value;
    // Instance variable to store the ID of this specific account
    private int serialId;


    // Static variable to keep track of the next available serial ID
    private static int nextSerialId = 1;


    public BankAccount(double value) {
        this.value = value;
        this.serialId = nextSerialId;
        nextSerialId++;  // Increment the static serial ID for the next account
    }

    public int getSerialId() {
        return serialId;
    }

    public static int getNextSerialId() {
        return nextSerialId;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "value=" + value +
                ", serialId=" + serialId +
                '}';
    }
}
