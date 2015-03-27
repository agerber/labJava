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

    public void stockMe(ArrayList<Product> prdProducts){

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


        mapProducts = new TreeMap<>();


        int nCounter = 0;
        Product[] prdStocks;
        Product prdItem;

        outerloop:
        for (int nR = 0; nR < ROWS ; nR++) {
            for (int nC = 0; nC < COLS ; nC++) {
                prdStocks = new Product[SLOTS];

                if (nCounter < prdProducts.size()){
                    prdItem = prdProducts.get(nCounter++);
                } else {
                    break outerloop;
                }
                for (int nS = 0; nS < SLOTS ; nS++) {
                    prdStocks[nS] = prdItem;
                }
                mapProducts.put(getProperId(nR, nC), prdStocks);

            }

        }




    }


    public String showSelection(){
        StringBuilder stb = new StringBuilder();
        Product[] prdProducts;
        for (String strKey : mapProducts.keySet()) {
            prdProducts =  mapProducts.get(strKey);
            stb.append(strKey + " : ");
            boolean bOutStock = true; //assume it's out of stock
            for (Product prdProduct : prdProducts) {
               if (prdProduct != null){
                   bOutStock = false;
                   stb.append(prdProduct.toString());
                   stb.append("\n");
                   break;
               }

            }
            if (bOutStock){
                stb.append("Out of Stock");
                stb.append("\n");
            }

        }
        stb.append("Credits : " + howMuchInserted() + "\n");
        return stb.toString();

    }

    public void insertCoins(ArrayList<Coin> conPassed){
            for (Coin con : conPassed) {
                 mPurchaseMoneys.add(con);
            }


    }

    public void insertCoins(String strCoinValue){
        ArrayList<Coin> conCoins = new ArrayList<>();

        String[] strCoins = strCoinValue.split(" ");
        for (String strCoin : strCoins) {
             mPurchaseMoneys.add(new Coin(strCoin));
        }
        insertCoins(conCoins);
    }

    private double getFunds(){
        double dReturn = 0.0;
        for (Coin conMoney : mPurchaseMoneys) {
            dReturn += conMoney.getValue();
        }
        return dReturn;
    }

    public String howMuchInserted(){
        double dReturn = 0.0;
        for (Coin purchaseMoney : mPurchaseMoneys) {
            dReturn += purchaseMoney.getValue();
        }

        return sDecimalFormat.format(dReturn);
    }


    public Product vend(String strKey){

        Product prdReturn = null;

        Product[] prdProds = mapProducts.get(strKey);
        if (prdProds == null){
            return prdReturn;
        }

        for (int nC = 0; nC <prdProds.length ; nC++) {
            if(prdProds[nC] != null){
               if (getFunds() >= prdProds[nC].getPrice()){
                   transferFunds();
                   prdReturn =   prdProds[nC];
                   prdProds[nC] = null;
               }
               break;
            }
        }

        return prdReturn;


        //get the product array at the proper key
        //assume we're out of stock
        //start at beginning and iterate entire
            //if you reach a product
                //if sufficient funds
                    //return Product
                //else return null



    }


    public ArrayList<Coin> returnCoins(){
        ArrayList<Coin> conTemps = mPurchaseMoneys;
        mPurchaseMoneys = new ArrayList<>();
        return conTemps;
    }

    public ArrayList<Coin> cashOut(){
        ArrayList<Coin> conTemp = mBanks;
        //reset the bank
        mBanks = new ArrayList<>();
        return conTemp;
    }

    private void transferFunds(){
        for (Coin conMoney : mPurchaseMoneys) {
            mBanks.add(conMoney);
        }
        //reset the user's money and give NO change
        mPurchaseMoneys = new ArrayList<>();
    }


    private String getProperId(int nRow, int nCol){

        nCol++;
        switch (nRow){
            case 0:
                return "A" + nCol;

            case 1:
                return "B" + nCol;

            case 2:
                return "C" + nCol;

            default:
                return "";
        }
    }






}
