package lec04.glab.override;

/**
 * Created by ag on 10/20/2014.
 */
public class Bike extends Vehicle implements  Drawable {

    public Bike(String model) {
        super(model);
    }

    @Override
    public String reportNumWheels() {
        return " has two mountain-bike tires with spokes";
    }



    @Override
    public void draw() {

        String strOut =
                    "                             __\n" +
                    "                             ,--.      <__)\n" +
                    "                             `- |________7\n" +
                    "                                |`.      |\\\n" +
                    "                             .--|. \\     |.\\--.\n" +
                    "                            /   j \\ `.7__j__\\  \\\n" +
                    "                           |   o   | (o)____O)  |\n" +
                    "                            \\     /   J  \\     /\n" +
                    "                             `---'        `---'     ";


        System.out.println(strOut);
    }


}
