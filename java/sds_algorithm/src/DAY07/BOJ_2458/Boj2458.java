package DAY07.BOJ_2458;
/*
 * 키 순서
 * 단방향그래프에서 어떤 노드에 대해, 들어오는 엣지와 나가는 엣지의 수 합이
 * 전체 엣지 수와 같은 노드의 수를 계산. 이때, 들어오는 엣지와 나가는 엣지는 모두
 * 복수 개로 구성될 수 있음.
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj2458 {
    static int V, E; // 단방향그래프의 노드 및 엣지 수
    static List<Integer>[] adj;
    static int[] inCnt; // inCnt는 누적해서 카운트
    static int[] outCnt; // outCnt는 dfs(i) 실행에서 노드 i마다 독립적으로 실행하여 카운트
    static boolean[] visited; // 방문 여부는 dfs(i) for i = 1 to V 할 때마다 초기화

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("programming/java/sds_algorithm/src/DAY07/BOJ_2458/input_boj_2458.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adj = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }

        int u, v;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
        }

        inCnt = new int[V+1];
        outCnt = new int[V+1];
        for (int i = 1; i <= V; i++) {
            visited = new boolean[V+1];
            outCnt[i] = dfs(i) - 1;
        }

        int answer = 0;
        for (int i = 1; i <= V; i++) {
            if (inCnt[i] + outCnt[i] == V - 1) {
                ++answer;
            }
        }
        System.out.println(answer);
    }

    static int dfs(int curr) {
        int outCntCurr = 0;
        for (int next : adj[curr]) {
            if (visited[next]) {
                continue;
            }
            visited[next] = true;
            ++inCnt[next];
            outCntCurr += dfs(next);
        }
        return outCntCurr + 1;
    }
}