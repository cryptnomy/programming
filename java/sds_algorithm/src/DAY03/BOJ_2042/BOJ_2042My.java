package DAY03.BOJ_2042;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2042My {
    static int N, M, K;
    static long[] tree;
    static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // arr = new long[N];
        // for (int i = 0; i < N; i++) {
        //     arr[i] = Long.parseLong(br.readLine());
        // }

        S = 1;
        while (S < N) { S <<= 1; }
        tree = new long[S*2];
        // Bottom-up initialization
        for (int i = S; i < N + S; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }
        for (int i = S; i < N + S; i++) { // no elem at index 0
            int p = i >> 1;
            while (p != 0) {
                tree[p] += tree[i];
                p >>= 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) { updateBU(b, (int)c); }
            else if (a == 2) { sb.append(queryBU(b, (int)c)).append("\n"); }
        }
        bw.write(sb.toString());
        bw.flush();       
    }

    // Top-down query
    static long query(int left, int right, int node, int queryLeft, int queryRight) {
        if (queryRight < left || right < queryLeft) { return 0; }
        else if (queryLeft <= left && right <= queryRight) { return tree[node]; }
        else {  // stretches over both regions
            int mid = (left + right) / 2;
            long resultLeft = query(left, mid, node*2, queryLeft, queryRight);
            long resultRight = query(mid + 1, right, node*2 + 1, queryLeft, queryRight);
            return resultLeft + resultRight;
        }
    }
    // Top-down update
    static void update(int left, int right, int node, int target, long diff) {
        if (target < left || right < target) { return; }
        else {
            tree[node] += diff;
            if (left != right) {
                int mid = (left + right) / 2;
                update(left, mid, node*2, target, diff);
                update(mid + 1, right, node*2 + 1, target, diff);
            }
        }
    }
    // Bottom-up query
    static long queryBU(int queryLeft, int queryRight) {
        int left = S + queryLeft - 1;
        int right = S + queryRight - 1;
        long sum = 0;
        while (left < right) {
            if ((left & 1) == 1) { sum += tree[left++]; }
            if ((right & 1) == 0) { sum += tree[right--]; }
            left >>= 1;
            right >>= 1;
        }
        if (left == right) sum += tree[left];
        return sum;
    }
    // Bottom-up update
    static void updateBU(int target, long value) {
        target += S - 1;
        long diff = value - tree[target];
        while (target != 0) {
            tree[target] += diff;
            target >>= 1;
        }
    }
}
