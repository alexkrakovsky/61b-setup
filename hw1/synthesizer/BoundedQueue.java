package synthesizer;
import java.util.Iterator;

public interface BoundedQueue<T> extends Iterable<T> {
    /** Return the size of the buffer. */
    int capacity();

    /** Return the number of items currently in the buffer. */
    int fillCount();

    /** Add item x to the end. */
    void enqueue(T x);

    /** Delete and return item from the front. */
    T dequeue();

    /** Return (do not delete) item at the front. */
    T peek();

    /** Is the buffer empty? */
    default boolean isEmpty() {
        return fillCount() == 0;
    }

    /** Is the buffer full? */
    default boolean isFull() {
        return fillCount() == capacity();
    }

    /** Returns an iterator over this bounded queue. */
    Iterator<T> iterator();
}
