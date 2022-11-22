package second;

public class Main {
    public static void main(String[] args) {
       Account account = new DepositAccount(100);
       Account account2 = new ClosedAccount(200);
       Account account3 = new TransitAccount(300);
       Bank bank = new Bank<>();
       bank.showMoney(account);
       bank.showMoney(account2);
       bank.showMoney(account3);
    }
}
