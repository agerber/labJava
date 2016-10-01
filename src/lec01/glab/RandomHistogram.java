package lec01.glab;

/**
 * Created by Adam on 9/26/2016.
 */
public class RandomHistogram {

    public static void main(String[] args) {




        for (int nC = 0; nC < 10; nC++) {
            genTop(60);
            genBottom(60);
        }

    }

    private static void genTop(int nSpike) {

        for (int nC = 0; nC < nSpike; nC++) {
            genStars(nC);
            genSpaces(nSpike - nC);
            System.out.println();
        }
    }

    private static void genBottom(int nSpear) {
        int nWidth = nSpear;
        for (int nC = nWidth; nC > 0; nC--) {
            genStars(nC);
            genSpaces(nWidth - nC);
            System.out.println();
        }
    }

    private static void genStars(int nW){
        for (int nC = 0; nC < nW; nC++) {
            System.out.print("*");
        }

    }

    private static void genSpaces(int nW){
        for (int nC = 0; nC < nW; nC++) {
            System.out.print(" ");
        }
    }

}
