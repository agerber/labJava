package lec09.glab.morepatterns.chain;

import java.util.Scanner;
//https://www.journaldev.com/
public class ATMDispense {

    private DispenseChain c1;

    public ATMDispense() {
        // initialize the chain
        this.c1 = new Dollar50Dispenser();
        DispenseChain c2 = new Dollar20Dispenser();
        DispenseChain c3 = new Dollar10Dispenser();

        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

    public static void main(String[] args) {
        ATMDispense atmDispenser = new ATMDispense();
        while (true) {
            int amount = 0;
            System.out.println("Enter amount to dispense or type quit to cancel");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            if (amount % 10 != 0) {
                System.out.println("Amount should be in multiple of 10s.");
                return;
            }
            // process the request
            atmDispenser.c1.dispense(new Currency(amount));
        }

    }

}