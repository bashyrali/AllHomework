public class Home3 {
    public static void main(String[] args) {
        int[] N = new int[15];
        N[0] = 1;
        N[1] = 1;
       System.out.println();
        for(int i = 2;i < N.length; i++){
            N[i] = N[i-1]+N[i-2];
            System.out.println(N[i]);
        }
        System.out.println(" ");
        for (int i = 14; i < N.length; i--) {
            System.out.println(N[i]);
        }
    }
}
