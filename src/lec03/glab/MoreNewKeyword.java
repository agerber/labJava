package lec03.glab;




/**
 Let's do this in class today
 */
public class MoreNewKeyword {

    //The new keyword returns a memory address of the newly constructed object.  You can store that memory
    // address in a object reference.

    //Java copies the address into the method as well.

    public static void main(String[] args) {


        Student stuOne = new Student("Alex", 2016);
        Student stuTwo = new Student("Bart", 2017);

        System.out.println("-----------original----------");
        System.out.println("stuOne: " + stuOne);
        System.out.println("stuTwo: " + stuTwo);

        //swap
        Student stuTemp = stuOne;
        stuOne = stuTwo;
        stuTwo = stuTemp;

        System.out.println("-----------swaped----------");
        System.out.println("stuOne: " + stuOne);
        System.out.println("stuTwo: " + stuTwo);


        System.out.println("---------call method swap------------");
        falseSwap(stuOne, stuTwo);

        System.out.println("stuOne: " + stuOne);
        System.out.println("stuTwo: " + stuTwo);

        System.out.println("-----------swaped and incremented-----------");

        //swap
        stuTemp = stuOne;
        stuOne = stuTwo;
        stuTwo = stuTemp;

        //increment
        increment(stuOne);
        increment(stuTwo);


        System.out.println("stuOne: " + stuOne);
        System.out.println("stuTwo: " + stuTwo);


    }

    public static void falseSwap(Student stuFirst, Student stuSecond){

        Student stuTemporary = stuFirst;
        stuFirst = stuSecond;
        stuSecond = stuTemporary;

    }

    public static void increment(Student stu){

        stu.setGraduate(stu.getGraduate() + 10);
    }



}

