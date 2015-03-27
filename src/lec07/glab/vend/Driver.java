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

    private static Scanner sScanner = new Scanner(System.in);

    public static void main(String[] args) {
        VendMachine vndMachine = new VendMachine();


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


        outer:
        while (true) {

            System.out.println("Type 'i' for insert coins or 's' for select product or type 'exit' to quit");
            String strInitial = sScanner.nextLine();
            strInitial = strInitial.toUpperCase();
            String strMoney, strSelect;
            switch (strInitial){
                case "I":
                  strMoney = addMoney();
                    vndMachine.insertCoins(strMoney);
                    System.out.println("Credits : " + vndMachine.howMuchInserted());
                  break;
                case "S":
                    System.out.println(vndMachine.showSelection());
                    strSelect = makeSelection();
                    if (strSelect.equalsIgnoreCase("AABBCC")){
                        ArrayList<Coin> conCashOuts = vndMachine.cashOut();
                        System.out.println("Jackpot!");
                        for (Coin conCashOut : conCashOuts) {
                            System.out.println(conCashOut);
                        }
                        break;
                    }
                    Product prdProduct = vndMachine.vend(strSelect);
                    if (prdProduct != null)
                        System.out.println("Thank you and Enjoy: " + prdProduct);
                    else {
                        System.out.print("You inserted " + vndMachine.howMuchInserted() + " : Insufficient coins or out of stock");
                        ArrayList<Coin> conReturns = vndMachine.returnCoins();
                        System.out.println(", here is your money back: ");
                        for (Coin conReturn : conReturns) {
                            System.out.println(conReturn);
                        }

                    }
                  break;
                case "EXIT":
                    break outer;
                default:
                  break;
            }

        }
        System.out.println("Thank you for vending");

    }

    private static String addMoney(){

        System.out.println("Insert Coins like so: q q d d n");
        return sScanner.nextLine().toUpperCase();

    }

    private static String makeSelection(){
        System.out.println("Please choose a product such as 'A2'");
        return sScanner.nextLine().toUpperCase();

    }


}
