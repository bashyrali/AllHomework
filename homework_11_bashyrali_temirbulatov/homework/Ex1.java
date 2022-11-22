import java.io.Console;

public class Ex1 {
    public static void main(String[] args) {
        Console console = System.console();
        String input = console.readLine();
        System.out.println(input.length());
        System.out.println(input.toLowerCase());
        System.out.println(input.toUpperCase());

    }
}
