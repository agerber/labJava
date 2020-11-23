package lec09.glab.simpledatastructs.tree;

public class SimpleTree<T> {

	private TreeNode<T> nodHead;

	public SimpleTree() {

		nodHead = null;
	}

	//one-arg
	public void insert(Comparable<T> comVal) {

		if (nodHead == null) {
			nodHead = new TreeNode<T>(comVal, null, null);
			System.out.println("  Inserted " + comVal + " at the root.");
		} else {
			//this is a recursive method in its 2-arg overloaded form
			insert(nodHead, comVal);
		}
	}

	//two arg ; overloaded
	public void insert(TreeNode<T> nod, Comparable<T> comVal) {

		if (comVal.compareTo((T) nod.getValue()) < 0) {
			//recursive case
			if (nod.getLeft() != null) {
				insert(nod.getLeft(), comVal);
			}
			//base case
			else {
				System.out.println("  Inserted " + comVal + " to left of "
						+ nod.getValue());
				nod.setLeft(new TreeNode<T>(comVal, null, null));
			}
		} else if (comVal.compareTo((T) nod.getValue()) > 0) {
			//recursive case
			if (nod.getRight() != null) {
				insert(nod.getRight(), comVal);
			}
			//base case
			else {
				System.out.println("  Inserted " + comVal + " to right of "
						+ nod.getValue());
				nod.setRight(new TreeNode<T>(comVal, null, null));
			}
		} else {
			throw new RuntimeException("Dupblicate item at "
					+ comVal.toString());
		}
	}

	public void printInOrder() {
		printInOrder(nodHead);
	}

	public void printInOrder(TreeNode<T> nod) {

        //base case
        if (nod == null){
            //do nothing -- terminate
        }
        //recusive case
		else {
			printInOrder(nod.getLeft());
			System.out.println("  Traversed " + nod.getValue());
			printInOrder(nod.getRight());
		}
	}

	//inner class     
	//package access
	static class TreeNode<T> {
        private TreeNode<T> nodL;
		private Comparable<T> comV;
		private TreeNode<T> nodR;

		public TreeNode(Comparable<T> comInitValue, TreeNode<T> nodLeft,
						TreeNode<T> nodRight) {
			comV = comInitValue;
			nodL = nodLeft;
			nodR = nodRight;
		}


		public Comparable<T>  getValue() {
			return comV;
		}

		public TreeNode<T>  getLeft() {
			return nodL;
		}

		public TreeNode<T>  getRight() {
			return nodR;
		}

		public void setValue(Comparable<T> comNewValue) {
			comV = comNewValue;
		}

		public void setLeft(TreeNode<T>  nodLeft) {
			nodL = nodLeft;
		}

		public void setRight(TreeNode<T>  nodRight) {
			nodR = nodRight;
		}

	}

}
