package lec04.glab.phone;

/**
 * Created by Adam on 10/17/2016.
 */
public class SamsungPhone extends Phone {
    public SamsungPhone(String model) {
        super(model);
    }

    @Override
    public String charge() {
        return "meltdown";
    }
}