package banking;

public class CollegeChecking extends Checking {
    private Campus campus; //campus code

    public CollegeChecking(String firstName, String lastName, Date date, double deposit, Campus campus) {
        super(firstName, lastName, date, deposit);
        this.campus = campus;
    }

    public boolean isValidCode() {
        return campus.getCollegeCode() > 0 && campus.getCollegeCode() < 3;
    }

    @Override
    public double monthlyInterest() {
        if (isValidCode()) {
            return super.monthlyInterest();
        }
        return 0;
    }


    @Override
    public double monthlyFee() {
            return 0;
    }


}
