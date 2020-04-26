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
            System.out.print(this.get(i) + " ");
        }
    }

    //Copy items to a larger/smaller underlying array
    private void resize(int capacity) {
        Type[] changed = (Type[]) new Object[capacity];
        if (plusOne(nextFirst) < minusOne(nextLast)) {
                System.arraycopy(items, plusOne(nextFirst), changed, capacity - size, size);
        }
        else {
            System.arraycopy(items, plusOne(nextFirst), changed, capacity - size, size - nextLast);
            System.arraycopy(items, 0, changed, capacity - nextLast, nextLast);
        }
        nextFirst = capacity - size - 1;
        items = changed;
        nextLast = 0;
    }

    //Adds item to the beginning of the list
    public void addFirst(Type item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[nextFirst] = item;
        size += 1;
        nextFirst = minusOne(nextFirst);
    }

    //Adds item to the end of the list
    public void addLast(Type item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
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

    //Returns and removes the first item in the list
    public Type removeFirst() {
        Type F = items[plusOne(nextFirst)];
        if (size == 0) {
            return null;
        }
        if (size < (items.length / 4) && items.length >= 16) {
            resize(items.length / 2);
        }
        size -= 1;
        items[plusOne(nextFirst)] = null;
        nextFirst = plusOne(nextFirst);
        return F;
    }

    //Returns and removes the last item in the list
    public Type removeLast() {
        Type L = items[minusOne(nextLast)];
        if (size == 0) {
            return null;
        }
        if (size < (items.length / 4) && items.length >= 16) {
            resize(items.length / 2);
        }
        size -= 1;
        items[minusOne(nextLast)] = null;
        nextLast = minusOne(nextLast);
        return L;
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

}