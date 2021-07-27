package edu.uchicago.gerber.labjava.lec02.glab2;



public class Intern {

    private String name;


    public Intern() {
        name = "Joe";
    }

    public Intern(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Intern{" +
                "name='" + name + '\'' +
                '}';
    }
}
