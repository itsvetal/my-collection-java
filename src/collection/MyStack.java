package collection;

import java.util.EmptyStackException;

/**
 * collection.MyStack is the parametrized class represents data structure stack that works on the principe LIFO -
 * last in first out. That's why you can work only with the elements at the end of the stack. Class
 * collection.MyStack extends class collection.MyArrayList. The end of the list is called the top of the stack. It
 * contains methods that allow to see the item at the top of the stack, add new the item,
 * remove it and find the item index in the stack
 *
 * @param <T> this parameter specifies the object type
 */
public class MyStack<T> extends MyArrayList<T> {

    /**
     * Default constructor which calls the parent's constructor and creates an empty object of
     * the class collection.MyStack
     */
    public MyStack() {
        super();
    }

    /**
     * Method adds tne new item to the top of the stack. It uses the method add()
     * from the parent class for this
     *
     * @param element object type T to add
     */
    public void push(T element) {
        add(element);
    }

    /**
     * Removes an item from the top of the stack. First, the method checks the stack and if
     * it's empty throws EmptyStackException(). Otherwise, it removes the item and returns it
     * from the top of the stack by using the method remove() from parent class
     *
     * @return object type T to remove
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return remove(size() - 1);
    }

    /**
     * Looks at the item of the stack's top and returns it. Method do it by using the
     * method isEmpty() and getLast from parent class. If the stack is empty
     * returns null
     *
     * @return object type T. If the stack is empty returns null
     */
    public T peek() {
        return isEmpty() ? null : getLast();
    }

    /**
     * Checks the stack. Method do it by using the method isEmpty() from parent class.
     * If its empty returns true, otherwise, return false
     *
     * @return boolean
     */
    public boolean empty() {
        return isEmpty();
    }

    /**
     * Finds the index of the item in the stack. Method does this using the method indexOf() from
     * parent class. If it's found returns the index, otherwise, return 1
     *
     * @param element object type T from an arguments
     * @return int value with index if it's found else return 1
     */
    public int search(T element) {
        int index = indexOf(element);
        if (index != -1) {
            int lastIndex = size() - 1;
            return lastIndex - index;
        }
        return 1;
    }
}
