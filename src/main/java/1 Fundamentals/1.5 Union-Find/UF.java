public class UF extends WeightedQuickUnionByHeightUF {
    private byte[] rank;

    public UF(int n) {
        super(n);
        rank = new byte[n];
    }

    @Override
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}
