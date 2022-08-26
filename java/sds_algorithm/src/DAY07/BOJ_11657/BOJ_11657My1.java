package DAY07.BOJ_11657;

import java.io.*;
import java.util.*;

public class BOJ_11657My1 {
    static int V, E;
    static List<List<Edge>> adj;
    static long[] dist;
    static final int MAX_VALUE = 60_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        dist = new long[V+1];
        Arrays.fill(dist, MAX_VALUE);
        adj = new ArrayList<>();
        for (int i = 0; i <= V; ++i) {
            adj.add(new ArrayList<>());
        }

        int u, v, w;
        for (int i = 0; i < E; ++i) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adj.get(u).add(new Edge(v, w));
        }

        int start = 1;
        if (bellmanFord(start)) { bw.append("-1\n"); }
        else {
            for (int i = 1; i <= V; ++i) {
                if (i == start) { continue; }
                if (dist[i] == MAX_VALUE) { bw.append("-1\n"); }
                else { bw.append(dist[i] + "\n"); }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean bellmanFord(int start) {
        dist[start] = 0;
        boolean updated = false;
        long newDist;

        for (int i = 1; i < V; ++i) {
            updated = false;
            for (int curr = 1; curr <= V; ++curr) {
                for (Edge next : adj.get(curr)) {
                    if (dist[curr] == MAX_VALUE) { break; }
                    newDist = dist[curr] + next.w;
                    if (dist[next.v] > newDist) {
                        dist[next.v] = newDist;
                        updated = true;
                    }
                }
            }
            if (!updated) { break; }
        }

        if (updated) {
            for (int curr = 1; curr <= V; ++curr) {
                if (dist[curr] == MAX_VALUE) { continue; }
                for (Edge next : adj.get(curr)) {
                    if (dist[next.v] > dist[curr] + next.w) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

class Edge {
    int v, w;
    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }
}
