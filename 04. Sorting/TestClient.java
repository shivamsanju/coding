import java.util.Arrays;
import java.util.Random;

public class TestClient {
    private static final int ARRAY_SIZE = 10000; // Size of each array
    private static final int NUM_ARRAYS = 100;  // Number of arrays to sort

    public static void main(String[] args) {
        Random random = new Random();

        // Arrays to store times
        long[] bubbleSortTimes = new long[NUM_ARRAYS];
        long[] insertionSortTimes = new long[NUM_ARRAYS];
        long[] selectionSortTimes = new long[NUM_ARRAYS];
        long[] mergeSortTimes = new long[NUM_ARRAYS];
        long[] heapSortTimes = new long[NUM_ARRAYS];
        long[] stockSortTimes = new long[NUM_ARRAYS];

        // Run sorting algorithms on 100 arrays
        for (int i = 0; i < NUM_ARRAYS; i++) {
            int[] arr = new int[ARRAY_SIZE];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = random.nextInt(10000); // Random integers between 0 and 9999
            }

            // Bubble Sort
            int[] arrForBubbleSort = Arrays.copyOf(arr, arr.length);
            long startTime = System.nanoTime();
            BubbleSort.sort(arrForBubbleSort);
            long endTime = System.nanoTime();
            bubbleSortTimes[i] = endTime - startTime;


            // Selection Sort
            int[] arrForSelectionSort = Arrays.copyOf(arr, arr.length);
            startTime = System.nanoTime();
            SelectionSort.sort(arrForSelectionSort);
            endTime = System.nanoTime();
            selectionSortTimes[i] = endTime - startTime;


            // Insertion Sort
            int[] arrForInsertionSort = Arrays.copyOf(arr, arr.length);
            startTime = System.nanoTime();
            InsertionSort.sort(arrForInsertionSort);
            endTime = System.nanoTime();
            insertionSortTimes[i] = endTime - startTime;


            // Merge Sort
            int[] arrForMergeSort = Arrays.copyOf(arr, arr.length);
            startTime = System.nanoTime();
            int[] sortedArr = MergeSort.sort(arrForMergeSort);
            endTime = System.nanoTime();
            mergeSortTimes[i] = endTime - startTime;


            // Heap Sort
            int[] arrForHeapSort = Arrays.copyOf(arr, arr.length);
            startTime = System.nanoTime();
            HeapSort.sort(arrForHeapSort);
            endTime = System.nanoTime();
            heapSortTimes[i] = endTime - startTime;

            // Stock Sort
            int[] arrForStockSort = Arrays.copyOf(arr, arr.length);
            startTime = System.nanoTime();
            Arrays.sort(arrForStockSort);
            endTime = System.nanoTime();
            stockSortTimes[i] = endTime - startTime;
        }

        // Calculate total and average times
        printPerformance("Bubble Sort", bubbleSortTimes);
        printPerformance("Selection Sort", selectionSortTimes);
        printPerformance("Insertion Sort", insertionSortTimes);
        printPerformance("Merge Sort", mergeSortTimes);
        printPerformance("Heap Sort", heapSortTimes);
        printPerformance("Stock Sort", stockSortTimes);
    }

    private static void printPerformance(String label, long[] times) {
        long totalTime = calculateTotal(times);
        double averageTime = (double) totalTime / times.length;

        System.out.println("\n--------------------------------------------------------------");
        System.out.println(label + ":");
        System.out.println("Total time: " + totalTime / 1_000_000.0 + " milliseconds");
        System.out.println("Average time: " + averageTime / 1_000_000.0 + " milliseconds");
        System.out.println("--------------------------------------------------------------\n");
    }

    private static long calculateTotal(long[] times) {
        long total = 0;
        for (long time : times) {
            total += time;
        }
        return total;
    }
}
