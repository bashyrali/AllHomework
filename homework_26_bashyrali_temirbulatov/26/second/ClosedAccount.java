package second;

public class ClosedAccount extends Account {
    public ClosedAccount(int money) {
        this.money = money;
    }

    
    @Override
    public String toString() {
        return "ClosedAccount{" + money +
                '}';
    }
    
}
