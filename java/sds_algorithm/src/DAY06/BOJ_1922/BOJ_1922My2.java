package DAY06.BOJ_1922;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1922My2 {
    static int V, E; // V \in [1, 1000]; E \in [1, 100_000]
    static int[] parent;
    static PriorityQueue<Edge> pq;
    static int minCost;
    static int count;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        parent = new int[V+1];
        for (int i = 1; i <= V; ++i) {
            parent[i] = i;
        }
        pq = new PriorityQueue<>();

        int u, v, w;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(u, v, w));
        }

        minCost = 0;
        count = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (find(curr.u) != find(curr.v)) {
                union(curr.u, curr.v);
                minCost += curr.w;
                ++count;
            }
            if (count == V - 1) { break; }
        }
        bw.write(minCost + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void union(int u, int v) {
        u = find(u);
        v = find(v);
        if (u != v) {
            parent[v] = u;
        }
    }

    static int find(int x) {
        return (x == parent[x]) ? x : (parent[x] = find(parent[x]));
    }
}

class Edge implements Comparable<Edge> {
    int u, v, w;

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}