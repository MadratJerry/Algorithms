public class Insertion extends Sort {

    public static <Key extends Comparable<Key>> void sort(Key[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }
}
