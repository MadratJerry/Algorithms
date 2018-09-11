import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private int size;
    private Node<Item> first;
    private Node<Item> last;

    private class Node<Item> {
        Item value;
        Node<Item> previous;
        Node<Item> next;
    }

    private class DequeIterator<Item> implements Iterator<Item> {
        Node<Item> current;

        DequeIterator(Node<Item> first) {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item value = current.value;
            current = current.next;
            return value;
        }
    }

    public Deque() {
        size = 0;
        first = last = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException("Item is expected to be not null.");
        Node<Item> newFirst = new Node<>();
        newFirst.value = item;
        newFirst.next = first;

        if (isEmpty()) last = newFirst;
        else first.previous = newFirst;

        first = newFirst;
        size++;
    }

    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException("Item is expected to be not null.");
        Node<Item> newLast = new Node<>();
        newLast.value = item;
        newLast.previous = last;

        if (isEmpty()) first = newLast;
        else last.next = newLast;

        last = newLast;
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("Deque is empty.");
        Item value = first.value;
        first = first.next;
        size--;

        if (isEmpty()) last = null;
        else first.previous = null;

        return value;
    }


    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("Deque is empty.");

        Item value = last.value;
        last = last.previous;
        size--;

        if (isEmpty()) first = null;
        else last.next = null;

        return value;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator<>(first);
    }
}
