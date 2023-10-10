package edu.uchicago.gerber.labjava.lec09.maps;

public class MapDriver {
    public static void main(String[] args) {
        SimpleMap<String, String> map = new SimpleTreeMap<>();
        map.insert("Chicago", "City of broad shoulders; meatmarket to the world.");
       // map.insert(60001,"Evanston");
        map.insert("New York", "The big apple, if I can make it here.");
        map.insert("Los Angeles", "Tinsle town. Lala land");
        map.insert("Shanghai", "Cosmopolitan China");
        map.insert("Moscow", "Capital of Russia");
        map.insert("Singapore", "China....town");

        System.out.println("ORIGINAL MAP");
        map.print();

        System.out.println("PRINTED MAP IN ORDER");
        printSorted(map);

    }


    //for TreeMap O(n)
    //for HashMap O(n * log n) * O(n)
    private static void printSorted(SimpleMap map){
        if (map instanceof SimpleHashMap){
            map = ((SimpleHashMap)map).convertToTreeMap();
        }
        map.print();
    }

}
