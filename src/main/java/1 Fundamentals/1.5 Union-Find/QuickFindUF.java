public class QuickFindUF implements IUF {
    private int[] parent;
    private int   count;

    public QuickFindUF(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    @Override
    public int count() { return count; }

    @Override
    public int find(int p) { return parent[p]; }

    @Override
    public boolean connected(int p, int q) { return parent[p] == parent[q]; }

    @Override
    public void union(int p, int q) {
        int pID = parent[p];
        int qID = parent[q];

        if (pID == qID) return;

        for (int i = 0; i < parent.length; i++)
            if (parent[i] == pID) parent[i] = qID;
        count--;
    }
}
