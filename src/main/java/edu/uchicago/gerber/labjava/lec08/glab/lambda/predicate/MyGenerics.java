package edu.uchicago.gerber.labjava.lec08.glab.lambda.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyGenerics {

   static  class GenClass<T>{
        private T typ;

        public GenClass(T typ) {
            this.typ = typ;
        }

        public T getTyp() {
            return typ;
        }

        public void setTyp(T typ) {
            this.typ = typ;
        }

       @Override
       public String toString() {
           return "GenClass{" +
                   "typ=" + typ +
                   '}';
       }
   }


    public static void main(String[] args) {


       Integer[] integers = {

               3,
               4,
               78
       };

       List<Integer> list = fromArrayList(integers, integers);


    }

    private static <U,Z> List<U> fromArrayList(U[] a, Z[] z){

       return Arrays.stream(a).collect(Collectors.toList());

    }
}
