import java.util.List;

public class Dealer {
    private List<Card> deck;

    public Dealer(List<Card> deck) {
        this.deck = deck;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void shuffleDeck() {
    }

    public List<Card> dealCards(int numCards) {
        // Implement card dealing logic
        return null;
    }
}