public class OptimizedQuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Get pivot using median-of-three
            int pivotIndex = medianOfThree(arr, low, high);
            swap(arr, pivotIndex, high);

            int[] partition = partition3Way(arr, low, high, arr[high]);

            quickSort(arr, low, partition[0] - 1);          // left part
            quickSort(arr, partition[1] + 1, high);         // right part
            // middle part (equals pivot) is already in place
        }
    }

    // Median of three to choose better pivot
    private static int medianOfThree(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;

        if (arr[low] > arr[mid]) swap(arr, low, mid);
        if (arr[low] > arr[high]) swap(arr, low, high);
        if (arr[mid] > arr[high]) swap(arr, mid, high);

        return mid;  // median is now at mid
    }

    // 3-way partition (handles many duplicates well)
    private static int[] partition3Way(int[] arr, int low, int high, int pivot) {
        int lt = low;
        int gt = high;
        int i = low;

        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt++, i++);
            } else if (arr[i] > pivot) {
                swap(arr, i, gt--);
            } else {
                i++;
            }
        }

        return new int[]{lt, gt};  // [lt, gt] is the equal region
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Optimized Quick Sort - Scenarios ===\n");

        // 1. Random array
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90, 5, 80};
        System.out.print("Before: ");
        printArray(arr1);
        quickSort(arr1, 0, arr1.length - 1);
        System.out.print("After:  ");
        printArray(arr1);

        // 2. Array with many duplicates
        int[] arr2 = {5, 2, 8, 5, 1, 5, 3, 5, 5, 9, 5};
        System.out.print("\nMany duplicates: ");
        printArray(arr2);
        quickSort(arr2, 0, arr2.length - 1);
        System.out.print("After:           ");
        printArray(arr2);

        // 3. Already sorted
        int[] arr3 = {1, 2, 3, 4, 5, 6, 7};
        System.out.print("\nAlready sorted: ");
        printArray(arr3);
        quickSort(arr3, 0, arr3.length - 1);
        System.out.print("After:           ");
        printArray(arr3);

        // 4. Reverse sorted
        int[] arr4 = {50, 40, 30, 20, 10};
        System.out.print("\nReverse: ");
        printArray(arr4);
        quickSort(arr4, 0, arr4.length - 1);
        System.out.print("After:   ");
        printArray(arr4);
    }
}