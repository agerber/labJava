package lec08.glab.lambda.behaviorParam;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MyLambdas {

    public static void main(String[] args) {



        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Frankfurt");
        map.put(2, "Chicago");
        map.put(3, "Beijing");


        BiConsumer<Integer, String> cityBiConsumer = (key, value) ->
                System.out.println("key: " + key + "Value " + value);

        map.forEach(cityBiConsumer);






    }
}
