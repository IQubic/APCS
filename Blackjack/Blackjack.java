import java.util.*;

public class Blackjack {
    public static void main(String[] args) {
        // This scanner takes our input
        Scanner console = new Scanner(System.in);

        // For storing the scores of each player
        ArrayList<Player> players = new ArrayList<Player>();

        // For scoring the final scores of each player
        // -1 represents a bust
        int[] finalScores = new int[2];

        // Create a deck and a dealer
        Deck deck = new Deck();
        Dealer dealer = new Dealer(deck);

        //Get the player's names and store them to an array list
        System.out.println("Welcome to Blackjack");
        for (int i = 1; i <= 2; i++) {
            System.out.print("Please enter the name of player " + i + ": ");
            players.add(new Player(console.nextLine()));
        }

        System.out.println("==============");

        char playAgain;
        do {
            // Give players their starting cards
            for (Player player : players) {
                dealer.giveCard(player);
                dealer.giveCard(player);
            }

            int currentPlayerNumber = 0;
            // Player take turns sequentially
            for (Player player : players) {
                showFaceUpCards(players);

                System.out.println(player.getName() + ", it is your turn.");

                // This loop runs once at minimum asking if the player wants to hit or stand
                // It terminates when the player stands or busts
                int currentHandScore = player.handScore();
                char hitOrBust;
                do {
                    System.out.println(player.getName() + ", you have "
                            + player.getHand().toString() + " (" + currentHandScore + ")");

                    // Check if we will hit or bust
                    System.out.println("Do you want to [h]it or [s]tand?");
                    hitOrBust = console.nextLine().charAt(0);

                    // We hit. Give the player a card and say what they drew
                    // Then check if we loop again. In other words, has that player busted?
                    if (hitOrBust == 'h') {
                        Card nextCard = dealer.giveCard(player);
                        System.out.println("You drew " + nextCard);
                        currentHandScore = player.handScore();
                    } else {
                        // We exit out of the loop and go to the next player turn
                        break;
                    }
                } while (currentHandScore <= 21);

                // Save the score
                if (hitOrBust == 'h') {
                    System.out.println("Bust!");
                    finalScores[currentPlayerNumber] = -1;
                } else {
                    finalScores[currentPlayerNumber] = currentHandScore;
                }

                if (currentPlayerNumber == 0) {
                    System.out.println("==============");
                }

                currentPlayerNumber++;
            }

            // Calculate and print the scores of that round
            if (finalScores[0] == -1 && finalScores[1] == -1) {
                System.out.println("Both Players Lose!");
            } else if (finalScores[0] == finalScores[1]) {
                System.out.println("Tie!");
                players.get(0).increaseWins(0.5);
                players.get(1).increaseWins(0.5);
            } else if (finalScores[0] > finalScores[1]) {
                players.get(0).increaseWins(1);
                System.out.println(players.get(0).getName() + " Wins!");
            } else {
                players.get(1).increaseWins(1);
                System.out.println(players.get(1).getName() + " Wins!");
            }

            // Print scores
            System.out.println();
            printScores(players);

            // Check if they want to play again
            System.out.print("Play again (y/n)? ");
            playAgain = console.nextLine().charAt(0);

            // Playing again requires things to be reset
            if (playAgain == 'y') {
                for (Player player : players) {
                    player.resetHand();
                }
                dealer.reset();
                System.out.println("==============");
            }
        } while (playAgain == 'y');
    }

    public static void showFaceUpCards(ArrayList<Player> players) {
        for (Player player : players) {
            System.out.println(player.getName() + " shows: " + player.getHand().getFirstCard());
        }
        System.out.println();
    }

    public static void printScores(ArrayList<Player> players) {
        for (Player player : players) {
            System.out.println(player.getName() + " has " + player.getWins() + " wins.");
        }
    }
}
