package programming.challenges;

import java.util.Arrays;

public class Misc {

	public static void main(String[] args) {

	}

	/**
	 * write a program to sort a stack in ascending order
	 */
	public LinkedStack<Integer> sort(LinkedStack<Integer> s) {

		LinkedStack<Integer> finalStack = new LinkedStack<Integer>();
		while (!s.isEmpty()) {
			Integer tmp = (Integer) s.pop();
			while (!finalStack.isEmpty() && (Integer) finalStack.peek() > tmp) {
				s.push(finalStack.pop());
			}
			finalStack.push(tmp);
		}
		return s;

	}

	/**
	 * implement a palindrome
	 * Storage complexity: O(n) b/c reverse grows with the length of word. 
	 */
	public boolean isPalindrome(String word) {
		String reverse = null;
		for (int i = word.length() - 1; i >= 0; i--) {
			reverse = reverse + word.charAt(i);
		}
		if (word.equals(reverse)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * determine if the word is an anagram of the original word
	 */
	public boolean isAnagram(String word, String anagram) {
		if (word.length() != anagram.length()) {
			return false;
		}
		char[] charFromWord = word.toCharArray();
		char[] charFromAnagram = anagram.toCharArray();
		Arrays.sort(charFromWord);
		Arrays.sort(charFromAnagram);
		return Arrays.equals(charFromWord, charFromAnagram);
	}

	public boolean isAnagram2(String word, String anagram) {
		if (word.length() != anagram.length()) {
			return false;
		}

		char[] charFromWord = word.toCharArray();
		for (char c : charFromWord) {
			int index = anagram.indexOf(c);
			if (index != -1) {
				anagram = anagram.substring(0, index) + anagram.substring(index + 1, anagram.length());

			} else {
				return false;
			}
		}
		return anagram.isEmpty();
	}

}
