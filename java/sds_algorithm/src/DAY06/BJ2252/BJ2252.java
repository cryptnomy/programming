package DAY06.BJ2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2252 {
    static int N, M;
    static int[] degree;
    static int[] parent;
    static List<Integer>[] list;
    static StringTokenizer st;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        degree = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            ++degree[b];
        }

        queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) { queue.add(i); }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            sb.append(String.valueOf(current)).append(" ");            
            for (int i = 0; i < list[current].size(); i++) {
                int next = list[current].get(i);
                --degree[next];
                if (degree[next] == 0) { queue.add(next); }
            }
        }
        System.out.println(sb);
    }
}
