package edu.uchicago.gerber.labjava.lec10.patterns.iterator.example.iterators;

import edu.uchicago.gerber.labjava.lec10.patterns.iterator.example.profile.Profile;

public interface ProfileIterator {
    boolean hasNext();

    Profile getNext();

    void reset();
}
