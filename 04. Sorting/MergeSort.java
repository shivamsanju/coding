import java.util.Arrays;

public class MergeSort {

    public static int[] sort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int midIndex = (arr.length + 1) / 2;
        return merge(
                sort(Arrays.copyOfRange(arr, 0, midIndex)),
                sort(Arrays.copyOfRange(arr, midIndex, arr.length))
        );
    }

    public static int[] merge(int[] a, int[] b) {
        int[] mergedArr = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                mergedArr[k] = a[i];
                i++;
            } else {
                mergedArr[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < a.length) {
            mergedArr[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length) {
            mergedArr[k] = b[j];
            j++;
            k++;
        }

        return mergedArr;
    }
}
