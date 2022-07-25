package DAY06.BJ1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1717 {
    static int N, M;    // (N+1) nodes, M operations
    static int[] parent;
    static int[] level;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        level = new int[N + 1];
        initialize();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (command == 0) {  // Union if "0"
                union(a, b);
            } else {  // Check inclusion if "1"
                sb.append(checkInclusion(a, b) + "\n");
            }
        }
        System.out.println(sb);
    }

    static void initialize() {
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
            level[i] = 1;
        }
    }

    static void union(int a, int b) {
        a = find(a);    // aRoot = find(a)
        b = find(b);    // bRoot = find(b)
        if (a != b) { parent[b] = a; }
        if (a != b) {
            if (level[a] < level[b]) {
                int temp = a;
                a = b;
                b = temp;
            }
            parent[b] = a;
            if (level[a] == level[b]) { ++level[a]; }
        }
    }

    static int find(int a) {
        return parent[a] = (parent[a] == a ? a : find(parent[a]));
    }

    static String checkInclusion(int a, int b) {
        a = find(a);
        b = find(b);
        return a == b ? "YES" : "NO";
    }
}
