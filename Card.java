public class Card implements Comparable<Card> {
    // Class data
    private int suit;
    private int value;

    // Constructors
    public Card() {
        this.suit = generateRandomSuit();
        this.value = generateRandomValue();
    }

    public Card(int suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    // Public methods
    @Override
    public String toString() {
        String returnString = "";

        // Generate value name
        switch (this.value) {
            case 0:
                returnString += "Two";
                break;
            case 1:
                returnString += "Three";
                break;
            case 2:
                returnString += "Four";
                break;
            case 3:
                returnString += "Five";
                break;
            case 4:
                returnString += "Six";
                break;
            case 5:
                returnString += "Seven";
                break;
            case 6:
                returnString += "Eight";
                break;
            case 7:
                returnString += "Nine";
                break;
            case 8:
                returnString += "Ten";
                break;
            case 9:
                returnString += "Jack";
                break;
            case 10:
                returnString += "Queen";
                break;
            case 11:
                returnString += "King";
                break;
            case 12:
                returnString += "Ace";
                break;
            case -1:
                returnString += "Ace";
                break;
        }

        returnString += " of ";

        // Generate suit name
        switch (this.suit) {
            case 0:
                returnString += "Hearts";
                break;
            case 1:
                returnString += "Diamonds";
                break;
            case 2:
                returnString += "Spades";
                break;
            case 3:
                returnString += "Clubs";
                break;
        }

        return returnString;
    }

    @Override
    public int compareTo(Card c) {
        return (this.getValue() < c.getValue() ? -1 : (this.getValue() == c.getValue() ? 0 : 1));
    }

    // Private methods
    private int generateRandomSuit() {
        return (int) (Math.random() * 4);
    }

    private int generateRandomValue() {
        return (int) (Math.random() * 13);
    }

    // Getter and Setters
    public int getSuit() {
        return suit;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
