package programming.challenges;

public class Misc {
	
	public static void main (String [] args) {
		
		
		
	}
	
	/**
	 * write a program to sort a stack in ascending order
	 */
	public LinkedStack<Integer> sort (LinkedStack<Integer> s){
		
		LinkedStack<Integer> finalStack = new LinkedStack<Integer>();
		while (!s.isEmpty()) {
			Integer tmp = (Integer) s.pop();
			while (!finalStack.isEmpty() && (Integer)finalStack.peek() > tmp) {
				s.push(finalStack.pop());
			}
			finalStack.push(tmp);
		}
		return s;
		
	}
	

}

