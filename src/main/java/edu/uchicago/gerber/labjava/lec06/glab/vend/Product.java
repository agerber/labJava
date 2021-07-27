package edu.uchicago.gerber.labjava.lec06.glab.vend;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/11/13
 * Time: 10:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class Product {
    private String mDesc;
    private double mPrice;


    public Product(String desc, double price) {
        mDesc = desc;
        mPrice = price;
    }

    public String getDesc() {
        return mDesc;
    }

    public void setDesc(String desc) {
        mDesc = desc;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    @Override
    public String toString() {
        return  mDesc + " " + VendMachine.sDecimalFormat.format(mPrice);

    }
}
