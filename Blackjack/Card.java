// A card has a suit, a rank, and a point value
public class Card {
    private int rank;
    private String suit;
    private int points;

    public Card(int rank, String suit, int points) {
        this.rank = rank;
        this.suit = suit;
        this.points = points;
    }

    // Gets the point value of a card
    // Returns a number 1 - 10
    public int getPoints() {
        return points;
    }

    // The toString method takes the rank 1 - 13 and turns it into the proper word
    public String toString() {
        String rank = Integer.toString(this.rank);
        if (this.rank == 1) {
            rank = "Ace";
        } else if (this.rank == 11) {
            rank = "Jack";
        } else if (this.rank == 12) {
            rank = "Queen";
        } else if (this.rank == 13) {
            rank = "King";
        }
        return rank + " of " + suit;
    }
}
