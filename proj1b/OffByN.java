public class OffByN implements CharacterComparator {
    private int n;

    /** Constructs an OffByN object with a given 'N'. */
    public OffByN(int N) {
        n = N;
    }

    /** Returns whether or not two characters are 'off by n'. */
    @Override
    public boolean equalChars(char a, char b) {
        int diff = Math.abs(a - b);
        if (diff == n) {
            return true;
        }
        return false;
    }
}
