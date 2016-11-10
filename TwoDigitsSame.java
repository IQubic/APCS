import java.util.Scanner;

public class TwoDigitsSame {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number");
		int num = input.nextInt();

		if (twoDigitsSame(num)) {
			System.out.println("Two digits are the same");
		} else {
			System.out.println("Not two digits, or not the same");
		}
	}

	public static boolean twoDigitsSame(int num) {
		if (num > 99 || num < 10) {
			return false;
		} else if (num % 11 != 0) {
			return false;
		} else {
			return true;
		}
	}
}
