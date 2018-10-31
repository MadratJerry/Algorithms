public class RedBlackBST<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> {
    private final static boolean BLACK = false;
    private final static boolean RED   = true;

    private Node root;

    private class Node {
        private Key   key;
        private Value value;
        int  size;
        Node left, right;
        boolean color;

        Node(Key key, Value value, int size, boolean color) {
            this.key = key;
            this.value = value;
            this.size = size;
            this.color = color;
        }
    }

    private void checkKey(Key key) {
        if (key == null) throw new IllegalArgumentException("The argument key is null");
    }

    private boolean isRedBlackBST() {
        return is23() && isBalanced();
    }

    private boolean isRed(Node node) {
        return node != null && node.color == RED;
    }

    private boolean is23() {
        return is23(root);
    }

    private boolean is23(Node node) {
        if (node == null) return true;

        if (isRed(node.left) && isRed(node.left.left)) return false;
        if (isRed(node.right)) return false;

        return is23(node.left) && is23(node.right);
    }

    private boolean isBalanced() {
        int  black = 0;
        Node node  = root;
        while (node != null) {
            if (!isRed(node)) black++;
            node = node.left;
        }
        return isBalanced(root, black);
    }

    private boolean isBalanced(Node node, int black) {
        if (node == null) return black == 0;
        if (!isRed(node)) black--;
        return isBalanced(node.left, black) && isBalanced(node.right, black);
    }

    private boolean isBST() {
        return isBST(root, null, null);
    }

    private boolean isBST(Node node, Key min, Key max) {
        if (node == null) return true;
        if (min != null && node.key.compareTo(min) <= 0) return false;
        if (max != null && node.key.compareTo(max) >= 0) return false;
        return isBST(node.left, min, node.key) && isBST(node.right, node.key, max);
    }

    @Override
    public void put(Key key, Value value) {
        checkKey(key);

        root = put(root, key, value);
        root.color = BLACK;

        assert isRedBlackBST();
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value, 1, RED);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = put(node.left, key, value);
        else if (cmp > 0) node.right = put(node.right, key, value);
        else node.value = value;

        if (!isRed(node.left) && isRed(node.right)) node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColors(node);

        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Node rotateLeft(Node node) {
        Node rightNode = node.right;
        node.right = rightNode.left;
        rightNode.left = node;
        rightNode.color = node.color;
        node.color = RED;
        rightNode.size = node.size;
        node.size = 1 + size(node.left) + size(node.right);
        return rightNode;
    }

    private Node rotateRight(Node node) {
        Node leftNode = node.left;
        node.left = leftNode.right;
        leftNode.right = node;
        leftNode.color = node.color;
        node.color = RED;
        leftNode.size = node.size;
        node.size = 1 + size(node.left) + size(node.right);
        return leftNode;
    }

    private void flipColors(Node node) {
        node.left.color = node.right.color = BLACK;
        node.color = RED;
    }

    @Override
    public Value get(Key key) {
        checkKey(key);

        return get(root, key);
    }

    private Value get(Node node, Key key) {
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
        return node == null ? 0 : node.size;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key select(int index) {
        return null;
    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }

    @Override
    public int size(Key l, Key r) {
        return 0;
    }

    @Override
    public Iterable<Key> keys(Key l, Key r) {
        return null;
    }
}
