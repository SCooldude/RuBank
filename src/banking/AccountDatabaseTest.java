package banking;

import static org.junit.Assert.*;
import org.junit.Test;

public class AccountDatabaseTest {

    @Test
    public void testCloseAccountFound() {
        AccountDatabase accountDatabase = new AccountDatabase();

        String firstName = "John";
        String lastName = "Adams";
        String dob = "12/5/2005";
        Date newDob = Date.fromDateStr(dob);

        Profile profile = new Profile(firstName,lastName,newDob);

        Account account = new Savings(profile, 1000, true);

        accountDatabase.open(account);

        boolean result = accountDatabase.close(account);

        assertTrue(result);
    }

    @Test
    public void testCloseAccountNotFound() {

        AccountDatabase accountDatabase = new AccountDatabase();

        String firstName = "John";
        String lastName = "Adams";
        String dob = "12/5/2005";
        Date newDob = Date.fromDateStr(dob);

        Profile profile = new Profile(firstName,lastName,newDob);

        Account account = new Savings(profile, 1000, true);

        accountDatabase.open(account);

        String fname = "John";
        String lname = "Adam";
        String dob1 = "12/5/2005";
        Date newDob1 = Date.fromDateStr(dob1);

        Profile profile1 = new Profile(fname,lname,newDob1);

        Account nonExistent_Acc = new Savings(profile1, 1000, true);
        boolean result = accountDatabase.close(nonExistent_Acc);

        assertFalse(result);
    }
}
