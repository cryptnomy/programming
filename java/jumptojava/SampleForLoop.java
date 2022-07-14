package jumptojava;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SampleForLoop {
    public static void main(String[] args) {
        // Double for loop
        for (int i = 2; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.println(String.format("%d x %d = %d", i, j, i*j));
            }
            if (i == 9) break;
            System.out.println();
        }
        // for each
        Integer[] numbers = {1, 2, 3, 4, 5};
        for (Integer number: numbers) {
            System.out.println(number);
        }   // 1\n 2\n 3\n 4\n 5\n
        // Or use join method
        String joined = Arrays.stream(numbers)
                            .map(String::valueOf)
                            .collect(Collectors.joining(" "));
        System.out.println(joined);
    }
}
