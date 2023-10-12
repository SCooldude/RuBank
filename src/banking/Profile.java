package banking;

public class Profile implements Comparable<Profile> {
    private String fname;
    private String lname;
    private final Date dob;

    public Profile(String firstName, String lastName, Date dateOfBirth) {
        this.fname = firstName;
        this.lname = lastName;
        this.dob = dateOfBirth;
    }

    @Override
    public int compareTo(Profile other) {
        int lastNameComparison = this.lname.compareTo(other.lname);
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }

        int firstNameComparison = this.fname.compareTo(other.fname);
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }
        int yearComparison = this.dob.getYear() - other.dob.getYear();
        if (yearComparison != 0) {
            return yearComparison;
        }

        int monthComparison = this.dob.getMonth() - other.dob.getMonth();
        if (monthComparison != 0) {
            return monthComparison;
        }

        return this.dob.getDay() - other.dob.getDay();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        Profile otherProfile = (Profile) obj;
        return fname.equalsIgnoreCase(otherProfile.fname) &&
                lname.equalsIgnoreCase(otherProfile.lname) && dob.getYear() == otherProfile.dob.getYear() &&
                dob.getMonth() == otherProfile.dob.getMonth() &&
                dob.getDay() == otherProfile.dob.getDay();
    }

    @Override
    public String toString() {
        return fname + " " + lname + " " + dob + "::";
    }
}


