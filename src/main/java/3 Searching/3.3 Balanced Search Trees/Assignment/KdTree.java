import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.StdDraw;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class KdTree {
    private              Node    root;
    private              int     size;
    private static final boolean VERTICAL   = true;
    private static final boolean HORIZONTAL = false;

    private static class Node {
        private Point2D p;
        private RectHV  rect;
        private Node    lb;
        private Node    rt;

        public Node(Point2D p) {
            this.p = p;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {return size;}

    public void insert(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
        root = insert(root, p, true);
    }

    private Node insert(Node node, Point2D p, boolean orientation) {
        if (node == null) {
            size++;
            return new Node(p);
        }

        if (node.p.equals(p)) return node;

        if (orientation == VERTICAL && p.x() < node.p.x() ||
            orientation == HORIZONTAL && p.y() < node.p.y()) {
            node.lb = insert(node.lb, p, !orientation);
        } else {
            node.rt = insert(node.rt, p, !orientation);
        }

        return node;
    }

    public boolean contains(Point2D p) {
        if (p == null) return false;
        return contains(root, p, VERTICAL);
    }

    private boolean contains(Node node, Point2D p, boolean orientation) {
        if (node == null) return false;
        int cmp = orientation == VERTICAL ? Double.compare(p.x(), node.p.x()) :
                  Double.compare(p.y(), node.p.y());
        if (cmp < 0) return contains(node.lb, p, !orientation);
        else if (cmp > 0) return contains(node.rt, p, !orientation);
        else return true;
    }

    public void draw() {
        StdDraw.setScale(0, 1);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setPenRadius();

        RectHV rect = new RectHV(0, 0, 1, 1);
        rect.draw();
        draw(root, rect, VERTICAL);
    }

    private void draw(Node node, RectHV rect, boolean orientation) {
        if (node == null) return;

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

        draw(node.lb, lbRect(rect, node, orientation), !orientation);
        draw(node.rt, rtRect(rect, node, orientation), !orientation);
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
        if (rect == null) throw new IllegalArgumentException();

        final TreeSet<Point2D> rangeSet = new TreeSet<>();
        range(root, new RectHV(0, 0, 1, 1), rect, rangeSet, VERTICAL);
        return rangeSet;
    }

    private void range(Node node, RectHV splitRect, RectHV rect, TreeSet<Point2D> rangeSet, boolean orientation) {
        if (node == null) return;

        if (rect.intersects(splitRect)) {
            final Point2D p = new Point2D(node.p.x(), node.p.y());
            if (rect.contains(p)) rangeSet.add(p);

            if (orientation == VERTICAL) {
                if (splitRect.xmax() < p.x())
                    range(node.lb, lbRect(splitRect, node, orientation), rect, rangeSet, orientation);
                if (splitRect.xmax() > p.x())
                    range(node.rt, rtRect(splitRect, node, orientation), rect, rangeSet, orientation);
                if (splitRect.contains(p)) {
                    range(node.lb, lbRect(splitRect, node, orientation), rect, rangeSet, orientation);
                    range(node.rt, rtRect(splitRect, node, orientation), rect, rangeSet, orientation);
                }
            } else {
                if (splitRect.ymax() < p.y())
                    range(node.lb, lbRect(splitRect, node, orientation), rect, rangeSet, orientation);
                if (splitRect.ymax() > p.y())
                    range(node.rt, rtRect(splitRect, node, orientation), rect, rangeSet, orientation);
                if (splitRect.contains(p)) {
                    range(node.lb, lbRect(splitRect, node, orientation), rect, rangeSet, orientation);
                    range(node.rt, rtRect(splitRect, node, orientation), rect, rangeSet, orientation);
                }
            }
        }
    }

    public Point2D nearest(Point2D p) {
        if (p == null) throw new IllegalArgumentException();
        if (isEmpty()) return null;


        Point2D     result = null;
        double      min    = Double.MAX_VALUE;
        Queue<Node> queue  = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node   node     = queue.remove();
            double distance = p.distanceSquaredTo(node.p);
            if (distance < min) {
                result = node.p;
                min = distance;
            }
            if (node.lb != null && node.lb.p.distanceSquaredTo(p) < min)
                queue.offer(node.lb);
            if (node.rt != null && node.rt.p.distanceSquaredTo(p) < min)
                queue.offer(node.rt);
        }
        return result;
    }
}
