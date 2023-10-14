package banking;

import java.text.DecimalFormat;


public abstract class Account implements Comparable<Account> {
    protected Profile holder;
    protected double balance;

    public abstract String accountType();

    public abstract String AA();

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
        if (this.accountType().equals("Checking") && account.accountType().equals("CollegeChecking") && account.balance == 0.0) {
            return false;
        }
        if (this.accountType().equals("CollegeChecking") && account.accountType().equals("Checking") && account.balance == 0.0) {
            return false;
        }
        if (this.accountType().equals("Checking") && account.accountType().equals("CollegeChecking")) {
            return true;
        }
        if (this.accountType().equals("CollegeChecking") && account.accountType().equals("Checking")) {
            return true;
        }


        return getClass() == obj.getClass();
    }
    public boolean equals(Object obj, int x) {
        Account account = (Account) obj;
        if (!holder.equals(account.holder)) {
            return false;
        }
        if (this.accountType().equals("Checking") && account.accountType().equals("CollegeChecking")) {
            return false;
        }
        if (this.accountType().equals("CollegeChecking") && account.accountType().equals("Checking")) {
            return false;
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
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return accountType() + "::" + holder + "::Balance $" + df.format(balance);
    }

    public abstract double monthlyInterest();
    public abstract double monthlyFee();

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public Profile getHolder() {
        return holder;
    }
}
