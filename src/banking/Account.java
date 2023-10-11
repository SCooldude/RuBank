package banking;

public abstract class Account implements Comparable<Account> {
    protected Profile holder;
    protected double balance;

    public Account(Profile profile, double deposit) {
        this.holder = profile;
        this.balance = deposit;
    }
    @Override
    public boolean equals(Object obj) {
        Account account = (Account) obj;
        return this.holder.equals(account.holder);
    }

    public abstract double monthlyInterest();
    public abstract double monthlyFee();

}
