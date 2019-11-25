package lec07.glab.midterm;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/18/13
 * Time: 11:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class    FibDriver {

    public static void main(String[] args) {
        System.out.println(fib(4));
      //  System.out.println(mystery(1,5));

    }

   private static int fib(int n) {  // assumes n >= 0
        if (n <= 1) {
            System.out.println("base");
            return n;
        }
        else {
            System.out.println("rec");
            return (fib(n - 1) + fib(n - 2));
        }
    }

    private static int mystery (int n, int m) {
        if (n == 0)
            return 0;
        if (n == 1)
            return m;
        return m + mystery(n - 1, m);
    }
}
