package collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * collection.MyLinkedList is the parametrized class represents two-linked list. All the elements are
 * the objects of the class Node. Elements have no indexes here. Elements reference the previous
 * element and the next element. That's why if we need to remove or to add an element, we change the
 * links between the elements.
 * <p>
 * collection.MyLinkedList has many methods to work with its elements. It works especially effectively with
 * first and last its elements. That's why it is very good work with Stack and Queue, and as it is
 * the two-linked list, it may be used by Deque
 * <p>
 * If you want, create collection.MyArrayList with primitive types (int, double, char...) you must use
 * class wrappers such as Integer, Double, Character etc.
 * <p>
 * collection.MyArrayList implements interface Iterable and this allows you to use cycle for-each for iteration between
 * the objects in the list
 *
 * @param <T> this parameter specifies the object type
 */
public class MyLinkedList<T> implements Iterable<T>, MyQueue<T> {

    /**
     * Object of the class Node, that points to the first element of the list
     */
    private final Node<T> first;

    /**
     * Object of the class Node, that points to the last element of the list
     */
    private final Node<T> last;

    /**
     * The size of the list
     */
    private int size;

    /**
     * Default constructor creates an object of the collection.MyLinkedList and initializes the
     * class fields, that specify the beginning and to the end of the list and sets the
     * size of the list to 0
     */
    public MyLinkedList() {
        //Initialize the fields of the class
        first = new Node<>(null);
        last = new Node<>(null);
        first.setNext(last);
        last.setPrev(first);
        size = 0;
    }

    /**
     * Add an element to the end of the list.
     * Method creates a new object of the class Node and puts in it the
     * element which comes as argument. Then we change the links in the last
     * objects and add a new Node to the end of the list
     *
     * @param element object of the type T
     */
    public void add(T element) {
        Node<T> node = new Node<>(element);
        node.setPrev(last.getPrev());
        last.getPrev().setNext(node);
        node.setNext(last);
        last.setPrev(node);
        size++;
    }

    /**
     * Add the element in the position "index".
     * If the index indicates the beginning or the end of the list,
     * we run the method addFirst() or add(). Otherwise, we run method findNode(),
     * which returns the Node from position "index". Then creates a new Node, sets
     * links between neighbors and increases the size of the list
     *
     * @param index   int value with position of a new object
     * @param element the object of type T
     * @throws IndexOutOfBoundsException if index is out of bounds for list size
     */
    public void add(int index, T element) throws IndexOutOfBoundsException {
        if (firstElement(index)) {
            addFirst(element);
        } else if (index == size) {
            add(element);
        } else if (indexInBounds(index)) {
            Node<T> currentNode = findNode(index);
            Node<T> node = new Node<>(element);
            //Check the node
            assert currentNode != null : "Node is null";
            currentNode.getPrev().setNext(node);
            node.setPrev(currentNode.getPrev());
            node.setNext(currentNode);
            currentNode.setPrev(node);
            size++;

        } else {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
    }

    /**
     * Add the element to the beginning of the list.
     * We create a new Node with an element from the arguments, set
     * its links and change the links in the head of the list.
     * Then increase the size of the list
     *
     * @param element the object of the type T to add
     */
    public void addFirst(T element) {
        Node<T> node = new Node<>(element);
        node.setNext(first.getNext());
        node.setPrev(first);
        first.getNext().setPrev(node);
        first.setNext(node);
        size++;
    }

    /**
     * Adds the element to the end of the list. Method runs add() for this
     *
     * @param element the object of the type T to add
     */
    public void addLast(T element) {
        add(element);
    }

    /**
     * Method find and return object of Node by index.
     * It starts the cycle for to find the element with "index" position
     *
     * @param index int value with position
     * @return found object Node
     */
    private Node<T> findNode(int index) {
        Node<T> currentNode = first.getNext();
        // Variable for counting of the elements
        int count = 0;
        while (currentNode != last) {
            if (count == index) {
                return currentNode;
            }
            count++;
            currentNode = currentNode.getNext();
        }
        return null;
    }

    /**
     * Get an element from position specified in the arguments.
     * If the index indicates the beginning or the end of the list,
     * we run method getFirst() or getLast(). Otherwise, we run the method
     * findNode(), which returns the Node from position and then returns its
     * element
     *
     * @param index int value with position of the object
     * @return object of the type T
     * @throws IndexOutOfBoundsException if index is out of bounds for list size
     */
    public T get(int index) throws IndexOutOfBoundsException {
        if (firstElement(index)) {
            getFirst();
        }
        if (lastElement(index)) {
            getLast();
        }
        if (indexInBounds(index)) {
            Node<T> node = findNode(index);
            //Check the node
            assert node != null : "Node is null" ;
            return node.getValue();
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
    }

    /**
     * Checks if a list is empty and returns the first element from the list
     *
     * @return the object of the type T
     */
    public T getFirst() {
        checkEmptyException();
        return  first.getNext().getValue();
    }

    /**
     * Checks if a list is empty and returns the last element from the list
     *
     * @return the object of the type T
     */
    public T getLast() {
        checkEmptyException();
        return  last.getPrev().getValue();
    }

    /**
     * Method changes the object in position "index" to the object in the arguments.
     * If the index indicates the beginning or the end of the list, we change the
     * element of the first or last Node to the element specified in arguments.
     * Otherwise, run the method findNode(), that return Node from position "index"
     * and change its element. Then decrease the size of the list
     *
     * @param index   int value with position of the object
     * @param element is the object of the type T
     * @throws IndexOutOfBoundsException if index is out of bounds for list size
     */
    public void set(int index, T element) throws IndexOutOfBoundsException {
        if (firstElement(index)) {
            first.getNext().setValue(element);
        } else if (lastElement(index)) {
            last.getPrev().setValue(element);
        } else if (indexInBounds(index)) {
            Node<T> nod = findNode(index);
            //Check the node
            assert nod != null : "Node is null";
            nod.setValue(element);
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
    }

    /**
     * Remove an element in position "index" and return its.
     * If the index indicates the beginning or the end of the list, we run the method
     * removeFirst() or removeLast. Otherwise, run the method findNode(), that returns
     * Node from position "index" and then changes the links of its neighbors so that
     * they indicate to each other.
     *
     * @param index int value with position of the object
     * @return object of the type T that is removed
     * @throws IndexOutOfBoundsException if index is out of bounds for list size
     */
    public T remove(int index) throws IndexOutOfBoundsException {
        if (firstElement(index)) {
            return removeFirst();
        } else if (lastElement(index)) {
            return removeLast();
        } else if (indexInBounds(index)) {
            Node<T> node = findNode(index);
            //Check the node
            assert node != null : "Node is null";
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            size--;
            return node.getValue();
        }
        throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);

    }

    public Node<T>  delete() {
        Node<T> node = first.getNext();
        node.setNext(null);
        return node;
    }

    /**
     * Removes an element specified in the arguments from the list and
     * decrease the size of the list.
     * If an argument is in the list, method removes it and returns true,
     * else returns false
     *
     * @param element object of the type T for remove
     * @return boolean
     */
    public boolean remove(T element) {
        Node<T> currentNode = first.getNext();
        while (currentNode != last) {
            if (element == currentNode.getValue()) {
                currentNode.getPrev().setNext(currentNode.getNext());
                currentNode.getNext().setPrev(currentNode.getPrev());
                size--;
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    /**
     * Checks if a list is empty and runs the method removeFirstElement()
     * for remove the first element
     *
     * @return the object of the type T, the first element of the list
     */
    public T removeFirst() {
        checkEmptyException();
        return removeFirstElement();
    }

    /**
     * Checks if a list is empty and runs the method removeLastElement()
     * for remove the last element
     *
     * @return the object of the type T, the last element of the list
     */
    public T removeLast() {
        checkEmptyException();
        return removeLastElement();
    }

    /**
     * Removes the first element.
     * Changes the links of first element neighbors so that
     * they indicate to each other. Then return the element to delete
     *
     * @return the object of the type T to remove
     */
    private T removeFirstElement() {
        Node<T> firstNode = first.getNext();
        first.setNext(firstNode.getNext());
        firstNode.getNext().setPrev(first);
        size--;
        return firstNode.getValue();
    }

    /**
     * Removes the last element.
     * Changes the links of last element neighbors so that
     * they indicate to each other. Then return the element to delete
     *
     * @return the object of the type T to remove
     */
    private T removeLastElement() {
        Node<T> lastNode = last.getPrev();
        last.setPrev(lastNode.getPrev());
        lastNode.getPrev().setNext(last);
        size--;
        return lastNode.getValue();
    }

    /**
     * Check if the element from arguments is in the list.
     * Method starts the cycle that iterates all elements in the
     * list and compares it to an element from arguments. If it
     * finds an element, returns true, else returns false
     *
     * @param element the object of the type T to search
     * @return boolean
     */
    public boolean contains(T element) {
        Node<T> currentNode = first.getNext();
        while (currentNode != last) {
            if (currentNode.getValue() == element) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    /**
     * Find the index of the element from arguments in the list.
     * Method starts the cycle which finds the element. If an element is found
     * returns its index. Otherwise, return -1
     *
     * @param element the object of the type T to search
     * @return int value with index of the element
     */
    public int indexOf(T element) {
        Node<T> currentNode = first.getNext();
        int currentIndex = 0;
        while (currentNode != last) {
            if (currentNode.getValue().equals(element)) {
                return currentIndex;
            }
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        return -1;
    }

    /**
     * Checks the list and if it's empty throws NoSuchElementException
     *
     * @throws NoSuchElementException if the size of the list is 0
     */
    private void checkEmptyException() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }
    }

    /**
     * Returns the first element of the list.
     * If a list is empty returns null
     *
     * @return the object of the type T or null
     */
    public T peekFirst() {
        return isEmpty() ? null : first.getNext().getValue();
    }

    /**
     * Returns the last element of the list.
     * If a list is empty returns null
     *
     * @return the object of the type T or null
     */
    public T peekLast() {
        return isEmpty() ? null :  last.getPrev().getValue();
    }

    /**
     * Removes first the element using method removeFirstElement() and returns it.
     * If a list is empty returns null
     *
     * @return the object of the type T or null
     */
    public T pollFirst() {
        return isEmpty() ? null : removeFirstElement();
    }

    /**
     * Removes last the element using method removeLastElement() and returns it.
     * If a list is empty returns null
     *
     * @return the object of the type T or null
     */
    public T pollLast() {
        return isEmpty() ? null : removeLastElement();
    }


    /**
     * Returns the size of the list
     *
     * @return int value of the list size
     */
    public int size() {
        return size;
    }

    /**
     * Returns the first element of the list by using the method peekFirst().
     *
     * @return the object of the type T. If the list is empty returns a null
     */
    @Override
    public T peek() {
        return peekFirst();
    }

    /**
     * Returns the first element of the list by using the method getFirst().
     * Method getFirst() may throw NoSuchElementException
     *
     * @return the object of the type T
     */
    @Override
    public T element() {
        return getFirst();
    }

    /**
     * Removes the first element of the list by using the method removeFirst().
     * Method removeFirst() may throw NoSuchElementException
     *
     * @return the object of the type T
     */
    @Override
    public T remove() {
        return removeFirst();
    }

    /**
     * Removes the first element of the list by using method pollFirst().
     *
     * @return the object of the type T. If the list is empty returns a null
     */
    @Override
    public T poll() {
        return pollFirst();
    }

    /**
     * Offer to add the element to the list and return true.
     * This method from interface Queue, and it's used in another collection,
     * which can be filled and the method will return false
     *
     * @param element the object of the type T
     * @return boolean
     */
    @Override
    public boolean offer(T element) {
        add(element);
        return true;
    }

    /**
     * Converts an object of the collection.MyLinkedList to an array with objects
     * and returns it
     *
     * @return Object[] array
     */
    public T[] toArray() {
        Object[] array = new Object[size];
        Node<T> currentNode = first.getNext();
        int index = 0;
        while (currentNode != last) {
            array[index] = currentNode.getValue();
            currentNode = currentNode.getNext();
            index++;
        }
        return (T[]) array;
    }

    /**
     * Clear all elements from the list. Method changes the links of
     * the first and the last node so that they indicate to each other
     */
    public void clear() {
        first.setNext(last);
        last.setPrev(first);
        size = 0;
    }

    /**
     * Returns true if the size of the list is 0.
     * Otherwise, return false
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the element in position "index" is the last element
     * and returns true, else returns false
     *
     * @param index int value with position for an element
     * @return boolean
     */
    private boolean lastElement(int index) {
        return index == size - 1;
    }

    /**
     * Checks if the element in position "index" is the first element
     * and returns true, else returns false
     *
     * @param index int value with position for an element
     * @return boolean
     */
    private boolean firstElement(int index) {
        return index == 0;
    }

    /**
     * Checks if index is in bounds of the list size and
     * returns true or false
     *
     * @param index int value with position of the element
     * @return boolean
     */
    private boolean indexInBounds(int index) {
        return index < size && index >= 0;
    }

    /**
     * Return all the elements of the list as an object of the String.
     * Method do it by using the cycle and class StringBuilder
     *
     * @return object of the class String
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder string = new StringBuilder();
        Node<T> currentNode = first.getNext();
        while (currentNode != last) {
            string.append(currentNode.getValue()).append(", ");
            currentNode = currentNode.getNext();
        }
        return "[" + string.substring(0, string.length() - 2) + "]";
    }

    /**
     * This method return new object of the iterator. It's allowing to use the
     * cycle for-each for elements of collection.MyLinkedList and to use methods hasNext() and
     * next() for iteration through the list
     *
     * @return object of the Iterator
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            /**
             * The object of the class Node that contains the link to
             * the node with first element
             */
            Node<T> currentNode = first;

            /**
             * Checks if the next element is in the list and returns boolean
             * true or false
             * @return boolean
             */
            @Override
            public boolean hasNext() {
                return currentNode.getNext() != last;
            }

            /**
             * Return next element in the list
             *
             * @return the object of the type T
             * @throws NoSuchElementException If there are no elements next
             */
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("The list is empty!");
                }
                Node<T> next = currentNode.getNext();
                currentNode = next;
                return next.getValue();
            }
        };
    }

    /**
     * Node is the parametrized class represents a node which contains the link to the
     * previous node, the link to the next node and object of the type T.
     * It has one constructor and some methods using that you can get and change the links of the
     * nodes, and get or change node objects
     *
     * @param <T> this parameter specifies the object type
     */
    public static class Node<T> {

        /**
         * The object of the class Node that is the link
         * to the previous object
         */
        private Node<T> prev;

        /**
         * The object of the class Node that is the link
         * to the next object
         */
        private Node<T> next;

        /**
         * The object of the type T that contains the data
         */
        private T element;

        /**
         * Constructor with one argument creates an object of the Node and initializes the
         * class fields, that specify the previous object, next object and value of the object
         *
         * @param element The object of the type T
         */
        private Node(T element) {
            //Initialize the fields of the class
            prev = null;
            next = null;
            this.element = element;
        }

        /**
         * Get a link to the previous object
         *
         * @return object of the Node
         */
        private Node<T> getPrev() {
            return prev;
        }

        /**
         * Change the link to the previous object
         * by object from the arguments
         *
         * @param node object of the Node
         */
        private void setPrev(Node<T> node) {
            prev = node;
        }

        /**
         * Get a link to the next object
         *
         * @return object of the Node
         */
        private Node<T> getNext() {
            return next;
        }

        /**
         * Change the link to the next object
         * by object from the argument
         *
         * @param node object of the Node
         */
        private void setNext(Node<T> node) {
            next = node;
        }

        /**
         * Get an element from node
         *
         * @return the object of the type T
         */
        private T getValue() {
            return element;
        }

        /**
         * Change the element in the node by element
         * from the arguments
         *
         * @param element the object of the type T
         */
        private void setValue(T element) {
            this.element = element;
        }

    }
}
