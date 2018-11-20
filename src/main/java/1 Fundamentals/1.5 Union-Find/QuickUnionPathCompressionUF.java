public class QuickUnionPathCompressionUF extends QuickUnionUF {

    public QuickUnionPathCompressionUF(int n) { super(n); }

    @Override
    public int find(int p) {
        int root = p;
        while (root != parent[root]) root = parent[root];
        while (p != root) {
            int nextP = parent[p];
            parent[p] = root;
            p = nextP;
        }
        return root;
    }
}
