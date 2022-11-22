import java.io.Console;

public class Ex5 {
    public static void main(String[] args) {
        Console console = System.console();
        System.out.print("Enter first sentence:");
        String firstSentence = console.readLine();
        System.out.print("Enter second sentence:");
        String secondSentence = console.readLine();
        firstSentence = firstSentence.replace("E", "I");
        firstSentence = firstSentence.replace("e", "i");
        firstSentence = firstSentence.replace("D", "T");
        firstSentence = firstSentence.replace("d", "t");
        secondSentence = secondSentence.replace("d", "t");
        secondSentence = secondSentence.replace("D", "T");
        secondSentence = secondSentence.replace("e", "i");
        secondSentence = secondSentence.replace("E", "I");
        System.out.println(firstSentence);
        System.out.println(secondSentence);


    }
}
