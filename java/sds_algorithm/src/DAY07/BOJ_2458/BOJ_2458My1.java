package DAY07.BOJ_2458;

import java.io.*;
import java.util.*;

public class BOJ_2458My1 {
    static int V, E;
    static List<List<Integer>> adj;
    static List<List<Integer>> adjReversed;
    static boolean[] visited;
    static Queue<Integer> q;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();
        adjReversed = new ArrayList<>();
        for (int i = 0; i <= V; ++i) {
            adj.add(new ArrayList<>());
            adjReversed.add(new ArrayList<>());
        }

        int u, v;
        for (int i = 0; i < E; ++i) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adjReversed.get(v).add(u);
        }

        int result = 0;
        for (int i = 1; i <= V; ++i) {
            if (bfs(i)) { ++result; }
        }
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean bfs(int start) {
        visited = new boolean[V+1];
        q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        int num = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : adj.get(curr)) {
                if (visited[next]) { continue; }
                q.offer(next);
                visited[next] = true;
                ++num;
            }
        }

        visited = new boolean[V+1];
        q.offer(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : adjReversed.get(curr)) {
                if (visited[next]) { continue; }
                q.offer(next);
                visited[next] = true;
                ++num;
            }
        }

        return num == V - 1 ? true : false;
    }
}
