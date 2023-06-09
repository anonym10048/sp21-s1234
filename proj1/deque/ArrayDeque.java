package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
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
        nextFirst = 0;
        nextLast = 1;
    }

    /**
     * Adds an item of type T in the nextFirst.
     */
    @Override
    public void addFirst(T item) {
        checkFull();

        items[nextFirst] = item;
        nextFirst = subOne(nextFirst);

        size += 1;
    }

    /**
     * Adds an item of type T in the nextLast.
     */
    @Override
    public void addLast(T item) {
        checkFull();

        items[nextLast] = item;
        nextLast = addOne(nextLast);

        size += 1;
    }

    /**
     * Returns the number of items in the deque.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last.
     */
    @Override
    public void printDeque() {
        for (T i : items) {
            System.out.print(i + " ");
        }

        System.out.println();
    }

    /**
     * Removes and returns the item after the nextFirst.
     */
    @Override
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
    @Override
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
    @Override
    public T get(int index) {
        // pointer points to the previous
        int itemIndex = addOne(nextFirst);

        // find the Nth items
        while (index > 0) {
            itemIndex = addOne(itemIndex);
            index -= 1;
        }

        return items[itemIndex];
    }

    /**
     * Return an iterator of deque.
     */
    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
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
        return (index - 1 + items.length) % items.length;
    }

    /**
     * Check if size equals to deque length.
     */
    private void checkFull() {
        if (size == items.length) {
            resize(size * 2);
        }
    }

    private void checkRedundancy() {
        int capacity = items.length;

        if (capacity > 4 * size && capacity >= 16) {
            resize(capacity / 4);
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
        nextFirst = capacity - 1;
        nextLast = size;
        items = newItems;
    }

    private class ArrayDequeIterator implements Iterator<T> {
        private int index;

        ArrayDequeIterator() {
            index = addOne(nextFirst);
        }

        public boolean hasNext() {
            return index != nextLast;
        }

        public T next() {
            T item = items[index];
            index = addOne(index);

            return item;
        }
    }

    /**
     * Returns whether the parameter o is equal to the Deque.
     */
    @Override
    public boolean equals(Object o) {
        // if o is instance of Deque and their size are same.
        if (o == null) {
            return false;
        }

        if (o == this) {
            return true;
        }

        if (o instanceof Deque) {
            Deque<?> d = (Deque<?>) o;

            if (d.size() == size) {
                int index = addOne(nextFirst);
                for (int i = 0; i < size; i += 1) {
                    if (!(items[index].equals(d.get(i)))) {
                        return false;
                    }
                    index = addOne(index);
                }
                return true;
            }
        }
        return false;
    }


}
