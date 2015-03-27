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




    }





}
