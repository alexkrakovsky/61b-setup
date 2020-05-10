package hw2;

import java.lang.IllegalArgumentException;
import java.lang.IndexOutOfBoundsException;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private final String[][] grid;
    private int numOpen;
    private final int sideLength;
    private final WeightedQuickUnionUF wqu;
    private final int source;
    private final int bottom;

    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        wqu = new WeightedQuickUnionUF(N * N + 2);
        source = N * N;
        bottom = N * N + 1;
        numOpen = 0;
        grid = new String[N][N];
        sideLength = N;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = "Closed";
            }
        }
    }

    /* Throws an exception if illegal arguments
    are given. */
    private void checkArgs(int x, int y) {
        if ((x < 0 || y < 0) || (x >= sideLength || y >= sideLength)) {
            throw new IndexOutOfBoundsException();
        }
    }

    /* Returns an integer representation of a
    given location. */
    private int xyTo1D(int row, int col) {
        return sideLength * row + col;
    }

    /* Returns an array of the coordinate sets
    touching the given site location. */
    private int[][] touching(int r, int c) {
        return new int[][]{{r - 1, c}, {r + 1, c}, {r, c + 1}, {r, c - 1}};
    }

    /* Returns the number of open sites. */
    public int numberOfOpenSites() {
        return numOpen;
    }

    /* Returns true if a given site is open.
     * False otherwise. */
    public boolean isOpen(int row, int col) {
        checkArgs(row, col);
        return (grid[row][col].equals("Open"));
    }

    /* Opens a given site. */
    public void open(int row, int col) {
        checkArgs(row, col);
        if (!isOpen(row, col)) {
            grid[row][col] = "Open";
            numOpen += 1;
            int k = xyTo1D(row, col);
            for (int[] xy : touching(row, col)) {
                try {
                    if (isOpen(xy[0], xy[1])) {
                        wqu.union(k, xyTo1D(xy[0], xy[1]));
                    }
                } catch (Exception ignored) {
                }
            }
            if (row == 0) {
                wqu.union(k, source);
            }
            if (row == sideLength - 1) {
                wqu.union(k, bottom);
            }
        }
    }

    /* Returns whether a given site is full. */
    public boolean isFull(int row, int col) {
        checkArgs(row, col);
        int k = xyTo1D(row, col);
        return wqu.connected(k, source);
    }

    /* Returns whether this percolation object
    successfully percolates. i.e. source and bottom
    are connected. */
    public boolean percolates() {
        return wqu.connected(bottom, source);
    }
}

