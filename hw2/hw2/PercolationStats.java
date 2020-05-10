package hw2;

import java.lang.IllegalArgumentException;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    private final int numTrials;
    private final double[] results;

    /* Create a new PercolationStats object. */
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        numTrials = T;
        results = new double[numTrials];
        for (int i = 0; i < T; i++) {
            Percolation p = pf.make(N);
            int opens = 0;
            while (!p.percolates()) {
                int a = StdRandom.uniform(N);
                int b = StdRandom.uniform(N);
                while (p.isOpen(a, b)) {
                    a = StdRandom.uniform(N);
                    b = StdRandom.uniform(N);
                }
                p.open(a, b);
                opens += 1;
            }
            results[i] = (double) opens / (N * N);
        }
    }

    /* Returns the mean of the T experiments. */
    public double mean() {
        return StdStats.mean(results);
    }

    /* Returns the standard deviation of the T experiments. */
    public double stddev() {
        return StdStats.stddev(results);
    }

    public double confidenceLow() {
        return mean() - (1.96 * stddev() / Math.sqrt(numTrials));
    }

    public double confidenceHigh() {
        return mean() + (1.96 * stddev() / Math.sqrt(numTrials));
    }

}
