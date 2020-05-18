package lab11.graphs;

import edu.princeton.cs.algs4.Stack;

/**
 *  @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private Stack<Integer> fringe;
    private Maze maze;

    public MazeCycles(Maze m) {
        super(m);
        maze = m;
        fringe = new Stack<>();
    }

    @Override
    public void solve() {
        cycleDetector();
    }

    private void cycleDetector() {
        fringe.push(0);

        while (!fringe.isEmpty()) {
            int v = fringe.pop();
            marked[v] = true;
            announce();
            for (int n : maze.adj(v)) {
                if (!marked[n]) {
                    fringe.push(n);
                } else if (checkFringe(fringe, n)) {


                }

            }
        }
    }

        private boolean checkFringe (Stack < Integer > fringe,int x){
            Stack<Integer> holding = new Stack<>();
            while (!fringe.isEmpty()) {
                int v = fringe.pop();
                holding.push(v);
                if (v == x) {
                    while (!holding.isEmpty()) {
                        fringe.push(holding.pop());
                    }
                    return true;
                }
            }
            while (!holding.isEmpty()) {
                fringe.push(holding.pop());
            }
            return false;
        }
    }





