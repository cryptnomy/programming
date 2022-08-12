package DAY07.BJ11657;

import java.io.*;
import java.util.*;

public class BJ11657My1 {
    static int V, E;
    static List<Edge> adj;
    static long[] dist;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();
        dist = new long[V+1];
        Arrays.fill(dist, Long.MAX_VALUE);

        int u, v, w;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            adj.add(new Edge(u, v, w));
        }

        dist[1] = 0;
        flag = false;
        long newDist;
        for (int i = 1; i <= V; i++) {
            for (Edge edge : adj) {
                if (dist[edge.u] == Long.MAX_VALUE) { continue; }
                newDist = dist[edge.u] + edge.w;
                if (dist[edge.v] > newDist) {
                    if (i == V) {
                        flag = true;
                        break;
                    }
                    dist[edge.v] = newDist;
                }
            }
        }

        if (flag) { bw.append("-1\n"); }
        else {
            for (int i = 2; i <= V; ++i) {
                bw.append(dist[i] == Long.MAX_VALUE ? "-1" : String.valueOf(dist[i])).append("\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

class Edge {
    int u, v, w;
    public Edge(int u, int v, int w) {
        super();
        this.u = u;
        this.v = v;
        this.w = w;
    }
}