public interface IUF {

    int count();

    int find(int p);

    boolean connected(int p, int q);

    void union(int p, int q);
}
