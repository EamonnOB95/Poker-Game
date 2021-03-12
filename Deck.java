import java.util.ArrayList;

public class Deck {
    // Class data
    private ArrayList<Card> deckOfCards;

    // Constructors
    public Deck() {
        this.deckOfCards = new ArrayList<>();
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 13; y++) {
                this.deckOfCards.add(new Card(x, y));
            }
        }
    }

    // Public methods
    public Card getRandomCard() {
        // Generate random number
        int rand = (int)(Math.random() * this.deckOfCards.size());

        // Take card from deck and remove it
        Card c = this.deckOfCards.get(rand);
        this.deckOfCards.remove(rand);

        // Return random card
        return c;
    }
}
