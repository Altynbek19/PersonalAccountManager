public class Main {
    public static void main(String[] args) {
        PersonalAccount account = new PersonalAccount(12345, "Altynbek Zhonguchkaev");
        account.deposit(1000);
        account.deposit(500);
        account.withdraw(300);
        account.printTransactionHistory();
        System.out.println("Текущий баланс: " + account.getBalance());
    }
}
