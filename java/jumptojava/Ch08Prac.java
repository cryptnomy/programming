package jumptojava;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Ch08Prac {
    public static void main(String[] args) {
        /* Initialize an array with range 1 to n */
        int n = 1000;
        // 1. IntStream.rangeClosed() method
        long startTime1 = System.nanoTime();
        int[] arr1 = rangeClosed(n);
        long endTime1 = System.nanoTime();
        System.out.printf("rangeClosed method %d ns\n", endTime1 - startTime1);
        // 2. IntStream.iterate() method
        long startTime2 = System.nanoTime();
        int[] arr2 = iterate(n);
        long endTime2 = System.nanoTime();
        System.out.printf("iterate method %d ns\n", endTime2 - startTime2);
        // 3. Arrays.setAll() method
        long startTime3 = System.nanoTime();
        int[] arr3 = setAll(n);
        long endTime3 = System.nanoTime();
        System.out.printf("setAll method %d ns\n", endTime3 - startTime3);
        // 4. IntStream.range() method
        long startTime4 = System.nanoTime();
        int[] arr4 = rangeForEach(n);
        long endTime4 = System.nanoTime();
        System.out.printf("rangeForEach method %d ns\n", endTime4 - startTime4);
        // 5. for loop
        long startTime5 = System.nanoTime();
        int[] arr5 = forLoop(n);
        long endTime5= System.nanoTime();
        System.out.printf("forLoop method %d ns\n", endTime5 - startTime5);
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

    static int[] forLoop(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
}
