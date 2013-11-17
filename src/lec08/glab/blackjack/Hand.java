package lec08.glab.blackjack;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> carHandCards;
    private boolean bDealer;


    public Hand(boolean bDealer) {
        this.bDealer = bDealer;
        carHandCards = new ArrayList<Card>();

    }


    public void hit(Card carHit) {
        carHandCards.add(carHit);
    }


    public ArrayList<Card> getCards() {
        return carHandCards;
    }

    public int getHardValue() {
        //add up the values of hte cards on face value; aces are 11
        int nRet = 0;
        for (Card car : carHandCards) {

            nRet += car.getValue();
        }
        return nRet;

    }

    public int getSoftValue() {

        //add up ;  count aces as one
        int nRet = 0;
        for (Card car : carHandCards) {
            if (car.getValue() == 11) {
                nRet += 1;
            } else {
                nRet += car.getValue();
            }
        }

        return nRet;

    }

    public int getSemiSoftValue() {


        //if the softValue <= 10 && there is at least one ace
        //sort the cards in the hand in descending order (aces first)
        //for each card in hand
        //promote the first ace to hard 11 and add it
        //add the softvalues for any other aces
        //add the other values

        //else
        //get the hard value


        int nRet = 0;

        //are there any aces?
        boolean bAcesPresent = isThereAces();


        if (bAcesPresent && getSoftValue() >= 10) {

            sortDescending();

            //the first aces is 11
            nRet += 11;
            //start at index 1
            for (int nC = 1; nC < carHandCards.size(); nC++) {

                if (carHandCards.get(nC).getValue() == 11) {
                    nRet += 1;
                } else {
                    nRet += carHandCards.get(nC).getValue();
                }


            }

        } else {

            nRet = getHardValue();

        }

        return nRet;

    }

    public boolean isThereAces() {
        boolean bAcesPresent = false;
        for (Card car : carHandCards) {
            if (car.getValue() == 11) {
                bAcesPresent = true;
                break;
            }
        }
        return bAcesPresent;
    }


    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        int nC = 0;
        for (Card carHandCard : carHandCards) {
            if (nC++ == 0 && bDealer)
                stringBuilder.append("##" + " ");
            else
                stringBuilder.append(carHandCard.toString() + " ");
        }

        if (!bDealer)
            stringBuilder.append(getBetterScore(getSoftValue(), getSemiSoftValue()));

        return stringBuilder.toString();

    }


    public String showEndState() {

        StringBuilder stringBuilder = new StringBuilder();
        for (Card carHandCard : carHandCards) {
            stringBuilder.append(carHandCard.toString() + " ");
        }
        stringBuilder.append(getBetterScore(getSoftValue(), getSemiSoftValue()));
        return stringBuilder.toString();

    }

    //gets the better score of player's hand for soft Aces
    public int getBetterScore(int nSoft, int nSemi) {

        if (nSoft <= 21 && nSemi <= 21) {
            return nSemi;
        } else if (nSoft <= 21 && nSemi > 21) {
            return nSoft;
        }
        //busted
        else {
            return nSoft;
        }

    }


    private void sortDescending() {


        //sort in descending order
        for (int nB = 0; nB < carHandCards.size(); nB++) {

            for (int nC = nB + 1; nC < carHandCards.size(); nC++) {

                if (carHandCards.get(nB).getValue() < carHandCards.get(nC).getValue()) {

                    //swap
                    Card carTemp = carHandCards.get(nB);
                    carHandCards.set(nB, carHandCards.get(nC));
                    carHandCards.set(nC, carTemp);


                }

            }
        }
    }


}
