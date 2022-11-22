public class Lab6 {
    public static void main(String[] args) {
        java.util.Random r = new java.util.Random(); 
        int a[] = new int[10];
        int b[] = new int[10];
        int c[] = new int[10];

        System.out.print("Array A:");
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(20)-10;
            System.out.print(a[i]+" ");

        }
        System.out.println();
        System.out.print("Array B:");
        
        for (int i = 0; i < b.length; i++) {
            b[i] = r.nextInt(20)-10;
            System.out.print(b[i]+" ");
        }
        System.out.println();
        System.out.print("Array C:");
        for (int i = 0; i < c.length; i++) {
            c[i] = a[i] + b[i];
            System.out.print(c[i]+ " ");
        }
        System.out.println();
        int max = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i]>max) {
                max = c[i];
            }
        }
        System.out.println("Max in Array C:"+max);
        int min = Math.min(Math.min(c[9], c[8]), c[7]);
        System.out.println("Min in array c of last 3:"+min);
    }
}
