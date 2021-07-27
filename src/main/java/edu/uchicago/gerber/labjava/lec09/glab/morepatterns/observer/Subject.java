package edu.uchicago.gerber.labjava.lec09.glab.morepatterns.observer;

public interface Subject {

    //methods to register and unregister observers
     void register(Observer obj);
     void unregister(Observer obj);

    //method to notify observers of change
     void notifyObservers();

    //method to get updates from subject
     Object getUpdate(Observer obj);

}