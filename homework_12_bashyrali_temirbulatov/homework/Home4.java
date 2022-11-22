public class Home4 {
    public static void main(String[] args) {
        java.util.Random r = new java.util.Random(); 
        int n[] = new int[10];
        String format = "%s ";
        System.out.print("Massive:");
        for(int i = 0; i < n.length; i++){
            n[i] = r.nextInt(20)-10;
            String msg = String.format(format, n[i]);
           
            System.out.print(msg);
        }

        System.out.print("Only negative:");
        for (int i = 0; i < n.length; i++) {
            if (n[i] < 0) {
                String msg = String.format(format, n[i]);
                System.out.print(msg);         
            }
        }
        System.out.print("Четные:");
        for (int i = 0; i < n.length; i++) {
            
            if(n[i] % 2 == 0){
                String msg = String.format(format, n[i]);
                System.out.print(msg);
            }

        }
        System.out.print("НеЧетные:");
        for (int i = 0; i < n.length; i++) {
            
            if(n[i] % 2 == 1 || n[i] % 2 == -1){
                String msg = String.format(format, n[i]);
                System.out.print(msg);
            }

        }
        int counterPositive = 0;
        int counterNegative = 0;
        for(int i = 0; i < n.length;i++){
            if (n[i]>0){
                counterPositive+=1;
            }
            if (n[i] < 0) {
                counterNegative-=1;
            }
        }
        System.out.print("Number of Positive:"+ counterPositive +" Number of Negative:" + counterNegative);
    }
}