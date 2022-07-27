package DAY08.BJ5719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

public class BJ5719 {
    static int N, M, S, D;
    static int[] dist;
    static boolean[][] isShortest;
    static Vector<Edge>[] adj;
    static List<Integer>[] parent;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) { break; }
            
            dist = new int[N];
            isShortest = new boolean[N][N];
            adj = new Vector[N];
            parent = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                adj[i] = new Vector<>();
                parent[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            int u, v, p;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                p = Integer.parseInt(st.nextToken());
                adj[u].add(new Edge(v, p));
            }

            dijkstra(S);
            backTracking(S, D);
            dijkstra(S);

            if (dist[D] == Integer.MAX_VALUE) { sb.append("-1\n"); }
            else { sb.append(dist[D] + "\n"); }
        }
        System.out.print(sb.toString());
    }

    public static void dijkstra(int start) {
        for (int i = 0; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Edge(start, dist[start]));
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (dist[curr.node] < curr.length) { continue; }
            for (Edge next : adj[curr.node]) {
                if (!isShortest[curr.node][next.node]) {
                    int nL = dist[curr.node] + next.length;
                    if (dist[next.node] == nL) {
                        parent[next.node].add(curr.node);
                    } else if (dist[next.node] > nL) {
                        dist[next.node] = nL;
                        parent[next.node].clear();
                        parent[next.node].add(curr.node);
                        pq.offer(new Edge(next.node, dist[next.node]));
                    }
                }
            }
        }
    }

    public static void backTracking(int start, int node) {
        if (node == start) { return; }
        for (int next : parent[node]) {
            if (!isShortest[next][node]) {
                isShortest[next][node] = true;
                backTracking(start, next);
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int node;
        int length;

        public Edge(int node, int length) {
            this.node = node;
            this.length = length;
        }

        @Override
        public int compareTo(Edge o) {
            return this.length - o.length;
        }
    }
}