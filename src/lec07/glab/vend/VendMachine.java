package lec07.glab.vend;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
//arbitrary rows, cols, slots
public enum Row {A,B,C,D,E};
public static final int COLS = 4; // 1,2,3,4
public static final int SLOTS = 10; //how deep

Map<String,Product[]> map;
ArrayList<Product> prdProducts;

private void initStock() {

prdProducts = new ArrayList<Product>();
prdProducts.add(new Product("Heath", 1.25));
prdProducts.add(new Product("PayDay", 1.25));
prdProducts.add(new Product("Pop Tart", 1.75));
...


map = new HashMap<>();


int nC = 0;
Product[] prdStocks;

//for each row
   //for each col
      //prdStocks = new Product[SLOTS];
      //if nC < prdProducts.size()
          //Product prdItem = prdProducts.get(nC++);
      //else
          //labelled break outer loop
      //for each slot 0-9
         //prdStocks[slot] = prdItem;
      //map.put(row+col, prdStocks ); //where row+col would resolve to something like "A1"



 */
public class VendMachine {

    //behaviors
    //stock
    //cash-out
    //vend
    //show products available
    private static DecimalFormat sDecimalFormat = new DecimalFormat("$0.00");

    //hold the vending machine's bank
    private ArrayList<Coin> mBanks;
    //hold user's money until vending
    private ArrayList<Coin> mPurchaseMoneys;

    private Map<String, Product[]> mapProducts;

    //arbitrary rows, cols, slots
    public static final int ROWS = 3;
    public static final int COLS = 3; // 1,2,3
    public static final int SLOTS = 3; //how deep


    public VendMachine() {
        mBanks = new ArrayList<>();
        mPurchaseMoneys = new ArrayList<>();

    }





}
