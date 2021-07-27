package edu.uchicago.gerber.labjava.lec04.glab.override;

/**
 * Created by ag on 10/20/2014.
 */
public class Ambulance extends Vehicle implements  Drawable {

    public Ambulance(String model) {
        super(model);
    }

    @Override
    public String reportNumWheels() {
        return " has four medium firestone tires";
    }

    @Override
    public void draw() {

        String strOut =
                "    _______\n" +
                "   /______/\"=,\n" +
                "  [     | \"=, \"=,,\n" +
                "  [-----+----\"=,* )\n" +
                "  (_---_____---_)/\n" +
                "    (O)     (O)";


        System.out.println(strOut);
    }


}
