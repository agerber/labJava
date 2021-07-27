package edu.uchicago.gerber.labjava.lec09.glab.generics.bounded;



//Establishing an upper bound for a wildcard
//
//<? extends superclass>
//Specifying a lower bound for a wildcard
//
//<? super subclass>
//        Here is the syntax for a generic method:
//
//<type-param-list> return-type meth-name(param-list)



// Use a wildcard.
class GenericStats<T extends Number> {
    T[] nums;

    GenericStats(T[] o) {
        nums = o;
    }

    double average() {
        double sum = 0.0;
        for(int i=0; i < nums.length; i++){
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    //we can use Number or ?
    boolean sameAvg(GenericStats<?> ob) {
        if(average() == ob.average())
            return true;

        return false;
    }
}

public class AverageDriver {
    public static void main(String args[]) {
        Integer inums[] = { 1, 2, 3, 4, 5 };
        GenericStats<Integer> iob = new GenericStats<Integer>(inums);
        double v = iob.average();
        System.out.println("iob average is " + v);

        Double dnums[] = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        GenericStats<Double> dob = new GenericStats<Double>(dnums);
        double w = dob.average();
        System.out.println("dob average is " + w);

        Float fnums[] = { 1.0F, 2.0F, 3.0F, 4.0F, 5.0F };
        GenericStats<Float> fob = new GenericStats<Float>(fnums);
        double x = fob.average();
        System.out.println("fob average is " + x);

        System.out.print("Averages of iob and dob ");
        if(iob.sameAvg(dob)){
            System.out.println("are the same.");
        }else{
            System.out.println("differ.");
        }

        System.out.print("Averages of iob and fob ");
        if(iob.sameAvg(fob)){
            System.out.println("are the same.");
        }else{
            System.out.println("differ.");
        }
    }
}