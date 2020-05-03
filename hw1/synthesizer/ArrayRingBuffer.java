package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    private T[] bufferArray;
    private int first;
    private int last;

    /** Constructs an ArrayRingBuffer object. */
    public ArrayRingBuffer(int x) {
        capacity = x;
        fillCount = 0;
        first = 0;
        last = 0;
        bufferArray = (T[]) new Object[capacity];
    }

    /** Returns the 'real' next highest index. */
    private int plusOne(int index) {
        if (index == capacity - 1) {
            return 0;
        }
        return index + 1;
    }

    @Override
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring Buffer Overflow");
        } else {
            bufferArray[last] = x;
            last = plusOne(last);
            fillCount += 1;
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        else {
            T item = bufferArray[first];
            bufferArray[first] = null;
            first = plusOne(first);
            fillCount -= 1;
            return item;
        }
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        else {
            return bufferArray[first];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayRingIterator();
    }

    private class ArrayRingIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < fillCount();
        }

        @Override
        public T next() {
            T returnItem = bufferArray[currentIndex];
            currentIndex += 1;
            return returnItem;
        }
    }
}
