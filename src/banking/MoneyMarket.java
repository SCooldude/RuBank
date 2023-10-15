package banking;

public class MoneyMarket extends Savings {
    private int withdrawl; //number of withdrawals


    public MoneyMarket(Profile profile, double deposit, boolean isLoyal, int withdrawal) {
        super(profile, deposit, isLoyal);
        this.withdrawl = withdrawal;
    }
    @Override
    public String accountType() {
        return "MoneyMarket";
    }

    @Override
    public String AA() {
        return "MM";
    }

    @Override
    public double withdrawalFee() {
        if (withdrawl > 3.0) {
            return 10.0;
        }

        return 0;
    }
    public boolean loyaltyStatus(){
        return (balance >= 2000.0);
    }
    @Override
    public double monthlyFee() {
        if (balance>=2000.0){
            return 0;
        }
        else{
            return 25.00;
        }
    }
    @Override
    public String toString() {
        if (!loyaltyStatus()) {
            isLoyal = false;
        }
        return super.toString() + "::withdrawal: " + withdrawl;
    }
    @Override
    public double monthlyInterest() {
        if (loyaltyStatus()){
            return (balance*0.0475)/12.0;

        }
        else{
            return (balance*0.045)/12.0;
        }
    }
}
