package edu.uchicago.gerber.labjava.lec09.simpledatastructs.hashsimple;

import edu.uchicago.gerber.labjava.lec09.simpledatastructs.linkedlist.SimpleLinkedList;

public class HashTableOfSimpleLinkedLists<T> {

    private SimpleLinkedList<T>[] buckets;
    private int size;


    public HashTableOfSimpleLinkedLists(int seed) {
        buckets = new SimpleLinkedList[seed];
        this.size = 0;
    }

    //considered O(1)
    public void add(T typ) {

        int nHash = typ.hashCode();
        nHash = Math.abs(nHash);
        nHash = nHash % buckets.length;

        buckets[nHash].addLast(typ);
        size++;

    }
    //considered O(1)
    public boolean contains(T typ){
        int nHash = typ.hashCode();
        nHash = Math.abs(nHash);
        nHash = nHash % buckets.length;

       return buckets[nHash].seek(typ);

    }




}
