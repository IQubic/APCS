public class Card {
    private int rank;
    private String suit;
    private int points;

    public Card(int rank, String suit, int points) {
        this.rank = rank;
        this.suit = suit;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

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
    }
}
