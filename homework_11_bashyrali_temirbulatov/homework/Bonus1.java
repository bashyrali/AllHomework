public class Bonus1 {
    public static void main(String[] args) {
        String t = System.console().readLine();
        Double time = Double.valueOf(t);
        time = time % 5;
        if (time < 3) { //Долго думал что здесь < или <= //
            System.out.println("Green");
        }
        else{
            System.out.println("Red");
        }
    }
}
