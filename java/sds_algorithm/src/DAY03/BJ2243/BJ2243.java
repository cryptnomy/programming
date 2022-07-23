package DAY03.BJ2243;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class BJ2243 {
    static int N, S;
    static int A, B, C;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        S = 1;
        while (S < 1_000_000) { S <<= 1; } // S = 524288
        tree = new int[S*2];    // S*2 = 1048576
        
        StringJoiner sj = new StringJoiner("\n");
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            if (A == 1) {           // Get candy out of the box
                int candyNum = query(1, S, 1, B);
                sj.add(Integer.toString(candyNum));
                update(1, S, 1, candyNum, -1);
            } else if (A == 2) {    // Get candy into the box
                C = Integer.parseInt(st.nextToken());
                update(1, S, 1, B, C);
            }
        }
        System.out.print(sj.toString());
    }

    public static int query(int left, int right, int node, int target) {
        if (left == right) { return left; }
        int mid = (left + right)/2;
        if (tree[node*2] >= target) { return query(left, mid, node*2, target); }
        else { return query(mid + 1, right, node*2 + 1, target - tree[node*2]); }
    }

    public static void update(int left, int right, int node, int target, int diff) {
        if (target < left || right < target) { return; }
        tree[node] += diff;
        if (left == right) { return; }
        int mid = (left + right)/2;
        update(left, mid, node*2, target, diff);
        update(mid + 1, right, node*2 + 1, target, diff);
    }
}
