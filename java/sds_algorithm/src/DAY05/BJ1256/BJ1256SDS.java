package sds_algorithm.src.DAY05.BJ1256;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1256SDS {
    static int N, M, K;
    static int KMAX = 1_000_000_000;
    static int[][] dp = new int[201][201];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K > choose(N + M, M)) { System.out.println(-1); }
        else {
            query(N, M, K);
            System.out.println(sb.toString());
        }
    }

    public static void query(int n, int m, int k) {
        // 단어 끝에 도달
        if (n + m == 0) { return; }
        // z만 남은 경우
        else if (n == 0) {
            sb.append('z');
            query(n, m - 1, k);
        }
        // a만 남은 경우
        else if (m == 0) {
            sb.append('a');
            query(n - 1, m ,k);
        }
        // a,z 둘 다 남은 경우 a를 고를 때 조합 수를 보고 판단
        else {
            int leftCount = choose(n + m - 1, m);
            if (leftCount >= k) {
                sb.append('a');
                query(n - 1, m, k);
            } else {
                sb.append('z');
                query(n, m - 1, k - leftCount);
            }
        }
    }

    public static int choose(int n, int r) {
        if (n == r || r == 0) { return 1; }
        else if (dp[n][r] != 0) { return dp[n][r]; }
        else { return dp[n][r] = Math.min(KMAX, choose(n - 1, r - 1) + choose(n - 1, r)); }
    }
}
