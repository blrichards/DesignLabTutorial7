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
