package lec06.glab.debugger;

public class DebugDriver {
    public static void main(String[] args) {

        for (int nC = 0; nC <20 ; nC++) {
            System.out.print("hello");
            doSomething(nC);
        }


    }


    private static void doSomething(int nNum){
        System.out.println(doSomeMore("goodbybe") + nNum);
    }

    private static String doSomeMore(String str){
        return "A" + str;
    }


}