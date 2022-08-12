package DAY07.BOJ_1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
    static int V, E, K;
    static int INF = 3_000_001;
    static List<Node>[] adj;
    static boolean[] visited;
    static int[] distance;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());   // K: start
        visited = new boolean[V+1];
        distance = new int[V+1];
        adj = new ArrayList[V+1];
        Arrays.fill(distance, INF);
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
        }
        int u, v, w;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
        }
        dijkstra(K);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distance[i] == INF) { sb.append("INF\n"); }
            else { sb.append(distance[i]).append("\n"); }
        }
        System.out.println(sb.toString());
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        distance[start] = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (visited[current.nodeNum]) { continue; }
            visited[current.nodeNum] = true;
            for (Node node : adj[current.nodeNum]) {
                if (distance[node.nodeNum] > distance[current.nodeNum] + node.weight) {
                    distance[node.nodeNum] = distance[current.nodeNum] + node.weight;
                    queue.add(new Node(node.nodeNum, distance[node.nodeNum]));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int nodeNum;
    int weight;

    public Node(int node, int weight) {
        this.nodeNum = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
