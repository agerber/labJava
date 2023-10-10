package edu.uchicago.gerber.labjava.lec09.generics.bounded;

class Two {
    int x, y;

    Two(int a, int b) {
        x = a;
        y = b;
    }
}

class Three extends Two {
    int z;

    Three(int a, int b, int c) {
        super(a, b);
        z = c;
    }
}

class Four extends Three {
    int t;

    Four(int a, int b, int c, int d) {
        super(a, b, c);
        t = d;
    }
}

class Gen<T extends Two> {
    T[] coords;

    Gen(T[] o) {
        coords = o;
    }
}

// Demonstrate a bounded wildcard.
public class ExtendsDriver {
    static void showTwo(Gen<?> c) {
        System.out.println("X Y Coordinates:");
        for (int i = 0; i < c.coords.length; i++)
            System.out.println(c.coords[i].x + " " + c.coords[i].y);
        System.out.println();
    }

    static void showThree(Gen<? extends Three> c) {
        System.out.println("X Y Z Coordinates:");
        for (int i = 0; i < c.coords.length; i++)
            System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z);
        System.out.println();
    }

    static void showAll(Gen<? extends Four> c) {
        System.out.println("X Y Z T Coordinates:");
        for (int i = 0; i < c.coords.length; i++)
            System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z + " "
                    + c.coords[i].t);
        System.out.println();
    }

    public static void main(String args[]) {
        Two td[] = { new Two(0, 0), new Two(7, 9), new Two(18, 4), new Two(-1, -23) };

        Gen<Two> tdlocs = new Gen<Two>(td);

        System.out.println("Contents of tdlocs.");
        showTwo(tdlocs); // OK, is a TwoD

        Four fd[] = { new Four(1, 2, 3, 4), new Four(6, 8, 14, 8), new Four(22, 9, 4, 9),
                new Four(3, -2, -23, 17) };

        Gen<Four> fdlocs = new Gen<Four>(fd);

        System.out.println("Contents of fdlocs.");
        // These are all OK.
        showTwo(fdlocs);
        showThree(fdlocs);
        showAll(fdlocs);
    }
}
