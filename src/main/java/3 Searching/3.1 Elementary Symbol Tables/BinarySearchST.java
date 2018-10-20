import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class BinarySearchST<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] values;
    private int n = 0;

    public BinarySearchST() {
        this(INIT_CAPACITY);
    }

    public BinarySearchST(int capacity) {
        @SuppressWarnings("unchecked")
        Key[] keys = (Key[]) new Comparable[capacity];
        @SuppressWarnings("unchecked")
        Value[] values = (Value[]) new Object[capacity];

        this.keys = keys;
        this.values = values;
    }

    private void resize(int capacity) {
        assert capacity >= n;

        @SuppressWarnings("unchecked")
        Key[] newKeys = (Key[]) new Comparable[capacity];
        @SuppressWarnings("unchecked")
        Value[] newValues = (Value[]) new Object[capacity];

        System.arraycopy(keys, 0, newKeys, 0, n);
        System.arraycopy(values, 0, newValues, 0, n);

        this.keys = newKeys;
        this.values = newValues;
    }

    private void checkKey(Key key) {
        if (key == null) throw new IllegalArgumentException("The argument key is null");
    }

    private boolean check() {
        return isSorted() && rankCheck();
    }

    private boolean isSorted() {
        for (int i = 1; i < size(); i++)
            if (keys[i].compareTo(keys[i - 1]) < 0) return false;
        return true;
    }

    private boolean rankCheck() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (int i = 0; i < size(); i++)
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) return false;
        return true;
    }

    @Override
    public void put(Key key, Value value) {
        checkKey(key);

        if (value == null) {
            delete(key);
            return;
        }

        int index = rank(key);

        if (index < n && key.compareTo(keys[index]) == 0) {
            values[index] = value;
            return;
        }

        if (keys.length == n) resize(2 * n);

        for (int i = n; i > index; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[index] = key;
        values[index] = value;
        n++;

        assert check();
    }

    @Override
    public Value get(Key key) {
        checkKey(key);
        int index = rank(key);
        return index < n && key.compareTo(keys[index]) == 0 ? values[index] : null;
    }

    @Override
    public void delete(Key key) {
        checkKey(key);
        int index = rank(key);

        if (!isEmpty() && index < n && key.compareTo(keys[index]) == 0) {
            for (int i = index; i < n - 1; i++) {
                keys[i] = keys[i + 1];
                values[i] = values[i + 1];
            }
        }

        n--;
        keys[n] = null;
        values[n] = null;

        if (n > 0 && n == keys.length / 4) resize(keys.length / 2);

        assert check();
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    @Override
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("Call min() with empty symbol table");
        return keys[0];
    }

    @Override
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("Call max() with empty symbol table");
        return keys[n - 1];
    }

    @Override
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("Key to floor() is null");
        int index = rank(key);
        if (index < n && key.compareTo(keys[index]) == 0) return keys[index];
        if (index == 0) return null;
        else return keys[index - 1];
    }

    @Override
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("Key to ceiling() is null");
        int index = rank(key);
        if (index == n) return null;
        else return keys[index];
    }

    @Override
    public int rank(Key key) {
        checkKey(key);

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2,
                    cmp = key.compareTo(keys[mid]);
            if (cmp < 0) r = mid - 1;
            else if (cmp > 0) l = mid + 1;
            else return mid;
        }

        return l;
    }

    @Override
    public Key select(int index) {
        if (index < 0 || index >= size())
            throw new IllegalArgumentException("Invalid argument: " + index);

        return keys[index];
    }

    @Override
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
        delete(min());
    }

    @Override
    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
        delete(max());
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
        if (l == null) throw new IllegalArgumentException("Left key to keys() is null");
        if (r == null) throw new IllegalArgumentException("Right key to keys() is null");
        if (l.compareTo(r) > 0) return new LinkedList<>();
        Key[] a =
                Arrays.copyOfRange(keys, rank(l), rank(r) + (contains(r) ? 1 : 0));
        return Arrays.asList(a);
    }
}
