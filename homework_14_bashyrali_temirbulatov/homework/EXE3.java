public class EXE3 {
    public static void main(String[] args) {
        System.out.print("Enter first Number(A):");
        int firstNum = Integer.valueOf(System.console().readLine());
        System.out.print("Enter second Number(B):");
        int secondNum = Integer.valueOf(System.console().readLine());
        System.out.println(recurs(firstNum, secondNum));
    }

    public static String recurs(int a, int b) {
        if (a <= b) {
            if (a == b) {
            return Integer.toString(a);
            }
        return a + " " + recurs(a + 1, b);
        } 
        else {return "B must be greater than A";}
    }
}

