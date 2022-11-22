import java.time.Month;
import java.util.Random;

public class Store {
    Product[] product =  new Product[20];
    static Random random = new Random();
    public void generationProduct() {
        for (int i = 0; i < product.length; i++) {
            int key = random.nextInt(5)+1;
            switch (key) {
                case 1:
                    product[i] = new Milk();
                    break;
            
                case 2:
                    product[i] = new Salt();
                    break;
                case 3:
                    product[i] = new Fish();
                    break;
                case 4:
                    product[i] = new Corn();
                    break;
                case 5:
                    product[i] = new Stew();
                    break;
            }
        }
    }
    public void doInspection() {
        System.out.println(" Product | Delivered at | Storage place | S. life days | Fresh ");
        System.out.println("---------+--------------+---------------+--------------+-------");
        String table = " %7s | %3.3s %2s, %3s | %14s| %12.0f | %5b |";
        for (int i = 0; i < product.length; i++) {
            int year = product[i].deliveryTimestamp.getYear();
            Month month = product[i].deliveryTimestamp.getMonth();
            int day = product[i].deliveryTimestamp.getDayOfMonth();
            String format = String.format(table, product[i].name, month, day, year, product[i].storagePlace, product[i].storageLifeDays, product[i].isFresh());
            System.out.println(format);
        }
        System.out.println("---------+--------------+---------------+--------------+-------");
    }
    public static int getRandomDeliveryTime() {
        
        return random.nextInt(200)+1;
    }
    public static String getRandomStoragePlace() {
        
        int a = random.nextInt(2);
        if (a==0) {
            return "Icebox";
        }
        else{
            return "Showcase";
        }
    }
    
}