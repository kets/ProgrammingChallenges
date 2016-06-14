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
		return n;
	}
	
	/**
	 * 
	 * @param head
	 * @return
	 */
	public LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {

		if (head == null || head.next == null) {
			return null;
		}
		LinkedListNode second = head.next;
		LinkedListNode third = second.next;
		second.next = head; // point 2nd pointer to head
		head.next = null; // change head pointer to null
		if (third == null)
			return second; // only have two nodes
		LinkedListNode currNode = third;
		LinkedListNode prevNode = second;
		while (currNode != null) {
			LinkedListNode nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		head = prevNode;
		return head;
	}
	
	public LinkedListNode<Integer> recursiveReverse(LinkedListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		LinkedListNode reverse = recursiveReverse(head.next);
		head.next.next = head;
		head.next = null;
		return reverse;
		
	}
	
}


