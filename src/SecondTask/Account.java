package SecondTask;

public class Account {
    private double balance;
    private int id;

    public Account(int a) {
        balance = 0.0;
        id = a;
    }

    public void deposit(double sum) {
        balance += sum;
    }

    public void withdraw(double sum) {
        balance -= sum;
    }

    public double getBalance() {
        return balance;
    }

    public double getAccountNumber() {
        return id;
    }

    public void transfer(double amount, Account other) {
        balance -= amount;
        other.balance += amount;
    }

    public String toString() {
        return "Account number: " + id +
                "Balance: " + balance;
    }

    public final void print() {
        System.out.println(toString());
    }
}
