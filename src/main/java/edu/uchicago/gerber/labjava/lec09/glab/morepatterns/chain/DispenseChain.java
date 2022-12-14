package edu.uchicago.gerber.labjava.lec09.glab.morepatterns.chain;

public interface DispenseChain {

    void setNextChain(DispenseChain nextChain);

    void dispense(Currency cur);
}