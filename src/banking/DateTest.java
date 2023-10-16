package banking;

import static org.junit.Assert.*;

public class DateTest {

    @org.junit.Test
    public void testNonLeapYear() {
        Date nonLeapYearDate = new Date(2023, 2, 28);
        assertTrue(nonLeapYearDate.isValid());
    }
    @org.junit.Test
    public void testValidDate() {
        Date validDate = new Date(2023, 5, 15);
        assertTrue(validDate.isValid());
    }

    @org.junit.Test
    public void testZeroDay() {
        Date validDate = new Date(2020, 2, 0);
        assertFalse(validDate.isValid());
    }

    @org.junit.Test
    public void testInvalidMonth() {
        Date invalidMonth = new Date(2023, 13, 15);
        assertFalse(invalidMonth.isValid());
    }

    @org.junit.Test
    public void testInvalidDay() {
        Date invalidDay = new Date(2023, 6, 31);
        assertFalse(invalidDay.isValid());
    }

    @org.junit.Test
    public void testLeapYear() {
        Date leapYearDate = new Date(2023, 2, 29);
        assertFalse(leapYearDate.isValid());
    }
    @org.junit.Test
    public void testInvalidNegativeYear() {
        Date invalidNegativeYear = new Date(2023, 5, -15);
        assertFalse(invalidNegativeYear.isValid());
    }
}