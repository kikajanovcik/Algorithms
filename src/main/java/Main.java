
public class Main {

    public static void main (String[] args) {

        //array to sort
        int[] arr = { 9, -5, 0, 11, 1, -2, 7, 3 };
        int n = arr.length;

        //Try out algorithms by uncommenting one of the following methods (:

        //SORTING algorithms
        //insertionSort(arr, n);
        //selectionSort(arr, n);
        //bubbleSort(arr, n);

        //BINARY search
        //System.out.println(binarySearch(arr, n, -5));
        //System.out.println(recursiveBinarySearch(arr, 0, n-1, 1));

        //PRINT array
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
    static void selectionSort(int[] arr, int n) {
        // run (n - 1) times
        for (int i = 0; i < n - 1; i++) {
            // find the minimum element in the unsorted sub-array[i..n-1] and swap it with arr[i]
            int min = i;

            for (int j = i + 1; j < n; j++) {
                // if arr[j] element is less, then it is the new minimum
                if (arr[j] < arr[min]) {
                    min = j; // update index of min element
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

    static void bubbleSort(int[] arr, int n) {
        // run (n - 1) times
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


    /** Binary search
     *
     * Reduces the search space to half at each step
     * Returns the position of target in the arr of size n
     * Array must be sorted beforehand!
     * **/

    static int binarySearch(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;

        // iterate till search space contains at least one element
        while (low <= high) {
            // find the mid value in the search space and compare it with target value

            int mid = (low + high) / 2;

            if (target == arr[mid]) {
                return mid; // target value is found, yay!

            // If target < mid, discard all elements in the right search space including the mid element
            } else if (target < arr[mid]) {
                high = mid - 1;

            // If target > mid, discard all elements in the left search space including the mid element
            } else {
                low = mid + 1;
            }
        }

        // target doesn't exist in the array
        return -1;
    }

    /** Recursive Binary search
     *
     * Returns the position of target in the sub-array arr[low..high]
     * Array must be sorted beforehand!
     */
    static int recursiveBinarySearch(int[] arr, int low, int high, int target) {
        // Base condition
        if (low > high) {
            return -1;
        }

        int mid = (low + high)/2;

        if (target == arr[mid]) {
            return mid; // target value is found, yay!
        } else if (target < arr[mid]) {
            // discard all elements in the right search space, including the mid element
            return recursiveBinarySearch(arr, low, mid - 1, target);
        } else {
            // discard all elements in the left search space, including the mid element
            return recursiveBinarySearch(arr, mid + 1, high, target);
        }
    }
}
