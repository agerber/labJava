package lec04.glab.phone;

/**
 * Created by Adam on 10/17/2016.
 */
public class GooglePhone extends Phone {

    public GooglePhone(String model) {
        super(model);
    }

    @Override
    public String charge() {
        return "charging rapidly";
    }
}
