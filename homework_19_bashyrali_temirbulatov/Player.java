import java.util.Random;
import java.util.Scanner;

public class Player {
    Scanner inputScanner;
    
    public Player(){
        inputScanner = new Scanner(System.in);
    }
    public int random() {
        Rps[] moves = Rps.values();
        Random random = new Random();
        int index = random.nextInt(moves.length)+1;
        return index;
    }
    public Rps getMove(int number) {
        if (number == 1 || number == 2 || number == 3 || number == 4 || number == 5) {
            
            switch (number) {
            case 1:
                return Rps.ROCK;
            case 2:
                return Rps.PAPER;
            case 3:
                return Rps.SCISSORS;
            case 4:
                return Rps.LIZARD;
            case 5:
                return Rps.SPOCK;
            }
        }
        System.out.println("ERROR! Incorect input");
        int n = inputScanner.nextInt();
        return getMove(n);
    }
    
    public boolean playAgain() {
        System.out.print("Do you wanna play again?(Y/N) ");
        String userInput = inputScanner.nextLine();
        userInput = userInput.toUpperCase();
        return userInput.equals("Y");
    }
}
