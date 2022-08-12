package DAY08.BOJ_3830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3830 {
    static int N, M;
    static int[] parent;
    static long[] dist;
    static String type;
    static int a, b, w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 & M == 0) { break; }
            parent = new int[N+1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }
            dist = new long[N+1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                type = st.nextToken();
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                if (type.equals("!")) {
                    w = Integer.parseInt(st.nextToken());
                    union(a, b, w);
                } else if (type.equals("?")) {
                    if (find(a) != find(b)) { sb.append("UNKNOWN\n"); }
                    else { sb.append((dist[b] - dist[a]) + "\n"); }
                }
            }
        }
        System.out.print(sb.toString());
    }

    static int find(int index) {
        if (parent[index] == index) { return index; }
        int pIndex = find(parent[index]);
        dist[index] += dist[parent[index]];
        return parent[index] = pIndex;
    }

    static void union(int a, int b, long diff) {
        int pA = find(a);
        int pB = find(b);
        if (pA == pB) { return; }
        dist[pB] = dist[a] - dist[b] + diff;
        parent[pB] = pA;
    }
}
