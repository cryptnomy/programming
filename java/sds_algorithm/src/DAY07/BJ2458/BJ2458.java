package DAY07.BJ2458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2458 {
    static int N, M;
    static boolean[][] adj;
    static boolean[] visited;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new boolean[N+1][N+1];
        int u, v;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            adj[u][v] = true;
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (bfs(i)) { ++result; }
        }

        System.out.println(result);
    }

    static boolean bfs(int index) {
        queue = new LinkedList<>();
        int num = 0;

        visited = new boolean[N+1];
        queue.offer(index);
        visited[index] = true;

        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j = 1; j <= N; j++) {
                if (adj[i][j] && !visited[j]) {
                    queue.add(j);
                    visited[j] = true;
                    ++num;
                }
            }
        }

        visited = new boolean[N+1];
        queue.offer(index);
        while(!queue.isEmpty()) {
            int i = queue.poll();
            for (int j = 1; j <= N; j++) {
                if (adj[j][i] && !visited[j]) {
                    queue.offer(j);
                    visited[j] = true;
                    ++num;
                }
            }
        }

        return (num == N-1) ? true : false;
    }
}
