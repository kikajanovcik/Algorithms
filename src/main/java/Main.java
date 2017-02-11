
public class Main {

    public static void main (String[] args) {

        //array to sort
        int[] arr = { 9, -5, 0, 11, 1, -2, 7, 3 };
        int n = arr.length;

        //Try out algorithms by uncommenting of the following methods (:

        //insertionSort(arr, n);
        //selectionSort(arr, n);
        //bubbleSort(arr, n);
        printArray(arr, n);
    }

    /** print n elements of the array arr */
    static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /** INSERTION SORT on int[] arr
     *
     * Insertion sort is stable, in-place sorting algorithm that builds the final sorted array
     * one item at a time. It is not very best in terms of performance but it is more efficient
     * in practice than most other simple O(n2) algorithms such as selection sort or bubble sort.
     */
    static void insertionSort(int[] arr, int n) {
        // Start from second element (element at index 0 is already sorted)
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i;

            // Find the index j within the sorted subset arr[0..i-1] where element arr[i] belongs
            while (j > 0 && arr[j - 1] > value) {
                arr[j] = arr[j - 1];
                j--;
            }
            // subarray arr[j..i-1] is shifted to the right by one position i.e. arr[j+1..i]
            arr[j] = value;
        }
    }

    /** SELECTION SORT on int[] arr
     *
     * Selection sort is a unstable, in-place sorting algorithm known for its simplicity,
     * and it has performance advantages over more complicated algorithms in certain situations,
     * particularly where auxiliary memory is limited.
     */
    static void selectionSort(int arr[], int n) {
        // run (n - 1) times
        for (int i = 0; i < n - 1; i++) {
            // find the minimum element in the unsorted subarray[i..n-1] and swap it with arr[i]
            int min = i;

            for (int j = i + 1; j < n; j++) {
                // if arr[j] element is less, then it is the new minimum
                if (arr[j] < arr[min]) {
                    min = j;    // update index of min element
                }
            }

            // swap the minimum element in subarray[i..n-1] with arr[i]
            int minElement = arr[min];

            arr[min] = arr[i];
            arr[i] = minElement;
        }
    }

    /** BUBBLE SORT on int[] arr
     *
     * Bubble sort is a stable, in-place sorting algorithm that is named for the way smaller
     * or larger elements “bubble” to the top of the list. Although the algorithm is simple,
     * it is too slow and impractical for most problems even when compared to insertion sort
     * and is not recommended when n is large.
     */

    static void bubbleSort(int arr[], int n) {
        // (n - 1) pass
        for (int j = 0; j < n - 1; j++) {
            // last j items are already sorted, so inner loop can avoid looking at the last j items
            // the algorithm can be stopped if the inner loop didn’t do any swap
            for (int i = 0; i < n - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int next = arr[i + 1];

                    arr[i + 1] = arr[i];
                    arr[i] = next;
                }
            }
        }
    }
}
