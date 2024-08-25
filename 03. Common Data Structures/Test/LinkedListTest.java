package Test;

import LinkedList.LinkedList;

import java.util.ArrayList;

public class LinkedListTest {
    public static void main(String[] args) {
        // Initialize a LinkedList
        LinkedList linkedList = new LinkedList();

        // Test insertHead method
        linkedList.insertHead(10);
        linkedList.insertHead(20);
        linkedList.insertHead(30);

        // Check values after inserting at head
        ArrayList<Integer> headValues = linkedList.getValues();
        assert headValues.size() == 3 : "Expected size 3 after inserting 3 elements at head";
        assert headValues.get(0) == 30 : "Expected head value 30";
        assert headValues.get(1) == 20 : "Expected second value 20";
        assert headValues.get(2) == 10 : "Expected third value 10";

        System.out.println("Values after inserting at head:");
        printList(headValues);

        // Test insertTail method
        linkedList.insertTail(40);
        linkedList.insertTail(50);

        // Check values after inserting at tail
        ArrayList<Integer> tailValues = linkedList.getValues();
        assert tailValues.size() == 5 : "Expected size 5 after inserting 2 elements at tail";
        assert tailValues.get(3) == 40 : "Expected fourth value 40";
        assert tailValues.get(4) == 50 : "Expected fifth value 50";

        System.out.println("\nValues after inserting at tail:");
        printList(tailValues);

        // Test get method
        int valueAtIndex2 = linkedList.get(2);
        assert valueAtIndex2 == 10 : "Expected value at index 2 to be 10";
        System.out.println("\nValue at index 2: " + valueAtIndex2);

        // Test remove method
        boolean removed = linkedList.remove(1);
        assert removed : "Expected successful removal at index 1";

        // Check values after removal
        ArrayList<Integer> valuesAfterRemoval = linkedList.getValues();
        assert valuesAfterRemoval.size() == 4 : "Expected size 4 after removing 1 element";
        assert valuesAfterRemoval.get(0) == 30 : "Expected head value 30 after removal";
        assert valuesAfterRemoval.get(1) == 10 : "Expected second value 10 after removal";
        assert valuesAfterRemoval.get(2) == 40 : "Expected third value 40 after removal";
        assert valuesAfterRemoval.get(3) == 50 : "Expected fourth value 50 after removal";

        System.out.println("\nValues after removal:");
        printList(valuesAfterRemoval);

        // Test remove at an invalid index
        boolean invalidRemove = linkedList.remove(10);
        assert !invalidRemove : "Expected failure for removal at invalid index";

        // Test get at an invalid index
        try {
            linkedList.get(10);
            assert false : "Expected IndexOutOfBoundsException for invalid index";
        } catch (IndexOutOfBoundsException e) {
            assert true : "Caught expected IndexOutOfBoundsException for invalid index";
        }

        System.out.println("\nAll test cases passed.");
    }

    // Helper method to print the values in the LinkedList
    public static void printList(ArrayList<Integer> values) {
        for (int value : values) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
