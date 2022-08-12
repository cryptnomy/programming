package DAY07.BJ1753;

import java.io.*;
import java.util.*;

public class BJ1753My1 {
    static int V, E;
    static int K; // starting point
    static List<List<Edge>> adj;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i = 0; i <= V; ++i) {
            adj.add(new ArrayList<>());
        }
        dist = new int[V+1];

        K = Integer.parseInt(br.readLine());

        int u, v, w;
        for (int i = 0; i < E; ++i) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            adj.get(u).add(new Edge(v, w));
        }

        dijkstra(K);

        for (int d : dist) {
            if (d == -1) { continue; }
            bw.append(d == INF ? "INF" : String.valueOf(d)).append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Arrays.fill(dist, INF);
        dist[0] = -1;
        dist[start] = 0;
        pq.offer(new Edge(start, 0));
        int newDist;
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (dist[curr.v] < curr.w) { continue; }
            for (Edge next : adj.get(curr.v)) {
                newDist = curr.w + next.w;
                if (newDist < dist[next.v]) {
                    dist[next.v] = newDist;
                    pq.offer(new Edge(next.v, newDist));
                }
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    int v, w;
    public Edge(int v, int w) {
        super();
        this.v = v;
        this.w = w;
    }
    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}