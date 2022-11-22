public class lab2 {
    public static void main(String[] args) {
        System.out.print("Enter number of guests:");
        int N = Integer.valueOf(System.console().readLine());
        if (N < 1) {
            System.out.println("Inncorect input, try again");
            
        }
        if (N == 1) {
            System.out.println("Petya alone:0");
        }
        if(N % 2 == 0){
            N = N/2;
            System.out.println("Diameter:"+ N);
        }
        else{
            System.out.println("Radius:"+ N);
        }
    }
}
