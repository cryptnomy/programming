package algorithms;

// Time complexity
// Best: O(n)
// Average: O(n^2)
// Worst: O(n^2)

public class InsertionSort {
    public void insertionSort(int arr[]) {
        int len = arr.length;
        int key;
        for (int i = 1; i < len; ++i) {
            key = arr[i];
            int j = i - 1;
            // key보다 큰 arr[j] 뒤로 한 칸씩 밀어내기
            while (j > -1 && arr[j] > key) {
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1] = key;
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
        InsertionSort ob = new InsertionSort();
        int arr[] = {64, 25, 12, 22, 11};
        System.out.println("Insertion Sort");
        System.out.print("Original array: ");
        ob.printArray(arr);
        ob.insertionSort(arr);
        System.out.print("Sorted array: ");
        ob.printArray(arr);
    }
}
