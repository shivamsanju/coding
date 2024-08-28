public class InsertionSort {
    public static void sort(int[] arr) {
        int i = 1;

        while (i < arr.length) {
            int elementToBeInserted = arr[i];
            int j = i - 1;

            // Shift elements in the sorted portion to the right to make room for the element to be inserted
            while (j >= 0 && arr[j] > elementToBeInserted) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert the element at its correct position in the sorted portion
            arr[j+1] = elementToBeInserted;
            i++;
        }
    }
}
