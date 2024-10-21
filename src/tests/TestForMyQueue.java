package tests;

import collection.MyLinkedList;
import collection.MyQueue;
import java.util.NoSuchElementException;

/**
 * Class tests.TestForMyQueue represents the program for testing the class {@link MyQueue collection.MyQueue}.
 * It extends class {@link MessageForTests tests.MessageForTests} for displaying logs and implements the
 * interface {@link ConstantsForTestingCollection Constants}, which contains the constants for testing. Class contains constructor
 * and some methods verifying the addition, receipt and removal elements of the class collection.MyQueue
 */
public class TestForMyQueue extends MessageForTests implements ConstantsForTestingCollection {

    /**
     * collection.MyQueue object for testing
     */
    private MyQueue<Integer> queue;

    /**
     * This is a default constructor, which creates the object of
     * tests.TestForMyQueue and run the method runTheTests()
     */
    public TestForMyQueue() {
        //Initialize collection.MyQueue object
        queue = new MyLinkedList<>();
        //Run the tests
        runTests();
    }

    /**
     * Starts the testing of the collection.MyQueue methods and displays
     * the test run time
     */
    private void runTests() {
        System.out.println("\u001B[33mSTART TESTS FOR collection.MyQueue");
        System.out.println("-----------------------------\u001B[0m");
        long start = System.currentTimeMillis();
        //Addition test
        testAdd();
        // Test for peek() method
        testPeek();
        //Test for element() method
        testElement();
        //Removal test
        testRemove();
        //Test for poll() method
        testPoll();
        System.out.println("\u001B[33mEND OF TESTS FOR collection.MyQueue");
        System.out.println("Total test execution time: " +
                (System.currentTimeMillis() - start) + "ms");
        System.out.println("---------------------------------------------\u001B[0m");
    }

    /**
     * Method adds to the collection.MyQueue the objects using fillQueue() method
     * and verifies whether the queue is empty and catches
     * NullPointerException if it's true
     */
    private void testAdd() {
        System.out.print("Test \"add(T element)\" for group of the elements");
        long start = System.currentTimeMillis();
        fillQueue();
        try {
            if (queue.peek() != 0 || queue.size() != NUMBER_OF_OBJECTS_FOR_ADD) {
                printFailed();
            } else {
                printPassed(start);
            }
        } catch (NullPointerException e) {
            printPassed(start);
            printQueueEmpty();
        }

        System.out.println("---------------------------------------------");
    }

    /**
     * Adds to the queue number of objects, that the constant of
     * NUMBER_OF_OBJECTS_FOR_ADD specifies
     */
    private void fillQueue() {
        for (int i = 0; i < NUMBER_OF_OBJECTS_FOR_ADD; i++) {
            queue.add(i);
        }
    }

    /**
     * Test verifies the operation of the peek() method. It must return the
     * first element in the queue. The test checks whether this element is 0
     * because the first element in the queue is zero. The method peek() returns
     * null if queue is empty. That's why the test catches NullPointerException
     */
    private void testPeek() {
        System.out.print("Test \"peek()\"");
        long start = System.currentTimeMillis();
        try {
            Integer object = queue.peek();
            if (object.equals(0)) {
                printPassed(start);
            } else {
                printFailed();
            }
        } catch (NullPointerException e) {
            printPassed(start);
            printQueueEmpty();
        }
        System.out.println("---------------------------------------------");
    }

    /**
     * Test verifies the operation of the element() method. It must return the
     * first element in the queue. The test checks whether this element is 0
     * because the first element in the queue is 0. The element() method throws
     * NoSuchElementException if queue is empty. That's why the test catches it
     */
    private void testElement() {
        System.out.print("Test \"element()\"");
        long start = System.currentTimeMillis();
        try {
            if (queue.element().equals(0)) {
                printPassed(start);
            } else {
                printFailed();
            }
        } catch (NoSuchElementException e) {
            printPassed(start);
            printQueueEmpty();
        }
        System.out.println("---------------------------------------------");
    }

    /**
     * The test tries to delete the element using remove() method.
     * Then it verifies if the method returns the element to remove and
     * checks the size of the queue.
     * Test catches NoSuchElementException if the size of the queue is 0
     */
    private void testRemove() {
        System.out.print("Test \"remove()\"");
        long start = System.currentTimeMillis();
        try {
            Integer object = queue.remove();
            if (object.equals(0) && queue.size() == NUMBER_OF_OBJECTS_FOR_ADD - 1) {
                printPassed(start);
            } else {
                printFailed();
            }
        } catch (NoSuchElementException e) {
            printPassed(start);
            printQueueEmpty();
        }
        System.out.println("---------------------------------------------");
    }

    /**
     * Test verifies the operation of the poll() method.
     * It must remove and return the first element in the queue.
     * The test checks whether this element is 0,because the first
     * element in the queue is 0 and checks if the size of the list
     * has been reduced. If queue is empty, the poll() method returns
     * the null. That's why the test catches NullPointerException
     */
    private void testPoll() {
        queue = new MyLinkedList<>();
        fillQueue();
        System.out.print("Test \"poll()\"");
        long start = System.currentTimeMillis();
        try {
            Integer object = queue.poll();
            if (object.equals(0) && queue.size() == NUMBER_OF_OBJECTS_FOR_ADD - 1) {
                printPassed(start);
            } else {
                printFailed();
            }
        } catch (NullPointerException e) {
            printPassed(start);
            printQueueEmpty();
        }
        System.out.println("---------------------------------------------");
    }
}
