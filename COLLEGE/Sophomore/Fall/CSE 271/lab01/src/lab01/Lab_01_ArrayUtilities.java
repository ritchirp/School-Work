/**
 * 
 */
package lab01;

/**
 * @author Robert Ritchie Contains methods to build an int array and swap the
 *         values of two elements in an int array
 */
public class Lab_01_ArrayUtilities {

	// Builds an array of random numbers given the length of the array and the
	// range of numbers
	public static int[] buildIntArray(int length, int fromNum, int toNum) {

		int[] numbers = new int[length];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) ((toNum - fromNum + 1) * Math.random() + fromNum);
		}

		return numbers;
	}

	
	// Given an int array and two indices, swaps the values of the elements at
	// the given indices
	public static int[] swap(int[] nums, int i, int j) {
		int swap = nums[i];
		nums[i] = nums[j];
		nums[j] = swap;

		return nums;
	}

}
