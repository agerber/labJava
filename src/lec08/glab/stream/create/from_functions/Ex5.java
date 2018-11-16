package lec08.glab.stream.create.from_functions;

import java.util.stream.Stream;
/*  www  .  j a v a  2 s .c om*/
public class Ex5 {
    public static void main(String[] args) {
        Stream.generate(Ex5::next)
                .limit(5)
                .forEach(System.out::println);

    }

    static int i=0;
    private static int next(){
        i++;
        return i;
    }
}