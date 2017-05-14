package programming.challenges;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import javax.swing.tree.TreeNode;
import java.util.Stack;

public class Misc {

	public static void main(String[] args) {
		Misc miscTests = new Misc();
		int [] nums = { 0,1,0,0,1,1,1,0,1,0};
//		System.out.println("binaryArray sorted: " + (miscTests.sortBinaryArray(nums)).toString());
		//miscTests.printFactors(12);
//		System.out.println(" k = 3 ==> " + miscTests.formatString("2-4a0r7-4k", 3));
//		System.out.println(" k = 4 ==> " +miscTests.formatString("2-4a0r7-4k", 4));
//		System.out.println(" k = 2 ==> " +miscTests.formatString("2-4a0r7-4k", 2));
//		System.out.println(" k = 2 ==> " +miscTests.formatString("2-4a0r7-4k", 5));
//		
	
		
		int [] pivotNums = {3,1,4,7,-1,10,9};
//		System.out.println(miscTests.findPivot(pivotNums));
		//System.out.println(matchBrace("(())))("));
		miscTests.maxSlidingWindow(pivotNums, 3);

	}
	
	/**
	 * calculate the height of an n-ary tree
	 */
//	public static int getHeightOfTree (TreeNode root) {
//		if (root == null) 
//			return 0;
//		int maxHeight = 0;
//		
//		
////		for (TreeNode n : root.children()) {
////			
////		}
//		
//		
//		
//	}
	
	/**
	 * Return the pivot index of the given array of numbers. The pivot index is the index
	 * where the sum of the numbers on the left is equal to the sum of the
	 * numbers on the right
	 * input array: {1, 2, 3, 4, 4, 6}
	 */
	public int findPivot(int [] arr){
		int leftSum = 0;
		int rightSum = 0;
		for (int i = 0; i < arr.length; i++) {
			rightSum += arr[i];
		}
		
		for (int i = 0; i < arr.length; i++){
			rightSum -= arr[i];
			leftSum += arr[i];
			if (leftSum == rightSum) {
				return i;
			}
			
		}
		
		return 0;
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
	
	/**
	 * sort binary array with minimum time complexity
	 */
	public int[] sortBinaryArray(int [] nums) {
		if (nums == null || nums.length == 0 ){
			return nums;
		}
		int left = 0, right = nums.length - 1;
		while (left < right) {
			if (nums[left] == 0) {
				left++;
			}
			if (nums[right] == 1){
				right--;
			}
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			
		}
		return nums;
	}
	
	private static void shuffle(int[] cards) {
		int totalCards = cards.length;
		for (int i = 0; i < totalCards; ++i) {
			int randomIndex = (int) (Math.random() * totalCards);
			int temp = cards[randomIndex];
			//cards[randomIndex] = deck[i];
			cards[i] = temp;
		}
	}

	private static int[][] deal(final int[] card, int nPlayers) {
		int noOfPlayers = nPlayers;
		int totalCards = card.length;
		int cardPerPlayer = totalCards / noOfPlayers;
		int[][] players = new int[noOfPlayers][cardPerPlayer];
		int i = 0;
		int j = 0;
		int k = 0;
		
		while (i < totalCards) {
			j = j % noOfPlayers; // four players accessed in a cyclic order
			players[j][k] = card[i];
			++j;
			++i;
			if (j == noOfPlayers)
				++k; // increment k only after all 4 players have recieved one
						// card each
		}
		return players;
	}
	
	public static void printFactors(int value)
	{
		if( value < 1)
			return;
		for (int i = 1 ; value >= i*i ; i++)
		{
			int j = 0;
			if((value)%i == 0)
			{
				j = value/i;
				System.out.println("{0}*{1}" + i +" " + j);
			}
		}
	}
	
	/**
	 * Given a string "2-4a0r7-4k", there are two dashes which we can split into 3 groups of length 1, 5, 2. 
		If we want each group to be length 4, then we get "24A0-R74k" 
		Given a String A and an int K, return a correctly formatted string
		IF A is "2-4A0r7-4k" and B is 4, string is "24A0-R74K" 
		IF K is 3, string is "24-A0R-74K" as the first grp could be shorter.
	 */
	
	public String formatString (String str, int k) {
		
		//have to remove all the '-' from the string
		str = str.replaceAll("-", "");
		StringBuilder sb = new StringBuilder(str);
		
		//start at the end of the string, since we want to make sure the small group for the odd split is at the beginning 
		//24A0R74K
		//K47-R0A-42
		// strLength % k == 0, then 
		
	
		sb.reverse();
		for (int i = k; i < sb.length(); i = i + k) {
			//System.out.println(i);
			sb.insert(i, "-");
			i++;
		}
		sb.reverse();

		return sb.toString();//.reverse().toString();
		
	}
	
	/**
	 * Find K which decides the # of open brackets are equal to the # of closed brackets
	 * @param str
	 * @return
	 */
	public static int matchBrace(String str){
		int i = 0;
		int j = str.length()-1;
		while(i < j){
			if(str.charAt(i) == ')'){
				i++;
				
			}
			if(str.charAt(j) == '('){
				j--;
			}
			if(str.charAt(i) == '(' && str.charAt(j) == ')'){
				i++;
				j--;
			}
		}
		return i+1;
	}

	/**
	 * given a str of brackets, find if the brackets are balanced
	 * @param str
	 * @return
	 */
	public boolean balancedString (String str) {
		
		Stack<Character> balancedStack = new Stack<Character>();

		for (int i = 0; i < str.length() - 1; i++) {
			if (balancedStack.empty()) {
				// push the char on the stack
				balancedStack.push(str.charAt(i));
			}

			char currChar = balancedStack.peek();
			if (isMatch(str.charAt(i), currChar)) {
				// found a matching bracket
				balancedStack.pop();
			}
		}

		if (balancedStack.empty()) {
			return true;
		}

		return false;
	}
	
	private boolean isMatch(char open, char close) {

		if (open == '{' && close == '}') {
			return true;
		}

		if (open == '(' && close == ')') {
			return true;
		}

		if (open == '[' && close == ']') {
			return true;
		}
		return false;

	}
	
	public int[] maxSlidingWindow(int [] arr, int windowSize) {
		if (arr.length == 0) {
			return new int[0];
		}
		
		//size for new array
		int newArraySize = arr.length - windowSize + 1;
		int [] resultArr = new int[newArraySize];
		
		//create a priority to store the max in the sliding window
		Queue<Integer> pQueue = new PriorityQueue<Integer>(newArraySize, new Comparator<Integer>() {

			@Override
			public int compare(Integer firstNum, Integer secondNum) {
				
				//add to queue in reverse order (max heap, biggest interger at the head)
				if (firstNum < secondNum) return 1;
				if (firstNum > secondNum) return -1;
				return 0;
			}
			
		});
		
		//iterate through first window and add numbers to queue
		for (int i = 0; i < windowSize; i++) {
			System.out.println("arr["+i+"] = " + arr[i]); 
			pQueue.add(arr[i]);
			
		}
		System.out.println("pQueue.peek() " + pQueue.peek());
		//add the first max integer to the results array
		resultArr[0] = pQueue.peek();
		
		for (int j = windowSize; j < arr.length; j++) {
			//remove the number that falls out of the window
			System.out.println("number to fall out of window: "+arr[j-windowSize]);
			
			pQueue.remove(arr[j-windowSize]);
			
			//add the current number in the current window
			System.out.println("current number to add to queue: "+arr[j]);
			pQueue.add(arr[j]);
			
			//current max to be added to result array
			System.out.println("number added to result array: " + pQueue.peek());
			resultArr[j - windowSize + 1] = pQueue.peek();
		}
		
		
		
		
		return resultArr;
		
	}

}
