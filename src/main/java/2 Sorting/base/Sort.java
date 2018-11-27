import edu.princeton.cs.algs4.StdOut;

public abstract class Sort {

    public static <Key extends Comparable<Key>> void sort(Key[] a) {
        throw new UnsupportedOperationException();
    }

    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    static <Key extends Comparable<Key>> boolean less(Key x, Key y) { return x.compareTo(y) < 0; }

    // exchange a[i] and a[j]
    static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/
    static <Key extends Comparable<Key>> boolean isSorted(Key[] a) { return isSorted(a, 0, a.length - 1); }

    static <Key extends Comparable<Key>> boolean isSorted(Key[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    // print array to standard output
    static <Key extends Comparable<Key>> void show(Key[] a) { for (Key key : a) StdOut.println(key); }
}
