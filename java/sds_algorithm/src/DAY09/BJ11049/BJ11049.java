package DAY09.BJ11049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11049 {
    static int N;
    static int[] nums;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N+1];
        dp = new int[N][N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums[0] = Integer.parseInt(st.nextToken());
        nums[1] = Integer.parseInt(st.nextToken()); 
        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            Integer.parseInt(st.nextToken());
            nums[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(Arrays.toString(nums));
        // // dp[s][e] = min(dp[s][k] + dp[k+1][e] + nums[s]nums[k+1]nums[e+1])
        // // s = j, e = j + i - 1
        // for (int i = 2; i <= N; i++) {
        //     for (int j = 0; j <= N - i; j++) {
        //         dp[j][j+i-1] = Integer.MAX_VALUE;
        //         for (int k = j; k < j + i - 1; k++) {
        //             dp[j][j+i-1] = Math.min(dp[j][j+i-1],
        //                             dp[j][k] + dp[k+1][j+i-1] + nums[j]*nums[k+1]*nums[j+i]);
        //         }
        //     }
        // }
        for (int diff = 1; diff < N; diff++) {
            for (int i = 0; i < N - diff; i++) {
                int j = i + diff;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + nums[i]*nums[k+1]*nums[j+1]);
                }
            }
        }
        System.out.println(dp[0][N-1]);
    }
}
/*
 * n = 0: i \in [0, N), j \in [i, N), i != j
 * n = 1: i \in [0, N-1), j \in [i+1, N), i != j
 * n = 2: i \in [0, N-2), j \in [i+2, N), i != j
 */

