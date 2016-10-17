package lec04.glab.override;

/**
 * Created by ag on 10/20/2014.
 */
public class WaterDriver {

    public static void main(String[] args) {
        Water water = new Water(55.88);
        System.out.println(water);

        System.out.println(water.getState() == Water.State.SOLID ? "ice" : "not ice");
    }
}
