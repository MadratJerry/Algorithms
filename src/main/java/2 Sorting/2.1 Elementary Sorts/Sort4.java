import edu.princeton.cs.algs4.StdOut;

public class Sort4 {

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int d = Integer.parseInt(args[3]);

        if (a > b) { int t = a; a = b; b = t; }
        if (c > d) { int t = c; c = d; d = t; }
        if (a > c) { int t = a; a = c; c = t; }
        if (b > d) { int t = b; b = d; d = t; }
        if (b > c) { int t = b; b = c; c = t; }

        StdOut.printf("%d %d %d %d\n", a, b, c, d);
    }
}
