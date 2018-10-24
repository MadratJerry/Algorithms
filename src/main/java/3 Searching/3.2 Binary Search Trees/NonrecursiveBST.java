import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NonrecursiveBST<Key extends Comparable<Key>, Value> extends BST<Key, Value> {

    @Override
    public void put(Key key, Value value) {
        checkKey(key);

        Node newNode = new Node(key, value, 1);
        if (root == null) {
            root = newNode;
            return;
        }

        Node parent = null, node = root;
        while (node != null) {
            parent = node;
            node.size++;
            int cmp = key.compareTo(node.key);
            if (cmp < 0) node = node.left;
            else if (cmp > 0) node = node.right;
            else {
                node.value = value;
                return;
            }
        }

        if (key.compareTo(parent.key) < 0) parent.left = newNode;
        else parent.right = newNode;
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
    public Iterable<Key> keys() {
        Stack<Node> stack = new Stack<>();
        Queue<Key>  queue = new LinkedList<>();

        Node node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            queue.add(node.key);
            node = node.right;
        }
        return queue;
    }
}
