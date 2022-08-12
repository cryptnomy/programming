package DAY06.BOJ_1717;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class BOJ_1717SDS {
    static int[] parent, level;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
 
        parent = new int[N + 1];
        level = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            level[i] = 1;
        }
 
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (command == 0) {
                union(a, b);
            } else if (command == 1) {
                bw.append((find(a) == find(b) ? "YES" : "NO") + "\n");
            }
        }
		bw.flush();
        bw.close();
        br.close();
    }
 
    public static int find(int x) {
        return (x == parent[x]) ? x : (parent[x] = find(parent[x]));
    }
 
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (level[x] < level[y]) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            parent[y] = x;
            if (level[x] == level[y]) ++level[x];
        }
    }
}