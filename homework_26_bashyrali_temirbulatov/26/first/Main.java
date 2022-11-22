package first;



public class Main {
    public static void main(String[] args) {
        Integer ints[] = {6,7,3,5,1,432,325,45};
        int low = 0;
        int high = ints.length-1;
        Sort<Integer> sort = new Sort<Integer>(ints);
        sort.quickSort(low, high);
        for (Integer i : ints) {
            System.out.println(i);
        }
        System.out.println();
        sort.reverseQuickSort(low, high);
        for (Integer i : ints) {
            System.out.println(i);
        }


    }
}
