package lec09.glab.maps;

// this class is generic
public class SimpleHashMap<K extends Comparable,V> implements SimpleMap<K,V>{

    private HashMapNode<K,V>[] nodHashes;

    private int nSize;

    // ===============================================
    // ==CONSTRUCTOR
    // ===============================================
    public SimpleHashMap() {
        nodHashes = new HashMapNode[1999];
        nSize = 0;

    }

    //overlaoded
    public SimpleHashMap(int nHashTableSize) {
        nodHashes = new HashMapNode[nHashTableSize];
        nSize = 0;

    }



    // ===============================================
    // ==ADD
    // ===============================================
    //O(1) very fast
    public void insert(K typKey, V typValue) {

        int nHash = typKey.hashCode();
        nHash = Math.abs(nHash);
        nHash = nHash % nodHashes.length;

        HashMapNode<K,V> nodCurrent = nodHashes[nHash];

        if (nodCurrent == null) {
            nodHashes[nHash] = new HashMapNode<K,V>(typKey,typValue, null);
            nSize++;
        } else {

            boolean bFound = false;
            while (nodCurrent != null){

                if (nodCurrent.getKey().equals(typKey)){
                    bFound = true;
                    break;
                }

                nodCurrent = nodCurrent.getNext();
            }
            if (!bFound){
                nodHashes[nHash] = new HashMapNode<K,V>(typKey,typValue, nodHashes[nHash]);
                nSize++;
            }


        }

    }

    public SimpleTreeMap convertToTreeMap(){

        SimpleTreeMap<K,V> simpleTreeMap = new SimpleTreeMap();


        for (int nC = 0; nC < nodHashes.length; nC++) {

            if (nodHashes[nC] != null){
                HashMapNode<K,V> nodCurrent = nodHashes[nC];
                while (nodCurrent != null){
                    simpleTreeMap.insert(nodCurrent.getKey(), nodCurrent.getValue());
                   // System.out.print( " : " + nodCurrent.getKey() + "-"+ nodCurrent.getValue());
                    nodCurrent = nodCurrent.getNext();
                }
               // System.out.println();
            }
        }
        return simpleTreeMap;
    }

    //used to print to screen
    public void print(){

        for (int nC = 0; nC < nodHashes.length; nC++) {
            System.out.print(nC);
            if (nodHashes[nC] == null){
                System.out.println(" : NULL");
            }
            else {
                HashMapNode<K,V> nodCurrent = nodHashes[nC];
                while (nodCurrent != null){
                    System.out.print( " : " + nodCurrent.getKey() + "-"+ nodCurrent.getValue());
                    nodCurrent = nodCurrent.getNext();
                }
                System.out.println();
            }
        }

    }



    //inner class
    class HashMapNode<K,V> {

        private K typKey;
        private V typValue;
        private HashMapNode<K,V> nodNext;

        HashMapNode(K typKey, V typValue, HashMapNode<K,V> nodNext) {
            this.typValue = typValue;
            this.typKey = typKey;
            this.nodNext = nodNext;
        }

        V getValue() {
            return typValue;
        }


        public K getKey() {
            return this.typKey;
        }

        public void setKey(K typKey) {
            this.typKey = typKey;
        }

        HashMapNode<K,V> getNext() {
            return nodNext;
        }

        void setValue(V typValue) {
            this.typValue = typValue;
        }

        void setNext(HashMapNode<K,V> nodNext) {
            this.nodNext = nodNext;
        }

    }

}