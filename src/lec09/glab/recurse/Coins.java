package lec09.glab.recurse;

public class Coins {

    public static void main(String[] args) {
        pay(100, new StringBuilder());
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
