package DAY03.BJ2243;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ2243SDS {
    static int A, B, C, N, S;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        S = 1;
        while (S < 1_000_000) { S <<= 1; } // S = 524288
        tree = new long[S*2];    // S*2 = 1048576

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            if (A == 2) {
                C = Integer.parseInt(st.nextToken());
                update(1, S, 1, B, C);
            } else if (A == 1) {
                int index = query(1, S, 1, B);
                update(1, S, 1, index, -1);
                bw.write(index + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int query(int left, int right, int node, int count) {
        // 1. Leaf에 도착했을 때 -> 사탕 번호 반환
        if (left == right) { return left; }
        else {
            int mid = (left+right) / 2;
            // 2. 왼쪽 >= count -> 왼쪽 이동
            if (tree[node*2] >= count) { return query(left, mid, node*2, count); }
            // 3. 왼쪽 < count -> 오른쪽
            else {
                count -= tree[node*2];
                query(mid + 1, right, node*2 + 1, count);
            }
        }
        return count;
    }

    static void update(int left, int right, int node, int index, long diff) {
        if (left <= index && index <= right) {
            tree[node] += diff;
            if (left != right) {
                int mid = (left+right) / 2;
                update(left, mid, node*2, index, diff);
                update(mid + 1, right, node*2 + 1, index, diff);
            }
        }
    }
}
