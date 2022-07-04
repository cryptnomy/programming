import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> report_map = new HashMap<>();
        Map<String, Integer> idx_map = new HashMap<>();

        for (int i = 0; i < id_list.length; ++i) {
            report_map.put(id_list[i], new HashSet<>());
            idx_map.put(id_list[i], i);
        }

        for (String rep: report) {
            String[] fromto = rep.split(" ");
            String fromId = fromto[0];
            String toId = fromto[1];
            report_map.get(toId).add(fromId);
        }

        for (int i = 0; i < id_list.length; ++i) {
            HashSet<String> reporters = report_map.get(id_list[i]);
            if (reporters.size() >= k) {
                for (String repId: reporters)
                    ++answer[idx_map.get(repId)];
            }
        }

        return answer;
    }
}