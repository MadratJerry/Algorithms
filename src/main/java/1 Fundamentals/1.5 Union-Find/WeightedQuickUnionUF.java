public class WeightedQuickUnionUF extends QuickUnionUF {
    private int[] size;

    public WeightedQuickUnionUF(int n) {
        super(n);
        size = new int[n];
        for (int i = 0; i < n; i++) size[i] = 1;
    }

    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--;
    }
}
