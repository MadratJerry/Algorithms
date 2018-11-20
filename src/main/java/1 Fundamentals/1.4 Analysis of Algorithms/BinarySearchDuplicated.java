public class BinarySearchDuplicated {

    public static int indexOfMin(int[] a, int key) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (key <= a[mid]) r = mid;
            else if (key > a[mid]) l = mid + 1;
        }
        if (a[l] == key) return l;
        return -1;
    }

    public static int indexOfMax(int[] a, int key) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2 + 1;
            if (key < a[mid]) r = mid - 1;
            else if (key >= a[mid]) l = mid;
        }
        if (a[r] == key) return r;
        return -1;
    }
}
