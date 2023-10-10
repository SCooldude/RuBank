package banking;

public class CollegeChecking extends Checking {
    private Campus campus; //campus code

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
