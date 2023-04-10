package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void addRemoveTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        assertTrue(ad1.isEmpty());

        ad1.addFirst(10);
        assertFalse(ad1.isEmpty());

        ad1.addLast(15);
        assertEquals(2, ad1.size());

        int tmp = ad1.removeFirst();
        assertEquals(10, tmp);

        tmp = ad1.removeLast();
        assertEquals(15, tmp);
        assertTrue(ad1.isEmpty());

    }
}
