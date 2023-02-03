package DAY08.BOJ_3830;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3830 {
    static int N, M;
    static char cmd;
    static int a, b, w;
    static int[] parent;
    static long[] weights;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("programming/java/sds_algorithm/src/DAY08/BOJ_3830/input_boj_3830.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            
            N = Integer.valueOf(st.nextToken());
            M = Integer.valueOf(st.nextToken());

            if (N == 0 && M ==0) {
                break;
            }

            weights = new long[N+1];
            parent = new int[N+1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                cmd = st.nextToken().charAt(0);
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                if (cmd == '!') {
                    w = Integer.parseInt(st.nextToken());
                    union(a, b, w);
                } else {
                    if (find(a) != find(b)) {
                        sb.append("UNKNOWN\n");
                    } else {
                        long diff = weights[a] - weights[b];
                        sb.append(diff + "\n");
                    }
                }
            }
        }
        System.out.print(sb);
    }

    static void union(int a, int b, int w) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return;
        }
        weights[a] = weights[b] - weights[a] + w;
        parent[a] = parent[b];
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        int y = find(parent[x]);
        weights[x] += weights[parent[x]];
        parent[x] = y;
        return y;
    }
}
