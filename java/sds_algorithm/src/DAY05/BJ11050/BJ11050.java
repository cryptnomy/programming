package sds_algorithm.src.DAY05.BJ11050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11050 {
    static int N, K;
    static int[][] nCk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nCk = new int[N+1][N+1];
        makeCombination(N, K);

        System.out.println(nCk[N][K]);
    }

    static void makeCombination(int N, int K) {
        nCk[0][0] = nCk[1][0] = nCk[1][1] = 1;
        for (int n = 2; n <= N; n++) {
            nCk[n][0] = 1;
        }
        for (int n = 2; n <= N; n++) {
            for (int k = 1; k <= n; k++) {
                nCk[n][k] = nCk[n - 1][k] + nCk[n - 1][k - 1];
            }
        }
    }
}
