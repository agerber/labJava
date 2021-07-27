package edu.uchicago.gerber.labjava.lec01.glab;

public class Card {

    private char face;
    private char suit;
    private byte value;


    public Card(char face1, char suit1, byte value1) {
        face = face1;
        suit = suit1;
        value = value1;
    }


    public char getFace() {
        return face;
    }

    public void setFace(char face) {
        this.face = face;
    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(char suit) {
        this.suit = suit;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }
}
