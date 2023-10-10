package edu.uchicago.gerber.labjava.lec07.stream.parallel;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiPredicate;

public class MyParellelSearch {

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";

    private static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
    private static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {

        List<String> stringList = new LinkedList<>();

        for (int nC = 0; nC < 1_000_000; nC++) {
            stringList.add(generateRandomString(8));
        }


        final BiPredicate<String, String> contains = (s, c) -> (s.contains(c));

        long start = System.currentTimeMillis();
        stringList.stream()
                .parallel()
                .filter(s -> contains.test(s, "aaa"))
                .forEach(s -> System.out.println(s));


        System.out.println(System.currentTimeMillis() - start);


    }


    private static String generateRandomString(int length) {
        if (length < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            // 0-62 (exclusive), random returns 0-61
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

            // debug
          //  System.out.format("%d\t:\t%c%n", rndCharAt, rndChar);

            sb.append(rndChar);

        }

        return sb.toString();

    }
}
