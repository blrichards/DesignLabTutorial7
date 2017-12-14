package main;

import org.junit.Test;
import static org.junit.Assert.*;

public class TimeParserTestFullStatementAndBranchCoverage {
    /**
     * Tests that parseTimeToSeconds throws exception with no first colon.
     */
    @Test(expected = NumberFormatException.class)
    public void testNoFirstColon() {
        TimeParser.parseTimeToSeconds("");
    }

    /**
     * Tests that parseTimeToSeconds throws exception with no second colon.
     */
    @Test(expected = NumberFormatException.class)
    public void testNoSecondColon() {
        TimeParser.parseTimeToSeconds(":");
    }

    /**
     * Tests that parseTimeToSeconds throws exception with bad time input.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBadTime() {
        TimeParser.parseTimeToSeconds("24:00:00 pm");
    }

    /**
     * Tests that parseTimeToSeconds returns correct value.
     */
    @Test
    public void testCorrectNumberOfSeconds() {
        assertEquals(0, TimeParser.parseTimeToSeconds("12:00:00 am"));
    }
}
