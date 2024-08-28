public class SelectionSort {
    public static void sort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int smallestElementIndex = i;

            // Find the smallest element in the unsorted portion of the array
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[smallestElementIndex]) {
                    smallestElementIndex = j; // Update the index of the smallest element
                }
            }

            swap(arr, i, smallestElementIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
