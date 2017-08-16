package programming.challenges;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

import javax.swing.tree.TreeNode;
import java.util.Stack;
import java.util.UUID;

public class Misc {

	public static void main(String[] args) {
		Misc miscTests = new Misc();
		int [] nums = { 40, 2, 8, 5, 20, 1, 23, 19, 13, 21, 23};
//		System.out.println("binaryArray sorted: " + (miscTests.sortBinaryArray(nums)).toString());
		//miscTests.printFactors(12);
//		System.out.println(" k = 3 ==> " + miscTests.formatString("2-4a0r7-4k", 3));
//		System.out.println(" k = 4 ==> " +miscTests.formatString("2-4a0r7-4k", 4));
//		System.out.println(" k = 2 ==> " +miscTests.formatString("2-4a0r7-4k", 2));
//		System.out.println(" k = 2 ==> " +miscTests.formatString("2-4a0r7-4k", 5));
//		
	
		
		int [] pivotNums = {3,1,4,7,-1,10,9,1200, 90, -100, 11};
		int [] results;
		
//		for (int i = 0; i < pivotNums.length; i++) {
//			System.out.print(" " +pivotNums[i] + ",");
//		}
		
//		System.out.println(miscTests.findPivot(pivotNums));
		//System.out.println(matchBrace("(())))("));
//		miscTests.maxSlidingWindow(pivotNums, 2);
//		miscTests.maxSubArray(pivotNums, 3);
//		System.out.println(miscTests.rearrange(pivotNums).toString());
//		System.out.println(miscTests.lengthOfLongestSubstring("abcabcbb"));
//		results = miscTests.mergeSort(pivotNums);
//		System.out.println();
//		for (int i = 0; i < results.length; i++) {
//			System.out.print(" "+results[i] +",");
//		}
		
//		System.out.println(Misc.getFibNumbers(nums));
//		System.out.println(miscTests.getIndexOfMax(nums));
		int [] nums2 = { 2, 5, 10, -6, 1, 4, 2};
//		System.out.println(miscTests.combinationSum(nums2, 16, 3));
//		System.out.println(miscTests.combinationSum(nums, 40, 3));
//		String str = sanitizeAttachmentName("Ketaki-_^&%!   # '3*4!2 3(3)5+=@`~~.");
//		System.out.println(str);
//		UUID uuid = UUID.randomUUID();
//		System.out.println("uuid: "+ uuid.toString());
//		AnyBaseEncoder encoder = new AnyBaseEncoder(36);
//		String base36Str = encoder.encode(uuid);
//		System.out.println(base36Str);
//		UUID newUUID = encoder.decodeUuid(base36Str);
//		System.out.println(newUUID.toString());
		
		int[] result = miscTests.twoSum(nums, 28);
		System.out.println("result[0]: " + result[0] + " result[1]: " + result[1]);
		System.out.println("\"".trim());
	

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
	
	/**
	 * return an array of integers that are the max in (k) sliding windows
	 * @param arr
	 * @param windowSize
	 * @return
	 */
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
	/**
	 * given an array, find the subarray (containing at least k number) which has the largest sum
	 * @param nums
	 * @param k
	 * @return
	 */
	public int maxSubArray(int[] nums, int k) {
		if (nums.length == 0) {
			return 0;
		}

		int first = 0, last = k-1; // Indexes of the max sum sub-array
		int maxSum = 0;
		int currSum = 0;
		
		Queue<Integer> maxQueue = new PriorityQueue<Integer>(nums.length);

		// iterate through first window and generate the sum of numbers
		for (int i = 0; i < k; i++) {
			System.out.println("arr[" + i + "] = " + nums[i]);
			//sum the numbers
			currSum += nums[i];
			//add the numbers to the queue
			maxQueue.add(nums[i]);

		}
		maxSum = currSum;
		int runSum = 0;
		System.out.println("maxSum after first window " + maxSum);
		
		//iterate starting with the second number and add the next number in the window
		for (int j = k; j < nums.length; j++) {
			//System.out.println("nums[j] = " + nums[j]);
//			System.out.println("nums[j + k - 1] = " + nums[j + k - 1]);
			currSum += nums[j];
			runSum += nums[j-k];
			if (runSum < 0) {
				currSum -= runSum;
				runSum = 0;
			}
			if (currSum > maxSum) {
				maxSum = currSum;
			}
			
			//sum the peek() with the next number in the window
//			windowSum += nums[j + k - 1] + topNumberInQueue;
//
//			// add the current number in the current window
//			maxQueue.add(nums[j + k  - 1]);
//
//			//check if sum of this window is more than the maxSum
//			if (windowSum > maxSum) {
//				System.out.println("current window ["+first+","+ last +"] windowSum = "+ windowSum);
//				first = j;
//				last = j + k;
//				maxSum = windowSum;
//			}
		}
		
		return maxSum;

	}
	
	/**
	 * find all subsets of size k in an array that sum up to the target.
	 * the array may contain negative numbers
	 * 
	 * @param nums
	 * @param target
	 * @param k
	 * @return
	 */
	public List<List<Integer>> combinationSum(int [] nums, int target, int k) {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		if (nums.length == 0) {
			return resultList;
		}
		
		List<Integer> sumList = new ArrayList<Integer>();
		//call the helper function
		sumUtil(nums, 0, k, target, sumList, resultList);
		return resultList;
		
	}
	
	private void sumUtil(int [] nums, int beginIndex, int k, int target, List<Integer> sumList, List<List<Integer>> resultList) {
		if (k < 0) {
			//if k = -1, the previous recursive call returns/pops off the stack
			return;
		}
		
		if (k == 0 && target == 0) {
			//add the sumList to the list of results since we have k nums that add to target
			System.out.println("k == 0 && target == 0 :" + sumList);
			resultList.add(new ArrayList<Integer>(sumList));
			System.out.println("resultList: " + resultList);
			return;
		}
		
		//for each element in nums, find the remaining k - 1 elements that sum up to the target
		for (int i = beginIndex; i < nums.length; i++) {
			//add the current num to the list
			sumList.add(nums[i]);
			System.out.println(sumList);
			//recursively call with k decremented and difference of target - currentNumber
			sumUtil(nums, i + 1, k - 1, target - nums[i], sumList, resultList);
			sumList.remove(sumList.size() - 1);
		}
		
	}
	
	
	/**
	 * given an array of unsorted int (may have negative number),
	 * rearrange the array such that the num at the odd index is greater than the num at the even index
	 * [5,2,3,4,1] -> [1,4,2,5,3]
	 * @param nums
	 */
	public int[] rearrange(int[] input) {
		// if the array length is even, only need to do one pass through - for
		// each neighbor
		for (int i = 1; i < input.length - 1; i += 2) {
			if (input[i] < input[i - 1]) {
				swap(input, i, i - 1);
			}
			if (input[i] < input[i + 1]) {
				swap(input, i, i + 1);
			}
		}
		return input;
	}
	
	/**
	 * swap numbers between two indexes
	 * @param nums
	 * @param from
	 * @param to
	 */
	private void swap (int [] nums, int from, int to) {
		int temp = nums[from];
		nums[from] = nums[to];
		nums[to] = temp;
		
	}
	
	/**
	 * longest subtring without repeating characters
	 * @param str
	 * @return
	 */
	public int lengthOfLongestSubstring(String str) {
		if (str.length() == 0) {
			return 0;
		}
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		int max = 0;
		for (int i = 0, j = 0; i < str.length(); ++i) {
			if (charMap.containsKey(str.charAt(i))) {
				j = Math.max(j, charMap.get(str.charAt(i)) + 1);
			}
			charMap.put(str.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}
			
		return max;
		
	}
	
	public int[] mergeSort(int [] arr) {
		
		if (arr.length <= 1) {
			return arr;
		}
		
		//split the array in half
		int [] firstHalf = new int[arr.length / 2];
		int [] secondHalf = new int[arr.length - firstHalf.length];
		//copy the first half 
		System.arraycopy(arr, 0, firstHalf, 0, firstHalf.length);
		System.arraycopy(arr, firstHalf.length, secondHalf, 0, secondHalf.length);
		
		mergeSort(firstHalf);
		mergeSort(secondHalf);
		
		merge(firstHalf, secondHalf, arr);
		
		return arr;
		
	}
	
	private int [] merge(int [] firstHalf, int [] secondHalf, int [] result) {
		
		//index for the first half array
		int firstHalfIndex = 0;
		//index for second half array
		int secondHalfIndex = 0;
		//next open position in result
		int j = 0;
		
		while(firstHalfIndex < firstHalf.length && secondHalfIndex < secondHalf.length) {
			
			if (firstHalf[firstHalfIndex] < secondHalf[secondHalfIndex]) {
				//add to result
				result[j] = firstHalf[firstHalfIndex];
				firstHalfIndex++;	
			} else {
				result[j] = secondHalf[secondHalfIndex];
				secondHalfIndex++;
			}
			
			j++;
		}
		
		 // copy what's left
        System.arraycopy(firstHalf, firstHalfIndex, result, j, firstHalf.length - firstHalfIndex);
        System.arraycopy(secondHalf, secondHalfIndex, result, j, secondHalf.length - secondHalfIndex);
		
		return result;
		
	}
	
	/**
	 * from the input array, output a subset array with numbers part of a fibonacci series
	 * input = [4, 3, 8, 5, 20, 1, 40, 23]
	 * output = [2, 5, 1, 13]
	 * @param nums
	 * @return
	 */
	public static List<Integer> getFibNumbers(int [] nums) {
		
		List<Integer> fibNum = new ArrayList<Integer>();
		
		if (nums.length == 0) {
			return fibNum;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (isFibonacci(nums[i])) {
				fibNum.add(nums[i]);
			}
		}
		
		return fibNum;
	}
	
	private static boolean isFibonacci(int inputNumber) {
		int firstNum = 0;
		int secondNum = 1;
		int thirdNum = 0;
		
		while (thirdNum < inputNumber) {
			thirdNum = firstNum + secondNum;
			firstNum = secondNum;
			secondNum = thirdNum;
		}
		
		if (thirdNum == inputNumber) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * fibonacci using recursion
	 * @param number
	 * @return
	 */
	public static int fibonacci(int number) {
		if (number == 0) {
			return 0;
		} else if (number == 1) {
			return 1;
		} else {
			return fibonacci(number - 1) + fibonacci(number - 2);
		}
	}
	
	public void reverseFib (int num1, int num2) {
		int num3 = num1 - num2;
		System.out.println(num3);
	}
	
	public static long fibArray[] = new long[26];

	/**
	 * fibonacci with memoization
	 * @param n
	 * @return
	 */
	public static long fibonacci(long n) {
		long fibValue = 0;
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (fibArray[(int) n] != 0) {
			return fibArray[(int) n];
		} else {
			fibValue = fibonacci(n - 1) + fibonacci(n - 2);
			fibArray[(int) n] = fibValue;
			return fibValue;
		}
	}
	
	/**
	 * write a function that returns the index of the max number in an array
	 * if there are multiple max numbers, then return a random index for each run
	 * time = O(n) and space = O(1)
	 * @param nums
	 * @return
	 */
	public int getIndexOfMax(int [] nums) {
		
		if (nums.length == 0) {
			return 0;
		}
		int maxIndex = 0;
		int maxIndexCount = 0;
		int maxNum = nums[0];
		//figure out the max number
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > maxNum) {
				
				maxNum = nums[i];
				System.out.println("maxNum: "+ maxNum + " index: " + i);
			}
		}
		
		
		//loop again with two pointers : one to get the max number index and another to store that index number
		//somehwere in the array
		for (int j = 0; j < nums.length; j++) {
			if (nums[j] == maxNum) {
				//set the max index
				//
				nums[maxIndex++] = j;
				maxIndexCount++;
			} 
		}
		
//		maxIndex = (int) (Math.random() * maxIndexCount);
		Random rand = new Random();
		maxIndex = rand.nextInt(maxIndexCount);
		
		return 
				
				nums[maxIndex];
	}
	
	/**
	 * determine if an array is monotonic - return true if it's in ascending/descending order
	 * false otherwise
	 * @param nums
	 * @return
	 */
	public boolean isMonotonic(int [] nums) {
		if(nums.length == 0) {
			return false;
		}
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				//ascending
				
			} else {
				//descending
				
			}
		}
		
		return false;
		
	}
	
	/**
	 * Given an input array, return the indices of the two #'s that add up to a specific target
	 * you may assume that each input would have exactly one solution, and you may not use the same number twice
	 * this will only work if the two numbers are next to each other
	 */
	public int[] twoSum (int [] nums, int target) {
		int[]  result = new int[2];
		
		Map<Integer, Integer> indicesMap = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if (indicesMap.containsKey(target - nums[i])) {
				result[1] = i;
				result[0] = indicesMap.get(target - nums[i]);
				return result;
			}
			indicesMap.put(nums[i], i);
		}
		return result;
	}
	
	public int getMedian (int [] arr1, int []arr2, int length) {
		if (length <= 0) {
			return -1;
		}
		if (length == 1) {
			return ((arr1[0] + arr2[0]) / 2);
		}
		if (length == 2) {
			return (Math.max(arr1[0], arr2[0]) + Math.min(arr1[1], arr2[1])) / 2;
		}
		
		int m1 = median(arr1, length);
		int m2 = median(arr2, length);
		
		//if medians are equal then return either m1 or m2
		if (m1 == m2) {
			return m1;
		}
		
		//if m1 < m2, then median must exist in arr1[m1....] and arr2[....m2]
		if (m1 < m2) {
			if (length % 2 == 0) {
			//	return getMedian(arr1 + length/2 - )
			}
		}
		
		return 0;
	}
	
	private int median(int arr [], int length) {
		if (length % 2 == 0) {
			return (arr[length/2] + arr[length/2-1]) / 2;
		} else {
			return arr[length/2];
		}
	}
	
	public String[] wordSeparator(Set<String> dict, String str) {
		
		char[] strChars = str.toCharArray();
		String [] words = {};
		int i = 0;
		int j = 1;
		while (i < strChars.length) {
			char currentChar = strChars[i];
			String word = "";
			String unusedChars = "";
			for (j = i; i < strChars.length - 1; i++) {
				if(dict.contains(word + unusedChars + strChars[j])) {
					word = word + unusedChars + strChars[j];
					unusedChars = "";
					i = j;
				} else {
					unusedChars = unusedChars + strChars[j];
				}
				
				if (word != "") {
//					words = word
				}
				
			}
		}
		
		return null;
	}
	

}
