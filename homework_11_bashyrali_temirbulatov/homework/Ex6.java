import java.io.Console;

public class Ex6 {
    public static void main(String[] args) {
        Console console = System.console();
        System.out.print("Enter sentence:");
        String sentence = console.readLine();
        System.out.print("Enter key word:");
        String keyWord = console.readLine();
        if (sentence.indexOf(keyWord) > 0) {
            System.out.println("The key word was found. Index of key word is " + sentence.indexOf(keyWord));
        }
        else{
            System.out.println("The key word was not found");
        }
    }
}
