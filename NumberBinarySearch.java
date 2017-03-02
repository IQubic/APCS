import java.util.Arrays;
import java.util.Random;

public class NumberBinarySearch {

	private static final int MAXINT = 100;
	private static final int ARRAY_SIZE = 100;
	private static Random rand = new Random(); 

	public static void main(String[] args) {
		int[] r = sortedArray(ARRAY_SIZE, MAXINT);
		
		// Is a number in the array?
		int target = rand.nextInt(MAXINT);
      System.out.println("Searching for: " + target); 
		System.out.println(indexOf(r, target));
	}
	

	private static int indexOf(int[] r, int target) {
      // implement binary search algorithm
		return -1;
	}


	/**
	 * Create an array of size n with random integers, each between 0 and magnitude.
	 */
	public static int[] sortedArray(int length, int magnitude) {
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = rand.nextInt(magnitude);
		}
      Arrays.sort(result);
		return result;
	}

}
