package tests;

import collection.MyArrayList;
import collection.MyLinkedList;
import collection.MyQueue;
import collection.MyStack;

import java.util.Scanner;

/**
 * Class Test is designed for testing of classes {@link MyArrayList collection.MyArrayList}, {@link MyLinkedList collection.MyLinkedList},
 * {@link MyStack collection.MyStack} and {@link MyQueue collection.MyQueue }.
 * It prompts the user to select the class to test and start the test
 */
public class StartTesting {

    /**
     * Method main starts the program. It shows which classes the user can check and runs
     * the method selectTheTest() to select the test
     *
     * @param args is not used
     */
    public static void main(String[] args) {
        System.out.println("""
                THE FOLLOWING CLASSES ARE AVAILABLE FOR TESTING:
                \u001B[32m1. MyArrayList
                2. MyLinkedList
                3. MyQueue
                4. MyStack\u001B[0m""");
        selectTheTest();
    }

    /**
     * Prompts the user to select the class to test. User must enter class number.
     * Then method scans the user input and runs runTheTest()
     */
    private static void selectTheTest() {
        System.out.println("ENTER THE CLASS NUMBER TO START THE TESTING: ");
        Scanner input = new Scanner(System.in);
        String className = input.nextLine();
        runTheTest(className);
    }

    /**
     * Method selects the test using user input and runs the test. If the user has entered
     * something else, it asks to enter the number again
     *
     * @param className the string with user input
     */
    private static void runTheTest(String className) {
        switch (className) {
            case "1" -> new TestForMyArrayList();
            case "2" -> new TestForMyLinkedList();
            case "3" -> new TestForMyQueue();
            case "4" -> new TestForMyStack();
            default -> {
                System.out.println("\u001B[31mWrong input!!!\u001B[0m");
                System.out.println("Enter the number:");
                selectTheTest();
            }
        }
        selectTheTest();
    }

}