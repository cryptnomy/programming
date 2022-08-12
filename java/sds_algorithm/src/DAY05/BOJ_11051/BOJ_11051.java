package DAY05.BOJ_11051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11051 {
    static int N, K;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][N + 1];
        int answer = choose(N, K);
        System.out.println(answer);
    }

    public static int choose(int n, int r) {
        if (r == 0 || n == r) { return 1; }
        if (dp[n][r] != 0) { return dp[n][r]; }
        return dp[n][r] = (choose(n - 1, r) + choose(n - 1, r - 1)) % 10007;
    }
}
