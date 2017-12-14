package main;

import static org.junit.Assert.*;
import org.junit.Test;

public class PhiladelphiaTest {

    @Test
    public void testIsItSunny() {
        assertTrue(Philadelphia.isItSunny());
    }

    @Test
    public void testIsItSunnyShouldFail() {
        assertFalse(Philadelphia.isItSunny());
    }

    @Test
    public void testIsItSunnyEqualTrue() {
        assertEquals(true, Philadelphia.isItSunny());
    }

    @Test
    public void testThrowException() throws Exception {
        throw new Exception("test");
    }
}