public class OptimizedInsertionSort {
    
    /**
     * Main sorting method - Optimized Insertion Sort
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Array is already sorted or empty
        }
        
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            
            // Find position to insert using binary search (Optimization)
            int insertPos = findInsertionPosition(arr, current, 0, i - 1);
            
            // Shift elements to make space
            shiftElements(arr, insertPos, i - 1);
            
            // Insert the current element at correct position
            arr[insertPos] = current;
        }
    }
    
    /**
     * Binary search to find insertion position (Optimization)
     * @param arr The array being sorted
     * @param key The element to insert
     * @param low Lower bound of search range
     * @param high Upper bound of search range
     * @return The insertion position
     */
    private static int findInsertionPosition(int[] arr, int key, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (key == arr[mid]) {
                // For stability, insert after equal elements
                return mid + 1;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    private static void shiftElements(int[] arr, int start, int end) {
        if (end >= start) {
            System.arraycopy(arr, start, arr, start + 1, end - start + 1);
        }
    }
    
    /**
     * Alternative implementation using standard insertion sort for comparison
     * This shows the difference between optimized and standard versions
     */
    public static void standardInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // Linear search for insertion point (O(n) comparisons)
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    /**
     * Test method to demonstrate the algorithm
     */
    public static void main(String[] args) {
        System.out.println("=== Optimized Insertion Sort Algorithm ===\n");
        
        int[] testArray = {64, 34, 25, 12, 22, 11, 90, 45, 33, 18};
        
        System.out.println("Original Array: ");
        printArray(testArray);
        
        // Create a copy for comparison
        int[] standardArray = testArray.clone();
        
        // Test optimized version
        sort(testArray);
        System.out.println("\nSorted with Optimized Insertion Sort: ");
        printArray(testArray);
        
        // Test standard version for comparison
        standardInsertionSort(standardArray);
        System.out.println("\nSorted with Standard Insertion Sort: ");
        printArray(standardArray);
        
        // Performance comparison
        System.out.println("\n=== Performance Analysis ===");
        System.out.println("Optimization: Binary search reduces comparisons from O(n) to O(log n)");
        System.out.println("Best for: Small arrays or nearly sorted arrays");
        System.out.println("Stability: Maintains relative order of equal elements");
    }
    
    /**
     * Utility method to print array
     */
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}