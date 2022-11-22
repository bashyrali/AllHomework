public class Salt extends Product {
    public Salt(){
        name = "Salt";
        storagePlace = Store.getRandomStoragePlace();
        storageLifeDays = Double.POSITIVE_INFINITY;
    }
    @Override
    boolean isFresh() {
        return true;
    }
}
