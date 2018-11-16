package lec08.glab.stream.create.from_strings;

import java.util.regex.Pattern;
//ww w.  ja  v a2  s.  c o m
public class Ex2 {
    public static void main(String[] args) {
        String str = "XML,CSS,HTML";
        Pattern.compile(",")
                .splitAsStream(str)
                .forEach(System.out::println);

    }
}