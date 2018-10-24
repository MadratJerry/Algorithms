import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedList;

public class SequentialSearchST<Key, Value> implements BasicSymbolTable<Key, Value> {
    private Node first;
    private int  n;

    private class Node {
        Key   key;
        Value value;
        Node  next;

        Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private void checkKey(Key key) {
        if (key == null) throw new IllegalArgumentException("The argument key is null");
    }

    @Override
    public void put(Key key, Value value) {
        checkKey(key);

        if (value == null) {
            delete(key);
            return;
        }

        for (Node node = first; node != null; node = node.next)
            if (key.equals(node.key)) {
                node.value = value;
                return;
            }

        first = new Node(key, value, first);
        n++;
    }

    @Override
    public Value get(Key key) {
        checkKey(key);

        for (Node node = first; node != null; node = node.next)
            if (key.equals(node.key)) return node.value;
        return null;
    }

    @Override
    public void delete(Key key) {
        checkKey(key);

        for (Node node = first, previous = null; node != null; previous = node, node = node.next)
            if (key.equals(node.key)) {
                if (previous == null) first = node.next;
                else previous.next = node.next;
                n--;
                break;
            }
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterable<Key> keys() {
        LinkedList<Key> list = new LinkedList<>();
        for (Node node = first; node != null; node = node.next)
            list.offerFirst(node.key);

        return list;
    }

    public static void main(String... args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}

