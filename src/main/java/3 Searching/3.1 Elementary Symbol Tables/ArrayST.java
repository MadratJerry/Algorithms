import java.util.Arrays;

public class ArrayST<Key, Value> implements BasicSymbolTable<Key, Value> {
    private static final int INIT_SIZE = 8;

    private Value[] values;   // symbol table values
    private Key[] keys;     // symbol table keys
    private int n = 0;      // number of elements in symbol table

    public ArrayST() {
        @SuppressWarnings("unchecked")
        Key[] keys = (Key[]) new Object[INIT_SIZE];
        @SuppressWarnings("unchecked")
        Value[] values = (Value[]) new Object[INIT_SIZE];

        this.keys = keys;
        this.values = values;
    }

    private void resize(int capacity) {
        @SuppressWarnings("unchecked")
        Key[] newKeys = (Key[]) new Object[capacity];
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

    @Override
    public Value get(Key key) {
        checkKey(key);
        for (int i = 0; i < n; i++)
            if (keys[i].equals(key)) return values[i];
        return null;
    }

    @Override
    public void put(Key key, Value value) {
        delete(key);

        if (n >= keys.length) resize(2 * n);

        keys[n] = key;
        values[n] = value;
        n++;
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public void delete(Key key) {
        checkKey(key);
        for (int i = 0; i < n; i++) {
            if (key.equals(keys[i])) {
                keys[i] = keys[n - 1];
                values[i] = values[n - 1];
                keys[n - 1] = null;
                values[n - 1] = null;
                n--;
                if (n > 0 && n == keys.length / 4) resize(keys.length / 2);
                break;
            }
        }
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterable<Key> keys() {
        return Arrays.asList(Arrays.copyOf(keys, n));
    }
}
