import java.util.ArrayList;
import java.util.Collections;

public class PokerHand implements Comparable<PokerHand> {
  // Class data
  private ArrayList<Card> hand;
  private int handValue;

  // Contructors
  public PokerHand(ArrayList<Card> hand) {
    this.hand = hand;
    calculateHandValue();
  }

  // Public methods
  public int getHandValue() {
    return this.handValue;
  }

  @Override
  public String toString() {
    String returnString = "Cards:\n";
    for(int p=0; p<this.hand.size(); p++) {
      returnString += this.hand.get(p).toString() + "\n";
    }
    return returnString + "Highest hand value:\t" + getStringValue();
  }

  @Override
  public int compareTo(PokerHand p) {
    return (this.getHandValue() < p.getHandValue() ? -1 : (this.getHandValue() == p.getHandValue() ? 0 : 1));
  }

  // Private methods
  private String getStringValue() {
    String returnString = "";
    switch(this.handValue) {
      case 0:
        returnString += "Nothing";
        break;
      case 1:
        returnString += "Pair";
        break;
      case 2:
        returnString += "Two Pair";
        break;
      case 3:
        returnString += "Triple";
        break;
      case 4:
        returnString += "Flush";
        break;
      case 5:
        returnString += "Straight";
        break;
      case 6:
        returnString += "Straight Flush";
        break;
      case 7:
        returnString += "Royal Flush";
        break;
    }
    return returnString;
  }

  private void calculateHandValue() {
    // Local variables
    boolean straightFlush=true, straight=true, flush=true;
    boolean triple=false, pair=false;
    boolean royalFlush, twoPair;
    int pairCount=0;

    // Determine ace value then sort hand
    Collections.sort(this.hand);
    if(this.hand.get(0).getValue() == 0 && this.hand.get(4).getValue() == 12) {
      this.hand.get(4).setValue(-1);
    }
    Collections.sort(this.hand);
    
    // Loop through hand
    for(int i=0;i<this.hand.size()-1;i++) {
      // Pair
      if(this.hand.get(i).getValue() == this.hand.get(i+1).getValue()) {
        pair = true;
        pairCount++;
        // Triple
        if(i<this.hand.size()-2) {
          if(this.hand.get(i).getValue() == this.hand.get(i+2).getValue()) {
            triple = true;
          }
        }
      }
      // Flush
      if((this.hand.get(i).getSuit()) != this.hand.get(i+1).getSuit()) {
        straightFlush = false;
        flush = false;
      }
      // Straight
      if((this.hand.get(i).getValue()+1) != this.hand.get(i+1).getValue()) {
        straightFlush = false;
        straight = false;
      }
    }
    twoPair = (pairCount==2 && !triple) ? true : false;
    royalFlush = (straight && flush && (this.hand.get(4).getValue()==12)) ? true : false;

    this.handValue = royalFlush ? 7 : straightFlush ? 6 : straight ? 5 : flush ? 4: triple ? 3 : twoPair ? 2 : pair ? 1 : 0;
  }

}