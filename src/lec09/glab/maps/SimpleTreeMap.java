package lec09.glab.maps;

public class SimpleTreeMap<K extends Comparable,V> implements SimpleMap<K,V> {

    private TreeNode nodHead;

    public SimpleTreeMap() {
        nodHead = null;
    }

    @Override
    public void insert(K key, V value) {

        if (nodHead == null) {
            nodHead = new TreeNode(key, value, null, null);
        } else {
            insert(nodHead, key, value);
        }
    }

    public void insert(TreeNode nod, K key, V value) {

        if (key.compareTo(nod.getKey()) < 0) {
            if (nod.getLeft() != null) {
                insert(nod.getLeft(), key, value);
            } else {
                nod.setLeft(new TreeNode(key, value, null, null));
            }
        } else if (key.compareTo(nod.getKey()) > 0) {
            if (nod.getRight() != null) {
                insert(nod.getRight(), key, value);
            } else {
                nod.setRight(new TreeNode(key, value, null, null));
            }
        } else {
            throw new RuntimeException("Dupblicate item at "
                    + key.toString());
        }
    }

    @Override
    public void print() {
        print(nodHead);
    }

    public void print(TreeNode nod) {

        //base case
        if (nod == null){
            //do nothing -- terminate
        }
        //recusive case
        else {
            print(nod.getLeft());
            System.out.println("  Traversed " + nod);
            print(nod.getRight());
        }
    }

    //inner class     
    //package access
    class TreeNode<K ,V> {
        private K key;
        private V value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(K key, V value, TreeNode left,
                        TreeNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

}