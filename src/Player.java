import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Cards> hand;
    private int chips;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.chips = 100; // Initial chip count
    }

    public String getName() {
        return name;
    }

    public List<Cards> getHand() {
        return hand;
    }

    public void addToHand(Cards card) {
        hand.add(card);
    }

    public int getChips() {
        return chips;
    }

    public void addToChips(int amount) {
        chips += amount;
    }

    public int placeBet() {
        // Implement betting logic as needed
        return 0;
    }

    public void clearHand() {
        hand.clear();
    }

    public void addToHand(List<Cards> cards) {
    }
}