// BubbleSort.java
public class BubbleSort {

    /**
     * Sorts an array using the Bubble Sort algorithm.
     * Bubble Sort repeatedly compares adjacent elements
     * and swaps them if they are in the wrong order.
     * 
     * @param arr the integer array to sort
     */
    public static void sort(int[] arr) {
        int n = arr.length;

        System.out.println("\nStarting Bubble Sort...\n");

        // Outer loop: for each pass through the array
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false; // track if any swap happened in this pass
            System.out.println("Pass " + (i + 1) + ":");

            // Inner loop: compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("  Comparing " + arr[j] + " and " + arr[j + 1]);
                if (arr[j] > arr[j + 1]) {
                    // Swap if elements are in the wrong order
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    System.out.println(" → swapped to: " + arr[j] + ", " + arr[j + 1]);
                } else {
                    System.out.println(" → no swap needed");
                }
            }

            // Print array after each pass
            System.out.print("  Array after pass " + (i + 1) + ": ");
            printArray(arr);

            // If no swaps happened, the array is already sorted
            if (!swapped) {
                System.out.println("No swaps in this pass, array is sorted early!");
                break;
            }

            System.out.println(); // extra line for readability
        }

        System.out.println("Bubble Sort completed!");
    }

    /**
     * Prints the elements of the array in one line.
     */
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("Original array:");
        printArray(arr);

        // Call the Bubble Sort function
        sort(arr);

        System.out.println("\nSorted array:");
        printArray(arr);
    }
}
