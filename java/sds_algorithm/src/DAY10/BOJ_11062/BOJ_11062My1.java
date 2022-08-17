package DAY10.BOJ_11062;

import java.io.*;
import java.util.*;

public class BOJ_11062My1 {
    static int T;
    static int N;
    static int[] cards;
    static int[][] memo;
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
            for (int[] i : memo) { Arrays.fill(i, 0); }

            turnAlice = (N % 2 == 1) ? true : false;
            for (int diagHeight = 0; diagHeight < N; diagHeight++) {
                for (int i = 0; i < N - diagHeight; i++) {
                    // initialization
                    if (diagHeight == 0) {
                        if (turnAlice) { memo[i][i] = cards[i]; }
                        else { memo[i][i] = 0; }
                    } else {
                        if (turnAlice) {
                            memo[i][i+diagHeight] = Math.max(
                                memo[i][i+diagHeight-1] + cards[i+diagHeight],
                                memo[i+1][i+diagHeight] + cards[i]
                            );
                        } else {
                            memo[i][i+diagHeight] = Math.min(
                                memo[i][i+diagHeight-1],
                                memo[i+1][i+diagHeight]
                            );
                        }
                    }
                }
                turnAlice = !turnAlice;
            }
            // for(int[] i : memo) {
            //     bw.append(Arrays.toString(i) + "\n");
            // }
            bw.append(memo[0][N-1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
