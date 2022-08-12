package DAY08.BOJ_17398;

import java.io.*;
import java.util.*;

public class BOJ_17398My1 {
    static int V, E, Q;
    static Edge[] adj;
    static int[] rmEdge;
    static boolean[] isRemoved;
    static int[] parent;
    static long sum;
    static long[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        parent = new int[V+1];
        count = new long[V+1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
            count[i] = 1;
        }
        adj = new Edge[E+1];
        isRemoved = new boolean[E+1];
        rmEdge = new int[Q+1];

        int u, v;
        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            adj[i] = new Edge(u, v);
        }

        for (int i = 1; i <= Q; i++) {
            int q = Integer.parseInt(br.readLine());
            rmEdge[i] = q;
            isRemoved[q] = true;
        }

        sum = 0;
        for (int i = 1; i <= E; i++) {
            if (isRemoved[i]) { continue; }
            union(adj[i].u, adj[i].v);
        }
        
        long initSum = sum;
        for (int i = Q; i > 0; --i) {
            int e = rmEdge[i];
            union(adj[e].u, adj[e].v);
        }

        bw.append(String.valueOf(sum - initSum)).append("\n");
        bw.close();
        br.close();
    }

    static int find(int x) {
        return (x == parent[x]) ? x : (parent[x] = find(parent[x]));
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) { return; }
        sum += count[a] * count[b];
        parent[b] = a;
        count[a] += count[b];
        // count[b] = 0;
    }
}

class Edge {
    int u, v;
    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }
}
