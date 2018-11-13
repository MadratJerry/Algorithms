import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedBag<Item> implements IBag<Item> {
    private Node first;
    private int  size;

    private class Node {
        private Item item;
        private Node next;
    }

    public LinkedBag() {
        first = null;
        size = 0;
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
    public void add(Item item) {
        Node temp = first;
        first = new Node();
        first.item = item;
        first.next = temp;
        size++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() { return current != null; }

        @Override
        public void remove()     { throw new UnsupportedOperationException(); }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
