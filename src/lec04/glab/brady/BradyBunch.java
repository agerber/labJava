package lec04.glab.brady;

public class BradyBunch {

    public static void main(String[] args) {

        Brady mike = new Brady("Mike");
        Brady carol = new Brady("Carol");

        Brady marcia = new Brady("Marcia");
        Brady jan = new Brady("Jan");
        Brady cindy = new Brady("Cindy");


        Brady gregg = new Brady("Gregg");
        Brady peter = new Brady("Peter");
        Brady bobby = new Brady("Bobby");

        carol.setJunior(marcia);
        marcia.setJunior(jan);
        jan.setJunior(cindy);
        cindy.setJunior(null);


        mike.setJunior(gregg);
        gregg.setJunior(peter);
        peter.setJunior(bobby);
        bobby.setJunior(null);



      //  mike.setJunior(new Brady("Gregg").setJunior(new Brady("Peter").setJunior(new Brady("Bobby"))));



//        mike.setJuniors(
//
//                new Brady("Gregg"),
//                new Brady("Peter"),
//                new Brady("Bobby")
//
//
//        );
//
//        carol.setJuniors(
//
//                new Brady("Marcia"),
//                new Brady("Jan"),
//                new Brady("Cindy")
//
//        );


        System.out.println(mike);
     //  System.out.println(carol);


    }
}
