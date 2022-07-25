package DAY06.BJ11438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ11438 {
    static int N, M;
    static int K;
    static int[] depth;
    static int[][] parent;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        // S s.t. N < 2^S
        K = 0;
        for (int i = 1; i <= N; i <<= 1) {
            ++K;
        }

        depth = new int[N + 1];
        parent = new int[K][N + 1];

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<Integer>();
        }
        int a, b;
        StringTokenizer st;
        for (int i = 1; i <= N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1, 1);
        fillParent();

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int i, int count) {
        depth[i] = count;
        int length = tree[i].size();
        for (int j = 0; j < length; j++) {
            int next = (Integer) tree[i].get(j);
            if (depth[next] == 0) {
                dfs(next, count + 1);
                parent[0][next] = i;
            }
        }
        return;
    }

    static void fillParent() {
        for (int i = 1; i < K; i++) {
            for (int j = 1; j <= N; j++) {
                parent[i][j] = parent[i - 1][parent[i - 1][j]];
            }
        }
    }

    static int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        for (int i = K - 1; i > -1; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                a = parent[i][a];
            }
        }
        if (a == b) { return a; }
        for (int i = K - 1; i > -1; i--) {
            if (parent[i][a] != parent[i][b]) {
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        return parent[0][a];
    }
}
