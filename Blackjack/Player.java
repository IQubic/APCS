public class Player {
    private String name;
    private Hand hand;
    private double wins;

    public Player(String name) {
        this.name = name;
        hand = new hand();
        wins = 0;
    }

    public void giveCard(Card card) {
        hand.addCard(card);
    }

    public int handScore() {
        return hand.getScore();
    }

    public String getName() {
        return name;
    }

    public double getWins() {
        return wins;
    }

}
