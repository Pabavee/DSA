public class SelectionSort {
    
    /**
     * Main sorting method - Selection Sort
     * @param arr The array to be sorted
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Array is already sorted or empty
        }
        
        for (int i = 0; i < arr.length - 1; i++) {
            // Assume the current position has the minimum element
            int minIndex = i;
            
            // Find the index of the minimum element in the unsorted portion
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Optimization: Only swap if minIndex has changed
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }
    }
    
    /**
     * Alternative: Stable Selection Sort
     * This version maintains relative order of equal elements
     */
    public static void stableSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            
            // Find minimum
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Instead of swapping, shift elements to maintain stability
            int minValue = arr[minIndex];
            while (minIndex > i) {
                arr[minIndex] = arr[minIndex - 1];
                minIndex--;
            }
            arr[i] = minValue;
        }
    }
    
    /**
     * Alternative: Two-way Selection Sort (finds both min and max)
     * Reduces number of passes by half
     */
    public static void twoWaySelectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int minIndex = left;
            int maxIndex = left;
            
            // Find both min and max in current unsorted range
            for (int i = left; i <= right; i++) {
                if (arr[i] < arr[minIndex]) {
                    minIndex = i;
                }
                if (arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
            }
            
            // Place min at left position
            if (minIndex != left) {
                swap(arr, left, minIndex);
                // If max was at left, update its index
                if (maxIndex == left) {
                    maxIndex = minIndex;
                }
            }
            
            // Place max at right position
            if (maxIndex != right) {
                swap(arr, right, maxIndex);
            }
            
            left++;
            right--;
        }
    }
    
    /**
     * Helper method to swap two elements
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /**
     * Test method to demonstrate the algorithm
     */
    public static void main(String[] args) {
        System.out.println("=== Selection Sort Algorithm ===\n");
        
        int[] testArray = {64, 25, 12, 22, 11, 90, 34, 25, 12};
        
        System.out.println("Original Array: ");
        printArray(testArray);
        
        // Test standard selection sort
        int[] standardArray = testArray.clone();
        sort(standardArray);
        System.out.println("\nSorted with Standard Selection Sort: ");
        printArray(standardArray);
        
        // Test stable version
        int[] stableArray = testArray.clone();
        stableSort(stableArray);
        System.out.println("\nSorted with Stable Selection Sort: ");
        printArray(stableArray);
        
        // Test two-way selection sort
        int[] twoWayArray = testArray.clone();
        twoWaySelectionSort(twoWayArray);
        System.out.println("\nSorted with Two-way Selection Sort: ");
        printArray(twoWayArray);

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