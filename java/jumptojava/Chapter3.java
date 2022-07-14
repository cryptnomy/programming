package jumptojava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Chapter3 {
    enum CoffeeType {
        AMERICANO,
        ICE_AMERICANO,
        CAFE_LATTE
    };
    
    private static double getAverage(List<Integer> list) {
        return list.stream()
                   .mapToInt(a -> a)
                   .average().orElse(0);
    }

    static void printCoffeePrice(CoffeeType type){
        HashMap<CoffeeType, Integer> priceMap = new HashMap<>();
        priceMap.put(CoffeeType.AMERICANO, 3000);
        priceMap.put(CoffeeType.ICE_AMERICANO, 4000);
        priceMap.put(CoffeeType.CAFE_LATTE, 5000);
        int price = priceMap.get(type);
        System.out.print(String.format("Price is %d.", price));
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
        // Q7. list to string
        ArrayList<String> my_list = new ArrayList<>(Arrays.asList("Life", "is", "too", "short"));
        String res7 = String.join(" ", my_list);
        System.out.println(res7);
        // Q8. Remove map element
        HashMap<String, Integer> grade8 = new HashMap<>();
        grade8.put("A", 90);
        grade8.put("B", 80);
        grade8.put("C", 70);
        System.out.println(grade8.remove("B")); // 80
        System.out.println(grade8);  // {A=90, C=70}
        // Q9. Remove duplicate numbers in list
        ArrayList<Integer> numbers9 = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 2, 3, 3, 4, 5, 5));
        System.out.println(numbers9);   // [1, 1, 2, 2, 2, 3, 3, 4, 5, 5]
        HashSet<Integer> temp9 = new HashSet<>(numbers9);
        ArrayList<Integer> res9 = new ArrayList<>(temp9);
        System.out.println(res9);   // [1, 2, 3, 4, 5]
        // Q10. enum
        printCoffeePrice(CoffeeType.AMERICANO);
    }
}
