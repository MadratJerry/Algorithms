public class Inversions {

    public static <Key extends Comparable<Key>> long count(Key[] a) {
        Key[] aux = a.clone();
        return count(a, aux, 0, a.length - 1);
    }

    private static <Key extends Comparable<Key>> long count(Key[] a, Key[] aux, int l, int r) {
        if (r <= l) return 0;
        long inversions = 0;
        int  mid        = l + (r - l) / 2;
        inversions += count(a, aux, l, mid);
        inversions += count(a, aux, mid + 1, r);
        inversions += merge(a, aux, l, mid, r);
        return inversions;
    }

    private static <Key extends Comparable<Key>> long merge(Key[] a, Key[] aux, int l, int mid, int r) {
        long inversions = 0;
        System.arraycopy(a, l, aux, l, r - l + 1);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > r) a[k] = aux[i++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
            else {
                a[k] = aux[j++];
                inversions += mid - i + 1;
            }
        }
        return inversions;
    }

    private static <Key extends Comparable<Key>> boolean less(Key x, Key y) {
        return x.compareTo(y) < 0;
    }
}
