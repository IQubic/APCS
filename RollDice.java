public class RollDice {
	public static void main(String[] args) {
		int sides = Integer.parseInt(args[0]);
		int[] diceRolls = new int[sides];
		int numOfTests = Integer.parseInt(args[1]);

		//Initialize the array
		for (int index = 0; index < sides; index++) {
			diceRolls[index] = 0;
		}

		//Roll the dice
		int result = 0;
		for (int rolls = 0; rolls < numOfTests; rolls++) {
			result = rollDice(sides);
			diceRolls[result - 1]++;
		}

		for (int index = 0; index < diceRolls.length; index++)
			System.out.println((index + 1) + " was rolled " + diceRolls[index] + " times"); 
	}

	public static int rollDice(int sides) {
		return (int) (Math.random() * sides) + 1;
	}
}
