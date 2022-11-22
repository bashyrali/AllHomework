public class Game {
    public static void main(String[] args){
        Hand hand = new Hand();
        hand.deck.mixDeck();
        hand.addToHand();
        hand.showHand();
        System.out.print("Enter card you want to change(with space) or just enter nothing if don't wanna change the cards:");
        String input = System.console().readLine();
        if (input.equals("")) {
            
        }
        else{
            for(String s: input.split(" ")){
                int a = Integer.parseInt(s);
                hand.changeCards(a-1);
            }
        }
        hand.showHand();

    }
}
