package lec08.glab.stream.create.from_collections;
import java.util.Arrays;
import java.util.stream.Stream;
public class Ex1 {

    public static void main(String[] args) {
        Stream<String> names = Arrays.stream(new String[] {"XML",   "Java"});
    }
}
