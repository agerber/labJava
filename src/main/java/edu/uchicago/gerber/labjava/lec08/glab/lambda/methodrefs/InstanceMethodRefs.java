package edu.uchicago.gerber.labjava.lec08.glab.lambda.methodrefs;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class InstanceMethodRefs {
    public static void main(String[] argv){
        Supplier<Integer> supplier  = () ->  "java2s.com".length();
        System.out.println(supplier.get());


        Supplier<Integer> supplier1  = "java2s.com"::length;
        System.out.println(supplier1.get());




        Util util = new Util();

        Consumer<String> consumer  = str ->  util.print(str);
        consumer.accept("Hello");


        Consumer<String> consumer1  = util::print;
        consumer1.accept("java2s.com");

        util.debug();



        //unbound Instance Method references

        Function<String,  Integer> strLengthFunc = String::length;
        String name ="java2s.com";
        int len   =  strLengthFunc.apply(name);
        System.out.println("name  = "  +  name + ", length = "  + len);

        name ="www.java2s.com";
        len   =  strLengthFunc.apply(name);
        System.out.println("name  = "  +  name + ", length = "  + len);




        BiFunction<String,  String,String> strFunc = Util::append;
        String name2 ="java2s.com";
        String s=  strFunc.apply(name,"hi");
        System.out.println(s);


    }

}

class Util{
    private int count=0;
    public void print(String s){
        System.out.println(s);
        count++;
    }
    public void debug(){
        System.out.println("count:" + count);
    }
    public static String append(String s1,String s2){
        return s1+s2;
    }
}
