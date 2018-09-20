import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final int n;
    private final WeightedQuickUnionUF uf, full;
    private final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int openCount = 0;
    private boolean[][] grid;

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("n is expected to be greater than 0");
        this.n = n;
        grid = new boolean[n][n];
        uf = new WeightedQuickUnionUF(n * n + 2); // Add virtual-top and virtual-bottom
        full = new WeightedQuickUnionUF(n * n + 2); // Add virtual-top and virtual-bottom
        for (int i = 1; i <= n; i++) {
            uf.union(0, i);
            full.union(0, i);
            uf.union(n * n + 1 - i, n * n + 1);
        }
    }

    private boolean rangeCheck(int row, int col) {
        return row >= 1 && row <= n && col >= 1 && col <= n;
    }

    private void rangeCheckWithException(int row, int col) {
        if (!rangeCheck(row, col))
            throw new IllegalArgumentException("Row or col is outside its prescribed range");
    }

    private int getIndex(int row, int col) {
        return (row - 1) * n + col;
    }

    public void open(int row, int col) {
        rangeCheckWithException(row, col);
        int index = getIndex(row, col);
        if (!grid[row - 1][col - 1]) {
            openCount++;
            for (int[] d : dir) {
                int nRow = row + d[0];
                int nCol = col + d[1];
                if (rangeCheck(nRow, nCol) && isOpen(nRow, nCol)) {
                    uf.union(index, getIndex(nRow, nCol));
                    full.union(index, getIndex(nRow, nCol));
                }
            }
        }
        grid[row - 1][col - 1] = true;
    }

    public boolean isOpen(int row, int col) {
        rangeCheckWithException(row, col);
        return grid[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        rangeCheckWithException(row, col);
        return isOpen(row, col) && full.connected(0, getIndex(row, col));
    }

    public int numberOfOpenSites() {
        return openCount;
    }

    public boolean percolates() {
        return n > 1 ? uf.connected(0, n * n + 1) : isOpen(1, 1);
    }
}
