package DAY07.BJ11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ11657 {
    static int V, E;
    static List<ArrayList<Node>> adj;
    static long[] distance;
    static final int INF = 60_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        init();

        int u, v, w;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adj.get(u).add(new Node(v, w));
        }

        StringBuilder sb = new StringBuilder();
        int start = 1;
        if (bellmanFord(start)) { sb.append("-1\n"); }
        else {
            for (int i = 1; i <= V; i++) {
                if (i == start) { continue; }
                if (distance[i] == INF) { sb.append("-1\n"); }
                else { sb.append(distance[i] + "\n"); }
            }
        }
        System.out.print(sb.toString());
    }

    public static void init() {
        adj = new ArrayList<>();
        distance = new long[V+1];
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
            distance[i] = INF;
        }
    }

    public static boolean bellmanFord(int start) {
        distance[start] = 0;
        boolean updated = false;
        for (int i = 1; i < V; i++) {
            updated = false;
            for (int j = 1; j <= V; j++) {
                for (Node node: adj.get(j)) {
                    if (distance[j] == INF) { break; }
                    long newDistance = distance[j] + node.weight;
                    if (distance[node.index] > newDistance) {
                        distance[node.index] = newDistance;
                        updated = true;
                    }
                }
            }
            if (!updated) { break; }
        }
        if (updated) {
            for (int i = 1; i <= V; i++) {
                for (Node node: adj.get(i)) {
                    if (distance[i] == INF) { break; }
                    if (distance[node.index] > distance[i] + node.weight) {
                        return true;
                    }
                }
            }
        }
        return false;
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
