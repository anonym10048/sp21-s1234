package deque;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {
    private class Node {
        private T item;
        private Node next;
        private Node prev;

        Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private final Node sentinel = new Node(null, null, null);
    private int size;

    /**
     * Create an empty LinkedListDeque.
     */
    public LinkedListDeque() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

        size = 0;
    }

    /**
     * Adds an item of type T to the front of the deque.
     */
    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.next);

        sentinel.next.prev = newNode;
        sentinel.next = newNode;

        size += 1;
    }

    /**
     * Adds an item of type T to the back of the deque.
     */
    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.prev, sentinel);

        sentinel.prev.next = newNode;
        sentinel.prev = newNode;

        size += 1;
    }

    /**
     * Returns the number of items in the deque.
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last.
     */
    public void printDeque() {
        Node p = sentinel;

        while (p.next != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    /**
     * Removes and returns the item at the front of the deque.
     */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T val = sentinel.next.item;

        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;

        size -= 1;

        return val;
    }

    /**
     * Removes and returns the item at the back of the deque.
     */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T val = sentinel.prev.item;

        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;

        size -= 1;

        return val;
    }

    /**
     * Gets the item at the given index.
     */
    public T get(int index) {
        Node p = sentinel;

        while (index != 0) {
            p = p.next;
            index -= 1;
        }

        return p.item;
    }

    public void replace(T item, int index) {
        Node p = sentinel;

        while (index != 0) {
            p = p.next;
            index -= 1;
        }

        p.item = item;
    }

    /**
     * Return an iterator of deque.
     */
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }

    /**
     * Returns whether the parameter o is equal to the deque.
     */
    @SuppressFBWarnings("HE_EQUALS_USE_HASHCODE")
    public boolean equals(Object o) {
        // if o is instance of LinkedListDeque and their size are same value.
        if (o instanceof LinkedListDeque && ((LinkedListDeque<?>) o).size() == this.size()) {
            for (int i = 0; i < size; i += 1) {
                if (((LinkedListDeque<?>) o).get(i) != this.get(i)) {
                    return false;
                }
            }

            return true;
        }
        return false;
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        private Node p;

        LinkedListDequeIterator() {
            p = sentinel.next;
        }

        public boolean hasNext() {
            return p != sentinel;
        }

        public T next() {
            if (hasNext()) {
                T item = p.item;
                p = p.next;

                return item;
            }
            return null;
        }
    }

}
