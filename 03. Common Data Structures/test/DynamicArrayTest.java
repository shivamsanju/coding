package test;

import dynamicarray.ArrayList;

public class DynamicArrayTest {
    public static void main(String[] args) {
        // Create a DynamicArray with initial capacity 3
        ArrayList dynamicArray = new ArrayList(3);

        // Initial size and capacity check
        assert dynamicArray.size == 0 : "Initial size should be 0";
        assert dynamicArray.capacity == 3 : "Initial capacity should be 3";

        // Test push method
        dynamicArray.push(10);
        dynamicArray.push(20);
        dynamicArray.push(30);
        dynamicArray.push(40); // This should trigger the increaseSize() method

        // Test array elements after pushing
        assert dynamicArray.get(0) == 10 : "Expected element at index 0 is 10";
        assert dynamicArray.get(1) == 20 : "Expected element at index 1 is 20";
        assert dynamicArray.get(2) == 30 : "Expected element at index 2 is 30";
        assert dynamicArray.get(3) == 40 : "Expected element at index 3 is 40";

        // Test size and capacity after pushing
        assert dynamicArray.size == 4 : "Expected size after pushing is 4";
        assert dynamicArray.capacity >= 4 : "Expected capacity after pushing is at least 4";

        // Test set method
        dynamicArray.set(2, 50); // Set the third element to 50
        assert dynamicArray.get(2) == 50 : "Expected element at index 2 is 50 after setting";

        // Test pop method
        dynamicArray.pop(); // Remove the last element
        assert dynamicArray.size == 3 : "Expected size after popping is 3";
        assert dynamicArray.get(2) == 50 : "Expected element at index 2 after popping is 50";

        // Test pop on an empty array
        dynamicArray.pop(); // Remove another element
        dynamicArray.pop(); // Remove another element
        dynamicArray.pop(); // Remove the last element, should be empty now
        assert dynamicArray.size == 0 : "Expected size after popping all elements is 0";

        // Test size and capacity after pops
        assert dynamicArray.capacity >= 3 : "Capacity should not decrease after popping all elements";

        // Test index out of bounds handling (negative and out of range)
        try {
            dynamicArray.get(-1);
            assert false : "Expected IndexOutOfBoundsException for negative index";
        } catch (IndexOutOfBoundsException e) {
            assert true;
        }

        try {
            dynamicArray.get(0); // Index 0 should be out of bounds now
            assert false : "Expected IndexOutOfBoundsException for index 0 on an empty array";
        } catch (IndexOutOfBoundsException e) {
            assert true;
        }

        // Ensure the array can handle further insertions after being emptied
        dynamicArray.push(60);
        assert dynamicArray.get(0) == 60 : "Expected element at index 0 is 60 after re-insertion";

        System.out.println("All test cases passed.");
    }
}
