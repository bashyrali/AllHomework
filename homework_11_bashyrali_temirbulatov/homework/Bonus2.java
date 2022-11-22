public class Bonus2 {
    public static void main(String[] args) {
        System.out.print("Your name:");
        String name = System.console().readLine();
        System.out.print("Age:");
        String age =  System.console().readLine();
        System.out.print("Your country:");
        String country = System.console().readLine();
        System.out.print("Year of birth:");
        String date = System.console().readLine();
        name = name.strip();
        age = age.strip();
        country = country.strip();
        date = date.strip();
        name = name.toUpperCase();
        age = age.toUpperCase();
        int dateNum = Integer.valueOf(date);
        dateNum = 2019 - dateNum;
        String format = "Your name is %s %s. And you %s years old, and you are from %s";
        String endSentence = String.format(format, name, age, dateNum, country);
        System.out.println(endSentence);
    }
}
