import java.util.Scanner;

public class RockPaperScissors {
	public static void main(String[] args) {
		int[] scores = new int[] {0, 0, 0};

		Scanner console = new Scanner(System.in);
		System.out.println("Choose (r)ock, (p)aper, or (s)cissors. (Or (q)uit to quit)");
		char userMove = getUserMove(console);

		while (userMove != 'q') {
			char compMove = getCompMove();
			int score = getScore(userMove, compMove);
			
			scores[score]++;
			printGameResult(userMove, compMove, score);

			userMove = getUserMove(console);
		}

		printScores(scores);
	}

	//This method returns the user's move
	//It returns 'q' if 'r' 'p' or 's' is not the first letter
	public static char getUserMove(Scanner input){
		char userMove = input.nextLine().toLowerCase().charAt(0);
		if (userMove == 'r' || userMove == 'p' || userMove == 's') {
			return userMove;
		} else {
			return 'q';
		}
	}
	
	//This method returns a random move for the computer
	public static char getCompMove() {
		int compMove = (int) (Math.random() * 3);
		if (compMove == 0) {
			return 'r';
		} else if (compMove == 1) {
			return 'p';
		} else {
			return 's';
		}
	}

	//This method returns the score of a game as an int
	//0 is a win for the player
	//1 is a loss for the player
	//2 is a tie
	public static int getScore(char userMove, char compMove) {
		if (userMove == compMove) {
			return 2;
		} else if ((userMove == 'r' && compMove == 's') || (userMove == 's' && compMove == 'p') || (userMove == 'p' && compMove == 'r')) {
			return 0;
		} else {
			return 1;
		}
	}

	//This method prints the game result
	public static void printGameResult(char userMove, char compMove, int score) {
		String scoreString;
		if (score == 0) {
			scoreString = "You win!";
		} else if (score == 1) {
			scoreString = "You lose!";
		} else {
			scoreString = "Tie game!";
		}

		System.out.println("You played: " + getString(userMove) + ". Computer played: " + getString(compMove) + ". " + scoreString);
	}

	//This method prints the scores of all the games played
	public static void printScores(int[] scores) {
		System.out.println("Wins: " + scores[0] + ", Losses: " + scores[1] + ", Ties: " + scores[2]);
	}

	//This method takes a char, and converts it into the corresponding string
	public static String getString(char move) {
		if (move == 'r') {
			return "Rock";
		} else if (move == 'p') {
			return "Paper";
		} else {
			return "Scissors";
		}
	}
}
