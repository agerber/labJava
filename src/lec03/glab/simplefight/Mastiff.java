package lec03.glab.simplefight;

public class Mastiff extends Dog {


    public Mastiff(String name) {
        super(name);
    }

    @Override
    public void bite(Dog dog) {
        //a chiwawa is fast so his percetage is high, but his bit is weak
        int percentage = (int) (Math.random() * 30) ;  //from 70 to 99 percent
        int effective = (int) (Math.random() * 30) + 70;  //from 0 to 30 percent

        dog.setHealth(dog.getHealth() - percentage * effective);
    }
}
