public class HOme4 {
    public static void main(String[] args) {
        int count = 0;
        int num = -1;
        int sum = 0;
        int i = 1;
        while (num != 0) {
            System.out.print("Number "+ i++ +":");
            num = Integer.valueOf(System.console().readLine());
            if (num!=0) {
                count= count + 1;
                sum = sum + num;
            }
        }
        System.out.println("You has entered "+ count+" numbers.");
        System.out.println("Their sum is " + sum);
        System.out.println("Average of numbers is " + avg(sum,count));
        
        
    }
    public static int avg(int sum,int count) {
        return sum/count;
    }
}
