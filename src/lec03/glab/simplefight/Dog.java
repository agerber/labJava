package lec03.glab.simplefight;

public  class Dog {

    // **********************************
    // ******* members
    // **********************************
    private String name;
    private int health;


    // **********************************
    // ******* constructors
    // **********************************
    public Dog(String name) {
        this.name = name;
        this.health = 10_000;
    }


    // **********************************
    // ******* getters and setters
    // **********************************
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    // **********************************
    // ******* abstract method
    // **********************************
    public  void bite(Dog dog){

        int percentage = (int) (Math.random() * 50) ;  //from 70 to 99 percent
        int effective = (int) (Math.random() * 50) + 50;  //from 0 to 30 percent

        dog.setHealth(dog.getHealth() - percentage * effective);
    }

    @Override
    public String toString() {
        return this.name + ", the " + this.getClass().getSimpleName() + " has " + health;
    }
}
