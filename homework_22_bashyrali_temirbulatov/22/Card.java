public class Card {
    private int rank;
    private int suit;
    String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    String[] suits = {"\u2660", "\u2665", "\u2666", "\u2663"};
    Card(int rank, int suit){
        this.rank = rank;
        this.suit = suit;
    }
    public String toString() {
        return ranks[rank] + suits[suit];
    }
}