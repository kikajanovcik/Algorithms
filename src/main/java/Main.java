
public class Main {

    public static void main (String[] args) {

        //array to sort
        int[] arr = { 3, 8, 5, 4, 1, 9, -2 };
        int n = arr.length;

        insertionSort(arr, n);
        printArray(arr, n);
    }

    /** perform insertion sort on arr[] */
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

    /** Function to print n elements of the array arr */
    static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
