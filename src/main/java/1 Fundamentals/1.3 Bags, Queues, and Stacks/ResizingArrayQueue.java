import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayQueue<Item> implements IQueue<Item> {
    private Item[] array;
    private int    size;
    private int    first, last;

    public ResizingArrayQueue() {
        @SuppressWarnings("unchecked")
        Item[] array = (Item[]) new Object[2];
        this.array = array;
        this.size = this.first = this.last = 0;
    }

    private void resize(int capacity) {
        assert capacity >= size;
        @SuppressWarnings("unchecked")
        Item[] tempArray = (Item[]) new Object[capacity];
        System.arraycopy(array, 0, tempArray, 0, this.size);
        array = tempArray;
        last = (last + size) % array.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void enqueue(Item item) {
        if (size == array.length) resize(size * 2);
        array[last] = item;
        last = (last + 1) % array.length;
        size++;
    }

    @Override
    public Item dequeue() {
        Item item = peek();
        first = (first + 1) % array.length;
        size--;
        if (size > 0 && size < array.length / 4) resize(array.length / 2);
        return item;
    }

    @Override
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return array[first];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int count = 0;

        @Override
        public boolean hasNext() { return count < size; }

        @Override
        public void remove() { throw new UnsupportedOperationException(); }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return array[(count++ + first) % array.length];
        }
    }
}
