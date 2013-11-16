package lec08.glab.blackjack;

import javax.swing.plaf.FontUIResource;

/**
 * Created with IntelliJ IDEA.
 * User: ag
 * Date: 11/16/13
 * Time: 10:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class Card {

    //public static enum
    public static enum Suit {
        CLUBS('C'), DIAMONDS('D'), HEARTS('H'), SPADES('S');
        private char value;

        //you MUST make this constructor private!
        private Suit(char value) {
            this.value = value;
        }

        public char getLetterVal(){
            return value;
        }

    }


    //public static enum
    public static enum Face {
        ACE('A'),
        TWO('2'),
        THREE('3'),
        FOUR('4'),
        FIVE('5'),
        SIX('6'),
        SEVEN('7'),
        EIGHT('8'),
        NINE('9'),
        TEN('T'),
        JACK('J'),
        QUEEN('Q'),
        KING('K');

        private char value;

        //you MUST make this constructor private!
        private Face(char value) {
            this.value = value;
        }

        public char getLetterVal(){
            return value;
        }

    }


    //instance members
    private Face mFace;
    private Suit mSuit;
    private int mValue;



    //constructor
    public Card(Face face, Suit suit) {
        mFace = face;
        mSuit = suit;
        mValue = getRank(face);
    }


    @Override
    public String toString() {
        return String.valueOf(mFace.getLetterVal()) + mSuit.getLetterVal();
    }

    private int getRank(Face face){
        switch (face.getLetterVal()){
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'T':
                return 10;
            case 'J':
                return 10;
            case 'K':
                return 10;
            case 'Q':
                return 10;
            case 'A':
                return 11;
            default:
                return 0;

        }
    }


    //getters and setters


    public Face getFace() {
        return mFace;
    }

    public void setFace(Face face) {
        mFace = face;
    }

    public Suit getSuit() {
        return mSuit;
    }

    public void setSuit(Suit suit) {
        mSuit = suit;
    }

    public int getValue() {
        return mValue;
    }

    public void setValue(int value) {
        mValue = value;
    }
}
