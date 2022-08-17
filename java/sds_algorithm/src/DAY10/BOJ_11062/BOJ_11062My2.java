package DAY10.BOJ_11062;

import java.io.*;
import java.util.*;

public class BOJ_11062My2 {
    static int T;
    static int N;
    static int[] cards;
    static int[][][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        cards = new int[1000];
        memo = new int[2][1000][1000];

        T = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            // cards = new int[N];
            // memo = new int[2][N][N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
            }
            // for (int i = 0; i < 2; ++i) {
            //     for (int[] j : memo[i]) { Arrays.fill(j, 0); }
            // }

            for (int diagHeight = 0; diagHeight < N; diagHeight++) {
                for (int i = 0; i < N - diagHeight; i++) {
                    for (int turnAlice = 0; turnAlice < 2; turnAlice++) {
                        if (diagHeight == 0) {
                            memo[turnAlice][i][i+diagHeight] = (turnAlice == 1 ? cards[i] : 0);
                            continue;
                        }
                        if (turnAlice == 1) {
                            memo[turnAlice][i][i+diagHeight] = Math.max(
                                memo[0][i][i+diagHeight-1] + cards[i+diagHeight],
                                memo[0][i+1][i+diagHeight] + cards[i]
                            );
                        } else {
                            memo[turnAlice][i][i+diagHeight] = Math.min(
                                memo[1][i][i+diagHeight-1],
                                memo[1][i+1][i+diagHeight]
                            );
                        }
                    }
                }
            }
            // for(int[] i : memo) {
            //     bw.append(Arrays.toString(i) + "\n");
            // }
            bw.append(memo[1][0][N-1] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
