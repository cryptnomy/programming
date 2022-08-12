package DAY07.BOJ_2458;

import java.io.*;
import java.util.*;

public class BOJ_2458My1 {
    static int V, E;
    static List<List<Integer>> adjOut, adjIn;
    static boolean[] visited;
    static Queue<Integer> q;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adjOut = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adjOut.add(new ArrayList<>());
        }
        adjIn = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adjIn.add(new ArrayList<>());
        }
        visited = new boolean[V+1];

        int a, b;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            adjOut.get(a).add(b);
            adjIn.get(b).add(a);
        }
        
        int result = 0;
        for (int i = 1; i <= V; i++) {
            int count = bfs(adjOut, i) + bfs(adjIn, i);
            if (count == V - 1) { ++result; }
        }

        bw.write(result + "\n");
        bw.flush();
        br.close();
    }

    public static int bfs(List<List<Integer>> adj, int start) {
        q = new LinkedList<>();
        int count = 0;

        Arrays.fill(visited, false);
        q.offer(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int next : adj.get(curr)) {
                if (visited[next]) { continue; }
                q.offer(next);
                ++count;
                visited[next] = true;
            }
        }
        return count;
    }
}
