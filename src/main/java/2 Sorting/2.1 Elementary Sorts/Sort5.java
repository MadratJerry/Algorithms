import edu.princeton.cs.algs4.StdOut;

public class Sort5 {

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int d = Integer.parseInt(args[3]);
        int e = Integer.parseInt(args[4]);

        if (a > b) { int t = a; a = b; b = t; }
        if (a > c) { int t = a; a = c; c = t; }
        if (b > c) { int t = b; b = c; c = t; }
        if (d > e) { int t = d; d = e; e = t; }
        if (a > d) { int t = a; a = d; d = t; }
        if (c > d) { int t = c; c = d; d = t; }
        if (b > e) { int t = b; b = e; e = t; }
        if (b > c) { int t = b; b = c; c = t; }
        if (d > e) { int t = d; d = e; e = t; }

        StdOut.printf("%d %d %d %d %d\n", a, b, c, d, e);
    }
}
