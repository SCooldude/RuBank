package banking;

import static org.junit.Assert.*;

public class DateTest {

    /**
     * Test Case 1
     */
    @org.junit.Test
    public void testNonLeapYear() {
        Date nonLeapYearDate = new Date(2023, 2, 28);
        assertTrue(nonLeapYearDate.isValid());
    }
    /**
     * Test Case 2
     */
    @org.junit.Test
    public void testValidDate() {
        Date validDate = new Date(2023, 5, 15);
        assertTrue(validDate.isValid());
    }
    /**
     * Test Case 3
     */
    @org.junit.Test
    public void testZeroDay() {
        Date validDate = new Date(2020, 2, 0);
        assertFalse(validDate.isValid());
    }
    /**
     * Test Case 4
     */
    @org.junit.Test
    public void testInvalidMonth() {
        Date invalidMonth = new Date(2023, 13, 15);
        assertFalse(invalidMonth.isValid());
    }
    /**
     * Test Case 5
     */
    @org.junit.Test
    public void testInvalidDay() {
        Date invalidDay = new Date(2023, 6, 31);
        assertFalse(invalidDay.isValid());
    }
    /**
     * Test Case 6
     */
    @org.junit.Test
    public void testLeapYear() {
        Date leapYearDate = new Date(2023, 2, 29);
        assertFalse(leapYearDate.isValid());
    }
    /**
     * Test Case 7
     */
    @org.junit.Test
    public void testInvalidNegativeYear() {
        Date invalidNegativeYear = new Date(2023, 5, -15);
        assertFalse(invalidNegativeYear.isValid());
    }
}