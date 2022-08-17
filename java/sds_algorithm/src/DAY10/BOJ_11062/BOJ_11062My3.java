package DAY10.BOJ_11062;

import java.io.*;
import java.util.*;

public class BOJ_11062My3 {
    static int T;
    static int N;
    static int[] cards;
    static int[][] memo;
    static boolean lastTurnByAlice;
    static boolean turnAlice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        cards = new int[1000];
        memo = new int[1000][1000];

        T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            // cards = new int[N];
            // memo = new int[N][N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
            } // 0 ~ N-1
            // for (int[] i : memo) { Arrays.fill(i, 0); }

            lastTurnByAlice = (N % 2 == 1) ? true : false;
            for (int s = N - 1; s > -1; --s) {
                turnAlice = lastTurnByAlice;
                for (int e = s; e < N; ++e) {
            // for (int e = 0; e < N; ++e) {
            //     turnAlice = lastTurnByAlice;
            //     for (int s = e; s > -1; --s) {
                    if (s == e) {
                        memo[s][e] = (turnAlice ? cards[s] : 0);
                    } else {
                        memo[s][e] = (turnAlice) ?
                            Math.max(memo[s+1][e] + cards[s],
                                    memo[s][e-1] + cards[e])
                                                 :
                            Math.min(memo[s+1][e], memo[s][e-1]);
                    }
                    turnAlice = !turnAlice;
                }
            }
            bw.append(memo[0][N-1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
