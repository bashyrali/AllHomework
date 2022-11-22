package first;

public class Sort<T extends Comparable<T>> {
     T arr [];
    Sort(T arr[]){
        this.arr = arr;
    }
    public void quickSort(int low, int high ) {
        if (arr.length == 0){
            return;
        }
        
        int midle = low+(high-low)/2;
        T opora =arr[midle];
        int i = low, j = high;
        while (i <= j) {
            while (arr[i].compareTo(opora) < 0) {
                i++;
            }
            
            while (arr[j].compareTo(opora) > 0) {
                j--;
            }
            
            if (i <= j) {
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
        quickSort(low, j);
        
        if (high > i)
        quickSort(i, high);
    }
    public void reverseQuickSort(int low, int high ) {
        if (arr.length == 0){
            return;
        }
        
        int midle = low+(high-low)/2;
        T opora =arr[midle];
        int i = low, j = high;
        while (i <= j) {
            while (arr[i].compareTo(opora) > 0) {
                i++;
            }
            
            while (arr[j].compareTo(opora) < 0) {
                j--;
            }
            
            if (i <= j) {
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j)
        reverseQuickSort(low, j);
        
        if (high > i)
        reverseQuickSort(i, high);
    }
}

