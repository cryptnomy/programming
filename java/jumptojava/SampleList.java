package jumptojava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SampleList {
    public static void main(String[] args) {
        // Mr. Park throws pitches three times with
        // moving speed of 138, 129, and, 142 km/h, respectively
        // add
        ArrayList<Object> pitches = new ArrayList<>();
        // ArrayList members type ~ Object (not string or int)
        pitches.add("138");
        pitches.add(129);
        pitches.add("142");
        // get
        System.out.println(pitches.get(1));
        // size
        System.out.println(pitches.size());
        // contains
        System.out.println(pitches.contains("142"));
        // remove
        System.out.println(pitches.remove("129"));
        // IndexOutOfBoundsException error occurs
        // System.out.println(pitches.remove(129));
        System.out.println(pitches.remove(0));
        // Generics
        ArrayList<String> pitches2 = new ArrayList<>();
        pitches2.add("138");
        pitches2.add("129");
        System.out.println(pitches2);
        // Arrays
        String[] data = {"138", "129", "142"};
        ArrayList<String> pitches3 = new ArrayList<>(Arrays.asList(data));
        System.out.println(pitches3);
        ArrayList<String> pitches4 = new ArrayList<>(Arrays.asList("138", "129", "142"));
        System.out.println(pitches4);
        // String.join
        String result4 = String.join(", ", pitches4);
        System.out.println(result4);
        // Compartor class
        // sort ascending order cf. descending ~ reverseOrder()
        pitches4.sort(Comparator.naturalOrder());
        System.out.println(pitches4);
    }
}
