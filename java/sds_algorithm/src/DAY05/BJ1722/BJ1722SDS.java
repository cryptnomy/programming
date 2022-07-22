package sds_algorithm.src.DAY05.BJ1722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1722SDS {
    static int N;
    static boolean[] visited;
    static long[] fact;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // Factorial hashing
        fact = new long[N + 1];
        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = fact[i - 1] * i;
        }
        // visited
        visited = new boolean[N + 1];
        // First input of the second line, command
        StringTokenizer st = new StringTokenizer(br.readLine());
        int command = Integer.parseInt(st.nextToken());
        if (command == 1) {
            long target = Long.parseLong(st.nextToken());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (visited[j] == true) { continue; }
                    if (target > fact[N - 1 - i]) {
                        target -= fact[N - 1 - i];
                    } else {
                        sb.append(j).append(" ");
                        visited[j] = true;
                        break;
                    }
                }
            }
            System.out.println(sb.toString());
        } else if (command == 2) {
            nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            long result = 0;
            
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < nums[i]; j++) {
                    if (visited[j] == false) {
                        result += fact[N - 1 - i];
                    }
                }
                visited[nums[i]] = true;
            }
            System.out.println(result + 1);
        }
    }
}
