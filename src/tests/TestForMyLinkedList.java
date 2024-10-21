package tests;

import collection.MessageForTests;
import collection.MyLinkedList;
import java.util.NoSuchElementException;

/**
 * Class tests.TestForMyLinkedList represents the program for testing the class {@link MyLinkedList collection.MyLinkedList}.
 * It extends class {@link MessageForTests collection.MessageForTests} for displaying logs and implements the
 * interface {@link ConstantsForTestingCollection Constants}, which contains the constants for testing. Class contains constructor
 * and some methods verifying the addition, receipt, installation, removal elements of the class MyALinkedList
 */
public class TestForMyLinkedList extends MessageForTests implements ConstantsForTestingCollection {

    /**
     * This is a default constructor, which creates the object of
     * tests.TestForMyLinkedList and run the method runTheTests()
     */
    public TestForMyLinkedList() {
        runTheTests();

    }

    /**
     * Starts the testing of the collection.MyLinkedList methods and displays
     * the test run time
     */
    private void runTheTests() {
        System.out.println("\u001B[33mSTART TESTS FOR collection.MyLinkedList");
        System.out.println("-----------------------------\u001B[0m");
        //The variable for check the total tests execution time
        long start = System.currentTimeMillis();
        // Addition test
        testAdd();
        // Receipt test
        testGet();
        // Installation test
        testSet();
        // Removal test
        testRemove();
        // Other tests
        testOtherMethods();
        System.out.println("\u001B[33mEND OF TESTS FOR collection.MyLinkedList");
        System.out.println("Total test execution time: " +
                (System.currentTimeMillis() - start) + "ms");
        System.out.println("---------------------------------------------\u001B[0m");
    }

    /**
     * Creates the MyALinkedList of Integers and adds to it the number of objects,
     * that the constant of NUMBER_OF_OBJECTS_FOR_ADD specifies. Adds elements so
     * that its index is equal to its value
     *
     * @return MyArraylist with Integer objects
     */
    private MyLinkedList<Integer> createLinkedList() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < NUMBER_OF_OBJECTS_FOR_ADD; i++) {
            list.add(i);
        }
        return list;
    }

    /**
     * Addition test for a group of the elements. Method adds to the collection.MyArrayList
     * the number of objects that the constant of NUMBER_OF_OBJECTS_FOR_ADD specifies.
     * Then it checks if the elements been added and catches NoSuchElementException
     */
    private void testAdd() {
        System.out.print("Test \"add(T element)\" for group of the elements");
        long start = System.currentTimeMillis();
        MyLinkedList<Integer> list = createLinkedList();
        try {
            if (list.get(0) != 0 || list.size() != NUMBER_OF_OBJECTS_FOR_ADD) {
                printFailed();
            } else {
                printPassed(start);
            }
        } catch (NoSuchElementException e) {
            printPassed(start);
            printListEmpty();
        }
        System.out.println("---------------------------------------------");
        // Addition test for a first element
        addFirst();
    }

    /**
     * Verifies the addition for first element. Method adds the OBJECT_FOR_OPERATIONS
     * and tries to retrieve it from index 0 of the list and catches NoSuchElementException
     * if a list is empty
     */
    private void addFirst() {
        MyLinkedList<Integer> list = createLinkedList();
        System.out.print("Test \"addFirst(T element)\"");
        long start = System.currentTimeMillis();
        //Current list size after adding the first element
        int currentSize = NUMBER_OF_OBJECTS_FOR_ADD + 1;
        if (NUMBER_OF_OBJECTS_FOR_ADD < 0) {
            printPassed(start);
            printListEmpty();
        } else {
            list.addFirst(OBJECT_FOR_OPERATIONS);
            try {
                if (list.get(0).equals(OBJECT_FOR_OPERATIONS) &&
                        list.size() == currentSize) {
                    printPassed(start);
                } else {
                    printFailed();
                }
            } catch (NoSuchElementException e) {
                printPassed(start);
                printListEmpty();
            }
        }
        System.out.println("---------------------------------------------");
        //Addition test for last element
        addLast(list, currentSize);
    }

    /**
     * Verifies the addition for last element. Method adds the OBJECT_FOR_OPERATIONS
     * and tries to retrieve it from the end of the list and catches NoSuchElementException
     * if a list is empty
     *
     * @param list        collection.MyLinkedList with Integer objects
     * @param currentSize int value with list size after adding the first element
     */
    private void addLast(MyLinkedList<Integer> list, int currentSize) {
        System.out.print("Test \"addLast(T element)\"");
        long start = System.currentTimeMillis();
        if (NUMBER_OF_OBJECTS_FOR_ADD < 0) {
            printPassed(start);
            printListEmpty();
        } else {
            list.addLast(OBJECT_FOR_OPERATIONS);
            try {
                if (list.get(list.size() - 1).equals(OBJECT_FOR_OPERATIONS) &&
                        list.size() == currentSize + 1) {
                    printPassed(start);
                } else {
                    printFailed();
                }
            } catch (NoSuchElementException e) {
                printPassed(start);
                printListEmpty();
            }
        }
        System.out.println("---------------------------------------------");
        addOneElementByIndex();
    }

    /**
     * Method tries to add one element and checks if add(int index, T element)
     * works correctly. It catches IndexOutOfBoundsException
     */
    private void addOneElementByIndex() {
        MyLinkedList<Integer> list = createLinkedList();
        System.out.print("Test \"add(int index, T element)\" for one element");
        long start = System.currentTimeMillis();
        try {
            list.add(INDEX_FOR_OPERATIONS, OBJECT_FOR_OPERATIONS);
            //Check the list after adding
            checkForAddOneElement(start, list);
        } catch (IndexOutOfBoundsException e) {
            printPassed(start);
            printForBounds(list);
        }
        System.out.println("---------------------------------------------");
        //Addition test for a group of the elements
        addGroupOfElementsByIndex();
    }

    /**
     * The test checks whether the element has been added and the size of the list has been increased.
     * Method catches IndexOutOfBoundsException if the index is out of bounds for list size
     *
     * @param start the long value to control the test executing time
     * @param list  collection.MyLinkedList with Integer objects
     */
    private void checkForAddOneElement(long start, MyLinkedList<Integer> list) {
        try {
            if (!list.get(INDEX_FOR_OPERATIONS).equals(OBJECT_FOR_OPERATIONS) ||
                    list.size() != NUMBER_OF_OBJECTS_FOR_ADD + 1) {
                printFailed();
            } else {
                printPassed(start);
            }
        } catch (IndexOutOfBoundsException e) {
            printPassed(start);
            printForBounds(list);
        }

    }

    /**
     * Method tries to add the group of elements and checks if add (int index, T element)
     * works correctly. It catches IndexOutOfBoundsException
     */
    private void addGroupOfElementsByIndex() {
        MyLinkedList<Integer> list = createLinkedList();
        System.out.print("Test \"add(int index, T element)\" for group" +
                " of the elements");
        long start = System.currentTimeMillis();
        for (int i = 0; i < NUMBER_OF_OBJECTS_FOR_OTHER_OPERATIONS; i++) {
            try {
                list.add(INDEX_FOR_OPERATIONS, OBJECT_FOR_OPERATIONS);

            } catch (IndexOutOfBoundsException e) {
                printPassed(start);
                printForBounds(list);
                System.out.println("---------------------------------------------");
                return;
            }
        }
        //Checks the list after addition test for a group of the elements
        checkForAddGroupOfElements(start, list);
        System.out.println("---------------------------------------------");
    }

    /**
     * Checks if the elements have been added and if the size of the list has been increased.
     * Method catches IndexOutOfBoundsException
     *
     * @param start the long value to control the test executing time
     * @param list  collection.MyLinkedList with Integer objects
     */
    private void checkForAddGroupOfElements(long start, MyLinkedList<Integer> list) {
        try {
            if (!list.get(INDEX_FOR_OPERATIONS).equals(OBJECT_FOR_OPERATIONS) ||
                    list.size() != NUMBER_OF_OBJECTS_FOR_ADD +
                            NUMBER_OF_OBJECTS_FOR_OTHER_OPERATIONS) {
                printFailed();
            } else {
                printPassed(start);
            }
        } catch (IndexOutOfBoundsException e) {
            printPassed(start);
            printForBounds(list);
        }
    }

    /**
     * Starts the methods for testing to get an element by index, get a first element
     * and get las
     */
    private void testGet() {
        MyLinkedList<Integer> list = createLinkedList();
        //Receipt by index test
        getByIndex(list);
        //Receipt test for a first element
        getFirst(list);
        //Receipt test for last element
        getLast(list);
    }

    /**
     * The test tries to get one element by index and checks if you get (int index, a T element)
     * works correctly. The index of each element is equal to its value, and it's easy to check
     * the operation of a method
     *
     * @param list collection.MyLinkedList with Integer objects
     */
    private void getByIndex(MyLinkedList<Integer> list) {
        System.out.print("Test \"get(int index)\"");
        long start = System.currentTimeMillis();
        try {
            if (list.get(INDEX_FOR_OPERATIONS).equals(INDEX_FOR_OPERATIONS)) {
                printPassed(start);
            } else {
                printFailed();
            }
        } catch (IndexOutOfBoundsException e) {
            printPassed(start);
            printForBounds(list);
        }
        System.out.println("---------------------------------------------");
    }

    /**
     * The test tries to get a first element in the list and checks if getFist()
     * works correctly. The index of each element is equal to its value, so the method
     * knows that the first element in the list is 0.
     * If a list is empty, catches NoSuchElementException
     *
     * @param list collection.MyLinkedList with Integer objects
     */
    private void getFirst(MyLinkedList<Integer> list) {
        System.out.print("Test \"getFist()\"");
        long start = System.currentTimeMillis();
        try {
            if (list.getFirst() == 0) {
                printPassed(start);
            } else {
                printFailed();
            }
        } catch (NoSuchElementException e) {
            printPassed(start);
            printListEmpty();
        }
        System.out.println("---------------------------------------------");
    }

    /**
     * The test tries to get the last element in the list and checks if getLast()
     * works correctly. The index of each element is equal to its value, so the method
     * knows that the last element in the list is (NUMBER_OF_OBJECTS_FOR_ADD - 1).
     * If a list is empty, catches NoSuchElementException
     *
     * @param list collection.MyLinkedList with Integer objects
     */
    private void getLast(MyLinkedList<Integer> list) {
        System.out.print("Test \"getLast()\"");
        long start = System.currentTimeMillis();
        try {
            if (list.getLast() == NUMBER_OF_OBJECTS_FOR_ADD - 1) {
                printPassed(start);
            } else {
                printFailed();
            }
        } catch (NoSuchElementException e) {
            printPassed(start);
            printListEmpty();
        }
        System.out.println("---------------------------------------------");
    }

    /**
     * Installation test by index. The test tries to set an element at an index and
     * then to get this element by index.
     * If the index is out of bounds for list size catches IndexOutOfBoundsException
     */
    private void testSet() {
        MyLinkedList<Integer> list = createLinkedList();
        System.out.print("Test \"set(int index, T element)\"");
        long start = System.currentTimeMillis();
        try {
            list.set(INDEX_FOR_OPERATIONS, OBJECT_FOR_OPERATIONS);
            if (!list.get(INDEX_FOR_OPERATIONS).equals(OBJECT_FOR_OPERATIONS)) {
                printFailed();
            } else {
                printPassed(start);
            }
        } catch (IndexOutOfBoundsException e) {
            printPassed(start);
            printForBounds(list);
        }
        System.out.println("---------------------------------------------");
    }

    /**
     * Starts the tests of remove one element by index, group of elements by index,
     * remove a first element, remove last element and remove by element
     */
    private void testRemove() {
        // Removal test by index for one element
        removeOneElementByIndex();
        // Removal test by index for a group of the elements
        removeGroupOfElementsByIndex();
        // Removal test of the first element
        removeFirst();
        // Removal test of the last element
        removeLast();
        // Removal test by element
        removeByElement();
    }

    /**
     * Tries to remove one element at an index and runs checkRemoveOneElement()
     * to check the operation of the remove(int index).
     * If the index is out of bounds for list size catches IndexOutOfBoundsException
     */
    private void removeOneElementByIndex() {
        MyLinkedList<Integer> list = createLinkedList();
        System.out.print("Test \"remove(int index)\" for one element");
        long start = System.currentTimeMillis();
        try {
            //Check remove(int index)
            checkRemoveOneElement(start, list);
        } catch (IndexOutOfBoundsException e) {
            printPassed(start);
            printForBounds(list);
        }
        System.out.println("---------------------------------------------");
    }

    /**
     * Checks whether the remove(int index) returns the deleted object and whether the
     * list size is reduced. This is simple because the method knows that the index
     * of each element is equal to its value
     *
     * @param start the long value to control the test executing time
     * @param list  collection.MyLinkedList with Integer objects
     */
    private void checkRemoveOneElement(long start, MyLinkedList<Integer> list) {
        Integer object = list.remove(INDEX_FOR_OPERATIONS);
        if (list.size() == NUMBER_OF_OBJECTS_FOR_ADD - 1 && object ==
                INDEX_FOR_OPERATIONS) {
            printPassed(start);
        } else {
            printFailed();
        }
    }

    /**
     * Tries to remove the group of elements at an index and runs checkRemoveGroupOfElements()
     * to check the operation of the remove(int index)
     */
    private void removeGroupOfElementsByIndex() {
        MyLinkedList<Integer> list = createLinkedList();
        System.out.print("Test \"remove(int index)\" for group of the elements");
        long start = System.currentTimeMillis();
        for (int i = 0; i < NUMBER_OF_OBJECTS_FOR_OTHER_OPERATIONS; i++) {
            try {
                list.remove(INDEX_FOR_OPERATIONS);
            } catch (IndexOutOfBoundsException e) {
                printPassed(start);
                printForBounds(list);
                System.out.println("---------------------------------------------");
                return;
            }
        }
        //Check remove(int index)
        checkRemoveGroupOfElements(start, list);
        System.out.println("---------------------------------------------");
    }

    /**
     * Checks whether the list size decreases after deleting the group of the elements
     *
     * @param start the long value to control the test executing time
     * @param list  collection.MyLinkedList with Integer objects
     */
    private void checkRemoveGroupOfElements(long start, MyLinkedList<Integer> list) {
        int restOf = NUMBER_OF_OBJECTS_FOR_ADD - NUMBER_OF_OBJECTS_FOR_OTHER_OPERATIONS;
        if (list.size() == restOf) {
            printPassed(start);
        } else {
            printFailed();
        }
    }

    /**
     * The test tries to remove the first element and verifies whether the
     * removeFirst() method removes and returns the element.
     * The index of each element is equal to its value, so the method
     * knows that the first element in the list is 0
     *  If the list is empty catches NoSuchElementException and displays the warning
     */
    private void removeFirst() {
        MyLinkedList<Integer> list = createLinkedList();
        System.out.print("Test \"removeFirst()\" for one element");
        long start = System.currentTimeMillis();
        try {
            Integer object = list.removeFirst();
            if (list.size() == NUMBER_OF_OBJECTS_FOR_ADD - 1 && object == 0) {
                printPassed(start);
            } else {
                printFailed();
            }
        } catch (NoSuchElementException e) {
            printPassed(start);
            printListEmpty();
        }
        System.out.println("---------------------------------------------");
    }

    /**
     * The test tries to remove the last element and verifies whether the
     * removeLast() method removes and returns the element.
     * The index of each element is equal to its value, so the method
     * knows that the last element in the list is (NUMBER_OF_OBJECTS_FOR_ADD - 1)
     *  If the list is empty catches NoSuchElementException and displays the warning
     */
    private void removeLast() {
        MyLinkedList<Integer> list = createLinkedList();
        System.out.print("Test \"removeLast()\" for one element");
        long start = System.currentTimeMillis();
        try {
            Integer object = list.removeLast();
            if (list.size() == NUMBER_OF_OBJECTS_FOR_ADD - 1 &&
                    object == NUMBER_OF_OBJECTS_FOR_ADD - 1) {
                printPassed(start);
            } else {
                printFailed();
            }
        } catch (NoSuchElementException e) {
            printPassed(start);
            printListEmpty();
        }
        System.out.println("---------------------------------------------");
    }

    /**
     * Tests the removing by element and runs checkRemoveByElement()
     * to check the operation of the remove(T element)
     */
    private void removeByElement() {
        MyLinkedList<Integer> list = createLinkedList();
        System.out.print("Test \"remove(T element)\" for one element");
        long start = System.currentTimeMillis();
        //Checks remove(T element)
        checkRemoveByElement(start, list);
        System.out.println("---------------------------------------------");
    }

    /**
     * Checks whether the remove(T element) removes the element and returns true
     * if the element is in the list or returns false if the list doesn't contain the element.
     * This is simple because the method knows that the index of each element is equal to its value
     *
     * @param start the long value to control the test executing time
     * @param list  collection.MyLinkedList with Integer objects
     */
    private void checkRemoveByElement(long start, MyLinkedList<Integer> list) {
        // If an object is in the list and if the remove(T element) method returns true,
        // method passed the test. Otherwise, method failed the test
        if (OBJECT_FOR_OPERATIONS >= 0 && OBJECT_FOR_OPERATIONS < NUMBER_OF_OBJECTS_FOR_ADD) {
            if (list.remove(OBJECT_FOR_OPERATIONS)) {
                //Check list size
                if (list.size() == NUMBER_OF_OBJECTS_FOR_ADD - 1) {
                    printPassed(start);
                }
            } else {
                printFailed();
            }
        } else {
            // If an object is not in the list and if the remove(T element) method returns false,
            // method passed the test. Otherwise, method failed the test
            if (NUMBER_OF_OBJECTS_FOR_ADD < 0) {
                printPassed(start);
                printListEmpty();
            } else if (!list.remove(OBJECT_FOR_OPERATIONS)) {
                //Check list size. It can't be equals to NUMBER_OF_OBJECTS_FOR_ADD constant
                if (list.size() == NUMBER_OF_OBJECTS_FOR_ADD) {
                    printPassed(start);
                    System.out.println("\u001B[31mThere are no such objects in tne list\u001B[0m");
                }
            } else {
                printFailed();
            }
        }
    }

    /**
     * Starts the tests for methods iterator, indexOf(T element), contains(T element)
     * empty(), peekFirst(), peekLast(), pollFirst(), pollLast() and clear()
     */
    private void testOtherMethods() {
        //Creates new collection.MyLinkedList
        MyLinkedList<Integer> list = createLinkedList();
        //Test for iterator
        testIterator(list);
        //Test for searching the index of the element
        testIndexOf(list);
        //Test for contains the element
        testContains(list);
        // Test for empty() method
        testEmpty(list);
        // Test for peek first
        testPeekFirst(list);
        // Test for peek last
        testPeekLast(list);
        //Test for a poll first
        testPollFirst(list);
        //Test for a poll last
        testPollLast();
        //Test for clearing
        testClear(list);

    }

    /**
     * First, the test checks whether the list is empty and displays
     * the warning if it's true.
     * Then check whether collection.MyLinkedList can use the cycle of "for-each" and if the elements in the
     * cycle iterate correctly
     *
     * @param list collection.MyLinkedList with Integer objects
     */
    private void testIterator(MyLinkedList<Integer> list) {
        System.out.print("Test \"Iterator\"");
        long start = System.currentTimeMillis();
        if (list.isEmpty()) {
            printPassed(start);
            printListEmpty();
        } else {
            //Variable for counting elements in the cycle
            int count = 0;
            for (Integer ignored : list) {
                count++;
            }
            //Checks for iteration all the elements
            if (count == NUMBER_OF_OBJECTS_FOR_ADD) {
                printPassed(start);
            } else {
                printFailed();
            }
        }
        System.out.println("---------------------------------------------");
    }

    /**
     * The test verifies whether indexOf(T element) method can find the element
     * and return its index. The test can check whether the returned index is
     * the index of the element, because the method knows that the index of each
     * element is equal to its value
     *
     * @param list collection.MyLinkedList with Integer objects
     */
    private void testIndexOf(MyLinkedList<Integer> list) {
        System.out.print("Test \"indexOf(T element)\"");
        long start = System.currentTimeMillis();
        // If an object is in the list and method indexOf(T element) returns element's index,
        //test is passed. Otherwise, the test is failed
        if (OBJECT_FOR_OPERATIONS >= 0 && OBJECT_FOR_OPERATIONS < NUMBER_OF_OBJECTS_FOR_ADD) {
            if (list.indexOf(OBJECT_FOR_OPERATIONS) == OBJECT_FOR_OPERATIONS) {
                printPassed(start);
            } else {
                printFailed();
            }
        } else {
            // If an object is not in the list and method indexOf(T element) returns -1,
            //test is passed. Otherwise, the test is failed
            if (list.indexOf(OBJECT_FOR_OPERATIONS) == -1) {
                printPassed(start);
                System.out.println("\u001B[31mThere are no such objects in tne list\u001B[0m");
            } else {
                printFailed();
            }
        }
        System.out.println("---------------------------------------------");
    }

    /**
     * Checks whether the contains(T element) method can to find the element.
     * Method returns true if the element is in the list or returns false
     * if a list doesn't contain the element. This is simple because the method knows
     * that the index of each element is equal to its value
     *
     * @param list collection.MyLinkedList with Integer objects
     */
    private void testContains(MyLinkedList<Integer> list) {
        System.out.print("Test \"contains(T element)\"");
        long start = System.currentTimeMillis();
        // If an object is in the list and method contains(T element) returns true,
        //test is passed. Otherwise, the test is failed
        if (OBJECT_FOR_OPERATIONS >= 0 && OBJECT_FOR_OPERATIONS < NUMBER_OF_OBJECTS_FOR_ADD) {
            if (list.contains(OBJECT_FOR_OPERATIONS)) {
                printPassed(start);
            } else {
                printFailed();
            }
        } else {
            // If an object is not the list and method contains(T element) returns false,
            //test is passed. Otherwise, the test is failed
            if (!list.contains(OBJECT_FOR_OPERATIONS)) {
                printPassed(start);
                System.out.println("\u001B[31mThere are no such objects in tne list\u001B[0m");
            } else {
                printFailed();
            }
        }
        System.out.println("---------------------------------------------");
    }

    /**
     * The test verifies whether the isEmpty() method can check the
     * list size. If a list is empty, the isEmpty() method must return
     * boolean true. Otherwise, it must return false
     *
     * @param list collection.MyLinkedList with Integer objects
     */
    private void testEmpty(MyLinkedList<Integer> list) {
        System.out.print("Test \"isEmpty()\"");
        long start = System.currentTimeMillis();
        if ((NUMBER_OF_OBJECTS_FOR_ADD <= 0 && list.isEmpty()) ||
                (NUMBER_OF_OBJECTS_FOR_ADD > 0 && !list.isEmpty())) {
            printPassed(start);
        } else {
            printFailed();
        }
        System.out.println("---------------------------------------------");
    }

    /**
     * Test verifies the operation of the peekFirst() method. It must return the
     * first element in the list. The test checks whether this element is 0
     * because the first element in the list is 0.
     * Catch NullPointerException if a list is empty
     *
     * @param list collection.MyLinkedList with Integer objects
     */
    private void testPeekFirst(MyLinkedList<Integer> list) {
        System.out.print("Test \"peekFirst()\"");
        long start = System.currentTimeMillis();
        try {
            Integer object = list.peekFirst();
            if (object == 0 && NUMBER_OF_OBJECTS_FOR_ADD > 0) {
                printPassed(start);
            } else {
                printFailed();
            }
        } catch (NullPointerException e) {
            printPassed(start);
            printListEmpty();
        }
        System.out.println("---------------------------------------------");
    }

    /**
     * Test verifies the operation of the peekLast() method. It must return the
     * last element in the list. The test checks whether this element is
     * (NUMBER_OF_OBJECTS_FOR_ADD - 1).
     * Catch NullPointerException if a list is empty
     *
     * @param list collection.MyLinkedList with Integer objects
     */
    private void testPeekLast(MyLinkedList<Integer> list) {
        System.out.print("Test \"peekLast()\"");
        long start = System.currentTimeMillis();
        try {
            Integer object = list.peekLast();
            if (object == NUMBER_OF_OBJECTS_FOR_ADD - 1 &&
                    NUMBER_OF_OBJECTS_FOR_ADD > 0) {
                printPassed(start);
            } else {
                printFailed();
            }
        } catch (NullPointerException e) {
            printPassed(start);
            printListEmpty();
        }
        System.out.println("---------------------------------------------");
    }

    /**
     * Test verifies the operation of the pollFirst() method.
     * It must remove and return the first element in the list.
     * The test checks whether this element is 0,because the first
     * element in the list is 0 and whether the size of the list
     * has been reduced
     * Catches NullPointerException if the list is empty
     *
     * @param list collection.MyLinkedList with Integer objects
     */
    private void testPollFirst(MyLinkedList<Integer> list) {
        System.out.print("Test \"pollFirst()\"");
        long start = System.currentTimeMillis();
        try {
            Integer object = list.pollFirst();
            if (object == 0 && NUMBER_OF_OBJECTS_FOR_ADD > 0 &&
                    list.size() == NUMBER_OF_OBJECTS_FOR_ADD - 1) {
                printPassed(start);
            } else {
                printFailed();
            }
        } catch (NullPointerException e) {
            printPassed(start);
            printListEmpty();
        }

        System.out.println("---------------------------------------------");
    }

    /**
     * Test verifies the operation of the pollLast() method.
     * It must remove and return the last element in the list.
     * The test checks whether this element is (NUMBER_OF_OBJECTS_FOR_ADD - 1)
     * and whether the size of the list has been reduced
     * Catches NullPointerException if a list is empty
     */
    private void testPollLast() {
        MyLinkedList<Integer> list = createLinkedList();
        System.out.print("Test \"pollLast()\"");
        long start = System.currentTimeMillis();
        Integer object = list.pollLast();
        int valueFromObject = 0;
        //Unboxing Integer
        if (object != null) {
            valueFromObject = object;
        }
        if (object == null && NUMBER_OF_OBJECTS_FOR_ADD <= 0) {
            printPassed(start);
            printListEmpty();
        } else if (valueFromObject == NUMBER_OF_OBJECTS_FOR_ADD - 1 && NUMBER_OF_OBJECTS_FOR_ADD > 0
                && list.size() == NUMBER_OF_OBJECTS_FOR_ADD - 1) {
            printPassed(start);
        } else {
            printFailed();
        }
        System.out.println("---------------------------------------------");
    }

    /**
     * First, the test checks whether the list is empty and displays
     * the warning if it's true.
     * Then the test verifies the operation of the clear() method.
     * It starts this method and then checks the size of the list
     *  if the size is 0, the test is passed
     *
     * @param list collection.MyLinkedList with Integer objects
     */
    private void testClear(MyLinkedList<Integer> list) {
        System.out.print("Test \"clear()\"");
        long start = System.currentTimeMillis();
        if (list.isEmpty()) {
            printPassed(start);
            printListEmpty();
        } else {
            list.clear();
            if (list.isEmpty()) {
                printPassed(start);
            } else {
                printFailed();
            }
        }
        System.out.println("---------------------------------------------");
    }
}
