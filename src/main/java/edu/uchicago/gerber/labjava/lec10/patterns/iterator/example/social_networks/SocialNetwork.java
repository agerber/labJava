package edu.uchicago.gerber.labjava.lec10.patterns.iterator.example.social_networks;

import edu.uchicago.gerber.labjava.lec10.patterns.iterator.example.iterators.ProfileIterator;

public interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
