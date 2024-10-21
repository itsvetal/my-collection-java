package collection;

import java.util.NoSuchElementException;

/**
 * Collection.MyQueue is the interface that defines methods for the queue.
 * This interface works on the
 * principe FIFO - first in first out.
 * The Class implementing
 * this interface must implement all the methods of collection.MyQueue
 *
 * @param <T> this parameter specifies the object type
 */
public interface MyQueue<T> {

    /**
     * Adds the item to the end of the queue. If the queue is filled,
     * throws IllegalStateException
     *
     * @param object object type T to add
     * @throws IllegalStateException if the queue is filled
     */
    void add(T object);

    /**
     * Returns the size of the queue
     *
     * @return int value
     */
    int size();

    /**
     * Looks at the first item in the queue. Method checks the queue and if it's
     * an empty returns null. Otherwise, returns the first element
     *
     * @return object type T or null if the queue is empty
     */
    T peek();

    /**
     * Looks at the first item in the queue. Method checks the queue and if it's
     * an empty throws NoSuchElementException. Otherwise, returns the first element
     *
     * @return object type T
     * @throws NoSuchElementException if the queue is empty
     */
    T element();

    /**
     * Removes and returns the first item in the queue. If the queue is empty,
     * throws NoSuchElementException
     *
     * @return object type T to remove
     * @throws NoSuchElementException if the queue is empty
     */
    T remove();

    /**
     * Removes and returns the first item in the queue. If the queue is empty,
     * returns null
     *
     * @return object type T to remove or null if the queue is empty
     */
    T poll();

    /**
     * Adds the item to the end of the queue. If the queue is filled,
     * returns false. Otherwise, returns true
     *
     * @param element object type T to add
     * @return boolean true if method was able to add item, otherwise, false
     */
    boolean offer(T element);

}
