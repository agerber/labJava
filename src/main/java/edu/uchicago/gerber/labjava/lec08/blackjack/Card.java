package edu.uchicago.gerber.labjava.lec08.blackjack;

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










}
