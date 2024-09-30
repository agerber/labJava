package edu.uchicago.gerber.labjava.lec01;

public class PrecedenceDemo {
    public static void main(String[] args) {
        int a = 5, b = 10, c = 15;

        // binary-additional and Prefix
        System.out.println(2 + a * ++b);  // first increment b to 11, second multiply 5 (a) * 11, third add 2
        b = 10; //reset b

        System.out.println((2 + a) * ++b);  // first evaluate express in inner parens (7), second increment b to 11
                                                //third multply 7 * 11
        b = 10; //reset b

        // Multiplicative vs Additive
        System.out.println(a + b * c); //first multiply 10 * 15, then add 5

        // Multiplicative vs Additive
        System.out.println((a + b) * c); //first evaluate inner parens (15), then mulitply by 15

        // Relational vs Logical AND
        System.out.println(a < b && b < c);  // Output: true
        System.out.println(true && true);  // Output: true





    }
}
