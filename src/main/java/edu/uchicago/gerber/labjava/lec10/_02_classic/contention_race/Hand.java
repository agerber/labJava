package edu.uchicago.gerber.labjava.lec10._02_classic.contention_race;

public class Hand {

    private byte value;

    //local method variables do not escape a Thread's stack
    //THREAD-SAFE
    public int add10(int paramValue){
        final int TEN = 10;
        return paramValue + TEN;
    }

    //StringBuilder sb is local and does not escape a Thread's stack
    //THREAD-SAFE
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("This class is called: ");
        sb.append(this.getClass().getName());
        return sb.toString();
    }

    //NOT THREAD-SAFE
    public void hitMe(byte hitValue){
        //possible check-then-act race condition
        if (this.value < 21){
            setValue((byte) (getValue() + hitValue));
        }
    }

    //NOT THREAD-SAFE
    public void incrementMe(){
        //possible read-write-modify race condition
        setValue((byte)(this.value +1));
    }


    //calling syntax: new Card('K', 'S', 11)
    //constructor definition loaded by class-loader
    public Hand( byte value) {
        this.value = value;
    }

    //calling syntax: implicitParameter.getFace()
    //instance methods definitions loaded by class-loader

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    //static field definition loaded by class-loader
    //static field value loaded by class-loader; value does not exist on heap
    private static final int NUM_CARDS_IN_DECK = 52;

    //calling syntax: Card.howManyCards()
    //static method definition loaded by class-loader
    public static int howManyCards(){
        return NUM_CARDS_IN_DECK;
    }

}
