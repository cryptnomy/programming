package jumptojava;

import java.util.Arrays;
import java.util.HashSet;

public class SampleSet {
    public static void main(String[] args) {
        // HashSet<String>
        HashSet<String> set = new HashSet<>(Arrays.asList("H", "e", "l", "l", "o"));
        System.out.println(set);  // [e, H, l, o]
        // HashSet<Integer>
        HashSet<Integer> s1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        HashSet<Integer> s2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));
        System.out.println(s1); // [1, 2, 3, 4, 5, 6]
        System.out.println(s2); // [4, 5, 6, 7, 8, 9]
        // retainAll (intersection)
        HashSet<Integer> intersection = new HashSet<>(s1);
        intersection.retainAll(s2);
        System.out.println(intersection);   // [4, 5, 6]
        // addAll (union)
        HashSet<Integer> union = new HashSet<>(s1);
        union.addAll(s2);
        System.out.println(union);  // [1, 2, 3, 4, 5, 6, 7, 8, 0]
        // removeAll (difference of sets)
        HashSet<Integer> difference = new HashSet<>(s1);
        difference.removeAll(s2);
        System.out.println(difference);
        // add, addAll
        HashSet<String> hs = new HashSet<>();
        hs.add("Jump");
        hs.addAll(Arrays.asList("To", "Java"));
        System.out.println(hs);  // [Java, To, Jump] ascending order of strings
        // remove
        hs.remove("To");
        System.out.println(hs);
    }
}
