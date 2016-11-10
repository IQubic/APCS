import java.util.Scanner;
import java.util.Arrays;

public class ArrayLesson {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Array length: ");
		int[] numbers = new int[input.nextInt()];

		//Initialize the array
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = input.nextInt();
		}

		//Print the array
		System.out.println(Arrays.toString(numbers));

		System.out.println("Max is: " + findMax(numbers));
		System.out.println(Arrays.toString(reverseArray(numbers)));
	}

	public static int findMax(int[] array) {
		int currentMax = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > currentMax) {
				currentMax = array[i];
			}
		}

		return currentMax;
	}

	public static int[] reverseArray(int[] array) {
		int[] reversed = new int[array.length];
		int count = 0;
		for (int i = array.length - 1; i >= 0; i--) {
			reversed[i] = array[count];
			count++;
		}
		return reversed;
	}
}
