package DAY03.BOJ_2243;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2243My1 {
    static int n, s;
    static int a, b, c;
    static int[] indexedTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        s = 1;
        while (s < 1_000_000) { s <<= 1; } // candy taste ranges [1, 1_000_000]
        indexedTree = new int[s*2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if (a == 1) {   // a == 1; pop b-th delicious candy
                int index = queryMy1(1, s, 1, b);
                updateMy1(1, s, 1, index, -1);
                bw.write(index + "\n");
            } else {        // a == 2; insert c number of b-th delicious candies
                c = Integer.parseInt(st.nextToken());
                updateMy1(1, s, 1, b, c);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    // if a == 1
    static int queryMy1(int left, int right, int node, int query) {
        // if (s <= node) {
        //     //indexedTree[node] -= 1; // update -> update function !
        //     return node - s + 1;
        // }
        if (left == right) { return left; }
        int mid = (left+right) / 2;
        if (query <= indexedTree[node*2]) {
            return queryMy1(left, mid, node*2, query);
        } else {
            return queryMy1(mid + 1, right, node*2 + 1, query - indexedTree[node*2]);
        }
    }
    // if a == 2
    static void updateMy1(int left, int right, int node, int target, int diff) {
        if (target < left || right < target) { return; }
        indexedTree[node] += diff;
        if (left != right) {
            //indexedTree[node] += diff;
            int mid = (left+right) / 2;
            updateMy1(left, mid, node*2, target, diff);
            updateMy1(mid + 1, right, node*2 + 1, target, diff);
        }
    }
}
