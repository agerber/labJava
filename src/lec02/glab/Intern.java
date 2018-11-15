package lec02.glab;



public class Intern  {

    private String name;

    public Intern(String name) {
        this.name = name;
    }

    public Intern() {
        this.name = "Joe";
    }

    @Override
    public String toString() {
        return "Intern{" +
                "name='" + name + '\'' +
                '}';
    }
}
