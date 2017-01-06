// The dealer is the main way to interact with the deck
public class Dealer {
    private Deck deck;

    public Dealer(Deck deck) {
        this.deck = deck;
    }

    // Gives a card to a certain player
    public Card giveCard(Player player) {
        Card nextCard = deck.draw();
        player.giveCard(nextCard);
        return nextCard;
    }

    // Reset the deck to its original state
    public void reset() {
        deck.reset();
    }
}
