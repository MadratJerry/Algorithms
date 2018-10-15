import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.LinkedList;

public class SequentialSearchST<Key, Value> implements SymbolTable<Key, Value> {
    private Node first;
    private int n;

    private class Node {
        Key key;
        Value value;
        Node next;

        Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("Key is null");
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
        if (key == null) throw new IllegalArgumentException("Key is null");

        for (Node node = first; first != null; node = node.next)
            if (key.equals(node.key)) return node.value;
        return null;
    }

    @Override
    public void delete(Key key) {
        for (Node node = first, previous = null; first != null; previous = node, node = node.next)
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
        for (Node node = first; first != null; node = node.next)
            list.add(node.key);

        return list;
    }

    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}

