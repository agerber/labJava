package lec08.glab.blackjack;

public class Shoe {

	public static final int DECKS = 6;
	//the lower the slug value, the easier it is to count cards.
    //0.75 will place the slug 75% way down the shoe
	public static final double SLUG = 0.75;
	
	private Card[] carCards; //312 cards
	private int nCount;

	
	public Shoe() {
	
		loadShoe();
		//toggle to see shuffle effect
		shuffle();
		nCount = 0;
	}

	public void shuffle(){
		//simple swapping operations
		//for each card in the chute
			//get a random swap index and swap
		
		
		for (int nC = 0; nC < carCards.length; nC++) {
			int nSwapIndex = (int) ( Math.random() * carCards.length);
			Card carTemp = carCards[nC];
			carCards[nC] = carCards[nSwapIndex];
			carCards[nSwapIndex] = carTemp;
		}
		
		
	}
	
	public void loadShoe(){
		
		
		
		int nC = 0;
		
		carCards = new Card[Card.Face.values().length * Card.Suit.values().length* DECKS];
		
		for (int nDeck = 0; nDeck < DECKS; nDeck++) {
            for (Card.Face face : Card.Face.values()) {
                for (Card.Suit suit : Card.Suit.values()){
					carCards[nC++] = new Card(face, suit);

				}
			}
        }
	}//end meth
	
	

	
	//to avoid card-counting, a shoe is reshuffled by the dealer 
	public Card deal(){
		if (nCount > (int)(carCards.length * SLUG)){
			shuffle();
			nCount = 0;
		}
		
		return carCards[nCount++];
	}
	
	
	//this is just for show
//	public CardOld[] getCards(){
//		return carCards;
//	}
	
}
