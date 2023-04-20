package deque;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Comparator;

public class MaxArrayDequeTest {
    @Test
    public void maxWithoutComparatorTest() {
        MaxArrayDeque<Integer> a = new MaxArrayDeque<>(new IntComparator());

        for (int i = 0; i < 5; i++) {
            a.addLast(i);
        }

        assertEquals((Integer) 4, a.max());
    }

    private static class IntComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            if (i1 == null && i2 == null) {
                return 0;
            } else if (i1 == null) {
                return -1;
            } else if (i2 == null) {
                return 1;
            } else {
                return i1 - i2;
            }
        }
    }
}
