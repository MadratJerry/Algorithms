import edu.princeton.cs.algs4.StdOut;

public abstract class Sort {

    public static void sort(Comparable[] a) {
        throw new UnsupportedOperationException();
    }

    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/
    static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    // print array to standard output
    static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
}
