package lec09.glab.morepatterns.factory;

import java.util.List;

public class FactoryDriver {
    public static void main(String[] args) {

       List list = ListFactory.createList(ListFactory.Type.ARRAY);
       list.add("Hello");
       list.add("Goodbye");

       list.forEach(System.out::println);
    }
}
