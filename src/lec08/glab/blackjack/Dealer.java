package lec08.glab.blackjack;

public class Dealer  {

	//these fields hold references to objects already instantiated by BlackJack, but we need 
	//to give the dealer access to these objects. Notice that the dealer does NOT instantiate
	//any of these objects
	private Shoe sho;
	private Hand hanDealer;
	private Hand hanPlayer;
	
	
	
	
	public Dealer(Shoe sho, Hand hanDealer, Hand hanPlayer) {
		super();
		this.sho = sho;
		this.hanDealer = hanDealer;
		this.hanPlayer = hanPlayer;
	}


	public void hitPlayer(){
		hanPlayer.hit(sho.deal());
	}
	
	public void hitDealer(){
		hanDealer.hit(sho.deal());
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
