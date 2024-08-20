package LinkedList;

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        // Initialize a LinkedList
        LinkedList linkedList = new LinkedList();

        // Test insertHead method
        linkedList.insertHead(10);
        linkedList.insertHead(20);
        linkedList.insertHead(30);

        System.out.println("Values after inserting at head:");
        printList(linkedList.getValues());

        // Test insertTail method
        linkedList.insertTail(40);
        linkedList.insertTail(50);

        System.out.println("\nValues after inserting at tail:");
        printList(linkedList.getValues());

        // Test get method
        int valueAtIndex2 = linkedList.get(2);
        System.out.println("\nValue at index 2: " + valueAtIndex2);

        // Test remove method
        boolean removed = linkedList.remove(1);
        System.out.println("\nValue removed at index 1: " + removed);

        System.out.println("\nValues after removal:");
        printList(linkedList.getValues());
    }

    // Helper method to print the values in the LinkedList
    public static void printList(ArrayList<Integer> values) {
        for (int value : values) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
