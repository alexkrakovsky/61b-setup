public interface Deque<Item> {
    /** Adds item to the end of the deque. */
    void addLast(Item item);

    /** Adds item to the front of the deque. */
    void addFirst(Item item);

    /** Returns true if a deque is empty. */
    boolean isEmpty();

    /** Returns the size of the deque. */
    int size();

    /** Prints the contents of the deque. */
    void printDeque();

    /** Removes and returns the first element of the deque. */
    Item removeFirst();

    /** Removes and returns the last element of the deque. */
    Item removeLast();

    /** Returns the element at the specificed index. */
    Item get(int i);
}