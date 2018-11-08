import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final int      t;
    private final double[] xn;
    private       double   mean;
    private       double   stddev;
    private       double   confidenceLo;
    private       double   confidenceHi;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException("n or trials is expected to be grater than 0.");
        t = trials;
        xn = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);
            for (int j = 0; j < n * n && !p.percolates(); j++) {
                int index, row, col;
                do {
                    index = StdRandom.uniform(0, n * n);
                    row = index / n + 1;
                    col = index % n + 1;
                } while (p.isOpen(row, col));
                p.open(row, col);
            }
            xn[i] = (double) p.numberOfOpenSites() / (n * n);
        }
    }

    public double mean() {
        if (mean > 0) {
            return mean;
        } else {
            mean = StdStats.mean(xn);
            return mean;
        }
    }

    public double stddev() {
        if (stddev > 0) {
            return stddev;
        } else {
            stddev = StdStats.stddev(xn);
            return stddev;
        }
    }

    public double confidenceLo() {
        if (confidenceLo > 0) {
            return confidenceLo;
        } else {
            confidenceLo = mean() - (1.96 * stddev() / Math.sqrt(t));
            return confidenceLo;
        }
    }

    public double confidenceHi() {
        if (confidenceHi > 0) {
            return confidenceHi;
        } else {
            confidenceHi = mean() + (1.96 * stddev() / Math.sqrt(t));
            return confidenceHi;
        }
    }

    public static void main(String[] args) {
        PercolationStats p = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        StdOut.printf("%-23s = %s\n", "mean", p.mean());
        StdOut.printf("%-23s = %s\n", "stddev", p.stddev());
        StdOut.printf("%-23s = [%s, %s]\n", "95% confidence interval", p.confidenceLo(), p.confidenceHi());
    }
}
