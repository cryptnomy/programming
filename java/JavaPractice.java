import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaPractice {
    public static void main(String[] args) {
        // Map<String, String> map = new HashMap<>();
        // map.put("001", "gildong");
        // map.put("002", "minsu");
        // map.put("001", "hoho");
        // System.out.println(map.size());
        // System.out.println(map.get("001"));
        // Set<String> set = new HashSet<>();
        // set = map.keySet();
        // Iterator<String> iter = set.iterator();
        // while (iter.hasNext()) {
        //     String key = iter.next();
        //     System.out.println("key: " + key + ", value: " + map.get(key));
        // }
        // String temp = "NUM 234245";
        // List<String> list = new ArrayList<>();
        // list.add(temp.substring(0, 3));
        // list.add(temp.substring(4));
        // System.out.println(Arrays.toString(list.toArray()));
        // System.exit(0);

        int N = 16;
        int S = 1;
        for(; (1 << S) < N; S++);
        System.out.println(S);
        
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        System.out.println(Arrays.toString(list.toArray()));
        int temp = list.get(2);
        list.set(2, list.get(3));
        list.set(3, temp);
        System.out.println(Arrays.toString(list.toArray()));
        // below occurs an error
        for (int i = 5; i < 9; i++) {
            list.set(i, i * 2);
        }
        System.out.println(Arrays.toString(list.toArray()));
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
