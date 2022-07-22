package sds_algorithm.src.DAY05.BJ1256;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1256My {
    static int N, M, K;
    static int[][] triPascal;
    static int triLength;
    static char[] word;
    static int KMAX = 1_000_000_001;    // about 1B

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        triLength = N + M + 1;
        triPascal = new int[triLength][triLength];
        makePascal(N, M);

        System.out.println(triPascal[N][M]);

        int r = N + M;
        int c = M;
        word = new char[N + M];
        for (int i = 0; i < N + M; i++) {
            if (K > triPascal[r][c]) {
                System.out.println(-1);
                return;
            } else {
                if (K > triPascal[r-1][c-1]) {
                    word[i] = 'a';
                    r--;
                    c--;
                } else {
                    word[i] = 'z';
                    r--;
                }
            }
        }
    }

    static void makePascal(int N, int M) {
        for (int i = 0; i < triLength; i++) {
            triPascal[i][i] = 1;
            for (int j = 0; j < i; j++) {
                if (j == 0) { triPascal[i][j] = 1; }
                else {
                    triPascal[i][j] = triPascal[i - 1][j - 1] + triPascal[i - 1][j];
                }
            }
        }
    }
}
