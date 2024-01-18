public class Pot {
    private int amount;

    public Pot() {
        this.amount = 0;
    }

    public int getAmount() {
        return amount;
    }

    public void addToPot(int amount) {
        this.amount += amount;
    }

    public void clearPot() {
        this.amount = 0;
    }
}