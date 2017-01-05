public class Dealer {
    private Deck deck;

    public Dealer(Deck deck) {
        this.deck = deck;
    }

    public Card giveCard(Player player) {
        nextCard = deck.draw();
        player.giveCard(nextCard);
        return nextCard;
    }
}
