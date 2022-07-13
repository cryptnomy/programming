package jumptojava;

import java.util.HashMap;

public class SampleMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("people", "사람");
        map.put("baseball", "야구");
        // get, getOrDefault
        System.out.println(map.get("people"));  // 사람
        System.out.println(map.get("java"));    // null
        System.out.println(map.getOrDefault("java", "자바"));   // 자바
        // containsKey
        System.out.println(map.containsKey("people"));  // true
        // remove
        System.out.println(map.remove("people"));   // 사람
        map.put("people", "사람");
        // size
        System.out.println(map.size());     // 2
        // keySet
        System.out.println(map.keySet());   // [baseball, people]
    }
}
