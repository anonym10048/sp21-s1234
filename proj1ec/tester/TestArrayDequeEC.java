package tester;

import org.junit.Test;
import static org.junit.Assert.*;

import edu.princeton.cs.algs4.StdRandom;
import student.StudentArrayDeque;

public class TestArrayDequeEC {
    @Test
    public void randomAddRemoveTest() {

        StudentArrayDeque<Integer> a = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> b = new ArrayDequeSolution<>();

        int N = 1000;

        while (N != 0) {
            int operation = StdRandom.uniform(0, 5);
            int sizeA = a.size();
            int sizeB = b.size();

            if (operation == 0) {
                System.out.println("size()");
                assertEquals("size()", sizeB, sizeA);

            } else if (operation == 1) {
                int randNum = StdRandom.uniform(0, 100);
                a.addFirst(randNum);
                b.addFirst(randNum);
                System.out.println("addFirst(" + randNum + ")");

            } else if (operation == 2) {
                int randNum = StdRandom.uniform(0, 100);
                a.addLast(randNum);
                b.addLast(randNum);
                System.out.println("addLast(" + randNum + ")");

            } else if (operation == 3 && sizeA > 0 && sizeB > 0) {
                Integer expected = b.removeFirst();
                Integer actual = a.removeFirst();

                assertEquals("removeFirst()", expected, actual);

            } else if (operation == 4 && sizeA > 0 && sizeB > 0) {
                Integer expected = b.removeLast();
                Integer actual = a.removeLast();

                assertEquals("removeLast()", expected, actual);
            }
            N -= 1;
        }

    }

    @Test
    public void printTest() {

    }

}
