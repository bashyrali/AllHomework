public class Ex1 {
    public static void main(String[] args) {
        System.out.println("Enter dividend:");
        String dividend = System.console().readLine();
        System.out.println("Enter divisor:");
        String divisor = System.console().readLine();
        Float div = Float.valueOf(dividend);
        Float dor = Float.valueOf(divisor);
        boolean bol = (div % dor) > 0;
        System.out.println("And is there a remainder of the division? -" + bol);
    }
}
