import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList<Card>();
    }

    public void resetHand() {
        cards.clear();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getScore() {
        int score = 0;
        for (Card card : cards) {
            score += card.getPoints();
        }
        return score
    }

    public ArrayList<Card> getCards() {
        return cards;
    }
}
