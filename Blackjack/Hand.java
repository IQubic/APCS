import java.util.ArrayList;

// This class stores the cards that a player has in their hand
public class Hand {
    private ArrayList<Card> cards;

    // Initialize the hand to be an ArrayList with zero cards in it
    public Hand() {
        this.cards = new ArrayList<Card>();
    }

    // Remove all the cards from a hand
    public void reset() {
        cards.clear();
    }

    public Card getFirstCard() {
        return cards.get(0);
    }

    // Add another card to a hand
    public void addCard(Card card) {
        cards.add(card);
    }

    // Get the score in a particular hand
    public int getScore() {
        int score = 0;
        for (Card card : cards) {
            score += card.getPoints();
        }
        return score;
    }

    public String toString() {
        return cards.toString();
    }
}
