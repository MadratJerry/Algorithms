import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class Point implements Comparable<Point> {

    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int compareTo(Point that) {
        return this.y - that.y == 0 ? this.x - that.x : this.y - that.y;
    }

    public double slopeTo(Point that) {
        double dx = that.x - this.x;
        double dy = that.y - this.y;

        if (dx == 0 && dy == 0) {
            return Double.NEGATIVE_INFINITY;
        } else if (dx == 0) {
            return Double.POSITIVE_INFINITY;
        } else if (dy == 0) {
            return 0.0;
        }

        return dy / dx;
    }

    public Comparator<Point> slopeOrder() {
        return Comparator.comparingDouble(this::slopeTo);
    }

    public static void main(String[] args) {
        Point p = new Point(83, 138);
        Point q = new Point(471, 108);
        Point r = new Point(308, 53);
        StdOut.println(p.slopeOrder().compare(q, r));
        StdOut.println(p.slopeTo(q));
        StdOut.println(p.slopeTo(r));
    }
}
