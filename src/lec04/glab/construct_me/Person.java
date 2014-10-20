package lec04.glab.construct_me;

/**
 * Created by ag on 10/20/2014.
 */
public class Person {

    //fields
    private String mName;


    //constructors
    public Person() {
        //funnel constuction to the one-arg constructor
        this("Adam");
    }

    public Person(String name) {
        mName = name;
    }


    //getters and setters

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    //there is a default contuctor here (the no-arg consturctor)



}
