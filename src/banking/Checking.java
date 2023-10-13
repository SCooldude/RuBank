package banking;

public class Checking extends Account {

    private static final double INTEREST_RATE = 0.01;
    private static final double MONTHLY_FEE_THRESHOLD = 1000.0;

    @Override
    public String accountType() {
        return "Checking";
    }


    public Checking(Profile profile, double deposit) {
        super(profile, deposit);
    }

    @Override
    public double monthlyInterest() {
        return (balance * INTEREST_RATE) / 12.0;
    }

    @Override
    public double monthlyFee() {
        if (balance >= MONTHLY_FEE_THRESHOLD) {
            return 0;
        } else {
            return 12.0;
        }
    }

}
