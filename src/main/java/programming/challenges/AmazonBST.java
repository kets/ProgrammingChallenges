package programming.challenges;

public class AmazonBST {
	// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
	// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
	// DEFINE ANY CLASS AND METHOD NEEDED
	// CLASS BEGINS, THIS CLASS IS REQUIRED
	private static class Node {
		Node left;
		Node right;
		int value;

		Node(int value) {
			this.left = null;
			this.right = null;
			this.value = value;
		}

	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public int bstDistance(int[] values, int n, int node1, int node2) {
		Node root = null;
		// create a root node with the first value
		if (n > 0) {
			root = new Node(values[0]);
		}

		if (root == null) {
			return -1;
		}

		for (int i = 1; i < n; i++) {
			insertIntoBST(root, values[i]);
		}
		//printBST(root);
		return findDistance(root, node1, node2);

	}
	// METHOD SIGNATURE ENDS

	private void printBST(Node root) {
		if (root == null) {
			return;
		} else {
			printBST(root.left);
			System.out.println(root.value + " ");
			printBST(root.right);
		}
	}

	private static Node insertIntoBST(Node root, int value) {
		if (value < root.value) {
			if (root.left != null) {
				insertIntoBST(root.left, value);
			} else {
				Node leftChild = new Node(value);
				root.left = leftChild;
			}
		} else {
			if (root.right != null) {
				insertIntoBST(root.right, value);
			} else {
				Node rightChild = new Node(value);
				root.right = rightChild;
			}
		}
		return root;
	}

	private static int findDistance(Node root, int firstNode, int secondNode) {
		if (root == null || firstNode == secondNode) {
			return 0;
		}

		int x = pathLength(root.left, firstNode) - 1;
		int y = pathLength(root.right, secondNode) - 1;
		int lcaData = findLowestCommonAncestor(root, firstNode, secondNode).value;
		int lcaDistance = pathLength(root, lcaData) - 1;
		//return (x + y) - 2 + lcaDistance;
		return lcaDistance;
	}

	private static int pathLength(Node root, int n1) {
		if (root != null) {
			int x = 0;
			if ((root.value == n1) || (x = pathLength(root.left, n1)) > 0 || (x = pathLength(root.right, n1)) > 0) {
				return x + 1;
			}
			return 0;
		}
		return 0;
	}

	private static Node findLowestCommonAncestor(Node root, int n1, int n2) {
		if (root != null) {
			if (root.value == n1 || root.value == n2) {
				return root;
			}
			Node left = findLowestCommonAncestor(root.left, n1, n2);
			Node right = findLowestCommonAncestor(root.right, n1, n2);
			if (left != null && right != null) {
				return root;
			}
			if (left != null) {
				return left;
			}
			if (right != null) {
				return right;
			}
		}
		return null;
	}
	
	public static void main(String [] args) {
		AmazonBST bst = new AmazonBST();
		int[] values = {5, 6, 3, 1, 2, 4};
		bst.bstDistance(values, 6, 2, 4);
	}

}
