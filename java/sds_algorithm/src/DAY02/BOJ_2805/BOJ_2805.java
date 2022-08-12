package DAY02.BOJ_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {
    static int N, M;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        tree = new int[N + 1];
        int minHeight = 0, maxHeight = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (maxHeight < tree[i]) maxHeight = tree[i];
        }

        while (minHeight <= maxHeight) {
            int midHeight = (minHeight + maxHeight) / 2;
            long sumHeight = 0;
            for (int i = 0; i < N; i++) {
                if (tree[i] > midHeight) sumHeight += tree[i] - midHeight;
            }
            if (M <= sumHeight) minHeight = midHeight + 1;
            else maxHeight = midHeight - 1;
        }

        System.out.println(maxHeight);
    }
}
