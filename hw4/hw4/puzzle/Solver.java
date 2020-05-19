package hw4.puzzle;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;

public class Solver {

    private static class SearchNode implements Comparable<SearchNode> {
        WorldState ws;
        int toGoal;
        int moves;
        SearchNode prev;

        public SearchNode(WorldState w, int m, SearchNode p) {
            ws = w;
            toGoal = w.estimatedDistanceToGoal();
            moves = m;
            prev = p;
        }

        @Override
        public int compareTo(SearchNode s) {
            int x = toGoal + moves;
            int y = s.toGoal + s.moves;
            return x - y;
        }
    }

    private Stack<WorldState> solution = new Stack<>();
    private MinPQ<SearchNode> pq = new MinPQ<>();

    public Solver(WorldState initial) {
        SearchNode start = new SearchNode(initial,0, null);
        while(!start.ws.isGoal()) {
            for (WorldState w : start.ws.neighbors()) {
                if (start.prev == null || !w.equals(start.prev.ws)) {
                    pq.insert(new SearchNode(w, start.moves + 1, start));
                }
            }
            start = pq.delMin();
        }

        while (start != null) {
            solution.push(start.ws);
            start = start.prev;
        }
    }

    public int moves() {
        return solution.size() - 1;
    }

    public Iterable<WorldState> solution() {
        return solution;
    }
}
