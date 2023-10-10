package edu.uchicago.gerber.labjava.lec09.recurse;

import java.util.Arrays;

public class Coins {

    public static void main(String[] args) {
        printAllCents(20, new int[] {100, 20, 5}, 500, new int[] {100} );
    }




    public static void printAllCents(int ind, int[] denom,int N,int[] vals){
        if(N==0){
            if(ind < denom.length) {
                for(int i=ind;i<denom.length;i++)
                    vals[i] = 0;
            }
            System.out.println(Arrays.toString(vals));
            return;
        }
        if(ind == (denom.length)) {
            vals[ind-1] = 0;
            return;
        }

        int currdenom = denom[ind];
        for(int i=0;i<=(N/currdenom);i++){
            vals[ind] = i;
            printAllCents(ind+1,denom,N-i*currdenom,vals);
        }
    }



    private static void pay(int money, StringBuilder sb){



        switch (money){
            case 100:


                sb.setLength(0);
                pay(20, sb.append("$20 "));
                pay(20, sb.append("$20 "));
                pay(20, sb.append("$20 "));
                pay(20, sb.append("$20 "));
                pay(20, sb.append("$20 "));
                //sb.append("$100 ");
                System.out.println(sb);


                break;
            case 20:
                sb.setLength(0);
                pay(5, sb.append("$5 "));
                pay(5, sb.append("$5 "));
                pay(5, sb.append("$5 "));
                pay(5, sb.append("$5 "));
                sb.append("$20 ");
                System.out.println(sb);


                break;

            case 5:
                sb.setLength(0);
                pay(1, sb.append("$1 "));
                pay(1, sb.append("$1 "));
                pay(1, sb.append("$1 "));
                pay(1, sb.append("$1 "));
                pay(1, sb.append("$1 "));
                sb.append("$5 ");
                System.out.println(sb);


                break;
            case 1:
                System.out.print(sb);
                break;


        }

    }

}
