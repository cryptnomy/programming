package DAY09.BJ14003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ14003 {
    static int N;
    static int[] nums;
    static int num;
    static int[] saveIndex;
    static List<Integer> list;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        saveIndex = new int[N];
        list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
            nums[i] = num;
            if (list.get(list.size() - 1) < num) {
                list.add(num);
                saveIndex[i] = list.size() - 1;
            } else {
                int left = 1;
                int right = list.size() - 1;
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                list.set(right, num);
                saveIndex[i] = right;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.size() - 1 + "\n");

        stack = new Stack<>();
        int compareIndex = list.size() - 1;
        for (int i = N - 1; i > - 1; --i) {
            if (saveIndex[i] == compareIndex) {
                stack.push(nums[i]);
                --compareIndex;
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb.toString());
    }
}
