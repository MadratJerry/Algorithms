import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<Item> implements IQueue<Item> {
    private Node first;
    private Node last;
    private int  size;

    private class Node {
        Item item;
        Node next;
    }

    public LinkedQueue() {
        first = last = null;
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
    public void enqueue(Item item) {
        Node temp = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) first = last;
        else temp.next = last;
        size++;
    }

    @Override
    public Item dequeue() {
        Item item = peek();
        first = first.next;
        size--;
        return item;
    }

    @Override
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return first.item;
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
        public void remove() { throw new UnsupportedOperationException(); }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
