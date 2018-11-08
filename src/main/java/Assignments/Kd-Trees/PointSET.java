import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdDraw;

import java.util.ArrayList;
import java.util.List;

public class PointSET {
    private SET<Point2D> set;

    public PointSET() {
        set = new SET<>();
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public int size() {
        return set.size();
    }

    public void insert(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
        set.add(p);
    }

    public boolean contains(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
        return set.contains(p);
    }

    public void draw() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);

        for (Point2D point : set)
            StdDraw.point(point.x(), point.y());
    }

    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) throw new IllegalArgumentException();

        List<Point2D> result = new ArrayList<>();
        for (Point2D p : set) if (rect.contains(p)) result.add(p);

        return result;
    }

    public Point2D nearest(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
        if (isEmpty()) return null;

        double  min    = Double.MAX_VALUE;
        Point2D result = null;
        for (Point2D point : set) {
            double distance = p.distanceTo(point);
            if (distance < min) {
                min = distance;
                result = point;
            }
        }

        return result;
    }
}
