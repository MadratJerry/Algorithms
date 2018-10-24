public class InsertionX extends Sort {

    public static void sort(Comparable[] a) {
        int exchanges = 0;
        for (int i = a.length - 1; i > 0; i--) {
            if (less(a[i], a[i - 1])) {
                exch(a, i, i - 1);
                exchanges++;
            }
        }

        if (exchanges == 0) return;

        for (int i = 2; i < a.length; i++) {
            Comparable v = a[i];
            int        j = i;
            while (less(v, a[j - 1])) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = v;
        }

        assert isSorted(a);
    }
}
