package jumptojava;

import java.util.ArrayList;
import java.util.Arrays;

public class PracticeStream {
    public static void main(String[] args) {
        ArrayList<String> ls = new ArrayList<String>(Arrays.asList("a", "b", "c"));
        for (String value: ls) {
            if (value == "b") {
                System.out.println("Value: " + value);
            }
        }
        ls.stream()
          .filter("b"::equals)
          .forEach(System.out::println);
    }
}
