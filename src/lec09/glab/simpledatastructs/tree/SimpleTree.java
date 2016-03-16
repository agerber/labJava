package lec09.glab.simpledatastructs.tree;

public class SimpleTree {

	private TreeNode nodHead;

	public SimpleTree() {

		nodHead = null;
	}

	//one-arg
	public void insert(Comparable comVal) {

		if (nodHead == null) {
			nodHead = new TreeNode(comVal, null, null);
			System.out.println("  Inserted " + comVal + " at the root.");
		} else {
			insert(nodHead, comVal);
		}
	}

	//two arg ; overloaded
	public void insert(TreeNode nod, Comparable comVal) {

		if (comVal.compareTo(nod.getValue()) < 0) {
			if (nod.getLeft() != null) {
				insert(nod.getLeft(), comVal);
			} else {
				System.out.println("  Inserted " + comVal + " to left of "
						+ nod.getValue());
				nod.setLeft(new TreeNode(comVal, null, null));
			}
		} else if (comVal.compareTo(nod.getValue()) > 0) {
			if (nod.getRight() != null) {
				insert(nod.getRight(), comVal);
			} else {
				System.out.println("  Inserted " + comVal + " to right of "
						+ nod.getValue());
				nod.setRight(new TreeNode(comVal, null, null));
			}
		} else {
			throw new RuntimeException("Dupblicate item at "
					+ comVal.toString());
		}
	}

	public void printInOrder() {
		printInOrder(nodHead);
	}

	public void printInOrder(TreeNode nod) {

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
	class TreeNode {
        private TreeNode nodL;
		private Comparable comV;
		private TreeNode nodR;

		public TreeNode(Comparable comInitValue, TreeNode nodLeft,
				TreeNode nodRight) {
			comV = comInitValue;
			nodL = nodLeft;
			nodR = nodRight;
		}

		/**
		 * Returns the value stored in this tree node.
		 * 
		 * @return this tree node's value
		 */

		public Comparable getValue() {
			return comV;
		}

		/**
		 * Returns the left subtree of this node.
		 * 
		 * @return a reference to the left subtree of this node
		 */

		public TreeNode getLeft() {
			return nodL;
		}

		/**
		 * Returns the right subtree of this node.
		 * 
		 * @return a reference to the right subtree of this node
		 */

		public TreeNode getRight() {
			return nodR;
		}

		/**
		 * Sets the value of this tree node.
		 * 
		 * @param comNewValue
		 *            is the (new) value stored in this node
		 */

		public void setValue(Comparable comNewValue) {
			comV = comNewValue;
		}

		/**
		 * Sets the value of the left subtree of this node.
		 * 
		 * @param nodLeft
		 *            is the (new) left subtree of this node
		 */

		public void setLeft(TreeNode nodLeft) {
			nodL = nodLeft;
		}

		/**
		 * Sets the value of the right subtree of this node.
		 * 
		 * @param nodRight
		 *            is the (new) right subtree of this node
		 */

		public void setRight(TreeNode nodRight) {
			nodR = nodRight;
		}

	}

}
