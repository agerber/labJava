package lec04.glab.brady;

public class BradyBunch {

    public static void main(String[] args) {

        Brady mike = new Brady("Mike");
        Brady carol = new Brady("Carol");

        mike.setJuniors(

                new Brady("Gregg"),
                new Brady("Peter"),
                new Brady("Bobby")


        );

        carol.setJuniors(

                new Brady("Marcia"),
                new Brady("Jan"),
                new Brady("Cindy")

        );


        System.out.println(mike);
        System.out.println(carol);


    }
}
