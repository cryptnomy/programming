package DAY08.BJ1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1932 {
    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N][];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dp[i] = new int[i+1];
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = N - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                dp[i-1][j] += Math.max(dp[i][j], dp[i][j+1]);
            }
        }

        System.out.println(dp[0][0]);
    }
}
