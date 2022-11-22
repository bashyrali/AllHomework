public class Lab8 {
    public static void main(String[] args) {
        System.out.print("Enter your number:");
        int num1 = Integer.valueOf(System.console().readLine());
        System.out.print("Enter your number 2:");
        int num2 = Integer.valueOf(System.console().readLine());
        int max = Math.max(num1, num2);
        int median = (num1+num2)/2;
        int min = Math.min(num1, num2);
        int arr[] = {max, median,min};
        System.out.println("Max = "+ arr[0]);
        System.out.println("Median = " + arr[1]);
        System.out.println("Min = "+ arr[2]);
        
        
    }
}
