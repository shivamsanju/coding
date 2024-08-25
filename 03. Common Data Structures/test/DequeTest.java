package test;

import deque.Deque;

public class DequeTest {
    public static void main(String[] args) {
        // Test Case 1: Basic operations with a small capacity
        System.out.println("Test Case 1: Basic operations with a small capacity");
        Deque<Integer> deque = new Deque<Integer>(3);
        assert deque.isEmpty() : "Expected deque to be empty";
        assert !deque.isFull() : "Expected deque to be not full";

        deque.insertFront(1);
        deque.insertFront(2);
        deque.insertLast(3);
        deque.insertLast(4); // Should trigger capacity doubling

        assert deque.removeFront() == 2 : "Expected 2 from removeFront()";
        assert deque.removeLast() == 4 : "Expected 4 from removeLast()";

        assert !deque.isEmpty() : "Expected deque to be not empty";
        assert !deque.isFull() : "Expected deque to be not full";
        assert deque.removeFront() == 1 : "Expected 1 from removeFront()";
        assert deque.removeLast() == 3 : "Expected 3 from removeLast()";
        assert deque.isEmpty() : "Expected deque to be empty";

        // Test Case 2: Edge case with capacity doubling
        System.out.println("\nTest Case 2: Edge case with capacity doubling");
        Deque<Integer> deque2 = new Deque<Integer>(2);
        deque2.insertFront(10);
        deque2.insertFront(20);
        deque2.insertLast(30); // Should trigger capacity doubling

        assert deque2.removeFront() == 20 : "Expected 20 from removeFront()";
        assert deque2.removeLast() == 30 : "Expected 30 from removeLast()";
        assert deque2.removeFront() == 10 : "Expected 10 from removeFront()";

        // Test Case 3: Remove operations on an empty deque
        System.out.println("\nTest Case 3: Remove operations on an empty deque");
        Deque<String> deque3 = new Deque<String>(5);
        assert deque3.removeFront() == null : "Expected null from removeFront()";
        assert deque3.removeLast() == null : "Expected null from removeLast()";

        // Test Case 4: Insert operations when deque is full
        System.out.println("\nTest Case 4: Insert operations when deque is full");
        Deque<Integer> deque4 = new Deque<Integer>(4);
        deque4.insertFront(1);
        deque4.insertFront(2);
        deque4.insertLast(3);
        deque4.insertLast(4); // Full

        assert deque4.isFull() : "Expected deque to be full";
        deque4.insertFront(5); // Should trigger capacity doubling
        assert deque4.removeFront() == 5 : "Expected 5 from removeFront()";
        assert deque4.removeLast() == 4 : "Expected 4 from removeLast()";

        // Test Case 5: Large capacity and many operations
        System.out.println("\nTest Case 5: Large capacity and many operations");
        Deque<Integer> deque5 = new Deque<Integer>(100);
        for (int i = 0; i < 100; i++) {
            deque5.insertLast(i);
        }

        assert deque5.isFull() : "Expected deque to be full";
        for (int i = 0; i < 50; i++) {
            assert deque5.removeFront() == i : "Expected " + i + " from removeFront()";
        }
        for (int i = 100; i < 150; i++) {
            deque5.insertLast(i);
        }

        assert deque5.isFull() : "Expected deque to be full";
        int expectedValue = 50;
        while (!deque5.isEmpty()) {
            Integer x = deque5.removeFront();
            assert x == expectedValue++ : "Expected " + (expectedValue - 1) + " from removeFront()";
        }

        // Test Case 6: Insert and remove from an empty deque with increased capacity
        System.out.println("\nTest Case 6: Insert and remove from an empty deque with increased capacity");
        Deque<Integer> deque6 = new Deque<Integer>(1);
        deque6.insertFront(1);
        assert deque6.removeFront() == 1 : "Expected 1 from removeFront()";

        // Ensure deque can still handle insertions and removals
        deque6.insertLast(2);
        assert deque6.removeLast() == 2 : "Expected 2 from removeLast()";

        System.out.println("All test cases passed.");
    }
}
