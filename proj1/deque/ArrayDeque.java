package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /**
     * Create an empty ArrayDeque.
     */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    public ArrayDeque(int capacity) {
        items = (T[]) new Object[capacity];
        size = 0;
        nextLast = Math.round(capacity / 2);
        nextFirst = nextLast - 1;
    }

    /**
     * Adds an item of type T in the nextFirst.
     */
    public void addFirst(T item) {
        size += 1;
        checkFull();

        items[nextFirst] = item;
        nextFirst = subOne(nextFirst);
    }

    /**
     * Adds an item of type T in the nextLast.
     */
    public void addLast(T item) {
        size += 1;
        checkFull();

        items[nextLast] = item;
        nextLast = addOne(nextLast);
    }

    /**
     * Returns the number of items in the deque.
     */
    public int size() {
        return size;
    }

    public int capacity() {
        return items.length;
    }

    /**
     * Prints the items in the deque from first to last.
     */
    public void printDeque() {
        for (T i : items) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    /**
     * Removes and returns the item after the nextFirst.
     */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        checkRedundancy();

        nextFirst = addOne(nextFirst);
        T item = items[nextFirst];

        items[nextFirst] = null;
        size -= 1;

        return item;
    }

    /**
     * Removes and returns the item before the nextLast.
     */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        checkRedundancy();

        nextLast = subOne(nextLast);
        T item = items[nextLast];

        items[nextLast] = null;
        size -= 1;

        return item;
    }

    /**
     * Gets the item at the given index.
     */
    public T get(int index) {
        return items[index];
    }

    public void replace(T item, int index) {
        items[index] = item;
    }

    /**
     * Return an iterator of deque.
     */
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    /**
     * Returns whether the parameter o is equal to the Deque.
     */
    public boolean equals(Object o) {
        if (o instanceof ArrayDeque && ((ArrayDeque<?>) o).size() == this.size()) {
            for (int i = 0; i < size; i += 1) {
                if (items[i] != ((ArrayDeque<?>) o).get(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Add one in '0' to 'size' circularly.
     */
    private int addOne(int index) {
        return (index + 1) % items.length;
    }

    /**
     * Sub one in '0' to 'size' circularly.
     */
    private int subOne(int index) {
        if (index == 0) {
            return items.length - 1;
        } else {
            return (index - 1) % items.length;
        }
    }

    /**
     * Check if size equals to deque length.
     */
    private void checkFull() {
        if (size > capacity()) {
            resize(size * 2);
        }
    }

    private void checkRedundancy() {
        int capacity = capacity();

        if (capacity > 4 * size && capacity >= 16) {
            resize(capacity / 2);
        }
    }

    /**
     * Resize length of deque.
     */
    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];

        int index = addOne(nextFirst);

        // Copy value in nextFirst to newItems[i].
        for (int i = 0; i < size; i += 1) {
            newItems[i] = items[index];
            index = addOne(index);
        }

        // Find the center position of new capacity.
        nextLast = size / 2 + size;
        nextFirst = nextLast - 1;
        items = newItems;
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int index;

        public ArrayDequeIterator() {
            index = 0;
        }

        public boolean hasNext() {
            return index == size;
        }

        public T next() {
            T item = items[index];
            index = addOne(index);

            return item;
        }
    }

}
