import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

import java.util.TreeSet;

public class KdTree {
    private              Node    root;
    private              int     size;
    private static final boolean VERTICAL   = true;
    private static final boolean HORIZONTAL = false;
    private static final RectHV  originRect = new RectHV(0, 0, 1, 1);

    private static class Node {
        private Point2D p;
        private RectHV  rect;
        private Node    lb;
        private Node    rt;

        public Node(Point2D p, RectHV rect) {
            this.p = p;
            this.rect = rect;
        }
    }

    private void checkNull(Object obj) {
        if (obj == null) throw new IllegalArgumentException();
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {return size;}

    private int compare(Point2D o1, Point2D o2, boolean orientation) {
        return orientation == VERTICAL ?
               Double.compare(o1.x(), o2.x()) :
               Double.compare(o1.y(), o2.y());
    }

    public void insert(Point2D p) {
        checkNull(p);
        root = insert(root, p, originRect, VERTICAL);
    }

    private Node insert(Node node, Point2D p, RectHV rect, boolean orientation) {
        if (node == null) {
            size++;
            return new Node(p, rect);
        }

        if (node.p.equals(p)) return node;
        int cmp = compare(p, node.p, orientation);
        if (cmp < 0) node.lb = insert(node.lb, p,
                                      node.lb == null ? lbRect(node.rect, node, orientation) : node.rect, !orientation);
        else node.rt = insert(node.rt, p,
                              node.rt == null ? rtRect(node.rect, node, orientation) : node.rect, !orientation);

        return node;
    }

    public boolean contains(Point2D p) {
        checkNull(p);
        return contains(root, p, VERTICAL);
    }

    private boolean contains(Node node, Point2D p, boolean orientation) {
        if (node == null) return false;
        if (node.p.equals(p)) return true;

        int cmp = orientation == VERTICAL ?
                  Double.compare(p.x(), node.p.x()) :
                  Double.compare(p.y(), node.p.y());
        if (cmp < 0) return contains(node.lb, p, !orientation);
        else return contains(node.rt, p, !orientation);
    }

    public void draw() {
        StdDraw.setScale(0, 1);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius();

        originRect.draw();
        draw(root, VERTICAL);
    }

    private void draw(Node node, boolean orientation) {
        if (node == null) return;

        RectHV rect = node.rect;
        // draw splitting line
        StdDraw.setPenRadius();
        if (orientation == VERTICAL) {
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.line(node.p.x(), rect.ymin(), node.p.x(), rect.ymax());
        } else {
            StdDraw.setPenColor(StdDraw.BLUE);
            StdDraw.line(rect.xmin(), node.p.y(), rect.xmax(), node.p.y());
        }

        // draw point
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius(0.01);
        StdDraw.point(node.p.x(), node.p.y());

        draw(node.lb, !orientation);
        draw(node.rt, !orientation);
    }

    private RectHV lbRect(RectHV rect, Node node, boolean orientation) {
        return orientation == VERTICAL ?
               new RectHV(rect.xmin(), rect.ymin(), node.p.x(), rect.ymax()) :
               new RectHV(rect.xmin(), rect.ymin(), rect.xmax(), node.p.y());
    }

    private RectHV rtRect(RectHV rect, Node node, boolean orientation) {
        return orientation == VERTICAL ?
               new RectHV(node.p.x(), rect.ymin(), rect.xmax(), rect.ymax()) :
               new RectHV(rect.xmin(), node.p.y(), rect.xmax(), rect.ymax());
    }

    public Iterable<Point2D> range(RectHV rect) {
        checkNull(rect);

        final TreeSet<Point2D> rangeSet = new TreeSet<>();
        range(root, rect, rangeSet, VERTICAL);
        return rangeSet;
    }

    private void range(Node node, RectHV rect, TreeSet<Point2D> rangeSet, boolean orientation) {
        if (node == null) return;

        RectHV splitRect = node.rect;
        if (rect.intersects(splitRect)) {
            final Point2D p = node.p;
            if (rect.contains(p)) rangeSet.add(new Point2D(node.p.x(), node.p.y()));

            if (orientation == VERTICAL) {
                if (splitRect.xmax() >= p.x()) range(node.rt, rect, rangeSet, !orientation);
                if (splitRect.xmin() <= p.x()) range(node.lb, rect, rangeSet, !orientation);
            } else {
                if (splitRect.ymax() >= p.y()) range(node.rt, rect, rangeSet, !orientation);
                if (splitRect.ymin() <= p.y()) range(node.lb, rect, rangeSet, !orientation);
            }
        }
    }

    public Point2D nearest(Point2D p) {
        checkNull(p);
        if (isEmpty()) return null;

        return nearest(root, p, root.p, p.distanceSquaredTo(root.p), VERTICAL);
    }

    private Point2D nearest(Node node, Point2D p, Point2D minPoint, double minDistance, boolean orientation) {
        if (node == null) return minPoint;

        double distance = p.distanceSquaredTo(node.p);
        if (distance < minDistance) {
            minDistance = distance;
            minPoint = node.p;
        }

        int cmp = compare(p, node.p, orientation);
        if (cmp < 0) minPoint = nearest(node.lb, p, minPoint, minDistance, !orientation);
        else minPoint = nearest(node.rt, p, minPoint, minDistance, !orientation);

        minDistance = minPoint.distanceSquaredTo(p);

        if (cmp < 0) {
            if (node.rt != null && node.rt.rect.distanceSquaredTo(p) <= minDistance)
                minPoint = nearest(node.rt, p, minPoint, minDistance, !orientation);
        } else {
            if (node.lb != null && node.lb.rect.distanceSquaredTo(p) <= minDistance)
                minPoint = nearest(node.lb, p, minPoint, minDistance, !orientation);
        }

        return minPoint;
    }
}
