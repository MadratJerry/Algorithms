public class QuickUnionUF implements IUF {
    int[] parent;
    int   count;

    public QuickUnionUF(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    @Override
    public int count() { return count; }

    @Override
    public int find(int p) {
        while (p != parent[p]) p = parent[p];
        return p;
    }

    @Override
    public boolean connected(int p, int q) { return find(p) == find(q); }

    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }
}
