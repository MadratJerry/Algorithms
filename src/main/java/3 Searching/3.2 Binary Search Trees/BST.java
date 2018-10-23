import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private int size;
        private Node left, right;

        Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    private void checkKey(Key key) {
        if (key == null) throw new IllegalArgumentException("The argument key is null");
    }

    @Override
    public void put(Key key, Value value) {
        checkKey(key);

        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value, 1);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = put(node.left, key, value);
        else if (cmp > 0) node.right = put(node.right, key, value);
        else node.value = value;

        node.size = size(node.left) + size(node.right) + 1;

        return node;
    }

    @Override
    public Value get(Key key) {
        checkKey(key);

        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) node = node.left;
            else if (cmp > 0) node = node.right;
            else return node.value;
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        checkKey(key);

        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = delete(node.left, key);
        else if (cmp > 0) node.right = delete(node.right, key);
        else {
            if (node.right == null) return node.left;
            if (node.left == null) return node.right;

            Node tempNode = node;
            node = min(tempNode.right);
            node.right = deleteMin(tempNode.right);
            node.left = tempNode.left;
        }

        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) return 0;
        else return node.size;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        return node == null ? 0 : Math.max(height(node.left), height(node.right)) + 1;
    }

    @Override
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    @Override
    public Key min() {
        return min(root).key;
    }

    private Node min(Node node) {
        return node.left == null ? node : min(node.left);
    }

    @Override
    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        return node.right == null ? node : max(node.right);
    }

    @Override
    public Key floor(Key key) {
        Node node = floor(root, key);
        return node == null ? null : node.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        else if (cmp < 0) return floor(node.left, key);

        Node rightNode = floor(node.right, key);
        return rightNode == null ? node : rightNode;
    }

    @Override
    public Key ceiling(Key key) {
        Node node = ceiling(root, key);
        return node == null ? null : node.key;
    }


    private Node ceiling(Node node, Key key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node;
        else if (cmp > 0) return ceiling(node.right, key);

        Node leftNode = ceiling(node.left, key);
        return leftNode == null ? node : leftNode;

    }

    @Override
    public int rank(Key key) {
        checkKey(key);

        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        if (node == null) return 0;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) return rank(node.left, key);
        else if (cmp > 0) return size(node.left) + rank(node.right, key) + 1;
        else return size(node.left);
    }

    @Override
    public Key select(int index) {
        return select(root, index);
    }

    private Key select(Node node, int index) {
        if (node == null) return null;

        int size = size(node.left);
        if (index < size) return select(node.left, index);
        else if (index > size) return select(node.right, index - size - 1);
        else return node.key;
    }

    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node.right == null) return node.left;
        node.right = deleteMin(node.right);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public int size(Key l, Key r) {
        if (l == null) throw new IllegalArgumentException("Left key to size() is null");
        if (r == null) throw new IllegalArgumentException("Right key to size() is null");
        if (l.compareTo(r) > 0) return 0;

        return rank(r) - rank(l) + (contains(r) ? 1 : 0);
    }

    @Override
    public Iterable<Key> keys(Key l, Key r) {
        Queue<Key> queue = new LinkedList<>();
        keys(root, queue, l, r);
        return queue;
    }

    private void keys(Node node, Queue<Key> queue, Key l, Key r) {
        if (node == null) return;

        int cmpL = l.compareTo(node.key);
        int cmpR = r.compareTo(node.key);
        if (cmpL < 0) keys(node.left, queue, l, r);
        if (cmpL <= 0 && cmpR >= 0) queue.add(node.key);
        if (cmpR > 0) keys(node.right, queue, l, r);
    }
}
