import edu.princeton.cs.algs4.StdRandom;

public class Quick extends Sort {

    public static <Key extends Comparable<Key>> void sort(Key[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    private static <Key extends Comparable<Key>> void sort(Key[] a, int l, int r) {
        if (l >= r) return;
        int p = partition(a, l, r);
        sort(a, l, p - 1);
        sort(a, p + 1, r);
        assert isSorted(a, l, r);
    }

    private static <Key extends Comparable<Key>> int partition(Key[] a, int l, int r) {
        Key pivot = a[l];
        int i     = l, j = r + 1;
        while (true) {
            while (less(a[++i], pivot)) if (i == r) break;
            while (less(pivot, a[--j])) if (j == l) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, l, j);
        return j;
    }
}
