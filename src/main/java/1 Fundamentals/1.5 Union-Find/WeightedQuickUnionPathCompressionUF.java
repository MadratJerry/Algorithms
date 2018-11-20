public class WeightedQuickUnionPathCompressionUF extends WeightedQuickUnionUF {

    public WeightedQuickUnionPathCompressionUF(int n) { super(n); }

    @Override
    public int find(int p) {
        int root = super.find(p);
        while (p != root) {
            int newP = parent[p];
            parent[p] = root;
            p = newP;
        }
        return root;
    }
}
