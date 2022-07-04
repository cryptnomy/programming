package algorithms;

// Time compelxity:
// Worst ... O(n lg n)
// Average ... Theta(n lg n)
// Best ... Omega(n lg n)

public class HeapSort {
    public void heapSort(int[] arr) {
        int arr_len = arr.length;
        int heap_size = arr_len;
        buildMaxHeap(arr, heap_size);
        for (int i = arr_len - 1; i > 0; --i) {
            swapValue(arr, 0, i);
            --heap_size;
            maxHeapify(arr, heap_size, 0);
        }
    }

    public void maxHeapify(int[] arr, int heap_size, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < heap_size && arr[l] > arr[largest])
            largest = l;
        if (r < heap_size && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            swapValue(arr, largest, i);
            maxHeapify(arr, heap_size, largest);
        }
    }

    public void buildMaxHeap(int[] arr, int heap_size) {
        // reason why we subtract 1 from heap_size/2?
        // ex 1. heap_size = 10 -> heap_size/2 - 1 = 4 (0 to 4; 5 elems)
        // ex 2. heap_size = 9 -> heap_size/2 - 1 = 3 (0 to 3; 4 elems)
        for (int i = heap_size/2 - 1; i > -1; --i) {
            maxHeapify(arr, heap_size, i);
        }
    }

    public static void swapValue(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};

        HeapSort ob = new HeapSort();
        
        System.out.println("Heap Sort");
        System.out.print("Original array: ");
        ob.printArray(arr);

        System.out.print("Sorted array: ");
        ob.heapSort(arr);
        ob.printArray(arr);
    }
}