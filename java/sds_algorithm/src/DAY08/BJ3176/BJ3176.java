package DAY08.BJ3176;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ3176 {
    static int N, M, K = 0;
    static int[] depth;
    static int[][] parent;
    static int[][] minDistance, maxDistance;
    static List<Edge>[] tree;
    static int minD, maxD;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // Find K s.t. 2^K > N
        for (int i = 1; i <= N; i <<= 1) {
            ++K;
        }
        // Initialization
        depth = new int[N+1];
        parent = new int[17][N+1];
        minDistance = new int[17][N+1];
        maxDistance = new int[17][N+1];
        tree = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st;
        int u, v, w;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            tree[u].add(new Edge(v, w));
            tree[v].add(new Edge(u, w));
        }
        // dfs with depth
        dfs(1, 1);
        fillParent();
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            lca(u, v);
            sb.append(minD + " " + maxD + "\n");
        }
        System.out.print(sb.toString());
    }

    public static void dfs(int source, int count) {
        depth[source] = count;
        int len = tree[source].size();
        for (int i = 0; i < len; ++i) {
            Edge edge = (Edge) tree[source].get(i);
            if (depth[edge.dest] == 0) {
                dfs(edge.dest, count + 1);
                parent[0][edge.dest] = source;
                minDistance[0][edge.dest] = edge.cost;
                maxDistance[0][edge.dest] = edge.cost;
            }
        }
        return;
    }

    public static void fillParent() {
        for (int i = 1; i < K; i++) {
            for (int j = 1; j <= N; j++) {
                parent[i][j] = parent[i-1][parent[i-1][j]];
                minDistance[i][j] = Math.min(minDistance[i-1][j], minDistance[i-1][parent[i-1][j]]);
                maxDistance[i][j] = Math.max(maxDistance[i-1][j], maxDistance[i-1][parent[i-1][j]]);
            }
        }
    }

    public static void lca(int u, int v) {  // u ~ deeper or equal depth
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        minD = Integer.MAX_VALUE;
        maxD = -1;
        for (int i = K - 1; i > -1; --i) {
            if (Math.pow(2, i) <= depth[u] - depth[v]) {
                minD = Math.min(minD, minDistance[i][u]);
                maxD = Math.max(maxD, maxDistance[i][u]);
                u = parent[i][u];
            }
        }
        if (u == v) { return; }
        for (int i = K - 1; i > -1; --i) {
            if (parent[i][u] != parent[i][v]) {
                minD = Math.min(minD, Math.min(minDistance[i][u], minDistance[i][v]));
                maxD = Math.max(maxD, Math.max(maxDistance[i][u], maxDistance[i][v]));
                u = parent[i][u];
                v = parent[i][v];
            }
        }
        minD = Math.min(minD, Math.min(minDistance[0][u], minDistance[0][v]));
        maxD = Math.max(maxD, Math.max(maxDistance[0][u], maxDistance[0][v]));

        return;
    }
}

class Edge {
    int dest;   // destination
    int cost;
    
    Edge(int dest, int cost) {
        this.dest = dest;
        this.cost = cost;
    }
}
