

public class Exe2 {
    public static void main(String[] args) {
        int arr[] = new int[10];
        System.out.println("Enter 10 numbers");
        for (int i = 0; i < arr.length; i++) {
            arr[i]  = Integer.valueOf(System.console().readLine());
        }
        boolean stop = true;
        System.out.println("Enter 1-avg, 2-minimum, 3-maximum, 4-to stop");
        while (stop == true) {
            int action = Integer.valueOf(System.console().readLine());
            if (action == 1) {
                int avg = avg(arr);
                System.out.println("Average:" + avg);
            }
            else if(action == 2){
                int min = min(arr);
                System.out.println("Minimum:" + min);
            }
            else if (action == 3) {
                int max = max(arr);
                System.out.println("Maximum:" + max);
            }
            else if(action == 4){
                stop = false;
            }
        }




    }
    public static int avg(int[] arr) {
       int avg = arr[0];
       for (int i = 0; i < arr.length; i++) {
           avg = avg +arr[i];
       } 
       avg= avg/arr.length;
       return avg;
    }
    public static int min(int[] arr) {
        int min= arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }
    public static int max(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]> max) {
                max = arr[i];
            }
        }
        return max;
    }
}
