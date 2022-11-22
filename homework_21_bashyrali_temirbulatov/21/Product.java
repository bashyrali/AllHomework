import java.time.LocalDateTime;

abstract class Product {
    LocalDateTime deliveryTimestamp = LocalDateTime.now().plusDays(-Store.getRandomDeliveryTime());
    String storagePlace;
    double storageLifeDays;
    String name;
    abstract boolean isFresh();
}
