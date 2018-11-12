import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<Item> implements IStack<Item> {
    private Item[] array;
    private int    size;

    public ResizingArrayStack() {
        @SuppressWarnings("unchecked")
        Item[] array = (Item[]) new Object[2];
        this.array = array;
        this.size = 0;
    }

    private void resize(int capacity) {
        assert capacity <= size;
        @SuppressWarnings("unchecked")
        Item[] tempArray = (Item[]) new Object[size];
        System.arraycopy(array, 0, tempArray, 0, this.size);
        array = tempArray;
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
    public void push(Item item) {
        if (size == array.length) resize(size * 2);
        array[size++] = item;
    }

    @Override
    public Item pop() {
        Item item = peek();
        array[size-- - 1] = null;
        if (size > 0 && size == array.length / 4) resize(array.length / 2);
        return item;
    }

    @Override
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return array[size - 1];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int count = size;

        @Override
        public boolean hasNext() { return count >= 0; }

        @Override
        public void remove() { throw new UnsupportedOperationException(); }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return array[--count];
        }
    }
}
