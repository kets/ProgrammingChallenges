package programming.challenges;

/**
 * use two stacks to implement a queue
 */

public class Queue<T> {
	LinkedStack<T> s1, s2;

	public Queue() {
		s1 = new LinkedStack<T>();
		s2 = new LinkedStack<T>();
	}

	public int size() {
		return s1.size() + s2.size();
	}

	public void add(T value) {
		s1.push(value);
	}

	public T peek() {
		if (!s1.isEmpty()) {
			return (T) s2.peek();
		}
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		return (T) s2.peek();
	}

	public T remove() {
		if (!s2.isEmpty()) {
			return (T) s2.pop();
		}
		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		return (T) s2.pop();
	}

}
