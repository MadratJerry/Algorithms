public class Merge extends Sort {

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
        assert isSorted(a);
    }

    private static void sort(Comparable[] a, Comparable[] dst, int l, int r) {
        if (r <= l) return;
        int mid = l + (r - l) / 2;
        sort(a, dst, l, mid);
        sort(a, dst, mid + 1, r);
        merge(a, dst, l, mid, r);
    }

    static void merge(Comparable[] a, Comparable[] dst, int l, int mid, int r) {
        assert isSorted(a, l, mid);
        assert isSorted(a, mid + 1, r);
        System.arraycopy(a, l, dst, l, r - l + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) a[k] = dst[j++];
            else if (j > r) a[k] = dst[i++];
            else if (less(dst[i], dst[j])) a[k] = dst[i++];
            else a[k] = dst[j++];
        }
    }
}
