import java.util.*;

public class JavaPractice {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("001", "gildong");
        map.put("002", "minsu");
        map.put("001", "hoho");
        System.out.println(map.size());
        System.out.println(map.get("001"));
        Set<String> set = new HashSet<>();
        set = map.keySet();
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println("key: " + key + ", value: " + map.get(key));
        }
    }
}
