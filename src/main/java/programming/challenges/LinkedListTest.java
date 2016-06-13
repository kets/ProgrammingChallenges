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
	
	/**
	 * remove node i the middle of the linkedlist
	 * cannot be solved if node to be deleted is the last node in the LL
	 */
	public static boolean deleteNode (LinkedListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		LinkedListNode next = head.next;
		head.data = next.data;
		return true;
	}
	
	/**
	 * delete a node in LL
	 */
	public LinkedListNode<Integer> deleteNode (LinkedListNode<Integer> head, Integer data) {
		LinkedListNode n = head;
		if (n.data.equals(data)) {
			return head.next;
		}
		while (n.next != null) {
			if (n.next.data.equals(data)) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
	}
}


