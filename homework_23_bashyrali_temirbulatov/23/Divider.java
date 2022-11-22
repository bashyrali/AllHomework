public class Divider {
    public static void main(String[] args) {
        try{
            System.out.print("Enter first number: ");
            String firstNumString = System.console().readLine();
            int firstNumber = Integer.parseInt(firstNumString);
            System.out.print("Enter second number: ");
            String secondNumString = System.console().readLine();
            int secondNumber = Integer.parseInt(secondNumString);
            int quotient = divide(firstNumber,secondNumber);
            System.out.println("Result: " + quotient);
        }
        catch(NumberFormatException  e) {
            System.out.println("the entered data is not a number");
            main(args);
        }   
        catch(ArithmeticException  e) {
            System.out.println("cannot be divided by zero");
            main(args);
        }
    }

    static int divide(int division, int devisor)  {
        return division/devisor;
    }

}