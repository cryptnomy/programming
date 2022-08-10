package DAY06.BJ2252;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
// import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2252 {
    static int N, M;
    static int[] front;
    static List<List<Integer>> list;
    static List<Integer> innerList;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        front = new int[N + 1];
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            innerList = new ArrayList<>();
            list.add(innerList);
        }

        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            ++front[b];
        }
        // for (int i = 0; i < list.size(); i++) {
        //     bw.append(list.get(i).toString()).append(" ");
        // }
        // bw.append("\n")

        queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (front[i] == 0) { queue.add(i); }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            bw.append(String.valueOf(current)).append(" ");            
            for (int next : list.get(current)) {
                --front[next];
                if (front[next] == 0) { queue.add(next); }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
