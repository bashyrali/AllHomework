public class Lab4 {
    public static void main(String[] args) {
        System.out.print("Your age in day:");
        int day = Integer.valueOf(System.console().readLine());
        int[] all = new int[3];
        all[0] = day/365;
        all[1] = day/30;
        all[2] = day;
        System.out.println("Years:" + all[0] + "; Months:" + all[1] + "; Days:" + all[2]);
    }
}
