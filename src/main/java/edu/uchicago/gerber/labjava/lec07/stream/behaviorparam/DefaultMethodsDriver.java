package edu.uchicago.gerber.labjava.lec07.stream.behaviorparam;

// Define an interface with a default method
interface Greetable {
    void greet();

    // Default method
    default void sayHello() {
        System.out.println("Hello, this is the default method speaking!");
    }
}

// Implement the interface without overriding the default method
class English implements Greetable {
    @Override
    public void greet() {
        System.out.println("Hello!");
    }
}

// Implement the interface and override the default method


class Chinese implements Greetable {
    @Override
    public void greet() {
        System.out.println("你好");
    }

    @Override
    public void sayHello() {
        System.out.println("您好，这是默认的说话方式");
    }
}

public class DefaultMethodsDriver {
    public static void main(String[] args) {
        Greetable englishGreetable = new English();
        Greetable chineseGreetable = new Chinese();

        englishGreetable.greet();      // Calls the abstract method implementation
        englishGreetable.sayHello();   // Calls the default method

        chineseGreetable.greet();      // Calls the abstract method implementation
        chineseGreetable.sayHello();   // Calls the overridden default method
    }
}
