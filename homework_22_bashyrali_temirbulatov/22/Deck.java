import java.util.Random;

public class Deck {
    Card[] cards = new Card[52];
    Random random = new Random();
    Card temp;
    public Deck(){
        
        int index=0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cards[index]=new Card(j, i);
                index++;
            }
        }
        
    }
    public void mixDeck() {
        for (int i = 0; i < cards.length; i++) {
            int index = random.nextInt(cards.length-1);
            temp = cards[index];
            cards[index] = cards[i];
            cards[i] = temp;
        }
    }
    public Card getTheCard() {
        int cardIndex = random.nextInt(51);
        if (cards[cardIndex] == null) {
            while (cards[cardIndex] == null) {
                cardIndex =  random.nextInt(51);
            }
        }
        Card card = cards[cardIndex];
        cards[cardIndex] = null;
        return card;

    }
    
    
    
}
