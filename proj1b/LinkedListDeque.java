public class LinkedListDeque<Type> implements Deque<Type> {
    private int size;
    private final Node sentinel;

    /** Initialize an empty LLDeque. */
    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /**Return whether or not this LLDeque is empty. */
    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    /** Returns the number of elements. */
    @Override
    public int size() {
        return this.size;
    }

    /** Adds an item to the beginning of the LLD. */
    @Override
    public void addFirst(Type item) {
        sentinel.next.prev = new Node(item, sentinel, sentinel.next);
        sentinel.next = sentinel.next.prev;
        size += 1;
    }

    /** Add an item to the end of the LLD. */
    @Override
    public void addLast(Type item) {
        sentinel.prev.next = new Node(item, sentinel.prev, sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }

    /** Remove and return the first item of the LLD. */
    @Override
    public Type removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Type first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return first;
    }

    /** Remove and return the last item of the LLD. */
    @Override
    public Type removeLast() {
        if (isEmpty()) {
            return null;
        }
        Type last = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return last;
    }

    /** Obtain the item at a specified index of the LLD. */
    @Override
    public Type get(int index) {
        if (index >= size) {
            return null;
        }
        Node A = sentinel;
        for (int i = 0; i <= index; i += 1) {
            A = A.next;
        }
        return A.item;
    }

    /** Recursively obtain the item at a specified index. */
    public Type getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        if (index == 0) {
            return sentinel.next.item;
        }
        Type B = removeFirst();
        Type C = getRecursive(index - 1);
        addFirst(B);
        return C;
    }

    /** Print the items in this LLD. */
    @Override
    public void printDeque() {
        Node A = sentinel;
        for (int i = 0; i < size; i++) {
            System.out.print(A.next.item + " ");
            A = A.next;
        }
    }

    /** Nested class Node. */
    public class Node {
        private Type item;
        private Node prev;
        private Node next;

        public Node(Type value, Node before, Node after) {
            item = value;
            prev = before;
            next = after;

        }
    }

}
