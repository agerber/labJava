package edu.uchicago.gerber.labjava.lec04.glab.construct_me;

/**
 * Created by ag on 10/20/2014.
 */
public class Person {

    //fields
    private String mName;
    private double mWeight;


    //constructors
    public Person() {
        //funnel constuction to the one-arg constructor
        this("Adam", 100.0);
    }

    public Person(String name) {
        this(name, 100.0);
    }

    public Person(String name, double weight) {
        mName = name;
        mWeight = weight;
    }

    //getters and setters

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }


    public double getWeight() {
        return mWeight;
    }

    public void setWeight(double weight) {
        mWeight = weight;
    }


    @Override
    public String toString() {
        return super.toString() +  ": Person{" +
                "mName='" + mName + '\'' +
                ", mWeight=" + mWeight +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

          return this.getName().equals(((Person) obj).getName()) &&
                  this.getWeight() == ((Person) obj).getWeight();

    }
}
