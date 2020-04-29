public class OffByOne implements CharacterComparator {

    @Override
    /** Returns true if characters are "off by one." */
    public boolean equalChars(char x, char y) {
        int diff = Math.abs(x - y);
        if (diff == 1) {
            return true;
        }
        return false;
    }
}
