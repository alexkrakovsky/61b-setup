public class LinkedListDeque<Type> {
    private int size;
    private final Node sentinel;

    //Initialize an empty LLDeque
    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    //Return whether or not this LLDeque is empty
    public boolean isEmpty() {
        return this.size == 0;
    }

    //Return the size
    public int size() {
        return this.size;
    }

    //Add an item to the beginning of the LLD
    public void addFirst(Type item) {
        sentinel.next = new Node(item, sentinel, sentinel.next);
        if (size == 0) {
            sentinel.prev = sentinel.next;
        }
        size += 1;
    }

    //Add an item to the end of the LLD
    public void addLast(Type item) {
        sentinel.prev = new Node(item, sentinel.prev, sentinel);
        size += 1;
    }

    //Remove and return the first item of the LLD
    public Type removeFirst() {
        Type first = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return first;
    }

    //Remove and return the last item of the LLD
    public Type removeLast() {
        Type last = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return last;
    }

    //Obtain the item at a specified index of the LLD
    public Type get(int index) {
        if (index >= size) {
            return null;
        }
        Node A = sentinel;
        for (int i = 0; i < index; i += 1) {
            A = A.next;
        }
        return A.item;
    }

    //Print the items in this LLD
    public void printDeque() {
        Node A = sentinel;
        for (int i = 0; i < size; i++) {
            System.out.print(A.next.item + " ");
            A = A.next;
        }
    }

    //Recursively obtain the item at a specified index

    //Nested class Node
    public class Node {
        public Node prev;
        public Type item;
        public Node next;

        public Node(Type value, Node before, Node after) {
            item = value;
            next = after;
            prev = before;

        }
    }
}
