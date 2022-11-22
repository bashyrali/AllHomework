import java.time.LocalDateTime;

public class Stew extends Product{
    public Stew(){
        name = "Stew";
        storagePlace = Store.getRandomStoragePlace();
        storageLifeDays = 180;
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
