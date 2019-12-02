package lec09.glab.maps;

public interface SimpleMap<K extends Comparable, V> {

    void insert(K key, V value);
    void print();
}
