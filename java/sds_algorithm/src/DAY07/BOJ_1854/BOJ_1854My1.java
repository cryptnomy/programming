package DAY07.BOJ_1854;

import java.io.*;
import java.util.*;

public class BOJ_1854My1 {
    static int V, E, K;
    static List<List<Edge>> adj;
    static List<List<Long>> dist;
    static PriorityQueue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList<>();
        dist = new ArrayList<>();
        for (int i = 0; i <= V; ++i) {
            adj.add(new ArrayList<>());
            dist.add(new ArrayList<>());
        }

        int u, v;
        long w;
        for (int i = 0; i < E; ++i) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Long.parseLong(st.nextToken());
            adj.get(u).add(new Edge(v, w));
        }

        int start = 1;
        dijkstra(start);

        for (int i = 1; i <= V; i++) {
            bw.append(dist.get(i).size() == K
                        ? String.valueOf(dist.get(i).get(K-1))
                        : "-1")
              .append("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra(int start) {
        pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        int count = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (dist.get(curr.v).size() < K) { dist.get(curr.v).add(curr.w); }
            else continue;
            if (dist.get(curr.v).size() == K) { ++count; }
            if (count == V) { break; }
            for (Edge next : adj.get(curr.v)) {
                if (dist.get(next.v).size() < K) {
                    pq.offer(new Edge(next.v, curr.w + next.w));
                }
            }
        }
    }
}

class Edge implements Comparable<Edge> {
    int v;
    long w;
    public Edge(int v, long w) {
        this.v = v;
        this.w = w;
    }
    @Override
    public int compareTo(Edge o) {
        return Long.compare(this.w, o.w);
    }
}
