

public class Hand {
    Card[] hand = new Card[5];
    Deck deck = new Deck();
    
    public void addToHand() {
        for (int i = 0; i < hand.length; i++) {
            hand[i] = deck.getTheCard();
        }
        
    }
    public void showHand() {
        String format = "1   | 2   | 3   | 4   | 5  |\n%3s | %3s | %3s | %3s | %3s |";
        String message = String.format(format, hand[0], hand[1], hand[2], hand[3], hand[4]);
        System.out.println(message);
        
    }
    public void changeCards(int pos) {
        hand[pos] = deck.getTheCard();

    }
}
