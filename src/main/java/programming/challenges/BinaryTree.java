package programming.challenges;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
public class BinaryTree {
	// root node pointer. will be null for an empty tree

	private Node root;

	private static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.left = null;
			this.right = null;
			this.data = data;
		}

	}

	private static int currentNodeCount = 0;

	/**
	 * creates an empty binary tree with a null root pointer
	 */
	public BinaryTree(Node root) {
		this.root = root;
	}

	public BinaryTree() {

	}

	/**
	 * returns true if the given target is in the binary tree. uses a recursive
	 * helper
	 */
	public boolean lookup(int data) {
		return lookup(root, data);
	}

	/**
	 * recursively looks up the data given a node
	 * 
	 * @param node
	 * @param data
	 * @return
	 */
	private boolean lookup(Node node, int data) {
		if (node == null) {
			return false;
		}

		if (data == node.data) {
			return true;
		} else if (data < node.data) {
			return lookup(node.left, data);
		} else {
			return lookup(node.right, data);
		}
	}

	public void insert(int data) {
		insertNodeIntoBST(root, data);
	}

	private Node insertNodeIntoBST(Node root, int data) {
		if (root == null) {
			return new Node(data);
		}
		
		if (data < root.data) {
			if (root.left != null) {
//				System.out.println("root.left: "+ root.left.data );
//				System.out.println("data: "+ data );
				insertNodeIntoBST(root.left, data);
			} else {
				Node leftChild = new Node(data);
//				System.out.println("left child: "+ data );
				root.left = leftChild;
			}
		} else {
			if (root.right != null) {
//				System.out.println("root.right: "+ root.right.data );
//				System.out.println("data: "+ data );
				insertNodeIntoBST(root.right, data);

			} else {
				Node rightChild = new Node(data);
//				System.out.println("right child: "+ data );
				root.right = rightChild;
			}

		}
//		System.out.println("root: "+ root.data );
		return root;
	}

	private Node insert(Node node, int data) {
		if (node == null) {
			return node = new Node(data);
		} else {
			if (data < node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		return node;

	}
	
	/**
	 * you are given a pointer to the root of a binary tree. Print the top view of the binary tree. 
	 * @param currNode
	 */
	public void topView(Node currNode){
		if (currNode == null) {
			return;
		} else {
			leftView(currNode.left);
			System.out.print(currNode.data + " ");
			rightView(currNode.right);

		}
	}
	
	private void leftView (Node leftNode) {
	    if (leftNode == null) {
	        return;        
	    }
	    leftView(leftNode.left);
	    System.out.print(leftNode.data + " ");
	    
	}

	private void rightView (Node rightNode) {
	    if (rightNode == null) {
	        return;        
	    }
	    System.out.print(rightNode.data + " ");
	    rightView(rightNode.right);    
	    
	}
	
	public void printLevelOrder(Node currNode) {
		if (root == null) {
			return;
		} else {
			
		}
	}

	/**
	 * Build 123 using three pointer variables. 2 / \ 1 3
	 */
	public void build123() {
		// root node
		root = new Node(2);
		Node node1 = new Node(1);
		Node node3 = new Node(3);

		root.left = node1;
		root.right = node3;

	}

	/**
	 * Build 123 using one pointer variables. 2 / \ 1 3
	 */
	public void build123WithOnePointer() {
		// root node
		root = new Node(2);
		root.left = new Node(1);
		root.right = new Node(3);
	}

	/**
	 * Build 123 using three inserts 2 / \ 1 3
	 */
	public void build123WithOneInsert() {
		// root node
		root = null;
		root = insert(root, 2);
		root = insert(root, 1);
		root = insert(root, 3);

	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		if (node == null) {
			return 0;
		} else {
			return size(node.left) + 1 + size(node.right);
		}

	}

	public int maxDepth() {
		return maxDepth(root);
	}

	/**
	 * max depth == farthest leaf node
	 * 
	 * @param node
	 * @return
	 */
	private int maxDepth(Node node) {
		if (node == null) {
			return 0;
		} else {
			int leftDepth = maxDepth(node.left);
			int rightDepth = maxDepth(node.right);
			System.out.println("max+1 :" + (Math.max(leftDepth, rightDepth) + 1));
			return Math.max(leftDepth, rightDepth) + 1;
		}
	}
	

	/**
	 * given a binary tree, return the longest paths b/w any two nodes in a tree. This path may or may not pass through the root
	 * @param root
	 * @return
	 */
	public List<List<Integer>> longestPath(Node root) {
		
		List<Integer> longestPath = null;
		
		return null;
		
	}
	
	/**
	 * convert a ternary expression into a binary tree
	 * ex: 1?2?3:4:5
	 * @param str
	 * @return
	 */
	public Node build(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		
		Node root = new Node(Character.getNumericValue(str.charAt(0)));
		Stack<Node> treeStack = new Stack<Node>();
		treeStack.push(root);
		
		for (int i = 1; i < str.length(); i += 2) {
			Integer currNodeData = Character.getNumericValue(str.charAt(i + 1));
			Node currNode = new Node(currNodeData);
			System.out.println("currNode.data - " + currNode.data);
			if (str.charAt(i) == '?') {
				System.out.println("treeStack.peek() " +treeStack.peek().data);
				treeStack.peek().left = currNode;
				treeStack.push(currNode);
			} else if (str.charAt(i) == ':') {
				System.out.println("treeStack.peek() before pop() " +treeStack.peek().data);
				treeStack.pop();
				System.out.println("treeStack.peek() after pop() " +treeStack.peek().data);
				treeStack.peek().right = currNode;
			}
		}
		
		
		return root;
		
	}
	
	/**
	 * convert a ternary expression into a binary tree
	 * ex: 1?2?3:4:5
	 * @param str
	 * @return
	 */
	public Node buildBSTFromTernary(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		
		Node root = null;// = new Node(Character.getNumericValue(str.charAt(0)));
		Stack<Node> treeStack = new Stack<Node>();
		//treeStack.push(root);
	
		
		
		boolean qSeenLast = false;
		boolean cSeenLast = false;
		Node poppedNode = null, lastNode = null;
		
		for (int i = 0; i < str.length(); i++) {

			if (i == 0) {
				Integer rootNodeData = Character.getNumericValue(str.charAt(i));
				root = new Node(rootNodeData);
				treeStack.push(root);
				lastNode = root;
				
			} else if (str.charAt(i) == '?' ) {
				
				//push the number that's before the ? onto the stack only if the symbol is ?				
				treeStack.push(lastNode);
				
				qSeenLast = true;
				
				System.out.println("treeStack.peek() " +treeStack.peek().data);
				
			} else if (str.charAt(i) == ':') {
				cSeenLast = true;
				System.out.println("treeStack.peek() before pop() " +treeStack.peek().data);
				poppedNode = treeStack.pop();
				System.out.println("treeStack.peek() after pop() " +treeStack.peek().data);
				//treeStack.peek().right = currNode;
			} else if (qSeenLast) {
				Integer leftNodeData = Character.getNumericValue(str.charAt(i));
				Node leftNode = new Node(leftNodeData);
				treeStack.peek().left = leftNode;
				lastNode = leftNode;
				qSeenLast = false;
			} else if (cSeenLast) {
				Integer rightNodeData = Character.getNumericValue(str.charAt(i));
				Node rightNode = new Node(rightNodeData);
				poppedNode.right = rightNode;
				lastNode = rightNode;
				cSeenLast = false;
			}
			
			
		}
		
		
		return root;
		
	}
	
	public int diameter(Node root) {
		//check if the root node is null, if so return 0
		if (root == null) {
			return 0;
		}
		
		//get the heights of the left and right subtrees
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		//get the diameter of the left and right subtrees
		int leftDiameter = diameter(root.left);
		int rightDiameter = diameter(root.right);
		
		/* Return max of following three
        1) Diameter of left subtree
        2) Diameter of right subtree
        3) Height of left subtree + height of right subtree + 1 */
		
		return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
		
	}
	
	/**
	 * The function Compute the "height" of a tree. Height is the
     * number f nodes along the longest path from the root node
     * down to the farthest leaf node.
    */
	public int height(Node root) {
		if (root == null) {
			return 0;
		}
		
		/* If tree is not empty then height = 1 + max of left
        height and right heights */
		return (1 + Math.max(height(root.left), height(root.right)));
		
	}

	public int minValue() {
		return minValue(root);
	}

	/**
	 * find the min value. will have to search the left part of the tree
	 * 
	 * @param node
	 * @return
	 */
	public int minValue(Node node) {
		Node current = node;
		while (current.left != null) {
			current = current.left;
		}

		return current.data;
	}

	public void printTree() {
		System.out.println("----printInOrderTree()----");
		printInOrderTree(root);

	}

	public void printInOrderTree(Node node) {
		if (node == null) {
			System.out.println("Tree is empty!");
			return;
		} else {
			// left, node itself, right
			printInOrderTree(node.left);
			System.out.println(node.data + "  ");
			printInOrderTree(node.right);
		}
	}
	
	public void printPreOrderTree(Node root) {
		if (root == null) {
			 System.out.println("Tree is empty!");
			return;
		} else {
			// root, left, right
			System.out.println(root.data + "  ");
			printInOrderTree(root.left);		
			printInOrderTree(root.right);
		}
		
	}

	public void printPostTree() {
		System.out.println("---printPostTree()---");
		printPostOrderTree(root);

	}

	private void printPostOrderTree(Node node) {
		if (node == null) {
			// System.out.println("Tree is empty!");
			return;
		} else {
			// left, right recur
			printPostOrderTree(node.left);
			printPostOrderTree(node.right);

			// print root node
			System.out.println(node.data + " ");
		}

	}

	public boolean hasPathSum(int sum) {
		return hasPathSum(root, sum);
	}

	private boolean hasPathSum(Node node, int sum) {
		if (node == null) {
			// check if sum == 0 since we subtracted each node in the path
			return sum == 0;
		} else {
			int subValue = sum - node.data;
			System.out.println("currentSum: " + sum);
			System.out.println("currentNode: " + node.data);
			System.out.println("currentSubValue: " + subValue);
			System.out.println("----------");
			return hasPathSum(node.left, subValue)
					|| hasPathSum(node.right, subValue);
		}
	}

	@SuppressWarnings("unused")
	private void printLeaves(Node node) {
		if (node == null) {
			// empty tree, return
			return;
		} else {
			if (node.left != null || node.right != null) {
				if (node.left != null) {
					printLeaves(node.left);
				}

				if (node.right != null) {
					printLeaves(node.right);
				}

			} else {

				System.out.println(node.data);

			}
		}

	}

	//if we can't use static variables, decrement K until K = 0, then we've found our kth element
	
	public Node getKthElementWithoutStaticVariable(Node root, int k) {
		Node node = null;
		
		if (root == null) {
			// root node is null, nothing to traverse
			return null;
		}
		
		//visit the left subchild, if it exists
		if (root.left != null) {
			System.out.println("left node: " + root.left.data + " k: "+ k);
			//traverse the left subtree
			node = getKthElementWithoutStaticVariable(root.left, k);
			
			if (node != null) {
				//found kth element, return the node
				return node;
			}
			//node == null, kth element not found, keep traversing
			
		}
		k--;
		System.out.println(" k: " + k);
		
		if (k == 0) {
			//System.out.println("currentNodeCount == k: " + root.data);
			return root;
		}
		
		//check if right child is null
		if (root.right != null) {
			System.out.println("right node: " + root.right.data + " k: "+ k);
			// traverse the right subtree
			node = getKthElementWithoutStaticVariable(root.right, k);
			
			if (node != null) {
				//found kth element, return node
				return node;
			}
			//node == null, kth element not found, keep traversing

			// root.right == null, we have reached the right most element
			// (highest of this subtree)

//			if (k == 0) {
//				return root;
//			}
			return node;
		}
		
		
		return node;
	}
	
	public Node getKthElement(Node root, int k) {
		Node node = null;
		if (root == null) {
			// root is null, nothing to traverse
			return null;
		}

		// Visit the left subchild, if it exists.
		if (root.left != null) {
			System.out.println("left node: " + root.left.data);
			// traverse the left subtree
			node = getKthElement(root.left, k);
			
			if (node != null) {
				//found kth element, return that node
				return node;
			}
			//if node == null, then you haven't found kth element --> keep looking

		}

		// Visit myself (I always exist)
		// increment the count for the current node
		currentNodeCount++;
		System.out.println("currentNodeCount: " + currentNodeCount);

		// Did we find the kth element? Return if so.
		if (currentNodeCount == k) {
			System.out.println("currentNodeCount == k: " + root.data);
			return root;
		}
		else if (currentNodeCount > k) {
			//in case we weren't able to return when currentNodeCount == k, return the node we came from
			System.out.println("currentNodeCount > k: " + node.data);
			return node;

		}
		//check if right child is null
		if (root.right != null) {
			System.out.println("right node: " + root.right.data);
			// traverse the right subtree
			node = getKthElement(root.right, k);
			
			if (node != null) {
				//found kth element, keep traversing
				return node;
			}
			//if node == null, then you haven't found kth element --> keep looking

			// root.right == null, we have reached the right most element
			// (highest of this subtree)

			if (currentNodeCount == k) {
				return root;
			}
			return node;
		}
		return node;
	}

	public void printPaths() {
		ArrayList<Integer> pathArray = new ArrayList<Integer>();
		printAllPaths(root, pathArray);

	}

	public void printPaths2(Node root) {
		ArrayList<Integer> pathArray = new ArrayList<Integer>();
		printAllPaths(root, pathArray);

	}

	private void printAllPaths(Node node, ArrayList<Integer> pathArray) {
		if (node == null) {
			// empty tree, return
			return;
		} else {
			if (node.left != null || node.right != null) {

				// only add the node to the pathArray once here on visiting it
				pathArray.add(node.data);

				if (node.left != null) {

					printAllPaths(node.left, pathArray);
				}

				if (node.right != null) {

					printAllPaths(node.right, pathArray);
				}

				// after visiting all the node's children, need to remove that
				// node from the pathArray
				// we remove the node from the array once we have visited all
				// its children and subsequently removed them
				pathArray.remove(pathArray.size() - 1);

			} else {
				// child node, print it along with remaining nodes in the
				// arraylist
				Iterator<Integer> iter = pathArray.iterator();
				while (iter.hasNext()) {
					// print the path minus the leaf node
					System.out.print(iter.next() + "-");
				}
				// print the leaf node
				System.out.println(node.data);

			}
		}

	}
	
	public static int getMaxUniquePath (Node root) {
		if (root == null) {
			return 0;
		}
		Set<Integer> uniqueSet = new HashSet<Integer>();
		return getMaxPath(root, uniqueSet);
	}
	
	private static int getMaxPath(Node root, Set<Integer> uniqueSet) {
		if (root == null) {
			return uniqueSet.size();
		}
		
		int left = 0;
		int right = 0;
		if (uniqueSet.add(root.data)) {
			//unique entry
			left =  getMaxPath(root.left, uniqueSet);
			right = getMaxPath(root.right, uniqueSet);
			uniqueSet.remove(uniqueSet.size() - 1);
		}
		return Math.max(left, right);
	}

	@SuppressWarnings("unused")
	private Node createBST() {
		Node root = null;
		int[] bstArray = { 12, 4, 7, 5, 3, 18, 20, 42, 1, 19, 6, 19 };
		for (int i = 0; i < bstArray.length; i++) {
			root = insertNodeIntoBST(root, bstArray[i]);
		}
		System.out.println("createBST().root: "+ root.data);
		return root;
	}
	
	public boolean isBalanced(Node root){
	    return checkBalance(root) != -1;
	}

	private int checkBalance(Node node){
	    if(node == null) return 0;
	    int left = checkBalance(node.left);

	    if(left == -1) return -1;

	    int right = checkBalance(node.right);

	    if(right == -1) return -1;

	    if(Math.abs(left - right) > 1){
	        return -1;
	    }else{
	        return 1 + Math.max(left, right);
	    }
	}
	
	public static int swapBit(int num) {
		int odds = ( 0xAAAAAAAA & num) >> 1; //clear the even bits
		int evens = ( 0x55555555 & num) << 1; //clear the odd bits
		return odds | evens;
	
	}

	public static void main(String[] args) {
		 Node root = new Node(3);
		 root.left = new Node(5);
		 root.left.left = new Node(1);
		 root.left.left.right = new Node(9);
		 root.right = new Node(2);
		 root.right.left = new Node(6);
		 root.right.right = new Node(7);
		 root.right.right.left = new Node(8);
		 root.right.right.right = new Node(2);
		 

		 BinaryTree bt = new BinaryTree();

		// bt.printPostTree();
//		 bt.printPaths();
//		 bt.printPostOrderTree(root);
		// System.out.println("size: " + bt.size());
		// System.out.println("minValue: " + bt.minValue());
		
//		System.out.println("maxDepth: " + BinaryTree.getMaxUniquePath(root));
		// System.out.println("hasPathSum: " + bt.hasPathSum(30));
		// bt.printPaths();

//		BinaryTree bt2 = new BinaryTree();
		//System.out.println("swap Bit: " + bt2.swapBit(5));
		//Node root = bt2.createBST();
		
		//System.out.println("root: " + root.data);
//		bt2.printPaths2(root);
	//	bt2.printInOrderTree(root);
		//System.out.println("max depth: "+ bt2.maxDepth(root));
		//System.out.println("isBalanced: "+ bt2.checkBalance(root));
//		bt2.topView(root);

//		for (int i = 1; i < 11; i++) {
//			bt2.currentNodeCount = 0;
//			//System.out.println("kth-element: " + bt2.getKthElement(root,i).data);
//		}
//		System.out.println("kth-element: " + bt2.getKthElementWithoutStaticVariable(root,3).data);
//		System.out.println("kth-element: " + bt2.getKthElement(root,1).data);
//		System.out.println("kth-element: " + bt2.getKthElement(root,2).data);
//		System.out.println("kth-element: " + bt2.getKthElement(root,3).data);
//		System.out.println("kth-element: " + bt2.getKthElement(root,4).data);
//		System.out.println("kth-element: " + bt2.getKthElement(root,5).data);
//		System.out.println("kth-element: " + bt2.getKthElement(root,6).data);
//		System.out.println("kth-element: " + bt2.getKthElement(root,7).data);
//		System.out.println("kth-element: " + bt2.getKthElement(root,8).data);
//		System.out.println("kth-element: " + bt2.getKthElement(root,9).data);
//		System.out.println("kth-element: " + bt2.getKthElement(root,1).data);
		 
		 
		 bt.printInOrderTree(bt.buildBSTFromTernary("1?2?3:4:5"));
	}

}
