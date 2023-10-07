package edu.uchicago.gerber.labjava.lec10.glab._04_modern.streams;

import java.util.stream.Stream;

public class ParallelStreamsGreenApples {


    public static void main(String[] args) {

        Stream.of(new Apple("Blue", 'A'), new Apple("Green", 'B'), new Apple("Green", 'C'), new Apple("Blue", 'D'),
                new Apple("Green", 'E'))
                .parallel()
                .peek(a -> System.out.println(Thread.currentThread().getName() + ": " + a.getColor()))
                .filter(a -> a.getColor().equalsIgnoreCase("GREEN"))
                .forEach(System.out::println);
    }


}

class Apple {
    private String color;
    private char letter;

    public Apple(String color, char letter) {
        this.color = color;
        this.letter = letter;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", letter=" + letter +
                '}';
    }
}
