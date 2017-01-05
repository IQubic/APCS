import java.util.ArrayList;
import java.util.Collection;

public class Deck {
    private ArrayList<Card> cardsInDeck = new ArrayList<Card>();
    private ArrayList<Card> cardsDrawn = new ArrayList<Cards>();
    private static int[] ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private static String[] = {"Clubs", "Hearts", "Spades", "Diamonds"};

    public Deck() {
        int pointValue;
        for (int rank : ranks) {
            for (String suit : suits) {
                if (rank >= 10) {
                    pointValue = 10;
                } else {
                    pointValue = rank;
                }
            }
        }
        cardsInDeck.add(new Card(rank, suit, pointValue));
        Collection.shuffle(cardsInDeck);
    }

    public void resetDeck() {
        cardsInDeck.add(cardsDrawn);
        cardsDrawn.clear();
        Collections.shuffle(cardsInDeck);
    }

    public Card draw() {
        Card nextCard = cardsInDeck.get(0);
        cardsInDeck.remove(0);
        cardsDrawn.add(nextCard);
        return nextCard;
    }
}
