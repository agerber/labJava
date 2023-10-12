package edu.uchicago.gerber.labjava.lec03.simplepoly;

public class GodView {

    public  enum Size {
        SMALL,
        MEDIUM,
        LARGE;

    }



    public static void print(Class<?> classRef, GodView.Size size, boolean isObject){

        int side = 0, length=0;
        switch (size){
            case Size.LARGE:
                side = 0;
                length = 30;
                break;
            case Size.MEDIUM:
                side = 5;
                length = 20;
                break;
            case Size.SMALL:
                side = 10;
                length = 10;
                break;

        }

        StringBuilder sb = new StringBuilder();

        if (!isObject){

            for(int i = 0; i < 15; i++){
                sb.append("   ");
            }
            sb.append('\u2193');
            sb.append('\n');
        }

        String br = (isObject)? "===":"|||";
        addBrick(sb, br, side, length);
        sb.append("\n");


        String trailer = (isObject) ? "" : "REFERENCE";
        String trailerPlus = classRef.getName() + " " + trailer;

        int sideRefName = 14 - (trailerPlus.length()/ 6);

        for(int i = 0; i < sideRefName ; i++){
            sb.append("   ");
        }

        //add middle here
        sb.append(trailerPlus + "\n");

        addBrick(sb, br, side, length);
        System.out.println(sb);

        if (isObject){
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }


    }

    private static void addBrick(StringBuilder sb, String br, int side, int length){
        //build side
        for(int i = 0; i < side; i++){
            sb.append("   ");
        }
        //build length
        for(int i = 0; i < length; i++){
            sb.append(br);
        }
    }
}
