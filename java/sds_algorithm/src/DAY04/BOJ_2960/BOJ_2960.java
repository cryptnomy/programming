package DAY04.BOJ_2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2960 {
    static int N, K;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new boolean[N+1];
        // false if prime, true if not prime (0, 1, composites, negatives)
        arr[0] = arr[1] = true;
        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                if (!arr[j]) { --K; }
                if (K == 0) {
                    System.out.println(j);
                    return;
                } else { arr[j] = true; }
            }
        }
    }
}
