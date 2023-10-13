package banking;

public class Savings extends Account {
    protected boolean isLoyal;
    public Savings(Profile profile, double deposit, boolean loyal) {
        super(profile, deposit);
        this.isLoyal = loyal;
    }

    @Override
    public String accountType() {
        return "Savings";
    }


    @Override
    public double monthlyInterest() {
        if (isLoyal){
            return (balance*4.25)/12.0;

        }
        else{
            return (balance*4.0)/12.0;
        }

    }

    @Override
    public double monthlyFee() {
        if (balance >= 500.0) {
            return 0;
        } else {
            return 25.0;
        }
    }
    @Override
    public String toString() {
        return super.toString() + (isLoyal ? "::is loyal" : "");
    }

}
