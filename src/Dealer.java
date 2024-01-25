import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dealer {
    private static List<Cards> deck;

    public Dealer() {
        initializeDeck();
    }

    private void initializeDeck() {
        deck = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        for (String suit : suits) {
            for (int rank = 2; rank <= 14; rank++) {
                deck.add(new Cards(suit, rank));
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public static List<Cards> dealCards(int numCards) {
        List<Cards> dealtCards = new ArrayList<>();
        for (int i = 0; i < numCards; i++) {
            dealtCards.add(deck.remove(0));
        }
        return dealtCards;
    }
}