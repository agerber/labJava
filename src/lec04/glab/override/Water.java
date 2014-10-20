package lec04.glab.override;

/**
 * Created by ag on 10/20/2014.
 */
public class Water {

    //no point storing this state in each instance, it can be calculated based on temp.
    public static enum State {solid, liquid, gas}

    private double mTemp;

    public Water(double temp) {
        mTemp = temp;
    }

    public Water() {
        this(67.5);
    }

    public double getTemp() {
        return mTemp;
    }

    public void setTemp(double temp) {
        mTemp = temp;
    }


    public State getState(){

        if (mTemp <= 0){
            return State.solid;
        } else if (mTemp > 0 && mTemp < 100){
            return State.liquid;
        } else {
            return State.gas;
        }
    }

    @Override
    public String toString() {
        return getState() + " : Water{" +
                "mTemp=" + mTemp +
                '}';
    }
}
