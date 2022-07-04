package algorithms;

// Time complexity
// Best: O(n^2)
// Average: O(n^2)
// Worst: O(n^2)

public class SelectionSort {
    public void selectionSort(int arr[]) {
        int len = arr.length;
        int idx_min;
        // 0 ~ len - 1: find minimum and exchange
        // 1 ~ len - 1: find minimum and exchange
        // ...
        for (int i = 0; i < len-1; ++i) {
            idx_min = i;
            for (int j = i + 1; j < len; ++j) {
                if (arr[idx_min] > arr[j])
                    idx_min = j;
            }
            int temp = arr[idx_min];
            arr[idx_min] = arr[i];
            arr[i] = temp;
        }
    }

    public void printArray(int arr[]) {
        int len = arr.length;
        for (int i = 0; i < len; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        SelectionSort ob = new SelectionSort();
        int arr[] = {64, 25, 12, 22, 11};
        System.out.println("Selection Sort");
        System.out.print("Original array: ");
        ob.printArray(arr);
        ob.selectionSort(arr);
        System.out.print("Sorted array: ");
        ob.printArray(arr);
    }
}