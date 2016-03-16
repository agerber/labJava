package lec08.glab.blackjack;

public class Dealer  {

	private Shoe sho;
	private Hand hanDealer;
	private Hand hanPlayer;
	
	
	
	
	public Dealer(Shoe sho, Hand hanDealer, Hand hanPlayer) {

		this.sho = sho;
		this.hanDealer = hanDealer;
		this.hanPlayer = hanPlayer;
	}

	
	
	public Hand getHanDealer() {
		return this.hanDealer;
	}
	public void setHanDealer(Hand hanDealer) {
		this.hanDealer = hanDealer;
	}
	public Hand getHanPlayer() {
		return this.hanPlayer;
	}
	public void setHanPlayer(Hand hanPlayer) {
		this.hanPlayer = hanPlayer;
	}
	public Shoe getSho() {
		return this.sho;
	}
	public void setSho(Shoe sho) {
		this.sho = sho;
	}


	
}
