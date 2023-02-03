package DAY06.BOJ_11438;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * LCA 2
 * V \in [2, 100_000]
 * E \in [1, 100_000]
 * 트리 = (V, E)
 * 두 노드가 주어질 때, 가장 가까운 조상 구하기
 */
public class Boj11438 {
    static int V; // 트리의 노드 수
    static int M; // 커맨드 라인 수
    static List<Integer>[] adj; // 인접리스트
    static boolean[] visited;
    static int[] depth; // 각 노드의 depth (one-based counting)
    static int h;
    static int[][] dp;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("programming/java/sds_algorithm/src/DAY06/BOJ_11438/input_boj_11438.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        V = Integer.parseInt(br.readLine()); // 트리 노드 수
        
        // 인접리스트 초기화
        adj = new ArrayList[V+1];
        for (int i = 0; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        // 인접리스트 업데이트, (V-1) 개의 엣지
        int u, v;
        for (int i = 1; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }
        // System.out.println(Arrays.deepToString(adj));

        // bfs 노드 순회를 위해 q 선언
        q = new LinkedList<>();
        // 각 노드를 정확히 1회만 방문하도록 visited 선언
        visited = new boolean[V+1];
        // 노드 방문 시 깊이 기록을 위해 depth 선언
        depth = new int[V+1];
        // dp[i][j] := 노드 j의 2^i번째 parent
        h = 1;
        while (V >= (1 << h)) {
            ++h;
        }
        dp = new int[h][V+1];

        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i = 0; i < adj[curr].size(); i++) {
                int next = adj[curr].get(i);
                if (visited[next]) {
                    continue;
                }
                // next 방문 체크 후,
                // - next의 2^0번째 parent로 curr 기록
                // - next의 깊이 기록
                // q에 추가
                visited[next] = true;
                dp[0][next] = curr;
                depth[next] = depth[curr] + 1;
                q.add(next);
            }
        }

        // dp 관계식
        for (int i = 1; i <= h - 1; i++) {
            for (int j = 1; j <= V; j++) {
                dp[i][j] = dp[i-1][dp[i-1][j]];
            }
        }

        M = Integer.parseInt(br.readLine()); // 트리 엣지 수
        // M개의 노드쌍에 대해 최소공통조상 구하기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            sb.append(lca(u, v) + "\n");
        }
        System.out.print(sb);
    }

    // lca: least common ancestor
    static int lca(int u, int v) {
        // depth 기준 정렬 - u, v 오름차순
        if (depth[u] > depth[v]) {
            int tmp = v;
            v = u;
            u = tmp;
        }
        // 두 노드의 depth 차이가 0이 되도록 u의 parent를 찾음
        int gap = depth[v] - depth[u];
        for (int i = 0; i < h; i++) {
            if ((gap & (1 << i)) > 0) {
                v = dp[i][v];
            }
        }
        if (u == v) {
            return u;
        }
        for (int i = h - 1; i > -1; i--) {
            if (dp[i][u] != dp[i][v]) {
                u = dp[i][u];
                v = dp[i][v];
            }
        }
        return dp[0][u];
    }
}
