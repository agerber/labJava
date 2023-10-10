package edu.uchicago.gerber.labjava.lec08.blackjack;

public class Shoe {

	public static final int DECKS = 6;
	//the lower the slug value, the easier it is to count cards.
    //0.75 will place the slug 75% way down the shoe
	public static final double SLUG = 0.75;
	
	private Card[] carCards; //312 cards
	private int nCount;

	

	
	//this is just for show
//	public CardOld[] getCards(){
//		return carCards;
//	}
	
}
