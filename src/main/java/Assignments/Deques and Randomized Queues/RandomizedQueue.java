import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int    size;
    private Item[] array;

    public RandomizedQueue() {
        @SuppressWarnings("unchecked")
        Item[] items = (Item[]) new Object[2];
        array = items;
    }

    private void resize(int size) {
        @SuppressWarnings("unchecked")
        Item[] tempArray = (Item[]) new Object[size];
        System.arraycopy(array, 0, tempArray, 0, this.size);
        array = tempArray;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException("Item is expected to be not null.");

        if (size == array.length) resize(size * 2);

        array[size++] = item;
    }

    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty.");

        int  index = StdRandom.uniform(size);
        Item item  = array[index];
        array[index] = array[size - 1];
        array[size-- - 1] = null;
        if (size > 0 && size == array.length / 4) resize(size * 2);

        return item;
    }

    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty.");

        return array[StdRandom.uniform(size)];
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedArrayIterator();
    }

    private class RandomizedArrayIterator implements Iterator<Item> {
        private RandomizedQueue<Item> rq;

        public RandomizedArrayIterator() {
            rq = new RandomizedQueue<>();
            rq.size = size;
            @SuppressWarnings("unchecked")
            Item[] items = (Item[]) new Object[2];
            rq.array = items;
            System.arraycopy(array, 0, rq.array, 0, size);
        }

        @Override
        public boolean hasNext() {
            return !rq.isEmpty();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return rq.dequeue();
        }
    }
}
