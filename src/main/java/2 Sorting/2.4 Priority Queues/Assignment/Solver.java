import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
    private Node lastNode;

    public Solver(Board initial) {
        if (initial == null) throw new IllegalArgumentException();

        MinPQ<Node> nodes = new MinPQ<>();
        nodes.insert(new Node(initial));

        MinPQ<Node> twinNodes = new MinPQ<>();
        twinNodes.insert(new Node(initial.twin()));

        while (true) {
            lastNode = expand(nodes);
            if (lastNode != null || expand(twinNodes) != null) break;
        }
    }

    public static void main(String[] args) {
        // create initial board from file
        In      in     = new In(args[0]);
        int     n      = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }

    public boolean isSolvable() {
        return lastNode != null;
    }

    public int moves() {
        return isSolvable() ? lastNode.moves : -1;
    }

    public Iterable<Board> solution() {
        if (!isSolvable()) return null;

        Stack<Board> nodes = new Stack<>();
        for (Node node = lastNode; node != null; node = node.previous)
            nodes.push(node.board);

        return nodes;
    }

    private Node expand(MinPQ<Node> nodes) {
        if (nodes.isEmpty()) return null;
        Node bestNode = nodes.delMin();
        if (bestNode.board.isGoal()) return bestNode;
        for (Board neighbor : bestNode.board.neighbors()) {
            if (bestNode.previous == null || !neighbor.equals(bestNode.previous.board))
                nodes.insert(new Node(neighbor, bestNode));
        }
        return null;
    }

    private class Node implements Comparable<Node> {
        private Node  previous;
        private Board board;
        private int   moves    = 0;
        private int   priority = 0;

        public Node(Board board) {
            this.board = board;
        }

        public Node(Board board, Node previous) {
            this.board = board;
            this.previous = previous;
            this.moves = previous.moves + 1;
            this.priority = board.manhattan() + moves;
        }

        @Override
        public int compareTo(Node that) {
            return priority - that.priority;
        }
    }
}
