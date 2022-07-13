package jumptojava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Chapter3 {
    private static double getAverage(List<Integer> list) {
        return list.stream()
                   .mapToInt(a -> a)
                   .average().orElse(0);
    }
    public static void main(String[] args) {
        // Q1. Average score
        List<Integer> list1 = Arrays.asList(80, 75, 55);
        double avg1 = getAverage(list1);
        System.out.println(avg1);
        // Q3. Substring
        String s2 = "881120-1068234";
        String[] resident_reg_num = s2.split("-");
        System.out.println(Arrays.toString(resident_reg_num));
        // Q4. string indexing
        System.out.println(s2.charAt(7));
        // Q5. replace method
        String s5 = "a:b:c:d";
        System.out.println(s5.replace(":", "-"));
        // Q6. Sort in descending order
        ArrayList<Integer> al6 = new ArrayList<>(Arrays.asList(1, 3, 5, 4, 2));
        al6.sort(Comparator.reverseOrder());
        System.out.println(al6); // [5, 4, 3, 2, 1]
    }   
}
