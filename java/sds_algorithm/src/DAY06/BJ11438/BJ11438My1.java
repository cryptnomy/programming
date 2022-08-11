package DAY06.BJ11438;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ11438My1 {
    static int V, E;
    static List<List<Integer>> adj;
    static Queue<Integer> q;
    static boolean[] visited;
    static int[][] dp;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        visited = new boolean[V+1];
        dp = new int[18][V+1]; // 2^17 = 131_072 > 100_000
        depth = new int[V+1];
        
        int u, v;
        for (int i = 1; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : adj.get(curr)) {
                if (!visited[next]) {
                    visited[next] = true;
                    dp[0][next] = curr;
                    depth[next] = depth[curr] + 1;
                    q.add(next);
                }
            }
        }

        for (int i = 1; i < 18; i++) {
            for (int j = 1; j <= V; j++) {
                dp[i][j] = dp[i-1][dp[i-1][j]];
            }
        }

        E = Integer.parseInt(br.readLine());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            bw.append(String.valueOf(lca(u, v))).append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int lca(int a, int b) {
        if (depth[a] > depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        int diff = depth[b] - depth[a];
        for (int i = 0; i < 18; i++) {
            if ((diff & (1<<i)) != 0) {
                b = dp[i][b];
            }
        }
        if (a == b) { return a; }
        for (int i = 17; i > -1; --i) {
            if (dp[i][a] != dp[i][b]) {
                a = dp[i][a];
                b = dp[i][b];
            }
        }
        return dp[0][a];
    }
}
