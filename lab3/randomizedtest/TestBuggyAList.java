package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        // Instantiate two lists.
        AListNoResizing<Integer> a = new AListNoResizing();
        BuggyAList<Integer> b = new BuggyAList();

        // Add numbers into list.
        for (int i = 0; i < 3; i++) {
            a.addLast(i);
            b.addLast(i);
        }

        // Use JUnit to test your code.
        for (int i = 0; i < 3; i++) {
            assertEquals(a.removeLast(), b.removeLast());        }
    }

    @Test
    public void randomizedTest() {

        // Instantiate two lists.
        AListNoResizing<Integer> a = new AListNoResizing<>();
        BuggyAList<Integer> b = new BuggyAList();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            int aSize = a.size();
            int bSize = b.size();

            // print size
            if (operationNumber == 0) {
                System.out.println("a.size: " + aSize);
                System.out.println("b.size: " + bSize);

            // addLast
            } else if (operationNumber == 1) {
                int randVal = StdRandom.uniform(0, 100);
                a.addLast(randVal);
                b.addLast(randVal);
                System.out.println("a.addLast(" + randVal + ")");
                System.out.println("b.addLast(" + randVal + ")");

            // getLast and removeLast
            } else if (operationNumber == 2 && aSize > 0){
                int aLast = a.getLast();
                int bLast = b.getLast();
                a.removeLast();
                b.removeLast();
                System.out.println("removeLast: " + aLast);
                System.out.println("removeLast: " + bLast);

                assertEquals(aLast, bLast);
            }
        }


    }

}

