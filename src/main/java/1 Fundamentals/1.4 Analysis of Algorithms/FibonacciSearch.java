public class FibonacciSearch {

    public static int indexOf(int[] a, int key) {
        int fk2 = 0, fk1 = 1, fk = fk2 + fk1;
        while (fk < a.length) {
            fk2 = fk1;
            fk1 = fk;
            fk = fk2 + fk1;
        }
        int i = -1;
        while (i < i + fk) {
            int mid = Math.min(i + fk2, a.length - 1);
            if (key < a[mid]) {
                fk1 = fk1 - fk2;
                fk = fk2;
                fk2 = fk - fk1;
            } else if (key > a[mid]) {
                fk = fk1;
                fk1 = fk2;
                fk2 = fk - fk1;
                i = mid;
            } else return mid;
        }
        return -1;
    }
}
