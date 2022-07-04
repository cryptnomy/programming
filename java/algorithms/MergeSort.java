package algorithms;

// Time compelxity:
// Worst ... O(n lg n)
// Average ... Theta(n lg n)
// Best ... Omega(n lg n)

public class MergeSort {
    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] arr_left = new int[n1];
        int[] arr_right = new int[n2];

        for (int i = 0; i < n1; ++i) {
            arr_left[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            arr_right[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (arr_left[i] <= arr_right[j]) {
                arr[k] = arr_left[i];
                ++i;
            }
            else {
                arr[k] = arr_right[j];
                ++j;
            }
            ++k;
        }
        while (i < n1) {
            arr[k] = arr_left[i];
            ++i;
            ++k;
        }
        while (j < n2) {
            arr[k] = arr_right[j];
            ++j;
            ++k;
        }
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        MergeSort ob = new MergeSort();
        System.out.print("Original array: ");
        ob.printArray(arr);
        ob.mergeSort(arr, 0, arr.length - 1);
        System.out.print("Sorted array: ");
        ob.printArray(arr);
    }
}
