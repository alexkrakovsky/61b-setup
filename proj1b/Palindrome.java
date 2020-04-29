public class Palindrome {
    /**
     * Return a deque of characters in the
     * order they appear in the given word.
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    /** Returns whether or not a given word is a palindrome. */
    public boolean isPalindrome(String word) {
        return isDequePalindrome(wordToDeque(word));
    }

    /** Helper method for isPalindrome.
     * Returns whether a deque is a "palindrome". */
    private boolean isDequePalindrome(Deque<Character> d) {
        if (d.size() <= 1) {
            return true;
        }
        if (!d.removeFirst().equals(d.removeLast())) {
            return false;
        }
        return isDequePalindrome(d);
    }

    /** Return true if the word is a palindrome
     * according to the character comparison test provided. */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        return generalDequePalindrome(wordToDeque(word), cc);
    }

    /** Helper for general isPalindrome method above. Returns whether
     * a given deque is a palindrome with respect to the
     * given character comparator. */
    private boolean generalDequePalindrome(Deque<Character> d, CharacterComparator cc) {
        if (d.size() <= 1) {
            return true;
        }
        if (!cc.equalChars(d.removeFirst(), d.removeLast())) {
            return false;
        }
        return generalDequePalindrome(d, cc);
    }
}

