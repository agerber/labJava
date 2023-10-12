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

        //build side
        for(int i = 0; i < side; i++){
            sb.append("   ");
        }
        //build length
        for(int i = 0; i < length; i++){
            sb.append(br);
        }
        sb.append("\n");

        for(int i = 0; i < side; i++){
            sb.append("   ");
        }
        String trailer = (isObject) ? "OBJECT" : "REFERENCE";
        //add middle here
        sb.append(classRef.getName() + "  " + trailer + "\n");

        //build side
        for(int i = 0; i < side; i++){
            sb.append("   ");
        }
        //build length
        for(int i = 0; i < length; i++){
            sb.append(br);
        }

        System.out.println(sb);

        if (isObject){
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }


    }
}
