package tests;

import collection.MessageForTests;
import collection.MyStack;
import tests.ConstantsForTestingCollection;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Class tests.TestForMyStack represents the program for testing the class {@link MyStack collection.MyStack}.
 * It extends class {@link MessageForTests collection.MessageForTests} for displaying logs and implements the
 * interface {@link ConstantsForTestingCollection Constants}, which contains the constants for testing. Class contains constructor
 * and some methods verifying the addition, receipt and removal elements of the class collection.MyQueue
 */
public class TestForMyStack extends MessageForTests implements ConstantsForTestingCollection {

    /**
     * The collection.MyStack object for testing
     */
    private final MyStack<Integer> stack;

    /**
     * This is a default constructor, which creates the object of
     * tests.TestForMyStack and run the method startTests()
     */
    public TestForMyStack() {
        //initialize collection.MyStack
        stack = new MyStack<>();
        //Run the tests
        startTests();

    }

    /**
     * Starts the testing of the collection.MyStack methods and displays
     * the test run time
     */
    private void startTests() {
        System.out.println("\u001B[33mSTART TESTS FOR collection.MyStack");
        System.out.println("-----------------------------\u001B[0m");
        long start = System.currentTimeMillis();
        //Addition test
        testPush();
        // Test for peek() method
        testPeek();
        //Searching test
        testSearch();
        //Test for empty() method
        testEmpty();
        //Removal test
        testPop();
        System.out.println("\u001B[33mEND OF TESTS FOR collection.MyStack");
        System.out.println("Total test execution time: " +
                (System.currentTimeMillis() - start) + "ms");
        System.out.println("---------------------------------------------\u001B[0m");
    }

    /**
     * Adds to the stack number of objects, that the constant of
     * NUMBER_OF_OBJECTS_FOR_ADD specifies and run the tryPeek() method
     * to check the stack
     */
    private void testPush() {
        System.out.print("Test \"push(T element)\" for group of the elements");
        long start = System.currentTimeMillis();
        for (int i = 0; i < NUMBER_OF_OBJECTS_FOR_ADD; i++) {
            stack.push(i);
        }
        if (NUMBER_OF_OBJECTS_FOR_ADD < 0) {
            printPassed(start);
            printStackEmpty();
        } else {
            tryPeek(start);
        }
        System.out.println("---------------------------------------------");
    }

    /**
     * Starts the test for peek ().The test runs the tryPeek()
     * method for it
     */
    private void testPeek() {
        System.out.print("Test \"peek()\"");
        long start = System.currentTimeMillis();
        // Try to peek the top of the stack
        tryPeek(start);
        System.out.println("---------------------------------------------");
    }

    /**
     * Checks what the element is at the top of the stack using
     * the peek() method that can to throw NoSuchElementException.
     * That's why method catches NullPointerException
     *
     * @param start the long value to control the test executing time
     */
    private void tryPeek(long start) {
        try {
            if (stack.peek().equals(NUMBER_OF_OBJECTS_FOR_ADD - 1)) {
                printPassed(start);
            } else {
                printFailed();
            }
        } catch (NoSuchElementException e) {
            printPassed(start);
            printStackEmpty();
        }
    }

    /**
     * Verifies the work of the search() method. This method must
     * find the element and return its index. The test run the
     * checkIndexFromSearch() that checks returned index
     */
    private void testSearch() {
        System.out.print("Test \"search(T element)\"");
        long start = System.currentTimeMillis();
        //Checks returned index
        checkIndexFromSearch(start);
        System.out.println("---------------------------------------------");
    }

    /**
     * Method checks if the correct index is returned. This is simple
     * because the method knows that the index of each element is equal
     * to its value
     *
     * @param start the long value to control the test executing time
     */
    private void checkIndexFromSearch(long start) {
        int lastIndex = NUMBER_OF_OBJECTS_FOR_ADD - 1;
        /*
        If an object is in the stack and the search(T element) method returns
        the element's index, test is passed. Otherwise, it's failed
        */
        if (OBJECT_FOR_OPERATIONS >= 0 && OBJECT_FOR_OPERATIONS < NUMBER_OF_OBJECTS_FOR_ADD) {
            if (stack.search(OBJECT_FOR_OPERATIONS) == lastIndex - OBJECT_FOR_OPERATIONS) {
                printPassed(start);
            } else {
                printFailed();
            }
        } else {
            //If an object is not in the stack and the search(T element) method returns 1,
            // test is passed. Otherwise, it's failed
            if (stack.search(OBJECT_FOR_OPERATIONS) == 1) {
                printPassed(start);
            } else {
                printFailed();
            }
        }
    }

    /**
     * The test verifies whether the empty() method can check the
     * stack size. If a list is empty, the empty() method must return
     * boolean true. Otherwise, it must return false
     */
    private void testEmpty() {
        System.out.print("Test \"empty()\"");
        long start = System.currentTimeMillis();
        if (NUMBER_OF_OBJECTS_FOR_ADD <= 0) {
            if (stack.empty()) {
                printPassed(start);
            } else {
                printFailed();
            }
        } else {
            if (!stack.empty()) {
                printPassed(start);
            } else {
                printFailed();
            }
        }
        System.out.println("---------------------------------------------");
    }

    /**
     * The test verifies the operation of the pop() method. It must remove and
     * return the element at the top of the stack. Method can throw
     * EmptyStackException if the stack is empty. That's why the test catches it
     */
    private void testPop() {
        System.out.print("Test \"pop()\"");
        long start = System.currentTimeMillis();
        try {
            Integer object = stack.pop();
            if (object == NUMBER_OF_OBJECTS_FOR_ADD - 1) {
                printPassed(start);
            } else {
                printFailed();
            }
        } catch (EmptyStackException e) {
            printPassed(start);
            printStackEmpty();
        }
        System.out.println("---------------------------------------------");
    }


}
