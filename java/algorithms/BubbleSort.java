package algorithms;

// Time complexity
// Best: O(n) ... why?
// break out of function using the variable, swapped
// Average: O(n^2)
// Worst: O(n^2)

public class BubbleSort {
    public void bubbleSort(int arr[]) {
        int n = arr.length;
        boolean swapped;
        // i, j ... two variables
        // i range ... [0, 1, 2, ...,  n-2]
        // j range ... [n-1, n-2, ..., i+1]
        // forwarding smaller number
        // if j ranges in [i+1, ..., n-1], backwarding larger number
        for (int i = 0; i < n-1; ++i) {
            swapped = false;
            for (int j = n-1; j > i; --j) {
                // left > right
                // larger left to right
                // rightmost ... largest
                if (arr[j-1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
                if (swapped == false)
                    break;
            }
        }
    }

    public void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        BubbleSort ob = new BubbleSort();
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Bubble Sort");
        System.out.print("Original array: ");
        ob.printArray(arr);
        ob.bubbleSort(arr);
        System.out.print("Sorted array: ");
        ob.printArray(arr);
    }
}
