public class Lab1 {
    public static void main(String[] args) {
        System.out.println("First employee salary");
        int first = Integer.valueOf(System.console().readLine());
        System.out.println("Second employee salary");
        int second = Integer.valueOf(System.console().readLine());
        System.out.println("Third employee salary");
        int third = Integer.valueOf(System.console().readLine());
        int max = Math.max(Math.max(first, second), third);
        int min = Math.min(Math.min(first, second), third);
        int difference = max-min;
        System.out.println("Highest paid position:" + max);
        System.out.println("Lowest paid position:" + min);
        System.out.println("Salary difference:" + difference);


    }
    
}