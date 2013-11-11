package lec07.glab.vend;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/11/13
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class Driver {

    public static void main(String[] args) {
        VendMachine vndMachine = new VendMachine();
        Scanner scan = new Scanner(System.in);

        ArrayList<Product> prdProducts = new ArrayList<>();
        prdProducts.add(new Product("Heath", 0.75));
        prdProducts.add(new Product("PayDay", 0.75));
        prdProducts.add(new Product("Reces", 0.75));
        prdProducts.add(new Product("Pop Tart", 1.25));
        prdProducts.add(new Product("Marathon", 0.75));
        prdProducts.add(new Product("Almond Joy", 0.75));
        prdProducts.add(new Product("Hersheys", 0.75));
        prdProducts.add(new Product("Hersheys Dark", 0.75));
        prdProducts.add(new Product("Twizzlers", 0.50));
        vndMachine.stockMe(prdProducts);



        while (true) {

            System.out.println(vndMachine.showSelection());
            System.out.println("Insert Coins like so: q q d d n");

            String strCoin = scan.nextLine();
            vndMachine.insertCoins(strCoin);
            System.out.println("Credits : " + vndMachine.howMuchInserted());

            System.out.println("Please choose a product such as 'A2'");

            String strSelection = scan.nextLine();
            strSelection = strSelection.toUpperCase();

            if (strSelection.equalsIgnoreCase("AABBCC")){
                ArrayList<Coin> conCashOuts = vndMachine.cashOut();
                System.out.println("Jackpot!");
                for (Coin conCashOut : conCashOuts) {
                    System.out.println(conCashOut);
                }
                break;
            }

            Product prdProduct = vndMachine.vend(strSelection);
            if (prdProduct != null)
                System.out.println("Thank you and Enjoy: " + prdProduct);
            else {
                System.out.println("You inserted " + vndMachine.howMuchInserted() + " : Insufficient coins or out of stock, try again");
            }

        }
        System.out.println("Thank you for vending");

    }


}
