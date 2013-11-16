package lec08.glab.blackjack;

public class BlackJack {

	// ===============================================
	// ==constants
	// ===============================================
	private static final double BET = 100.00; 

	private Dealer dlr;
	private Player ply;
	private Hand hanDealer;
	private Hand hanPlayer;
	private Shoe sho;


	public BlackJack() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frm = new JFrame();
		//frm.setTitle("BlackJack");
		ply = new Player(1000.00);
        sho = new Shoe();
        initHands();


		
	}

    public void initHands() {
        hanPlayer = new Hand(false);
        hanDealer = new Hand(true);
        dlr = new Dealer(sho, hanDealer, hanPlayer);
        dlr.hitDealer();
        dlr.hitDealer();
        dlr.hitPlayer();
        dlr.hitPlayer();
    }





    public String status(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Dealer has:"+ hanDealer);
        stringBuilder.append("\n");
        stringBuilder.append("You have  :" + hanPlayer);
        return stringBuilder.toString();

    }

    public Dealer getDealer() {
        return dlr;
    }





    public String showStatusAfterHit(){


        StringBuilder stringBuilder = new StringBuilder();
        boolean bAces = hanPlayer.isThereAces();
        int nBetter = hanPlayer.getBetterScore(hanPlayer.getSoftValue(), hanPlayer.getSemiSoftValue());


            if(bAces){

                if (nBetter == 21){
                    stringBuilder.append("BLACKJACK: " + nBetter);
                    ply.setMoney(ply.getMoney() + BET * 1.5);
                    initHands();
                    return showMoney(stringBuilder);

                }
                else if (nBetter > 21){
                    stringBuilder.append("BUSTED: " + nBetter);
                    ply.setMoney(ply.getMoney() - BET );
                    initHands();
                    return showMoney(stringBuilder);
                }
//                else
//                     stringBuilder.append("You have " + hanPlayer.getSoftValue() + " or " + hanPlayer.getSemiSoftValue());

            }
            //no aces
            else{

                if (hanPlayer.getHardValue() == 21){
                    stringBuilder.append("BLACKJACK: " + hanPlayer.getHardValue());
                    ply.setMoney(ply.getMoney() + BET * 1.5);
                    initHands();
                    return showMoney(stringBuilder);

                }

                else if (hanPlayer.getHardValue() > 21){
                    stringBuilder.append("BUSTED: " + hanPlayer.getHardValue());
                    ply.setMoney(ply.getMoney() - BET);
                    initHands();
                    return showMoney(stringBuilder);

                }
//                else
//                    stringBuilder.append("You have " + hanPlayer.getHardValue());

            }

        return stringBuilder.toString();


    }


    public String showStatusAfterDealerAutoHit(){

        boolean bAces = hanPlayer.isThereAces();
        int nBetter = hanPlayer.getBetterScore(hanPlayer.getSoftValue(), hanPlayer.getSemiSoftValue());

        StringBuilder stringBuilder = new StringBuilder();
        if (hanDealer.getHardValue() >21){
            stringBuilder.append("DEALER BUSTED :" + hanDealer.getHardValue() + " YOU WIN");

            ply.setMoney(ply.getMoney() + BET );
            return showMoney(stringBuilder);

        }

        if(bAces){

            if (nBetter > hanDealer.getHardValue()){
                stringBuilder.append("You:" +
                        " " + nBetter +" versus Dealer: " + hanDealer.getHardValue() + " YOU WIN");


                ply.setMoney(ply.getMoney() + BET );
            }
            else if (nBetter < hanDealer.getHardValue()){
                stringBuilder.append("You: " + nBetter +" versus Dealer: " + hanDealer.getHardValue() + " YOU LOSE");


                ply.setMoney(ply.getMoney() - BET );
            }
            else {
                stringBuilder.append("You: " + nBetter +" versus Dealer: " + hanDealer.getHardValue() + " PUSH");



            }
        }
        else {

            if (hanPlayer.getHardValue() > hanDealer.getHardValue()){
                stringBuilder.append("You: " + nBetter +" versus Dealer: " + hanDealer.getHardValue() + " YOU WIN");


                ply.setMoney(ply.getMoney() + BET );
            }
            else if (hanPlayer.getHardValue() < hanDealer.getHardValue()){
                stringBuilder.append("You: " + nBetter +" versus Dealer: " + hanDealer.getHardValue() + " YOU LOSE");


                ply.setMoney(ply.getMoney() - BET );
            }
            else {
                stringBuilder.append("You: " + hanPlayer.getHardValue() +" versus Dealer: " + hanDealer.getHardValue() + " PUSH");



            }

        }
        return showMoney(stringBuilder);

    }

    private String showMoney(StringBuilder stringBuilder) {
        stringBuilder.append("\n##############################\n");
        stringBuilder.append(ply.getStringMoney());
        stringBuilder.append("\n##############################");
        stringBuilder.append("\n\n");
        return stringBuilder.toString();
    }



}
