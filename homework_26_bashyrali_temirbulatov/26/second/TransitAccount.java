package second;

public class TransitAccount extends Account {

    public TransitAccount(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "TransitAccount{" + money +
                '}';
    }
    
}
