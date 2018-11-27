public class MergeX extends Sort {
    private static final int CUTOFF = 7;

    public static <Key extends Comparable<Key>> void sort(Key[] a) {
        Key[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
    }

    private static <Key extends Comparable<Key>> void insertionSort(Key[] a, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            for (int j = i; j > l && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
        }
    }

    private static <Key extends Comparable<Key>> void sort(Key[] src, Key[] dst, int l, int r) {
        if (r <= l + CUTOFF) {
            insertionSort(dst, l, r);
            return;
        }

        int mid = l + (r - l) / 2;
        sort(dst, src, l, mid);
        sort(dst, src, mid + 1, r);

        if (less(src[mid], src[mid + 1])) {
            System.arraycopy(src, l, dst, l, r - l + 1);
            return;
        }

        merge(src, dst, l, mid, r);
    }

    private static <Key extends Comparable<Key>> void merge(Key[] src, Key[] dst, int l, int mid, int r) {
        assert isSorted(src, l, mid);
        assert isSorted(src, mid + 1, r);

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) dst[k] = src[j++];
            else if (j > r) dst[k] = src[i++];
            else if (less(src[i], src[j])) dst[k] = src[i++];
            else dst[k] = src[j++];
        }

        assert isSorted(dst, l, r);
    }
}
