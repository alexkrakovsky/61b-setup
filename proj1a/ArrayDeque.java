@SuppressWarnings("unchecked")
public class ArrayDeque<Type> {
    //Instance variables for the class
    private int size;
    private Type[] items;
    private int nextFirst;
    private int nextLast;


    //Constructs an empty array deque
    public ArrayDeque() {
        size = 0;
        items = (Type[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
    }

    //Returns whether or not an AList is empty
    public boolean isEmpty() {
        return this.size == 0;
    }

    //Returns the size of an AList
    public int size() {
        return this.size;
    }

    //Prints the contents of an AList
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[trueIndex(i)] + " ");
        }
    }

    //Company items to a larger underlying array
    public void resize(int r) {

    }


    //Adds item to the beginning of the list
    public void addFirst(Type item) {
        items[nextFirst] = item;
        size += 1;
        nextFirst = minusOne(nextFirst);
    }

    //Adds item to the end of the list
    public void addLast(Type item) {
        items[nextLast] = item;
        size += 1;
        nextLast = plusOne(nextLast);
    }

    //Returns the index just after the input
    public int plusOne(int index) {
        if (index == items.length - 1) {
            return 0;
        }
        return index + 1;
    }

    //Returns the index just before the input
    public int minusOne(int index) {
        if (index == 0) {
            return items.length - 1;
        }
        return index - 1;
    }

    //Returns and removes the first item in the ist
    public Type removeFirst() {

    }

    //Returns the true array-adjusted index
    public int trueIndex(int index) {
        int x = nextFirst + 1 + index;
        if (x > items.length - 1) {
            int d = x - items.length;
            return d;
        }
        return x;
    }

    //Returns the ith item in the list
    public Type get(int index) {
        if (index >= size) {
            return null;
        }
        return items[trueIndex(index)];
    }
    /*public static void main(String[] args) {
        ArrayDeque<Integer> A = new ArrayDeque<>();
        A.addFirst(2);
        A.addFirst(3);
        A.addFirst(4);
        A.addLast(5);
        A.addLast(6);
        A.addLast(7);
        A.printDeque();
    }*/


}