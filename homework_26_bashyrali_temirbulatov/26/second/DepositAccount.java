package second;

public class DepositAccount extends Account  {
    public DepositAccount(int money) {
        this.money = money;
        
    }
    
    
    @Override
    public String toString() {
        return "DepositAccount{" + money +
                '}';
    }

  
    
    
}
