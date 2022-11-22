public class Home1 {
    public static void main(String[] args) {
 
        String[] words = {", kid.", "That's where", "and corners" , "Doors" , "you", "they get"};
        String format = "%s %s %s %s %s %s";
        String msg = String.format(format, words[3], words[2],words[0],words[1],words[5], words[4]);
        System.out.println(msg);
    }
    
}
    
