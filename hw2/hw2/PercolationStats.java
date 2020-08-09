package hw2;

import edu.princeton.cs.introcs.StdStats;

import java.util.Random;

public class PercolationStats {
    private double mean;
    private double stddev;
    private double confidenceLow;
    private double confidenceHigh;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        Random rand = new Random();
        pf = new PercolationFactory();
        int[] numberNeedForPercolate = new int[T];
        for (int i = 0; i < T; i +=1) {
            Percolation grid = pf.make(N);
            for (int j = 0; j < N * N; j += 1) {
                int index = rand.nextInt(N * N);
                int row = index / N;
                int col = index % N;
                grid.open(row, col);
                if (grid.percolates()) {
                    numberNeedForPercolate[i] = j;
                    break;
                }
            }
        }
        mean = StdStats.mean(numberNeedForPercolate);
        stddev = StdStats.stddev(numberNeedForPercolate);
        confidenceLow = mean - 1.96 * stddev / Math.sqrt(T);
        confidenceHigh = mean + 1.96 * stddev / Math.sqrt(T);
    }

    public double mean() {
        return mean;
    }

    public double stddev() {
        return stddev;
    }

    public double confidenceLow() {
        return confidenceLow;
    }

    public double confidenceHight() {
        return confidenceHigh;
    }
}
