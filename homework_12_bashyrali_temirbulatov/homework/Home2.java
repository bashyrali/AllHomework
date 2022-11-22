public class Home2 {
        public static void main(String[] args) {
            System.out.print("Enter number:");
            int num = Integer.valueOf(System.console().readLine()) ;
            String format = "%s * %s = %s";
            for(int i=1;i<=9;i++){
                int answer = num *i;
                String msg = String.format(format, num, i, answer);
                System.out.println(msg);
            }
        }
}
