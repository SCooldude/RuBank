package banking;

public abstract class Account implements Comparable<Account> {
    protected Profile holder;
    protected double balance;

    public abstract String accountType();

    public Account(Profile profile, double deposit) {
        this.holder = profile;
        this.balance = deposit;
    }
    public double getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object obj) {
        Account account = (Account) obj;
        if (!holder.equals(account.holder)) {
            return false;
        }
        if (this.accountType().equals("Checking") && account.accountType().equals("CollegeChecking")) {
            if (account.balance == 0.0) {
                return false;
            } else {
                return true;
            }
        }
        if (this.accountType().equals("CollegeChecking") && account.accountType().equals("Checking")) {
            if (account.balance == 0.0){
                return false;
            }
            else {
                return true;
            }
        }
        return getClass() == obj.getClass();
    }

    @Override
    public int compareTo(Account account) {
        int accountTypeComparison = this.accountType().compareTo(account.accountType());
        if (accountTypeComparison != 0) {
            return accountTypeComparison;
        }

        return this.holder.compareTo(account.holder);
    }
    @Override
    public String toString() {
        return accountType() + "::" + holder + "::Balance $" + String.format("%.2f", balance);
    }

    public abstract double monthlyInterest();
    public abstract double monthlyFee();

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}
