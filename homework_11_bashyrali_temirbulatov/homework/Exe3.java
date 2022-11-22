import java.io.Console;

public class Exe3 {
    public static void main(String[] args) {
        Console console = System.console();
        System.out.print("Enter speed in killometer per hour:");
        int kiloHour = Integer.valueOf(console.readLine());
        System.out.print("Enter speed in meter per second:");
        int meterHour = Integer.valueOf(console.readLine());
        kiloHour = (kiloHour *1000) / 3600;
        if (kiloHour > meterHour) {
            System.out.println("The first speed is higher than the second");
        }
        if (kiloHour == meterHour) {
            System.out.println("The both speeds are eqals");
        }
        else{
            System.out.println("The second speed is higher than the first");
        }
    }
    
}