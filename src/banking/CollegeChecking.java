package banking;

public class CollegeChecking extends Checking {
    private Campus campus; //campus code

    public CollegeChecking(Profile profile, double deposit, Campus campus) {
        super(profile, deposit);
        this.campus = campus;
    }
    @Override
    public String accountType() {
        return "CollegeChecking";
    }

    public boolean isValidCode() {
        return campus.getCollegeCode() >= 0 && campus.getCollegeCode() <= 3;
    }

    @Override
    public double monthlyInterest() {
        if (isValidCode()) {
            return super.monthlyInterest();
        }
    return 0.00;
    }
    @Override
    public String AA() {
        return "CC";
    }
    @Override
    public String toString() {
        return super.toString() + "::" + campus;
    }

    @Override
    public double monthlyFee() {
            return 0;
    }

}
