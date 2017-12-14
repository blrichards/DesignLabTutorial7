## Exercise 1

1. Verify output of jUnit test passes for `testIsItSunny()`

2. Added test `testIsItSunnyShouldFail()`

    ```java
    @Test
    public void testIsItSunnyShouldFail() {
        assertFalse(Philadelphia.isItSunny());
    }
    ```
    
    `testIsItSunnyShouldFail()` stops execution of the test at assertFalse. jUnit catches
    the exception, prints 'java.lang.AssertionError' and the call stack.

3. Added test `testIsItSunnyEqualTrue()`

    ```java
    @Test
    public void testIsItSunnyEqualTrue() {
        assertEquals(true, Philadelphia.isItSunny());
    }
    ```
       
    testIsItSunnyEqualTrue() passes jUnit test because the first argument (expected)
    in assertEquals() is true and Philadelphia.isItSunny() (actual) returns true.
    
4. Added test `testThrowException()`

    ```java
    @Test
    public void testThrowException() throws Exception {
        throw new Exception("test");
    }
    ```
    
    testThrowException() throws an exception during jUnit execution. The exception is
    caught by jUnit and the exception type, error message, and call stack is printed to
    the console.

## Exercise 2

1. Verify all 3 tests pass

2. Added test `testClear()`

    ```java
    /**
     * Tests the clear method and verifies the expected return value.
     */
    @Test
    public void testClear() {
        testArray.clear();
        assertTrue(testArray.isEmpty());
    }
    ```

3. Added test `testContainsDoesContain()`

    ```java
    /**
     * Tests the contains method and verifies the expected return value.
     */
    @Test
    public void testContains() {
        assertTrue(testArray.contains(5));
    }
    ```

4. Added test `testContainsDoesNotContain()` 

    ```java
    /**
     * Test the contains method on non existing value and verifies the expected return value.
     */
    @Test
    public void testContainsDoesNotContain() {
        assertFalse(testArray.contains(10));
    }
    ```
    
5. Added test `testGet()`

    ```java
    /**
     * Tests the get methods and verifies the expected return value.
     */
    @Test
    public void testGet() {
        Integer expected = 3;
        Integer actual = testArray.get(0);
        assertEquals(expected, actual);
    }
    ```
    
## Exercise 3

#### Full Statement Coverage

```java
package main;

import org.junit.Test;
import static org.junit.Assert.*;

public class TimeParserTestFullStatementCoverage {
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
```

#### Full Branch Coverage

*Note: Full branch coverage test suite is actually the exact same 
as full statement coverage test suite for this particular method. 
This is due to the fact that each lone if statement throws an exception 
so individual tests much be created to cover each one.*

```java
package main;

import org.junit.Test;
import static org.junit.Assert.*;

public class TimeParserTestFullBranchCoverage {
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
```

#### Full Path Coverage

*Note: Full path coverage test suite uncovers bug that full branch test
suite and full statement test suite did not with the final test.*

```java
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
        int expected = ((12 * MINS_PER_HR) * SECS_PER_MIN); // 43,200 secs
        assertEquals(expected, TimeParser.parseTimeToSeconds("12:00:00 pm"));
    }
}
```

## Exercise 4

#### Test Suite

```java
package main;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class MinHeapArrayInvariant2Test {
    private static final long SEED = 42;
    private static final long VALUES_TO_TEST = 1000;

    private Random random;
    private HeapArray<Integer> heap;

    @Before
    public void setUp() {
        random = new Random(SEED);
        heap = new HeapArray<>();
    }

    @Test
    public void testWithRandomAdds() {
        for (int i = 0; i < VALUES_TO_TEST; i++) {
            int addMe = random.nextInt();
            heap.add(addMe);
            assertTrue(invariantHolds());
        }
    }

    @Test
    public void testWithRandomRemoves() {
        fillWithRandomValues(VALUES_TO_TEST);
        while (heap.size() > 0) {
            int indexToRemove = random.nextInt(heap.size());
            Integer removeMe = heap.get(indexToRemove);
            heap.remove(removeMe);
            assertTrue(invariantHolds());
        }
    }

    @Test
    public void testPop() {
        fillWithRandomValues(VALUES_TO_TEST);
        while (heap.size() > 0) {
            heap.pop();
            assertTrue(invariantHolds());
        }
    }

    @Test
    public void testClear() {
        fillWithRandomValues(VALUES_TO_TEST);
        heap.clear();
        assertTrue(invariantHolds());
    }

    @Test
    public void testToString() {
        fillWithRandomValues(VALUES_TO_TEST);
        Integer[] contents = heap.toArray(new Integer[heap.size()]);
        assertEquals(Arrays.toString(contents), heap.toString());
    }

    private boolean invariantHolds() {
        Integer[] contents = heap.toArray(new Integer[heap.size()]);

        for (int n = 0; n < contents.length; ++n) {
            int left = 2 * n + 1;
            int right = left + 1;
            if (left < contents.length && contents[n] > contents[left])
                return false;
            if (right < contents.length && contents[n] > contents[right])
                return false;
        }

        return true;
    }

    private void fillWithRandomValues(long numValues) {
        for (int i = 0; i < numValues; i++) {
            heap.add(random.nextInt());
        }
    }
}
```

#### Suggestions

1. Correct `toString()`

    Current `toString()` method includes null elements in output.
    Changed so that filling buffer stops at the first `null`, or equivalently,
    uses a `counter` and stops when `counter == size`.

