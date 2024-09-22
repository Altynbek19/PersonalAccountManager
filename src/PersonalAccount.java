public class PersonalAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private Amount[] transactions;
    private int transactionCount;

    public PersonalAccount(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.transactions = new Amount[100];
        this.transactionCount = 0;
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

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            transactions[transactionCount++] = new Amount(amount, TransactionType.DEPOSIT);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            transactions[transactionCount++] = new Amount(amount, TransactionType.WITHDRAWAL);
        } else {
            System.out.println("Недостаточно средств.");
        }
    }

    public void printTransactionHistory() {
        for (int i = 0; i < transactionCount; i++) {
            Amount transaction = transactions[i];
            System.out.println(transaction.getTransactionType() + ": " + transaction.getAmount());
        }
    }
}
