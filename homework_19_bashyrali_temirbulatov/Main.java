/**
* Main
*/
public class Main {
    static int userScore = 0;
    static int computerScore = 0;
    static int numberOfGames = 0;
    public static void main(String[] args) {
        boolean start = true;
        
        while (start) {
            System.out.println("ROCK-1, SCISSORS-2, PAPER!-3, LIZZARD-4, SPOCK-5");
            Player user = new Player();
            int userInput = user.inputScanner.nextInt();
            Player computer = new Player();
            
            Rps userMove = user.getMove(userInput);
            Rps computerMove = computer.getMove(computer.random());
            System.out.println("\nYour turn " + userMove + ".");
            System.out.println("Computer move " + computerMove + ".\n");
            int compareMoves = userMove.compareMoves(computerMove);
            switch (compareMoves) {
                case 0: // Ничья
                System.out.println("Tie!");
                break;
                case 1: // Победил игрок
                System.out.println(userMove + " beats " + computerMove + ". Вы победили!");
                userScore++;
                break;
                case -1: // Победил компьютер
                System.out.println(computerMove + " beats " + userMove + ". Вы проиграли.");
                computerScore++;
                break;
            }
            numberOfGames++;
            if (computer.playAgain()) {
                start = true;
            }
            else{
                start = false;
                printGameStats();
            }
        }
    }
    
    
    
    
    public static void printGameStats() {
        int wins = userScore;
        int losses = computerScore;
        int ties = numberOfGames - userScore - computerScore;
        double percentWon = (wins + ((double) ties) / 2) / numberOfGames;
        
        
        System.out.print("+");
        printDashes(68);
        System.out.println("+");
        
        
        System.out.printf("|  %6s  |  %6s  |  %6s  |  %12s  |  %14s  |\n",
        "WINS", "LOSSES", "TIES", "GAMES PLAYED", "PERCENTAGE WON");
        
        // Вывод линии
        System.out.print("|");
        printDashes(10);
        System.out.print("+");
        printDashes(10);
        System.out.print("+");
        printDashes(10);
        System.out.print("+");
        printDashes(16);
        System.out.print("+");
        printDashes(18);
        System.out.println("|");
        
        // Вывод значений
        System.out.printf("|  %6d  |  %6d  |  %6d  |  %12d  |  %13.2f%%  |\n",
        wins, losses, ties, numberOfGames, percentWon * 100);
        
        // Вывод линии
        System.out.print("+");
        printDashes(68);
        System.out.println("+");
    }
    
    public static void printDashes(int numberOfDashes) {
        for (int i = 0; i < numberOfDashes; i++) {
            System.out.print("-");
        }
    }
    
}