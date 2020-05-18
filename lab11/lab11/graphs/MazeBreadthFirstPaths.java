package lab11.graphs;

import java.util.Queue;
import java.util.LinkedList;

/**
 *  @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private Queue<Integer> fringe;
    private Maze maze;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = m.xyTo1D(sourceX, sourceY);
        t = m.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
        fringe = new LinkedList<>();
    }

    /** Conducts a breadth first search of the maze starting at the source. */
    private void bfs() {
        fringe.add(s);
        marked[s] = true;
        announce();
        if (s == t) {
            return;
        }
        while (!fringe.isEmpty()) {
            int c = fringe.remove();
            for (int n : maze.adj(c)) {
                if (!marked[n]) {
                    edgeTo[n] = c;
                    distTo[n] = distTo[c] + 1;
                    marked[n] = true;
                    announce();
                    if (n == t) {
                        return;
                    }
                    fringe.add(n);
                }
            }
        }
    }


    @Override
    public void solve() {
        bfs();
    }
}

