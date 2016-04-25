package lec04.glab.override;

/**
 * Created by ag on 10/20/2014.
 */
public class Corsair extends Vehicle implements  Drawable {

    public Corsair(String model) {
        super(model);
    }

    @Override
    public String reportNumWheels() {
        return " has three huge tires";
    }

    @Override
    public void draw() {

        String strOut =
                "                            ___________                                        \n" +
                "                                 |                                             \n" +
                "                            _   _|_   _                                        \n" +
                "                           (_)-/   \\-(_)                                       \n" +
                "    _                         /\\___/\\                         _                \n" +
                "   (_)_______________________( ( . ) )_______________________(_)            \n" +
                "                              \\_____/                                          \n" +
                "                                       ";

        System.out.println(strOut);
    }

    @Override
    public void draw3D() {

    }
}
