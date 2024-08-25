package test;

import heap.MaxHeap;

public class MaxHeapTest {
    public static void main(String[] args) {
        // Initialize a MaxHeap with a capacity of 5
        MaxHeap maxHeap = new MaxHeap(5);

        // Test 1: Check if the heap is initially empty
        assert maxHeap.isEmpty() : "Heap should be empty initially";

        // Test 2: Test push operation and verify the heap's state
        maxHeap.push(10);
        maxHeap.push(20);
        maxHeap.push(5);
        maxHeap.push(30);
        maxHeap.push(15);

        assert maxHeap.getSize() == 5 : "Heap size should be 5 after pushing 5 elements";
        assert maxHeap.peek() == 30 : "Top element should be 30";

        // Test 3: Test peek operation
        int topValue = maxHeap.peek();
        assert topValue == 30 : "Peek should return 30";
        assert maxHeap.getSize() == 5 : "Heap size should remain 5 after peek";

        // Test 4: Test pop operation and verify the heap's state
        int poppedValue = maxHeap.pop();
        assert poppedValue == 30 : "Popped value should be 30";
        assert maxHeap.getSize() == 4 : "Heap size should be 4 after one pop";
        assert maxHeap.peek() == 20 : "New top element should be 20 after pop";

        // Test 5: Test popping all elements
        maxHeap.pop();
        maxHeap.pop();
        maxHeap.pop();
        maxHeap.pop();

        assert maxHeap.isEmpty() : "Heap should be empty after popping all elements";

        // Test 6: Test pushing after heap is empty
        maxHeap.push(25);
        assert maxHeap.peek() == 25 : "Top element should be 25 after pushing 25";

        // Test 7: Test pushing to a full heap (expect exception)
        maxHeap.push(30);
        maxHeap.push(35);
        maxHeap.push(40);
        maxHeap.push(45); // Heap is full now

        boolean exceptionThrown = false;
        try {
            maxHeap.push(50);
        } catch (IllegalStateException e) {
            exceptionThrown = true;
        }
        assert exceptionThrown : "Pushing to a full heap should throw an exception";

        System.out.println("All test cases passed.");
    }
}
