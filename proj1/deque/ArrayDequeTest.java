package deque;

import org.junit.Test;
import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;

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

    @Test
    public void removeEmptyTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(3);

        ad1.removeLast();
        ad1.removeFirst();
        ad1.removeLast();
        ad1.removeFirst();

        int size = ad1.size();
        assertEquals(0, size);

    }

    @Test
    public void multipleParamTest() {

        ArrayDeque<String> ad1 = new ArrayDeque<>();
        ArrayDeque<Double> ad2 = new ArrayDeque<>();
        ArrayDeque<Boolean> ad3 = new ArrayDeque<>();

        ad1.addFirst("string");
        ad2.addFirst(3.14159);
        ad3.addFirst(true);

        String s = ad1.removeFirst();
        double d = ad2.removeFirst();
        boolean b = ad3.removeFirst();

        assertEquals("string", s);
        assertEquals("3.14159", Double.toString(d));
        assertEquals("true", Boolean.toString(b));

    }

    @Test
    public void emptyNullReturnTest() {

        ArrayDeque<Integer> ad1 = new ArrayDeque<>();

        assertNull(ad1.removeFirst());
        assertNull(ad1.removeLast());

    }

}
