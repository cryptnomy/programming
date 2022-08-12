package DAY07.BOJ_11266;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_11266 {
    static int N, M;
    static List<Integer>[] adj;
    static int[] index;
    static boolean[] bp;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // |V|
        M = Integer.parseInt(st.nextToken());  // |E|
        adj = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        index = new int[N+1];
        bp = new boolean[N+1];
        
        int u, v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            if (index[i] == 0) {
                dfs(i, true);
            }
        }

        StringBuilder sb = new StringBuilder();
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (bp[i]) {
                ++answer;
                sb.append(i).append(" ");
            }
        }
        System.out.println(answer);
        System.out.println(sb.toString());
    }

    private static int dfs(int node, boolean isRoot) {
        index[node] = ++count;
        int ret = index[node];
        int child = 0;
        for (int i = 0; i < adj[node].size(); i++) {
            if (index[adj[node].get(i)] == 0) {
                ++child;
                int low = dfs(adj[node].get(i), false);
                ret = Math.min(ret, low);
                if (!isRoot && low >= index[node]) {
                    bp[node] = true;
                }
            } else {
                ret = Math.min(ret, index[adj[node].get(i)]);
            }
        }
        if (isRoot && child >= 2) { bp[node] = true; }
        return ret;
    }
}
