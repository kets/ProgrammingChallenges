package programming.challenges;

public class Quicksort {
	private int [] numbers;
	private int number;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Quicksort sorter = new Quicksort();
	    int[] test = { 5, 5, 6, 6, 4, 4, 5, 5, 4, 4, 6, 6, 5, 5 };
	    sorter.sort(test);
	    sorter.printResult(test);

	}
	
	
	private void printResult(int[] numbers) {
	    for (int i = 0; i < numbers.length; i++) {
	      System.out.print(numbers[i]);
	    }
	    System.out.println();
	  }
	private int getKthSmallestElement (int [] array, int k){
		
		
		return -1;
		
	}
	
	public void sort (int [] values){
		//check for empty or null array
		if (values == null || values.length == 0){
			return;
		}
		
		this.numbers = values;
		number = values.length;
		quicksort(0, number -1);
		
		
		
	}
	
	private void quicksort (int low, int high){
		int i = low, j = high;
		//get the pivot element from the middle of the list
		int pivot = numbers[low + (high-low)/2];
		
		//divide into two lists
		while (i <= j){
			//if the current value from the left list is smaller then the pivot element then get the next elmenet from the left list
			
			while (numbers[i] < pivot){
				i++; 
			
			}
			//if the current value from the right list is larger then the pivot element then get the next element from the right list
			
			while (numbers[j] > pivot){
				j--;
			}
			
			//if we habe found a value in the left list which is larger then the pivot element and if we habe found a value in the right list which is
			//smaller then the pivot element then we exchange the values.
			//then increase i and decrease j
			
			if (i <= j){
				exchange (i,j);
				i++;
				j--;
			}
			
		}
		
		//recursion
		if (low < j){
			quicksort (low, j);
			
		}
		
		if (i < high){
			quicksort (i, high);
		}
	}
	
	private void exchange (int i, int j){
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
	
	

}
