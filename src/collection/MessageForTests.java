package collection;

import tests.ConstantsForTestingCollection;

/**
 * collection.MessageForTests class represents the set of the methods, which displays information about
 * the tests in the console
 */
public class MessageForTests implements ConstantsForTestingCollection {
    /**
     * Reports that the test is passed and shows the test
     * execution time in the console
     *
     * @param start the long value to control the test executing time
     */
    public void printPassed(long start) {
        System.out.println("\u001B[32m ✓ passed!\u001B[0m");
        System.out.println("Test execution time: " +
                (System.currentTimeMillis() - start) + "ms");
    }

    /**
     * Reports that the test is failed
     */
    public void printFailed() {
        System.out.println("\u001B[31m ✗ failed!\u001B[0m");
    }

    /**
     * Reports that the list is empty
     */
    public void printListEmpty() {
        System.out.println("\u001B[31mList is empty!\u001B[0m");
    }

    /**
     * Reports that the stack is empty
     */
    public void printStackEmpty() {
        System.out.println("\u001B[31mStack is empty!\u001B[0m");
    }

    /**
     * Reports that the queue is empty
     */
    public void printQueueEmpty() {
        System.out.println("\u001B[31mQueue is empty!\u001B[0m");
    }

    /**
     * Reports that the index is out of bounds for collection.MyLinkedList size
     *
     * @param list collection.MyLinkedList with Integer objects
     */
    public void printForBounds(MyLinkedList<Integer> list) {
        System.out.println("\u001B[31mIndex " + INDEX_FOR_OPERATIONS +
                " is out of bounds for size \u001B[0m" + list.size());
    }

    /**
     * Reports that the index is out of bounds for collection.MyArrayList size
     *
     * @param list collection.MyArrayList with Integer objects
     */
    public void printForBounds(MyArrayList<Integer> list) {
        System.out.println("\u001B[31mIndex " + INDEX_FOR_OPERATIONS +
                " is out of bounds for size \u001B[0m" + list.size());
    }
}
