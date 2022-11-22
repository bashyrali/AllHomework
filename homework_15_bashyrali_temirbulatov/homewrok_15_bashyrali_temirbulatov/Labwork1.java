public class Labwork1 {
    public static void main(String[] args) {
        System.out.println("Выберите тип еды:Молоко-Milk, Мясо-Meat, Вода-Water");
        for (int i = 0; i < Food.values().length; i++) {
            
            System.out.print(Food.values()[i] + ", "); 
        }
        System.out.println();
        String value = System.console().readLine();
        Food food = Food.valueOf(value.toUpperCase());
        int satiety = food.getFoodValue();
        System.out.println("Кот сыт на: " + satiety);
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