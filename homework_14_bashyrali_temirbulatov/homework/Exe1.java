public class Exe1 {
    public static void main(String[] args) {
        int[] arr = {-1,-2,94,32,11,-4};
        for (int i = 0; i < arr.length; i++) {
            
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int[] arr2 = new int[6];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = changeToNegative(arr[i]); 
            System.out.print(arr2[i] + " ");
        }
       

    }
    public static int changeToNegative(int index) {
        return index * -1;
    }
}
