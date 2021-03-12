import java.util.ArrayList;
import java.util.Collections;

public class PokerGame {

  // Class data
  private Deck gameDeck;
  private ArrayList<PokerHand> hands;
  private int numOfPlayers;
  private ArrayList<Integer> winners;
  private boolean validGame = false;

  // Contructors
  public PokerGame() {
    this(2);
  }

  public PokerGame(int num) {
    this.numOfPlayers = num;
    if(numOfPlayers > 1 && numOfPlayers < 9) {
      this.gameDeck = new Deck();
      this.hands = new ArrayList<>();
      this.winners = new ArrayList<>();
      this.validGame = true;
    }
    else {
      System.out.println("Invalid number of players. Between 2-8 players required.");
    }
  }

  // Public methods
  public boolean playGame() {
    if(this.validGame) {
      for(int i=0;i<this.numOfPlayers;i++) {
          this.hands.add(new PokerHand(dealHand()));
      }
      printHands();
      determineWinners();
      printWinners();
      return true;
    }
    return false;
  }

  // Private methods
  private void printWinners() {
    String printStatement = "";
    if(this.winners.size() > 1) {
      printStatement += "And the winners are...\n";
      if(this.winners.size() == this.numOfPlayers) {
        printStatement += "It's a draw!";
      }
      else {
        for(int i=0;i<this.winners.size();i++) {
          printStatement += "Player " + this.winners.get(i) + "\n";
        }
      }
    }
    else {
      printStatement += "And the winner is...Player " + this.winners.get(0); 
    }
    System.out.println(printStatement);
  }

  private void determineWinners() {
    int highestValue = this.hands.get(0).getHandValue();
    for(int i=1;i<this.hands.size();i++) {
      if(this.hands.get(i).getHandValue() > highestValue) {
        highestValue = this.hands.get(i).getHandValue();
      }
    }
    for(int i=0;i<this.hands.size();i++) {
      if(this.hands.get(i).getHandValue() == highestValue) {
        this.winners.add(i+1);
      }
    }
  }

  private void printHands() {
    for(int i=0;i<this.numOfPlayers;i++) {
      System.out.println("Player " + (i+1));
      System.out.println(this.hands.get(i).toString());
      System.out.println();
    }
  }

  private ArrayList<Card> dealHand() {
    ArrayList<Card> cards = new ArrayList<>();
    for(int i=0;i<5;i++) {
      cards.add(this.gameDeck.getRandomCard());
    }
    return cards;
  }
}