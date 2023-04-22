package deque;

import org.junit.Test;
import static org.junit.Assert.*;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class ArrayDequeTest {

    @Test
    public void addGetTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        assertTrue(ad1.isEmpty());

        for (int i = 0; i < 5; i++) {
            ad1.addLast(i);
        }

        for (int i = 0; i < 5; i++) {
            assertEquals(ad1.get(i), (Integer)i);
        }
    }

    @Test
    public void addRemoveTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();

        for (int i = 0; i < 4; i++) {
            ad1.addFirst(i);
        }

        for(int i = 4; i < 9; i++) {
            ad1.addLast(i);
        }

        assertNotNull(ad1.removeFirst());
        assertNotNull(ad1.removeLast());

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

    @Test
    public void getTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            ad1.addLast(i);
        }

        for (int i = 0; i < 5; i++) {
            assertEquals((int)ad1.get(i), i);
        }
    }

    @Test
    public void iteratorNextValueTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 5; i++) {
            ad1.addFirst(i);
        }

        Iterator<Integer> ad2 = ad1.iterator();
        for (Integer i = 4; i >= 0; i--) {
            assertEquals(ad2.next(), i);
        }
    }

    @Test
    public void emptyIteratorTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        Iterator<Integer> ad2 = ad1.iterator();

        assertFalse(ad2.hasNext());
    }

}
