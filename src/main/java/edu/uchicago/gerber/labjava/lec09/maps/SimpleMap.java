package edu.uchicago.gerber.labjava.lec09.maps;

public interface SimpleMap<K extends Comparable, V> {

    void insert(K key, V value);
    void print();
}
