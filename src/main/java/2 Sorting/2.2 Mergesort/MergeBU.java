public class MergeBU extends Merge {

    public static void sort(Comparable[] a) {
        int          n   = a.length;
        Comparable[] aux = new Comparable[a.length];
        for (int i = 1; i < n; i *= 2) {
            for (int l = 0; l < n - i; l += 2 * i) {
                int mid = l + i - 1;
                int r   = Math.min(l + 2 * i - 1, n - 1);
                merge(a, aux, l, mid, r);
            }
        }
        assert isSorted(a);
    }
}
