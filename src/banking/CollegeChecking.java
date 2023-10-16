package banking;

/**
 * This class represents a College Checking Account, a specific type of checking account with extended capabilities.
 *
 * @author Fraidoon Pourooshasb, Samman Pandey
 */
public class CollegeChecking extends Checking {
    private Campus campus; //campus code

    /**
     * Constructor for creating a College Checking Account with a specified profile, initial deposit, and campus code.
     *
     * @param profile  the account holder's profile
     * @param deposit  the initial deposit amount
     * @param campus   the campus associated with the account
     */
    public CollegeChecking(Profile profile, double deposit, Campus campus) {
        super(profile, deposit);
        this.campus = campus;
    }
    @Override
    public String accountType() {
        return "CollegeChecking";
    }

    /**
     * Check if the campus code is valid, where valid values are in the range [0, 3].
     *
     * @return true if the campus code is valid, false otherwise
     */
    public boolean isValidCode() {
        return campus.getCollegeCode() >= 0 && campus.getCollegeCode() <= 3;
    }

    /**
     * uses the isValidCode to check if the client's campus code is valid and if they then returns the interest rate.
     *
     * @return double amount of monthly interest owed
     */
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
