import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class PerfectBalance {

    public static void perfect(BST bst, String[] array) {
        Arrays.sort(array);
        perfect(bst, array, 0, array.length - 1);
    }

    public static void perfect(BST bst, String[] array, int l, int r) {
        if (r < l) return;
        int mid = l + (r - l) / 2;
        bst.put(array[mid], mid);
        StdOut.printf("%s ", array[mid]);
        perfect(bst, array, l, mid - 1);
        perfect(bst, array, mid + 1, r);
    }

    public static void main(String... args) {
        String[]             words = StdIn.readAllStrings();
        BST<String, Integer> bst   = new BST<>();
        PerfectBalance.perfect(bst, words);
    }
}
