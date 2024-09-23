import java.util.ArrayList;
import java.util.List;

public class PersonalAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private List<Amount> transactions;
    private int transactionCount;

    public PersonalAccount(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        Amount transaction = new Amount(amount, TransactionType.DEPOSIT);
        transactions.add(transaction);
        balance += amount;
    }
    public void withdraw(double amount){
        if(amount <= balance){
            Amount transaction = new Amount(amount, TransactionType.WITHDRAWAL);
            transactions.add(transaction);
            balance -= amount;
        }else{
            System.out.println("Недостаточно средств.");
        }
    }

    public void printTransactionHistory(){
        for(Amount transaction: transactions){
            System.out.println(transaction.getTransactionType() + " : " + transaction.getAmount());
        }
    }
}
