public class Merge extends Sort {

    public static <Key extends Comparable<Key>> void sort(Key[] a) {
        Key[] aux = a.clone();
        sort(a, aux, 0, a.length - 1);
        assert isSorted(a);
    }

    public static <Key extends Comparable<Key>> int[] indexSort(Key[] a) {
        int   n     = a.length;
        int[] index = new int[n];
        for (int i = 0; i < n; i++) index[i] = i;
        int[] aux = new int[n];
        sort(a, aux, index, 0, n - 1);
        return index;
    }

    private static <Key extends Comparable<Key>> void sort(Key[] a, int[] aux, int[] index, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        sort(a, aux, index, l, mid);
        sort(a, aux, index, mid + 1, r);
        merge(a, aux, index, l, mid, r);
    }

    private static <Key extends Comparable<Key>> void merge(Key[] a, int[] aux, int[] index, int l, int mid, int r) {
        System.arraycopy(index, l, aux, l, r - l + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) index[k] = aux[j++];
            else if (j > r) index[k] = aux[i++];
            else if (less(a[aux[i]], a[aux[j]])) index[k] = aux[i++];
            else index[k] = aux[j++];
        }
    }

    private static <Key extends Comparable<Key>> void sort(Key[] a, Key[] aux, int l, int r) {
        if (r <= l) return;
        int mid = l + (r - l) / 2;
        sort(a, aux, l, mid);
        sort(a, aux, mid + 1, r);
        merge(a, aux, l, mid, r);
    }

    static <Key extends Comparable<Key>> void merge(Key[] a, Key[] aux, int l, int mid, int r) {
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
