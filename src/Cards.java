public class Cards {
    private String suit;
    private int rank;
    private String name;

    public Cards(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
        this.name = getCardName(rank);
    }

    public String getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " of " + suit;
    }

    private String getCardName(int rank) {
        switch (rank) {
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            case 14:
                return "Ace";
            default:
                return String.valueOf(rank);
        }
    }
}