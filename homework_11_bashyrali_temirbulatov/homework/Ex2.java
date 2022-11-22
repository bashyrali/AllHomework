import java.io.Console;

public class Ex2 {
    public static void main(String[] args) {
        Console console = System.console();
        String firstSurname = console.readLine();
        String secondSurname = console.readLine();
        System.out.println(firstSurname + " " + firstSurname.length());
        System.out.println(secondSurname + " " + secondSurname.length());
        if (firstSurname.length() > secondSurname.length()) {
            System.out.println("First surname longer than second surname");
        }
        if(firstSurname.length() == secondSurname.length()){
            System.out.println("Suranme are equals");
        }
        else{
            System.out.println("Second surname longer than first surname");
        }
    }
}
