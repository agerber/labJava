package lec04.glab.phone;

/**
 * Created by Adam on 10/17/2016.
 */
public abstract  class Phone {
    private String model;

    public Phone(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "model='" + model + '\'' +
                '}';
    }


    public abstract String charge();
}
