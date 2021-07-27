package edu.uchicago.gerber.labjava.lec02.glab.pac;

import java.util.*;

public class Ghost {
    private String name;


    public Ghost(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return "Ghost{" +
                "name='" + name + '\'' + GodDriver.GAME_NAME + new Date() +
                '}';
    }
}
