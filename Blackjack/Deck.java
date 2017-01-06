import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    // cardsInDeck stores the cards that have not been drawn
    private ArrayList<Card> cardsInDeck = new ArrayList<Card>();
    // cardsDrawn stores the cards that have been drawn
    private ArrayList<Card> cardsDrawn = new ArrayList<Card>();

    // The ranks and suits of the cards in the deck
    private static int[] ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private static String[] suits = {"Clubs", "Hearts", "Spades", "Diamonds"};

    // Create 52 cards in a set order, then shuffle the deck
    public Deck() {
        int pointValue;
        for (int rank : ranks) {
            for (String suit : suits) {
                if (rank >= 10) {
                    pointValue = 10;
                } else {
                    pointValue = rank;
                }
            cardsInDeck.add(new Card(rank, suit, pointValue));
            }
        }
        shuffle();
    }

    // Restore the deck to 52 unique cards in a random order
    public void reset() {
        cardsInDeck.addAll(cardsDrawn);
        cardsDrawn.clear();
        shuffle();
    }

    // draw the next card from the deck
    public Card draw() {
        Card nextCard = cardsInDeck.get(0);
        cardsInDeck.remove(0);
        cardsDrawn.add(nextCard);
        return nextCard;
    }

    public void shuffle() {
        Collections.shuffle(cardsInDeck);
    }
}
