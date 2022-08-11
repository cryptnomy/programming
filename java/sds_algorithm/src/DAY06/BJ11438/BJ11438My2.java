package DAY06.BJ11438;

import java.io.*;
import java.util.*;

public class BJ11438My2 {
    static int V, E;
    static List<Integer>[] adj;
    static Queue<Integer> q;
    static boolean[] visited;
    static int[][] dp;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        adj = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[V+1];
        dp = new int[18][V+1];
        depth = new int[V+1];

        int u, v;
        for (int i = 1; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }

        q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : adj[curr]) {
                if (!visited[next]) {
                    dp[0][next] = curr;
                    depth[next] = depth[curr] + 1;
                    visited[next] = true;
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

        int gap = depth[b] - depth[a];
        for (int i = 0; i < 18; i++) {
            if ((gap & (1 << i)) != 0) {
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
