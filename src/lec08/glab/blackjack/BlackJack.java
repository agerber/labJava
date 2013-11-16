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
        hanPlayer = new Hand(false, true);
        hanDealer = new Hand(true, false);
        dlr = new Dealer(sho, hanDealer, hanPlayer);
        dlr.hitDealer();
        dlr.hitDealer();

        dlr.hitPlayer();
        dlr.hitPlayer();
        setPlayerTurn(true);

		
	}



    public String status(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Dealer has: "+ hanDealer);
        stringBuilder.append("\n");
        stringBuilder.append("You have  :" + hanPlayer);
        return stringBuilder.toString();

    }

    public Dealer getDealer() {
        return dlr;
    }


    //	//eval and display score
//	public String showStatusAsString(){
//
//        StringBuilder stb = new StringBuilder();
//
//		boolean bAces = hanPlayer.isThereAces();
//		int nBetter = hanPlayer.getBetterScore(hanPlayer.getSoftValue(), hanPlayer.getSemiSoftValue());
//
//		//the player has the choice to hit, hold
//		if(hanPlayer.isMyTurn()){
//
//			if(bAces){
//
//
//				if (nBetter == 21){
//					 //lblScore.setText("BLACKJACK: " + nBetter);
//
//					 ply.setMoney(ply.getMoney() + BET * 1.5);
//
//				}
//				else if (nBetter > 21){
//					 //lblScore.setText("BUSTED: " + nBetter);
//
//					 ply.setMoney(ply.getMoney() - BET );
//				}
//				else
//                    System.out.println("soething");
//                //lblScore.setText(hanPlayer.getSoftValue() + " or " + hanPlayer.getSemiSoftValue());
//			}
//			//no aces
//			else{
//
//				if (hanPlayer.getHardValue() == 21){
//					 //lblScore.setText("BLACKJACK: " + hanPlayer.getHardValue());
//
//					 ply.setMoney(ply.getMoney() + BET * 1.5);
//
//				}
//
//				else if (hanPlayer.getHardValue() > 21){
//					//lblScore.setText("BUSTED: " + String.valueOf(hanPlayer.getHardValue()));
//
//					 ply.setMoney(ply.getMoney() - BET);
//				}
//				else
//				    //lblScore.setText(String.valueOf(hanPlayer.getHardValue()));
//                    System.out.println("afadf");
//            }
//
//
//		}
//		//not hte players turn
//		else {
//
//			if (hanDealer.getHardValue() >21){
//				//evalDisplayScore("DEALER BUSTED :" + hanDealer.getHardValue() + " YOU WIN");
//
//				 setPlayerTurn(true);
//				 ply.setMoney(ply.getMoney() + BET );
//
//				// lblMoney.setText(NumberFormat.getCurrencyInstance().format(ply.getMoney()));
//				 //sidPlayer.repaint();
//				// sidDealer.repaint();
//				 return;
//			}
//
//			if(bAces){
//
//				if (nBetter > hanDealer.getHardValue()){
//					evalDisplayScore("You:" +
//							" " + nBetter +" versus Dealer: " + hanDealer.getHardValue() + " YOU WIN");
//					 //setButtonsHandOver();
//					 setPlayerTurn(true);
//					 ply.setMoney(ply.getMoney() + BET );
//				}
//				else if (nBetter < hanDealer.getHardValue()){
//					evalDisplayScore("You: " + nBetter +" versus Dealer: " + hanDealer.getHardValue() + " YOU LOSE");
//					// setButtonsHandOver();
//					 setPlayerTurn(true);
//					 ply.setMoney(ply.getMoney() - BET );
//				}
//				else {
//					evalDisplayScore("You: " + nBetter +" versus Dealer: " + hanDealer.getHardValue() + " PUSH");
//					// setButtonsHandOver();
//					 setPlayerTurn(true);
//
//				}
//			}
//			else {
//
//				if (hanPlayer.getHardValue() > hanDealer.getHardValue()){
//					evalDisplayScore("You: " + nBetter +" versus Dealer: " + hanDealer.getHardValue() + " YOU WIN");
//					// setButtonsHandOver();
//					 setPlayerTurn(true);
//					 ply.setMoney(ply.getMoney() + BET );
//				}
//				else if (hanPlayer.getHardValue() < hanDealer.getHardValue()){
//					evalDisplayScore("You: " + nBetter +" versus Dealer: " + hanDealer.getHardValue() + " YOU LOSE");
//					// setButtonsHandOver();
//					 setPlayerTurn(true);
//					 ply.setMoney(ply.getMoney() - BET );
//				}
//				else {
//					evalDisplayScore("You: " + hanPlayer.getHardValue() +" versus Dealer: " + hanDealer.getHardValue() + " PUSH");
//					// setButtonsHandOver();
//					 setPlayerTurn(true);
//
//				}
//
//			}
//
//		}
//		//lblMoney.setText(NumberFormat.getCurrencyInstance().format(ply.getMoney()));
//		//sidPlayer.repaint();
//		//sidDealer.repaint();
//
//
//
//
//	}//end meth



    public String showPlayersTurn(){


        StringBuilder stringBuilder = new StringBuilder();
        boolean bAces = hanPlayer.isThereAces();
        int nBetter = hanPlayer.getBetterScore(hanPlayer.getSoftValue(), hanPlayer.getSemiSoftValue());


            if(bAces){

                if (nBetter == 21){
                    stringBuilder.append("BLACKJACK: " + nBetter);
                    ply.setMoney(ply.getMoney() + BET * 1.5);

                }
                else if (nBetter > 21){
                    stringBuilder.append("BUSTED: " + nBetter);
                    ply.setMoney(ply.getMoney() - BET );
                }
                else
                     stringBuilder.append("You have " + hanPlayer.getSoftValue() + " or " + hanPlayer.getSemiSoftValue());

            }
            //no aces
            else{

                if (hanPlayer.getHardValue() == 21){
                    stringBuilder.append("BLACKJACK: " + hanPlayer.getHardValue());
                    ply.setMoney(ply.getMoney() + BET * 1.5);

                }

                else if (hanPlayer.getHardValue() > 21){
                    stringBuilder.append("BUSTED: " + hanPlayer.getHardValue());
                    ply.setMoney(ply.getMoney() - BET);
                }
                else
                    stringBuilder.append("You have " + hanPlayer.getHardValue());

            }

        return stringBuilder.toString();


    }


    public String showDealersTurn(){

        boolean bAces = hanPlayer.isThereAces();
        int nBetter = hanPlayer.getBetterScore(hanPlayer.getSoftValue(), hanPlayer.getSemiSoftValue());

        StringBuilder stringBuilder = new StringBuilder();
        if (hanDealer.getHardValue() >21){
            stringBuilder.append("DEALER BUSTED :" + hanDealer.getHardValue() + " YOU WIN");
            setPlayerTurn(true);
            ply.setMoney(ply.getMoney() + BET );
            return stringBuilder.toString();
        }

        if(bAces){

            if (nBetter > hanDealer.getHardValue()){
                stringBuilder.append("You:" +
                        " " + nBetter +" versus Dealer: " + hanDealer.getHardValue() + " YOU WIN");
                //setButtonsHandOver();
                setPlayerTurn(true);
                ply.setMoney(ply.getMoney() + BET );
            }
            else if (nBetter < hanDealer.getHardValue()){
                stringBuilder.append("You: " + nBetter +" versus Dealer: " + hanDealer.getHardValue() + " YOU LOSE");
                // setButtonsHandOver();
                setPlayerTurn(true);
                ply.setMoney(ply.getMoney() - BET );
            }
            else {
                stringBuilder.append("You: " + nBetter +" versus Dealer: " + hanDealer.getHardValue() + " PUSH");
                // setButtonsHandOver();
                setPlayerTurn(true);

            }
        }
        else {

            if (hanPlayer.getHardValue() > hanDealer.getHardValue()){
                stringBuilder.append("You: " + nBetter +" versus Dealer: " + hanDealer.getHardValue() + " YOU WIN");
                // setButtonsHandOver();
                setPlayerTurn(true);
                ply.setMoney(ply.getMoney() + BET );
            }
            else if (hanPlayer.getHardValue() < hanDealer.getHardValue()){
                stringBuilder.append("You: " + nBetter +" versus Dealer: " + hanDealer.getHardValue() + " YOU LOSE");
                // setButtonsHandOver();
                setPlayerTurn(true);
                ply.setMoney(ply.getMoney() - BET );
            }
            else {
                stringBuilder.append("You: " + hanPlayer.getHardValue() +" versus Dealer: " + hanDealer.getHardValue() + " PUSH");
                // setButtonsHandOver();
                setPlayerTurn(true);

            }

        }

        return stringBuilder.toString();

    }






		

	

	
	//if it's the player's turn, it's not the dealer's turn, and vice versa
	private void setPlayerTurn(boolean bTurn){
		if(!bTurn){
			hanPlayer.setMyTurn(false);
			hanDealer.setMyTurn(true);
		}
		else 
		{
			hanPlayer.setMyTurn(true);
			hanDealer.setMyTurn(false);
		}
	}
}
