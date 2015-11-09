package lec07.glab.vend;

import java.text.DecimalFormat;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/11/13
 * Time: 10:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class Coin {
    private double mValue;


    public Coin(double value) {
        mValue = value;
    }

    public Coin(String  strVal){

        strVal = strVal.toUpperCase();
        double dVal = 0.0;

         switch (strVal){
             case "Q":
                 dVal = 0.25;
                 break;
             case "D":
                 dVal = 0.10;
                 break;
             case "N":
                 dVal = 0.05;
                 break;
             default:
                 dVal = 0.00;
                 break;

         }

        setValue(dVal);
    }

    public double getValue() {
        return mValue;
    }

    public void setValue(double value) {
        mValue = value;
    }

    @Override
    public String toString(){
        return VendMachine.sDecimalFormat.format(getValue());
    }
}
