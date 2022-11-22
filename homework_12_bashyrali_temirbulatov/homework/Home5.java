
public class Home5 {
    public static void main(String[] args) {
        String format = "| %2s ";
        
        for(int i = 1; i < 10; ++i){
            System.out.println("+----+----+----+----+----+----+----+----+----+");
            for (int j = 1; j < 10; j++) {
                String msg = String.format(format, (i*j));
                System.out.print(msg);
            }
            System.out.println("|");
        }
        System.out.println("+----+----+----+----+----+----+----+----+----+");
    }
    
}