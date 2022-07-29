package DAY09.BJ2098;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2098 {
    static int N;
    static int fullyVisted; // bitmask
    static int INF = 16_000_001;  // N \in [2, 16], matrix elem max = 1,000,000
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        fullyVisted = (1 << N) - 1;
        StringTokenizer st;
        map = new int[N][N];
        dp = new int[N][fullyVisted];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(dfs(0, 1));
    }

    public static int dfs(int start, int visited) {
        if (visited == fullyVisted) { return map[start][0] == 0 ? INF : map[start][0]; }
        if (dp[start][visited] != -1) { return dp[start][visited]; }
        dp[start][visited] = INF;
        for (int i = 0; i < N; i++) {
            int next = 1 << i;
            if (map[start][i] == 0 || (visited & next) != 0) { continue; }
            dp[start][visited] = Math.min(dp[start][visited], dfs(i, next|visited) + map[start][i]);
        }
        return dp[start][visited];
    }
}
