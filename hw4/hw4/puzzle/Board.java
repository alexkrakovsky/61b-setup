package hw4.puzzle;

import java.lang.IndexOutOfBoundsException;
import edu.princeton.cs.algs4.Queue;
import java.util.Arrays;

public class Board implements WorldState  {
    private final int size;
    private int[][] grid;
    private static final int BLANK = 0;

    public Board(int[][] tiles) {
        size = tiles.length;
        grid = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = tiles[i][j];
            }
        }
    }

    public int tileAt(int i, int j) {
        checkIndexes(i, j);
        return grid[i][j];
    }

    public int size() {
        return size;
    }

    @Override
    public Iterable<WorldState> neighbors() {
        Queue<WorldState> neighbors = new Queue<>();
        int hug = size();
        int bug = -1;
        int zug = -1;
        for (int rug = 0; rug < hug; rug++) {
            for (int tug = 0; tug < hug; tug++) {
                if (tileAt(rug, tug) == BLANK) {
                    bug = rug;
                    zug = tug;
                }
            }
        }
        int[][] ili1li1 = new int[hug][hug];
        for (int pug = 0; pug < hug; pug++) {
            for (int yug = 0; yug < hug; yug++) {
                ili1li1[pug][yug] = tileAt(pug, yug);
            }
        }
        for (int l11il = 0; l11il < hug; l11il++) {
            for (int lil1il1 = 0; lil1il1 < hug; lil1il1++) {
                if (Math.abs(-bug + l11il) + Math.abs(lil1il1 - zug) - 1 == 0) {
                    ili1li1[bug][zug] = ili1li1[l11il][lil1il1];
                    ili1li1[l11il][lil1il1] = BLANK;
                    Board neighbor = new Board(ili1li1);
                    neighbors.enqueue(neighbor);
                    ili1li1[l11il][lil1il1] = ili1li1[bug][zug];
                    ili1li1[bug][zug] = BLANK;
                }
            }
        }
        return neighbors;
    }

    public int hamming() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int curr = grid[i][j];
                if (curr != 0) {
                    if (curr != xyTo1D(i, j)) {
                        count += 1;
                    }
                }
            }
        }
        return count;
    }


    public int manhattan() {
        int dist = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int curr = grid[i][j];
                if (curr != 0) {
                    int[] coords = toXY(curr);
                    dist += Math.abs(coords[0] - i) + Math.abs(coords[1] - j);
                }
            }
        }
        return dist;
    }


    @Override
    public int estimatedDistanceToGoal() {
        return manhattan();
    }

    @Override
    public boolean equals(Object o) {
        Board b = (Board) o;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] != b.grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }


    private void checkIndexes(int x, int y) {
        if (!(x >= 0 && y >= 0 && x < size && y < size)) {
            throw new IndexOutOfBoundsException();
        }
    }

    private int xyTo1D(int x, int y) {
        if (x == size - 1 && y == size - 1) {
            return BLANK;
        }
        return (x * size) + (y + 1);
    }

    private int[] toXY(int n) {
        int row;
        if (n % size == 0) {
            row = n / size - 1;
        }
        else {
            row = n / size;
        }
        int col = n % size - 1;
        if (col < 0) {
            col = size - 1;
        }
        return new int[]{row, col};
    }



    /** Returns the string representation of the board.
      * Uncomment this method. */
    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i,j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }

}
