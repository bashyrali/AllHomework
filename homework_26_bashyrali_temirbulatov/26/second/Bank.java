package second;

public class Bank<T extends Account> {
    
    void showMoney(Account account){
        System.out.println(account);
    }
}
