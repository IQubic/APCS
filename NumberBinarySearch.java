import java.util.Arrays;
import java.util.Random;

public class NumberBinarySearch {
    private static final int MAXINT = 100000;
    private static final int ARRAY_SIZE = 100000;
    private static Random rand = new Random();

    public static void main(String[] args) {
        int[] r = sortedArray(ARRAY_SIZE, MAXINT);

        // Is a number in the array?
        int target = rand.nextInt(MAXINT);
        System.out.println("Searching for: " + target);
        System.out.println(indexOf(r, target));
    }


    private static int indexOf(int[] arr, int target) {
        // Set index variables
        int left = 0;
        int right = arr.length;

        while (true) {
            int middle = (left + right) / 2;

            // Does midValue = target? If so, return
            if (arr[middle] == target) {
                return middle;
            }

            // Check if we are done searching
            if (right - left == 1) {
                break;
            }

            // Update index variables
            if (arr[middle] < target) {
                // Keep right half
                left = middle;
            } else {
                // Keep left half
                right = middle;
            }
        }

        // Target not found
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
