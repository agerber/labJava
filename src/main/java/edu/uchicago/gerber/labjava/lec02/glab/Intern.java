package edu.uchicago.gerber.labjava.lec02.glab;




public class Intern  {

    //STATIC - BELONGS TO CLASS - CLASS-LOADER
    public final static String company = "Apple Computer";
    public static String myAddress(){
        return "1 Infinite Loop, Cupertino, CA";
    }




    //INSTANCE - BELONGS TO OBJECT - HEAP MEMORY
    private String name;

    public Intern(String name) {
        this.name = name;
    }

    public Intern() {
        this.name = "Adam";
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
                '}' + " and I work for " + company;
    }


}
