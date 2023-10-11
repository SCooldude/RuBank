package banking;

public abstract class Account implements Comparable<Account> {
    protected Profile holder;
    protected double balance;
    private final String firstName;
    private final String lastName;
    private final Date date;
    private final double deposit;

    public Account(String firstName, String lastName, Date date, double deposit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.deposit = deposit;

    }

    public abstract double monthlyInterest();
    public abstract double monthlyFee();

}
