package lec07.glab.casting;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/7/13
 * Time: 11:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class CastPrimitivesDriver {


    public static void main(String[] args) {
        //A: WHEN YOU CAST A PRIMITIVE, THE PRIMITIVE RETURNED IS OF A DIFFERENT TYPE, AND THE ORIGINAL STAYS THE SAME

        //Let's take some examples
        //a short is a 16bit signed integer ranging from -32,768  to   32,767.

        //in binary, the left-most bit is the sign-bit, so in binary 151 as a short looks like this:
        //0 0 0 0   0 0 0 0   1 0 0 1   0 1 1 1
        //if we read the above from right-to-left, we get
        //2^0 + 2^1 + 2^2 + 0 + 2^4 + 0 + 0 + 2^7 + 0 etc,  which == 151

        short sMe = 407;
       // short sMe = 151;
        //Rather than pass the primitive directly into println, I'm going to use the wrapper class .valueOf(), which enforces the type
        System.out.println("Short value of sMe : " + Short.valueOf(sMe));


        //Let's promote this to an int which is a 32-bit signed integer ranging from   -2^31 to 2^31 - 1
        int nMe = sMe;
        //no problem, we don't really need all the precision, but memory is cheap, and the value stays the same.
        //when we copy the bits, we just put those bits into an 32-bit int like so ->
        //upcasting is automatic (no cast required) and looses no precision

        //0 0 0 0   0 0 0 0   0 0 0 0   0 0 0 0   0 0 0 0   0 0 0 1   1 0 0 1   0 1 1 1
                                                //0 0 0 0   0 0 0 1   1 0 0 1   0 1 1 1

        System.out.println("After upcasting, int value of sMe : " + Integer.valueOf(nMe));

        //and the original value stored in sMe is unchanged.
        System.out.println("Short value of sMe : " + Short.valueOf(sMe));


        //Let's demote this to an byte which is an 8-bit signed integer ranging from  -128 to 127
        //notice that 407 is out of this range, so when you copy the bits over, you will get erroneous results.
        //downcasting requires a cast and you loose precision and potentially erroneous results.
        //you flipped the sign-bit, so now, the result is -128 + 1 + 2 + 4 + 16, == -105. This is obviously erroenous.


        //0 0 0 0   0 0 0 1   1 0 0 1   0 1 1 1
        //                    1 0 0 1   0 1 1 1


        byte yMe = (byte) sMe;
        System.out.println("After downcasting, byte value of sMe : " + Byte.valueOf(yMe));


        //If we cast to a double (64-bit floating point value), we lose no precision. The number just becomes 151.0
        double dMe = (double) sMe;
        //when we use the == operator on primitives, we are not checking for memory addresses, but rather values
        System.out.println("These numbers, 407 and 407.0 are numerically equivalent : " + (sMe == dMe));


        System.out.println("#################################################################################");
        //#################################################################################

        //Now let's cast from floating-point to primitive.
        double dYou = 123.987654;

        //if we demote this to a float, which is a 32bit floating point value, no problem, a float is sufficiently large
        //enough to hold 123.987654 without losing precision.
        float fYou = (float) dYou;   //Yes, I realize fYou is a funny variable name :)
        System.out.println(Float.valueOf(fYou));



        //if we cast to an int, then we TRUNCATE the floating point values
        int nYou = (int)dYou;

        System.out.println(Integer.valueOf(nYou));




    }








}
