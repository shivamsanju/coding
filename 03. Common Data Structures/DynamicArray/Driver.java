package DynamicArray;

public class Driver {
    public static void main(String[] args) {
        // Create a DynamicArray with initial capacity 3
        ArrayList dynamicArray = new ArrayList(3);

        // Test push method
        dynamicArray.push(10);
        dynamicArray.push(20);
        dynamicArray.push(30);
        dynamicArray.push(40); // This should trigger the increaseSize() method

        // Print array elements after pushing
        System.out.println("Array elements after pushing:");
        for (int i = 0; i < 4; i++) {
            System.out.println(dynamicArray.get(i));
        }

        // Test set method
        dynamicArray.set(2, 50); // Set the third element to 50
        System.out.println("\nArray after setting the third element to 50:");
        for (int i = 0; i < 4; i++) {
            System.out.println(dynamicArray.get(i));
        }

        // Test pop method
        dynamicArray.pop(); // Remove the last element
        System.out.println("\nArray after popping the last element:");
        for (int i = 0; i < 3; i++) {
            System.out.println(dynamicArray.get(i));
        }

        // Check the size and capacity
        System.out.println("\nFinal size and capacity:");
        System.out.println("Size: " + dynamicArray.size);
        System.out.println("Capacity: " + dynamicArray.capacity);
    }
}
