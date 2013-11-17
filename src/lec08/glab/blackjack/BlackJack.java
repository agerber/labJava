package lec08.glab.blackjack;

/*
This model is completely decoupled from the controller/view. Implementing the gui would be relatively easy.
ConsoleDriver is the driver class

 */
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


    public String status() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Dealer has:" + hanDealer);
        stringBuilder.append("\n");
        stringBuilder.append("You have  :" + hanPlayer);
        return stringBuilder.toString();

    }

    public Dealer getDealer() {
        return dlr;
    }

    public String showStatusAfterHit() {

        StringBuilder stringBuilder = new StringBuilder();
        boolean bAces = hanPlayer.isThereAces();
        int nBetter = hanPlayer.getBetterScore(hanPlayer.getSoftValue(), hanPlayer.getSemiSoftValue());

        if (bAces) {

            if (nBetter == 21) {
                stringBuilder.append("BLACKJACK: " + nBetter);
                ply.setMoney(ply.getMoney() + BET * 1.5);
                initHands();
                return showMoney(stringBuilder);

            } else if (nBetter > 21) {
                stringBuilder.append("BUSTED: " + nBetter);
                ply.setMoney(ply.getMoney() - BET);
                initHands();
                return showMoney(stringBuilder);
            }

        }
        //no aces
        else {

            if (hanPlayer.getHardValue() == 21) {
                stringBuilder.append("BLACKJACK: " + hanPlayer.getHardValue());
                ply.setMoney(ply.getMoney() + BET * 1.5);
                initHands();
                return showMoney(stringBuilder);

            } else if (hanPlayer.getHardValue() > 21) {
                stringBuilder.append("BUSTED: " + hanPlayer.getHardValue());
                ply.setMoney(ply.getMoney() - BET);
                initHands();
                return showMoney(stringBuilder);

            }

        }

        return stringBuilder.toString();


    }


    public String showStatusAfterDealerAutoHit(boolean bDoubleDown) {

        double dBet = BET;
        if (bDoubleDown)
            dBet *= 2;


        boolean bAces = hanPlayer.isThereAces();
        int nBetter = hanPlayer.getBetterScore(hanPlayer.getSoftValue(), hanPlayer.getSemiSoftValue());

        StringBuilder stringBuilder = new StringBuilder();
        if (hanDealer.getHardValue() > 21) {
            stringBuilder.append("DEALER BUSTED :" + hanDealer.getHardValue() + " YOU WIN");

            ply.setMoney(ply.getMoney() + dBet);
            return showMoney(stringBuilder);

        }

        if (bAces) {

            if (nBetter > hanDealer.getHardValue()) {
                stringBuilder.append("You:" +
                        " " + nBetter + " versus Dealer: " + hanDealer.getHardValue() + " YOU WIN");


                ply.setMoney(ply.getMoney() + dBet);
            } else if (nBetter < hanDealer.getHardValue()) {
                stringBuilder.append("You: " + nBetter + " versus Dealer: " + hanDealer.getHardValue() + " YOU LOSE");


                ply.setMoney(ply.getMoney() - dBet);
            } else {
                stringBuilder.append("You: " + nBetter + " versus Dealer: " + hanDealer.getHardValue() + " PUSH");


            }
        } else {

            if (hanPlayer.getHardValue() > hanDealer.getHardValue()) {
                stringBuilder.append("You: " + nBetter + " versus Dealer: " + hanDealer.getHardValue() + " YOU WIN");


                ply.setMoney(ply.getMoney() + dBet);
            } else if (hanPlayer.getHardValue() < hanDealer.getHardValue()) {
                stringBuilder.append("You: " + nBetter + " versus Dealer: " + hanDealer.getHardValue() + " YOU LOSE");


                ply.setMoney(ply.getMoney() - dBet);
            } else {
                stringBuilder.append("You: " + hanPlayer.getHardValue() + " versus Dealer: " + hanDealer.getHardValue() + " PUSH");


            }

        }
        return showMoney(stringBuilder);

    }

    private String showMoney(StringBuilder stringBuilder) {

        stringBuilder.append("\n########HAND OVER##########\n");

        stringBuilder.append(hanDealer.showEndState());
        stringBuilder.append("\n");

        stringBuilder.append(hanPlayer.showEndState());
        stringBuilder.append("\n");
        stringBuilder.append(ply.getStringMoney());
        stringBuilder.append("\n########HAND OVER##########\n");

        stringBuilder.append("\n");
        return stringBuilder.toString();
    }


}
