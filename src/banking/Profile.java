package banking;

public class Profile implements Comparable<Profile>{
        private String fname;
        private String lname;
        private final Date dob;

    public Profile(String firstName, String lastName, Date dateOfBirth) {
        this.fname = firstName;
        this.lname = lastName;
        this.dob = dateOfBirth;
    }

    @Override
    public int compareTo(Profile o) {
        return 0;
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
}

