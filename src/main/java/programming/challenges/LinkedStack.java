package programming.challenges;

import java.util.NoSuchElementException;

interface Stack {
	void push(Object item);
	Object pop();
	Object peek();
	int size();
	boolean isEmpty();
}

public class LinkedStack<T> implements Stack {
	
	private LinkedListNode top = null;

	@Override
	public void push(Object item) {
		top = new LinkedListNode(item, top);
		
	}

	@Override
	public Object pop() {
		Object item = peek();
		top = top.next;
		return item;
	}

	@Override
	public Object peek() {
		if (top == null) {
			throw new NoSuchElementException();
		}
		return top.data;
	}

	@Override
	public int size() {
		int count = 0;
		for (LinkedListNode node = top; node != null; node = node.next) {
			count++;
		}
		return count;
	}

	@Override
	public boolean isEmpty() {
		
		return top == null;
	}
	
	
	
	

}
