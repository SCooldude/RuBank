package banking;

public abstract class Account implements Comparable<Account> {
    protected Profile holder;
    protected double balance;

    public abstract String accountType();

    public Account(Profile profile, double deposit) {
        this.holder = profile;
        this.balance = deposit;
    }
    @Override
    public boolean equals(Object obj) {
        Account account = (Account) obj;

        if (!holder.equals(account.holder)) {
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



    public abstract double monthlyInterest();
    public abstract double monthlyFee();

}
