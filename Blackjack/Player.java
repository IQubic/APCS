// This class stores the info for a player of the blackjack game
public class Player {
    private String name;
    private Hand hand;
    private double wins;

    // A player starts with several default values
    public Player(String name) {
        this.name = name;
        hand = new Hand();
        wins = 0;
    }

    // Give a player a card
    public void giveCard(Card card) {
        hand.addCard(card);
    }

    // Find out the score for a player's hand
    public int handScore() {
        return hand.getScore();
    }

    // Accessors and Mutators
    public String getName() {
        return name;
    }

    public void increaseWins(double amt) {
        wins += amt;
    }

    public double getWins() {
        return wins;
    }

    public Hand getHand() {
        return hand;
    }

    public void resetHand() {
        hand.reset();
    }
}
