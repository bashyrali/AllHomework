public class Ex2 {
    public static void main(String[] args) {
        System.out.println("Enter grade for Jake:");
        Float jake = Float.valueOf(System.console().readLine());
        System.out.println("Enter grade for John:");
        Float john = Float.valueOf(System.console().readLine());
        System.out.println("Enter grade for Jack:");
        Float jack = Float.valueOf(System.console().readLine());
        System.out.println("Enter grade for Jane:");
        Float jane = Float.valueOf(System.console().readLine());
        int grade =(int) (Math.ceil((jake + john + jack + jane)/4));
        System.out.println("Mean for grades:" + grade);
    }
}
