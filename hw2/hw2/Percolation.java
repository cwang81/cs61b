package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int[][] grid;
    private int N;
    private int numOpenSites;
    WeightedQuickUnionUF uf;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, -1, 0, 1};

    public Percolation(int N) {
        this.N = N;
        grid = new int[N][N];
        uf = new WeightedQuickUnionUF(N * N + 1);
    }

    private void validate(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= N) {
            throw new IllegalArgumentException("Index not valid!!!");
        }
    }

    public void open(int row, int col) {
        validate(row, col);

        if (grid[row][col] == 0) {
            numOpenSites += 1;
            grid[row][col] = 1;
            int index = row * N + col;
            unionInGrid(index);
        }
    }

    private void unionInGrid(int index) {
        int row = index / N;
        int col = index % N;

        if (row == 0) {
            uf.union(index, N * N);
        }

        for (int i = 0; i < 4; i += 1) {
            int rowNeighbour = row + dx[i];
            int colNeighbour = col + dy[i];
            int indexNeighbour = rowNeighbour * N + colNeighbour;
            if (rowNeighbour >= 0 && rowNeighbour < N && colNeighbour >= 0 && colNeighbour < N) {
                if (grid[rowNeighbour][colNeighbour] == 1) {
                    uf.union(indexNeighbour, index);
                }
            }
        }
    }

    public boolean isOpen(int row, int col) {
        validate(row, col);

        return grid[row][col] == 1;
    }

    public boolean isFull(int row, int col) {
        validate(row, col);

        int index = row * N + col;
        return uf.connected(index, N * N);
    }

    public int numberOfOpenSites() {
        return numOpenSites;
    }

    public boolean percolates() {
        for (int i = 0; i < N; i += 1) {
            int index = (N - 1) * N + i;
            if (uf.connected(index, N * N)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {}
}
