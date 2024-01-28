import java.util.List;
import java.util.Scanner;

public class Game {
    private Dealer dealer;
    private Player player;
    private Pot pot;

    public Game() {
        this.dealer = new Dealer();
        this.player = new Player("Player1");
        this.pot = new Pot();
    }

    public void startGame() {
        displayGameRules();

        // Ask if the player understands the rules
        if (confirmUnderstanding()) {
            while (player.getChips() > 0) {
                System.out.println("Great! Let's start the game.");

                // Shuffle deck
                dealer.shuffleDeck();

                // Deal initial cards to the player
                List<Cards> playerHand = dealer.dealCards(5); // Assuming a 5-card poker game
                player.addToHand(playerHand);

                // Display player's initial hand
                System.out.println("Player's hand: " + player.getHand());

                // Place bets
                int playerBet = takePlayerBet();
                System.out.println("Player placed a bet of " + playerBet + " chips.");

                // Deal initial cards to the dealer (not displayed)
                List<Cards> dealerHand = dealer.dealCards(5); // Assuming a 5-card poker game

                // Display results
                System.out.println("Player's hand: " + player.getHand());
                System.out.println("Dealer's hand: " + dealerHand);

                // Determine the winner and update chips
                int result = determineWinner(player.getHand(), dealerHand);
                updateChips(result);

                // Display updated chips
                System.out.println("Player's chips: " + player.getChips());

                // Ask if the player wants to play again
                if (!playAgain()) {
                    System.out.println("Thanks for playing! Exiting the game.");
                    break;
                }
            }

            // Player has lost all chips
            System.out.println("You have lost all your chips. Game over!");
        } else {
            System.out.println("That's okay. If you have any questions, feel free to ask.");
        }
    }

    private void displayGameRules() {
        System.out.println("Welcome to Poker Game!");
        System.out.println("Game Rules:");
        System.out.println("- Each player receives five cards initially.");
        System.out.println("- The player with at least one pair in their hand wins.");
        System.out.println("- You can place bets and try to win chips.");
        System.out.println();
    }

    private boolean confirmUnderstanding() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you understand the rules? (yes/no): ");
        String response = scanner.next().toLowerCase();
        return response.equals("yes");
    }

    private int takePlayerBet() {
        player.displayChips(); // Display current chip count
        int maxBet = player.getChips(); // Player cannot bet more than their available chips

        Scanner scanner = new Scanner(System.in);
        int playerBet;

        do {
            System.out.print("Enter your bet (up to " + maxBet + " chips): ");
            playerBet = scanner.nextInt();

            if (playerBet < 0 || playerBet > maxBet) {
                System.out.println("Invalid bet. Please enter a valid amount.");
            }

        } while (playerBet < 0 || playerBet > maxBet);

        return playerBet;
    }

    private int determineWinner(List<Cards> playerHand, List<Cards> dealerHand) {
        // Implement your poker hand ranking logic here
        // For simplicity, let's assume the player wins if they have at least one pair
        if (hasOnePair(playerHand)) {
            return 1; // Player wins
        } else {
            return -1; // Player loses
        }
    }

    private boolean hasOnePair(List<Cards> hand) {
        // Implement logic to check if the hand has at least one pair
        return hand.stream().anyMatch(card ->
                hand.stream().filter(c -> c.getRank() == card.getRank()).count() == 2);
    }

    private void updateChips(int result) {
        // Update chips based on the game result
        int playerBet = player.placeBet();
        switch (result) {
            case 1:
                // Player wins
                player.addToChips(playerBet);
                pot.clearPot();
                System.out.println("Player wins!");
                break;
            case -1:
                // Player loses
                player.addToChips(-playerBet);
                pot.clearPot();
                System.out.println("Player loses!");
                break;
            default:
                // It's a draw
                System.out.println("It's a draw!");
                break;
        }
    }

    private boolean playAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to play again? (yes/no): ");
        String response = scanner.next().toLowerCase();
        return response.equals("yes");
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}