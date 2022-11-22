public class Lab7 {
    public static void main(String[] args) {
        double radius[]={12,35,4};
        double square[] = new double[3];
        System.out.print("Square:");
        for(int i = 0; i <radius.length; i++){
            square[i] = Math.PI*(radius[i]*radius[i]);
            System.out.print(square[i]+" ");
        }
    }
}
