package banking;

public class Checking extends Account{

    @Override
    public double monthlyInterest() {
        return (balance*.01)/12.0;
    }

    @Override
    public double monthlyFee() {
        if (balance >= 1000.0) {
            return 0;

        } else {
            return 12.0;
        }
    }

    @Override
    public int compareTo(Account o) {
        return Double.compare(this.balance, o.balance);
    }
}
