package DAY10.BOJ_11062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11062 {
    static int T, N;
    static int[] cardArr;
    static int[][] dp;
    static boolean turn;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        cardArr = new int[1000];
        dp = new int[1000][1000];
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                cardArr[i] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[i], 0);
            }
            sb.append(dfs(true, 0, N-1) + "\n");
        }
        System.out.print(sb.toString());
    }

    public static int dfs(boolean turn, int left, int right) {
        // turn true -> Alice's turn
        // turn false -> Computer's turn
        if (left > right) { return 0; }
        int ret = dp[left][right];
        if (ret != 0) { return ret; }
        if (turn) {
            ret = Math.max(dfs(!turn, left + 1, right) + cardArr[left],
                            dfs(!turn, left, right - 1) + cardArr[right]);
        } else {
            ret = Math.min(dfs(!turn, left + 1, right),
                            dfs(!turn, left, right - 1));
        }
        return dp[left][right] = ret;
    }
}
