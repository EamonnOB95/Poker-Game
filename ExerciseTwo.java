import java.util.ArrayList;

public class ExerciseTwo {
    public static void main(String[] args) {

      // Code to run poker game
      PokerGame p = new PokerGame(6);
      p.playGame();
      
      // Code to count hands till a certain value is found
      /*
      Deck d1;
      PokerHand p1;
      ArrayList<Card> cards;
      int count = 0;
      boolean found=false;

      do {
        d1 = new Deck();
        for(int x=0;x<8;x++) {
          cards = new ArrayList<>();
          for(int i=0;i<5;i++) {
            cards.add(d1.getRandomCard());
          }
          p1 = new PokerHand(cards);
          count++;
          if(p1.getHandValue() == 6) {
            System.out.println(p1.toString());
            found = true;
            break;
          }
        }
        
      } while(!found && count < 1000000);

      System.out.println("Number of hands passed to find: " + count);

      */
      
    }
}
