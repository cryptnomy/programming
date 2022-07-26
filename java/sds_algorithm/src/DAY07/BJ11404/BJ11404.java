package DAY07.BJ11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11404 {
    static final long INF = 10_000_000_001L;
    static int V, E;
    static long[][] adjM;     // adjacency matrix
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        adjM = new long[V+1][V+1];
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) { adjM[i][j] = 0; }
                else { adjM[i][j] = INF; }
            }
        }
        StringTokenizer st;
        int u, v, w;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            adjM[u][v] = Math.min(w, adjM[u][v]);
        }

        floydWarshall();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (adjM[i][j] == INF) { adjM[i][j] = 0; }
                sb.append(adjM[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    private static void floydWarshall() {
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    adjM[i][j] = Math.min(adjM[i][j], adjM[i][k] + adjM[k][j]);
                }
            }
        }
    }
}
