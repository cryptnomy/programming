package jumptojava;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ch08Prac {
    public static void main(String[] args) {
        /* Initialize an array with range 1 to n */
        int n = 100;
        // 1. IntStream.rangeClosed() method
        int[] arr1 = rangeClosed(n);
        // 2. IntStream.iterate() method
        int[] arr2 = iterate(n);
        // 3. Arrays.setAll() method
        int[] arr3 = setAll(n);
        // 4. IntStream.range() method
        int[] arr4 = rangeForEach(n);
    }

    static int[] rangeClosed(int n) {
        return IntStream.rangeClosed(1, n).toArray();
    }

    static int[] iterate(int n) {
        return IntStream.iterate(1, i -> i + 1).limit(n).toArray();
    }

    static int[] setAll(int n) {
        int[] arr = new int[n];
        Arrays.setAll(arr, i -> i + 1);
        return arr;
    }

    static int[] rangeForEach(int n) {
        int[] arr = new int[n];
        IntStream.range(1, n + 1).forEach(val -> arr[val - 1] = val);
        return arr;
    }
}
