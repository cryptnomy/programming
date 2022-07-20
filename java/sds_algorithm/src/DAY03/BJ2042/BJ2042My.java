package sds_algorithm.src.DAY03.BJ2042;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2042My {
    static int N, M, K;
    static long[] given, tree;
    static int S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        given = new long[N+1];
        S = 1;
        while (S < N) { S *= 2; }
        tree = new long[S*2];
        for (int i = 1; i < N + 1; i++) {
            given[i] = Long.parseLong(br.readLine());
        }

        init();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 1) {
                long c = Long.parseLong(st.nextToken());
                long diff = c - given[b];
                given[b] = c;
                update(1, N, 1, b, diff);
            } else if (a == 2) {
                int c = Integer.parseInt(st.nextToken());
                sb.append(query(1, N, 1, b, c) + "\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();        
    }
    // Bottom-up initialization
    static void init() {
        for (int i = 0; i < N; i++) {
            tree[S + i] = given[i + 1];
        }
        for (int i = S - 1; i > 0; i--) { // no elem at index 0
            tree[i] = tree[2*i] + tree[2*i + 1];
        }
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
            if (left == right) { return; }
            int mid = (left + right) / 2;
            update(left, mid, node*2, target, diff);
            update(mid + 1, right, node*2 + 1, target, diff);
        }
    }
    // Bottom-up query

    // Bottom-up update
}
