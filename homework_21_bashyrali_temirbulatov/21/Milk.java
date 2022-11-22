import java.time.LocalDateTime;

public class Milk extends Product{
    
    public Milk(){
        name = "Milk";
        storagePlace = Store.getRandomStoragePlace();
        storageLifeDays = storagePlace == "Icebox" ? 60 : 60/2;
    }

    @Override
    boolean isFresh() {
        LocalDateTime now = LocalDateTime.now();
        double nowYear = now.getYear();
        double nowDay = now.getDayOfYear();
        double deliveryYear = deliveryTimestamp.getYear();
        double deliveryDay = deliveryTimestamp.getDayOfYear();
        
        double yearLife = nowYear- deliveryYear;
        if(yearLife==0){
            double timeLife = nowDay - deliveryDay;
            if (timeLife >= storageLifeDays) {
                return false;
            }
            else{
                return true;
            }
        }
        else{
            double day = 365.0 - deliveryDay + nowDay;
            if (day >= storageLifeDays) {
                return false;
            }
            else{
                return true;
            }
        }
        
        
    }
}
