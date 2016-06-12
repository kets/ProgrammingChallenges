package programming.challenges;

public class LinkedListTest {

	public static void deleteDups2(LinkedListNode head) {
		if (head == null)
			return;
		LinkedListNode previous = head;
		LinkedListNode current = previous.next;
		while (current != null) {
			LinkedListNode runner = head;
			while (runner != current) { // Check for earlier dups
				if (runner.data == current.data) {
					LinkedListNode tmp = current.next; // remove current
					previous.next = tmp;
					current = tmp; // update current to next node
					break; // all other dups have already been removed
				}
				runner = runner.next;
			}
			if (runner == current) { // current not updated - update now
				previous = current;
				current = current.next;
			}
		}
	}
	
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

}


