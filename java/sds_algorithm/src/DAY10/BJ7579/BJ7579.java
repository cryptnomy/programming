package DAY10.BJ7579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ7579 {
    static int N, M;
    static int answer;
    static int[] memoryArr;
    static int[] costArr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        // Initialization
        memoryArr = new int[N];
        costArr = new int[N];
        dp = new int[N][10001];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memoryArr[i] = Integer.parseInt(st1.nextToken());
            costArr[i] = Integer.parseInt(st2.nextToken());
        }
        for (int i = 0; i < N; i++) {
            int memory = memoryArr[i];
            int cost = costArr[i];
            for (int j = 0; j < 10001; j++) {
                if (i == 0) {
                    if (j >= cost) { dp[i][j] = memory; }
                } else {
                    if (j >= cost) { dp[i][j] = Math.max(dp[i-1][j-cost] + memory, dp[i-1][j]); }
                    else { dp[i][j] = dp[i-1][j]; }
                }
                if (dp[i][j] >= M) { answer = Math.min(answer, j); }
            }
        }
        System.out.println(answer);
    }
}