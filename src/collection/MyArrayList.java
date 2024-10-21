package collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * collection.MyArrayList is the parametrized class represents an array which can change dynamically.
 * Its contains two constructors: default and with one parameter of capacity. There are several methods
 * by which you can add an object to the collection.MyArrayList, edit, remove, and get using index. You can set the capacity
 * of collection.MyArrayList, find index of an object, check if the list contains an object, clear list
 * and return it as an Object[] array
 * <p>
 * If you want to create collection.MyArrayList with primitive types (int, double, char...) you must use
 * class wrappers such as Integer, Double, Character etc.
 * <p>
 * collection.MyArrayList implements interface Iterable and this allows you to use cycle for-each for iteration between
 * the objects in the list
 *
 * @param <T> this parameter specifies the object type
 */
public class MyArrayList<T> implements Iterable<T> {

    /**
     * Data array with objects of collection.MyArrayList
     */
    private Object[] dataArray;

    /**
     * Default value for length of the dataArray if
     * are using the basic constructor
     */
    private int DEFAULT_CAPACITY = 10;

    /**
     * The size of the collection.MyArrayList
     */
    private int size;

    /**
     * Default constructor that creates object of the class collection.MyArrayList.
     * If this constructor is used, a new dataArray is created with length
     * DEFAULT_CAPACITY
     */
    public MyArrayList() {
        //Initialize the fields of the class
        dataArray = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Constructor with one argument, which set capacity
     * for object collection.MyArrayList
     *
     * @param capacity is the value of int with new capacity
     * @throws IllegalArgumentException if capacity is negative number
     */
    public MyArrayList(int capacity) throws IllegalArgumentException {
        if (capacity < 0) {
            throw new IllegalArgumentException("Wrong capacity:" + capacity);
        }
        //Initialize the fields of the class
        dataArray = new Object[capacity];
        size = 0;
    }

    /**
     * Change the cell of collection.MyArrayList in the position "index" to the object which coming
     * in the arguments "T element"
     * <p>
     * If index out of bounds throws new IndexOutOfBoundsException
     *
     * @param index   int value is the position of the object to be changed
     * @param element object type T for change
     * @throws IndexOutOfBoundsException if index is out of bounds for list size
     */
    public void set(int index, T element) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        dataArray[index] = element;
    }

    /**
     * Check the capacity of the list, add the element to the
     * end of the list and resize its
     *
     * @param element is the object type T
     */
    public void add(T element) {
        dataArray[size] = element;
        size++;
        checkForResize();
    }

    /**
     * Check the bounds of "int index" and capacity
     * If index == size of the list, add the element to the end.
     * If index out of bounds throws new IndexOutOfBoundsException
     * <p>
     * Add the element in the position "index". Method do it using function
     * System.arraycopy. There is a shift of elements to the right and puts "T element"
     * in the position with index "index"
     *
     * @param index   int value with position for a new element
     * @param element is the object type T
     * @throws IndexOutOfBoundsException if index is out of bounds for list size
     */
    public void add(int index, T element) throws IndexOutOfBoundsException {
        if (index == size) {
            add(element);
        } else if (index < size && index >= 0) {
            Object[] modifiedArray = new Object[size - index];
            System.arraycopy(dataArray, index, modifiedArray, 0, size - index);
            System.arraycopy(modifiedArray, 0, dataArray, index + 1, modifiedArray.length);
            dataArray[index] = element;
            size++;
            checkForResize();
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
    }

    /**
     * Check the size of the list. If size == length of dataArray, we
     * increase the capacity by one and a half times, plus one
     */
    private void checkForResize() {
        if (size >= dataArray.length) {
            int newCapacity = (int) (DEFAULT_CAPACITY * 1.5 + 1);
            DEFAULT_CAPACITY = newCapacity;
            //Set new capacity
            ensureCapacity(newCapacity);
        }
    }

    /**
     * Change the capacity of the list on the value "newCapacity".
     * Method do it by using function System.arraycopy
     *
     * @param newCapacity is the int value for resizing
     */
    public void ensureCapacity(int newCapacity) {
        if (newCapacity >= size) {
            Object[] resizedArrayList = new Object[newCapacity];
            System.arraycopy(dataArray, 0, resizedArrayList, 0, size);
            dataArray = resizedArrayList;
        }
    }

    /**
     * Decrease the length of the dataArray to size of collection.MyArrayList capacity
     */
    public void trimToSize() {
        ensureCapacity(size);
    }

    /**
     * Methode get the size of the collection.MyArrayList
     *
     * @return int value with size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Return the element in position "index"
     * <p>
     * If index out of bounds throws new IndexOutOfBoundsException
     *
     * @param index is the position of the element
     * @return object type T
     * @throws IndexOutOfBoundsException if index is out of bounds for list size
     */
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        return (T) dataArray[index];
    }

    /**
     * Return the first element of the list
     *
     * @return object of type T
     * @throws NoSuchElementException if a list is empty
     */
    public T getFirst() {
        if (size == 0) {
            throw new NoSuchElementException("The size is 0");
        }
        return (T) dataArray[0];
    }

    /**
     * Return the last element of the list
     *
     * @return object of type T
     * @throws NoSuchElementException if a list is empty
     */
    public T getLast() {
        if (size == 0) {
            throw new NoSuchElementException("The size is 0");
        }
        return (T) dataArray[size - 1];
    }

    /**
     * Find the object in the list. If the object is found, return
     * its index, else return -1
     *
     * @param element is the object of type T
     * @return int value with index or -1
     */
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (dataArray[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Check if the list contains the argument and return
     * true or false
     *
     * @param element object of type T, which need to find
     * @return boolean
     */
    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (dataArray[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Delete all elements from the list. Change to null all items
     * of the list for this and set the value of the size to 0
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            dataArray[i] = null;
        }
        size = 0;
    }

    /**
     * Remove the element in the position "index". Move to the left all elements, that
     * are to the right of the "index" position. Use the function System.arraycopy for this
     * <p>
     * If index out of bounds throws new IndexOutOfBoundsException
     *
     * @param index int value with index of the position
     * @return object of type T to be removed
     * @throws IndexOutOfBoundsException if index is out of bounds for list size
     */
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        Object objectForRemove = dataArray[index];
        Object[] modifiedArray = new Object[size - index];
        System.arraycopy(dataArray, index + 1, modifiedArray, 0, modifiedArray.length);
        System.arraycopy(modifiedArray, 0, dataArray, index, modifiedArray.length);
        dataArray[size - 1] = null;
        size--;
        return (T) objectForRemove;
    }

    /**
     * Remove from the list T element. Iterate through the list, find the object,
     * remove it and return true if it's found. If the element is not found, return false
     *
     * @param element object of type T
     * @return boolean
     */
    public boolean remove(T element) {
        for (int i = 0; i < size; i++) {
            if (dataArray[i].equals(element)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Check if there are elements in the list. If the list is empty
     * return true, otherwise return false
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return an array with objects of the type T.
     * First call the method trimToSize() and then return an array
     * with elements of collection.MyArrayList
     *
     * @return an array with objects of the type T
     */
    public T[] toArray() {
        trimToSize();
        return (T[]) dataArray;
    }

    /**
     * Return all the elements of the list as the String
     *
     * @return object of the class String
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < size; i++) {
            string.append(dataArray[i]).append(", ");
        }
        return "[" + string.substring(0, string.length() - 2) + "]";
    }

    /**
     * This method return new object of the iterator. It's allowing to use the
     * cycle for-each for elements of collection.MyArrayList and to use methods hasNext() and
     * next() for iteration through the list
     *
     * @return object of the Iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            /**
             * The current index for elements
             */
            private int currentIndex = -1;

            /**
             * Checks if the next element is in the list and returns boolean
             * true or false
             * @return boolean
             */
            @Override
            public boolean hasNext() {
                return currentIndex + 1 < size;
            }

            /**
             * Return next element in the list
             *
             * @return next object of the type T
             * @throws NoSuchElementException If there are no elements next
             */
            @Override
            public T next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException("There is no elements next");
                }
                return (T) dataArray[++currentIndex];
            }
        };
    }
}
