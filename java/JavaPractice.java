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
    }
}
