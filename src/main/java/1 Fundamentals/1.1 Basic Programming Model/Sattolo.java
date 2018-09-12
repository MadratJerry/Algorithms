import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Sattolo {
    public static void cycle(Object[] a) {
        for (int i = a.length; i > 1; i--) {
            int r = StdRandom.uniform(i - 1);
            Object temp = a[r];
            a[r] = a[i - 1];
            a[i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Sattolo.cycle(a);
        for (String s : a) StdOut.println(s);
    }
}
