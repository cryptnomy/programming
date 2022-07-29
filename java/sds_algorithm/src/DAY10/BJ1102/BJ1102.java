package DAY10.BJ1102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1102 {
    static int N;
    static int[][] map;
    static int[][] dp;
    static int initOn; // bitmask; initially on
    static int P;
    static int MAX = 629;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N+1][1<<16];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i], -1);
        }
        Arrays.fill(dp[N], -1);
        initOn = 0;
        int count = 0;
        String[] onOff = br.readLine().split("");
        for (int i = 0; i < onOff.length; i++) {
            if (onOff[i].equals("Y")) {
                initOn |= (1 << i);
                ++count;
            }
        }
        P = Integer.parseInt(br.readLine());
        int ret = dfs(count, initOn);
        System.out.println(ret == MAX ? -1 : ret);
    }

    static int dfs(int count, int on) {
        if (count >= P) { return 0; }
        if (dp[count][on] != -1) { return dp[count][on]; }
        dp[count][on] = MAX;
        for (int i = 0; i < N; i++) {
            if ((on & (1 << i)) == (1 << i)) {
                for (int j = 0; j < N; j++) {
                    if ((i == j) || (on & (1 << j)) == (1 << j)) { continue; }
                    dp[count][on] = Math.min(dp[count][on],
                                            dfs(count + 1, on | (1 << j)) + map[i][j]);
                }
            }
        }
        return dp[count][on];
    }
}
