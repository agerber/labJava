package edu.uchicago.gerber.labjava.lec09.glab.searchsort;

//inner class
class ListNode<T> {

    private T typValue;
    private ListNode<T> nodNext;

    ListNode(T typInit, ListNode<T> nodInit) {
        typValue = typInit;
        nodNext = nodInit;
    }

    T getValue() {
        return typValue;
    }

    ListNode<T> getNext() {
        return nodNext;
    }

    void setValue(T typValue) {
        this.typValue = typValue;
    }

    void setNext(ListNode<T> nodNext) {
        this.nodNext = nodNext;
    }

}