package lec04.glab.construct_me;

/**
 * Created by ag on 10/20/2014.
 */
public class Metric {

    private static final double CONVERSION = 2.2046;

    public static double lbsToKilos(double dLb){

        return dLb / CONVERSION;

    }

    public static double kilosToLbs(double dKilo){
        return dKilo * CONVERSION;
    }
}
