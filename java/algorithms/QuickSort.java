package algorithms;

// Time compelxity:
// Worst ... O(n^2)
// Average ... Theta(n lg n)
// Best ... Omega(n lg n)

public class QuickSort {
    public void quickSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = partition(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    public int partition(int[] arr, int p, int r) {
        int x = arr[r];
        int i = p - 1;
        for (int j = p; j < r; ++j) {
            if (arr[j] <= x) {
                ++i;
                swapArrayValue(arr, i, j);
            }
        }
        ++i;
        swapArrayValue(arr, i, r);
        return i;
    }

    public void swapArrayValue(int[] arr, int i, int j) {
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

        QuickSort ob = new QuickSort();
        
        System.out.println("QuickSort");
        System.out.print("Original array: ");
        ob.printArray(arr);

        System.out.print("Sorted array: ");
        ob.quickSort(arr, 0, arr.length - 1);
        ob.printArray(arr);
    }
}
