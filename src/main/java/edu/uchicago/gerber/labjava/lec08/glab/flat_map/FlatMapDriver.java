package edu.uchicago.gerber.labjava.lec08.glab.flat_map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMapDriver {

    public static void main(String[] args) {

        List<Sport> sports = new ArrayList<>();
        sports.add(new Sport("Chicago", new String[] {"Sox", "Cubs", "Bears", "Bulls", "Blackhawks"}));
        sports.add(new Sport("New York", new String[] {"Yankees", "Mets", "Giants", "Jets", "Nets", "Knicks", "Rangers",
                "Islanders",}));


        sports.stream()
                .map(sport -> sport.getTeams())
                .flatMap(teams -> Arrays.stream(teams))
                .filter(team -> !team.startsWith("B"))
                .forEach(s -> System.out.println(s));
    }

}
 class Sport {
    private String city;
    private String[] teams;

    public Sport(String city, String[] teams) {
        this.city = city;
        this.teams = teams;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String[] getTeams() {
        return teams;
    }

    public void setTeams(String[] teams) {
        this.teams = teams;
    }
}
