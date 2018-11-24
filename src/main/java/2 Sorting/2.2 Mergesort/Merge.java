public class Merge extends Sort {

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
        assert isSorted(a);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int l, int r) {
        if (r <= l) return;
        int mid = l + (r - l) / 2;
        sort(a, aux, l, mid);
        sort(a, aux, mid + 1, r);
        merge(a, aux, l, mid, r);
    }

    static void merge(Comparable[] a, Comparable[] aux, int l, int mid, int r) {
        assert isSorted(a, l, mid);
        assert isSorted(a, mid + 1, r);

        System.arraycopy(a, l, aux, l, r - l + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > r) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }
}
