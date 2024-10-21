package tests;

import collection.MyArrayList;
import collection.MyLinkedList;
import collection.MyQueue;
import collection.MyStack;

/**
 * Constant interface contains the data for operation of the tests of {@link MyArrayList collection.MyArrayList},
 * {@link MyLinkedList collection.MyLinkedList}, {@link MyQueue collection.MyQueue} and {@link MyStack}
 */
public interface ConstantsForTestingCollection {

    /**
     * The number of the elements to add to the test object. If you want to add
     * more elements than 86000000, you must change
     * the amount of virtual memory in
     * VM options in the Idea. I change it to "-Xmx5000m -Xms256m ". Write this in
     * VM options. Otherwise, Idea throws OutOfMemoryError exception
     */
    int NUMBER_OF_OBJECTS_FOR_ADD = 1000000;

    /**
     * The object for adding to the test object
     */
    Integer OBJECT_FOR_OPERATIONS = 10;

    /**
     * The number of objects for other operations, not for adding
     */
    int NUMBER_OF_OBJECTS_FOR_OTHER_OPERATIONS = 1000;

    /**
     * Index for operations using the index
     */
    int INDEX_FOR_OPERATIONS = 100;
}
