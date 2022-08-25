package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1197 {
    static int V, E;
    static int[] parent;
    static PriorityQueue<Edge> pq;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        parent = new int[V+1];
        for (int i = 1; i <= V; ++i) {
            parent[i] = i;
        }
        pq = new PriorityQueue<>();
        
        int u, v;
        long w;
        for (int i = 0; i < E; ++i) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Long.parseLong(st.nextToken());
            pq.add(new Edge(u, v, w));
        }
        
        int mst_edges = 0;
        int weight = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (find(curr.u) == find(curr.v)) { continue; }
            weight += curr.w;
            union(curr.u, curr.v);
            ++mst_edges;
            if (mst_edges == V - 1) { break; }
        }
        bw.write(weight + "\n");
        bw.close();
        br.close();
    }
    
    static void union(int a, int b) {
        a = parent[a];
        b = parent[b];
        if (a != b) {
            parent[b] = a;
        }
    }
    
    static int find(int x) {
        return x == parent[x] ? x : (parent[x] = find(parent[x]));
    }
}

class Edge implements Comparable<Edge> {
    int u, v;
    long w;
    public Edge(int u, int v, long w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
    @Override
    public int compareTo(Edge o) {
        return Long.compare(this.w, o.w);
    }
}