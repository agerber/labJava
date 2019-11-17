package lec07.glab.stream.intro;
import java.util.Arrays;
import java.util.List;
public class HowIterateInternalExternal {


/*    AutoCloseable
 |
         +--BaseStream
     |
             +--IntStream
     |
             +--LongStream
     |
             +--DoubleStream
     |
             +--Stream<T>*/



    public static void main(String[] args) {

        //Extneral
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = 0;
        for (int n : numbers) {
            if (n % 2 == 1) {
                int square = n * n;
                sum = sum + square;
            }
        }
        System.out.println(sum);


        //Internal

        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        int sum2 = numbers2.stream()
                .filter(n -> n % 2  == 1)
                .map(n  -> n * n)
                .reduce(0, Integer::sum);

        System.out.println(sum2);



        //intermediate versus terminal operations

        //Sequential
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5);
        int sum3 = numbers.parallelStream()
                .filter(n -> n % 2  == 1)
                .map(n  -> n * n)
                .reduce(0, Integer::sum);

        System.out.println(sum3);






    }
}
