import java.io.Console;

public class Ex4 {
    public static void main(String[] args) {
        Console console = System.console();
        
        System.out.print("Enter radius of circle:");
        double radius = Double.valueOf(console.readLine());
        System.out.print("Enter Side of a square:");
        double side = Double.valueOf(console.readLine());
        double radiusSqaure = 3.14 * (radius * radius);
        double square = side * side;
        System.out.println("Square of circle:" + radiusSqaure);
        System.out.println("Square of kvadrat:"+ square);
        if(radiusSqaure > square){
            System.out.println("Square of circle bigger than sqare of kvadrat");
        }
        else{
            System.out.println("Sqare of kvadrat bigger than sqare of circle");
        }
    }
}
