package jumptojava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.function.BiFunction;

@FunctionalInterface
interface Calculator2 {
    int sum(int a, int b);
}

public class SampleFunctionalProgramming {
    public static void main(String[] args) {
        // Lambda expressions
        //Calculator2 mc = (int a, int b) -> a + b;
        Calculator2 mc = Integer::sum;
        int result = mc.sum(3, 4);
        System.out.println(result);
        BiFunction<Integer, Integer, Integer> mc2 = (a, b) -> a + b;
        int result2 = mc2.apply(4, 7);
        System.out.println(result2);

        /* Stream */
        int[] data = {5, 6, 4, 2, 3, 1, 1, 2, 2, 4, 8};
        // Without stream
        ArrayList<Integer> dataList = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                dataList.add(data[i]);
            }
        }
        // Deduplication using Set
        HashSet<Integer> dataSet = new HashSet<>(dataList);
        // Set to List
        ArrayList<Integer> distinctList = new ArrayList<>(dataSet);
        // Sort in reverse order
        distinctList.sort(Comparator.reverseOrder());
        // Convert Integer list to integer array
        int[] resultWithoutStream = new int[distinctList.size()];
        for (int i = 0; i < distinctList.size(); i++) {
            resultWithoutStream[i] = distinctList.get(i);
        }
        System.out.println(Arrays.toString(resultWithoutStream));

        // With stream
        int[] resultWithStream = Arrays.stream(data)  // Make IntStream
                        .boxed()  // IntStream -> Stream<Integer>
                        .filter((a) -> a % 2 == 0)  // Filter even numbers
                        .distinct()  // Deduplication
                        .sorted(Comparator.reverseOrder())  // Sort in reverse order
                        .mapToInt(Integer::intValue)  // Stream<Integer> -> IntStream
                        .toArray();  // -> int[]
        System.out.println(Arrays.toString(resultWithStream));
    }
}
