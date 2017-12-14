package main;

import org.junit.Test;
import static org.junit.Assert.*;

public class TimeParserTestFullPathCoverage {
    private static final int MINS_PER_HR = 60;
    private static final int SECS_PER_MIN = 60;

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
    public void testBadTimePM() {
        TimeParser.parseTimeToSeconds("24:00:00 pm");
    }

    /**
     * Tests that parseTimeToSeconds throws exception with bad time input.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testBadTimeAM() {
        TimeParser.parseTimeToSeconds("24:00:00 am");
    }

    /**
     * Tests that parseTimeToSeconds returns correct value for AM times.
     */
    @Test
    public void testCorrectNumberOfSecondsAM() {
        assertEquals(0, TimeParser.parseTimeToSeconds("12:00:00 am"));
    }

    /**
     * Tests that parseTimeToSeconds returns correct value for PM times.
     */
    @Test
    public void testCorrectNumberOfSecondsPM() {
        int expected = ((12 * MINS_PER_HR) * SECS_PER_MIN); // == 43,200 secs
        assertEquals(expected, TimeParser.parseTimeToSeconds("12:00:00 pm"));
    }
}
