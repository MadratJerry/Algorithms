import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class BinarySearch {

    public static int indexOf(int[] a, int key) {
        int l = 0, r = a.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (a[mid] < key) r = mid - 1;
            else if (a[mid] > key) l = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        In    in        = new In(args[0]);
        int[] whiteList = in.readAllInts();

        Arrays.sort(whiteList);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (BinarySearch.indexOf(whiteList, key) == -1)
                StdOut.println(key);
        }
    }
}
