public class Lab3 {
    public static void main(String[] args) {
        System.out.print("Hieght of tower:");
        int hieght = Integer.valueOf(System.console().readLine());
        System.out.print("Man's position at tower:");
        int man = Integer.valueOf(System.console().readLine());
        String star = "#";
        for (int i = 0; i < hieght+1; i++) {
            System.out.print("|");
            if(hieght - man == i){
                System.out.print("@");
            }
            String repeated = star.repeat(i+1); 
            System.out.println(repeated);
        }
    }
}
