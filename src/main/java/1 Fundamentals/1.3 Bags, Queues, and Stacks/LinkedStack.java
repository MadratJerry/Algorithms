import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<Item> implements IStack<Item> {
    private int  size;
    private Node first;

    public LinkedStack() {
        first = null;
        size = 0;
    }

    private class Node {
        private Item item;
        private Node next;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(Item item) {
        Node temp = first;
        first = new Node();
        first.item = item;
        first.next = temp;
        size++;
    }

    @Override
    public Item pop() {
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
