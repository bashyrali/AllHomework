import java.util.Random;

public class Labwork2 {
    public static void main(String[] args) {
        System.out.println("Выберите тип еды:Молоко-Milk, Мясо-Meat, Вода-Water");
        for (int i = 0; i < Food.values().length; i++) {
            
            System.out.print(Food.values()[i] + ", ");  
        }
        System.out.println();
        Random random = new Random();
        int satiety =  random.nextInt(100)-50;
        int maxSatiety = random.nextInt(100);
        if (maxSatiety < satiety) {
            System.out.println("Коту пора на диету");
        }
        while (maxSatiety > satiety) {
            String value = System.console().readLine();
            Food food = Food.valueOf(value.toUpperCase());
            satiety += food.getFoodValue();
            System.out.println("Кот сыт на: " + satiety);
            System.out.println("Максимальный уровень:" + maxSatiety);
            if (maxSatiety == satiety) {
                System.out.println("Кот сыт");
            }
            else if (satiety > maxSatiety) {
                System.out.println("Кот перекормлен");
            }
        } 
    }
    enum Food{
        
        WATER(20),
        MILK(40),
        MEAT(60);
        
        private int foodVal;
        
        Food(int foodVal){
            this.foodVal =  foodVal;
        }
        
        public int getFoodValue(){
            return this.foodVal;
        }
    }
}

