
public class Main {

    public static void main (String[] args) {

        //array to sort
        int[] arr = { 9, -5, 0, 11, 1, -2, 7, 3 };
        int[] aux = { 10, 2, -3, 4 };
        int n = arr.length;

        //Try out algorithms by uncommenting one of the following methods (:

        //SORTING algorithms
        //insertionSort(arr);
        //doInsertionSort(arr);
        //selectionSort(arr);
        //bubbleSort(arr);
        mergeSort(arr, 0, n-1);

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
    public static int[] insertionSort(int[] arr) {
        // Start from second element (element at index 0 is already sorted)
        for (int i = 1; i < arr.length; i++) {
            int valueToSwap = arr[i];
            int j = i;

            // if valueToSwap is less than the number before, swap them
            while (j > 0 && arr[j - 1] > valueToSwap) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = valueToSwap;
        }
        return arr;
    }

    /** same sort but with loops only*/
    public static int[] doInsertionSort(int[] arr){

        int valueToSwap;
        // Start from second element (element at index 0 is already sorted)
        for (int i = 1; i < arr.length; i++) {
            for (int j = i ; j > 0 ; j--) {
                // if valueToSwap is less than the number before, swap them
                if (arr[j] < arr[j-1]) {
                    valueToSwap = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = valueToSwap;
                }
            }
        }
        return arr;
    }

    /** SELECTION SORT on int[] arr
     *
     * Selection sort is a unstable, in-place sorting algorithm known for its simplicity,
     * and it has performance advantages over more complicated algorithms in certain situations,
     * particularly where auxiliary memory is limited.
     */
    public static int[] selectionSort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                // if arr[j] element is less, then it is the new minimum
                if (arr[j] < arr[index]) {
                    index = j; // update index of min element
                }
            // swap minimum element with arr[i]
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }

    /** BUBBLE SORT on int[] arr
     *
     * Bubble sort is a stable, in-place sorting algorithm that is named for the way smaller
     * or larger elements “bubble” to the top of the list. Although the algorithm is simple,
     * it is too slow and impractical for most problems even when compared to insertion sort
     * and is not recommended when n is large.
     */

    static void bubbleSort(int[] arr) {

        int n = arr.length;
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < n - 1 - j; i++) {
                //compare a pair of elements and swap for the lower one if needed
                if (arr[i] > arr[i + 1]) {

                    int next = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = next;
                }
            }
        }
    }

    /**  MERGE SORT on int[] arr
     *
     * Merge sort is an efficient, general-purpose sorting algorithm
     * which produces a stable sort, which means that the implementation
     * preserves the input order of equal elements in the sorted output.
     * Merge sort is a comparison sort, i.e. it can sort items of any type
     * for which a less-than relation is defined.
     *
     * Merge sort first divides a large array into two smaller sub-arrays
     * and then recursively sort the sub-arrays.
     * */

    static void mergeSort(int[] arr, int lowerIndex, int higherIndex) {

        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            mergeSort(arr, lowerIndex, middle);
            // Below step sorts the right side of the array
            mergeSort(arr, middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(arr, lowerIndex, middle, higherIndex);
        }
    }

    static void mergeParts(int[] array, int lowerIndex, int middle, int higherIndex) {
        int[] tempMergArr = new int[higherIndex+1];

        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;

        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
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
