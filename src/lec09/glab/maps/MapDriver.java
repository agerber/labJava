package lec09.glab.maps;

public class MapDriver {
    public static void main(String[] args) {
        SimpleMap<Integer, String> map = new SimpleTreeMap<>();
        map.insert(60001,"Chicago");
       // map.insert(60001,"Evanston");
        map.insert(20001,"New York");
        map.insert(90001,"Los Angeles");
        map.insert(99998,"Shanghai");
        map.insert(99999,"Moscow");
        map.insert(99997,"Hong Kong");

        System.out.println("ORIGINAL MAP");
        map.print();

        System.out.println("PRINTED MAP IN ORDER");
        printSorted(map);

    }


    private static void printSorted(SimpleMap map){
        if (map instanceof SimpleHashMap){
            map = ((SimpleHashMap)map).convertToTreeMap();
        }
        map.print();
    }

}
