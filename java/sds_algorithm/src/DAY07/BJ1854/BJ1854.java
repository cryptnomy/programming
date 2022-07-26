package DAY07.BJ1854;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1854 {
    static int V, E, K;
    static List<Node>[] adj;
    static PriorityQueue<Integer>[] distance;
    static int INF = 2_000_000_001;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());   // K: K-th shortest path

        init();

        int u, v, w;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adj[u].add(new Node(v, w));
        }

        dijkstra(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distance[i].size() == K) { sb.append(distance[i].peek() * -1).append("\n"); }
            else { sb.append("-1\n"); }
        }
        System.out.print(sb.toString());
    }

    private static void init() {
        adj = new ArrayList[V+1];
        distance = new PriorityQueue[V+1];
        for (int i = 1; i <= V; i++) {
            adj[i] = new ArrayList<>();
            distance[i] = new PriorityQueue<>();
        }
    }

    private static void dijkstra(int start) {
        distance[start].add(0);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node currNode = pq.poll();
            for (Node nextNode : adj[currNode.index]) {
                if (distance[nextNode.index].size() < K) {
                    int newWeight = currNode.weight + nextNode.weight;
                    distance[nextNode.index].add(newWeight * -1);
                    pq.add(new Node(nextNode.index, newWeight));
                } else {
                    int newWeight = currNode.weight + nextNode.weight;
                    if ((distance[nextNode.index].peek() * -1) > newWeight) {
                        distance[nextNode.index].poll();
                        distance[nextNode.index].add(newWeight * -1);
                        pq.add(new Node(nextNode.index, newWeight));
                    }
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int index;
    int weight;

    public Node(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
