package DAY05.BOJ_1722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BOJ_1722 {
    static int N;
    static long[] dp;
    static long k;
    static List<Integer> oneToN, permutation;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        // Save 1! ~ N! to dp
        dp = new long[N + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] * i;
        }
        oneToN = Stream.iterate(1, n -> n+1)
                       .limit(N)
                       .collect(Collectors.toList());
        //System.out.println(Arrays.toString(oneToN.toArray()));
        // second line
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        // if 1, print k-th corresponding permutation
        if (a == 1) {
            k = Long.parseLong(st.nextToken());
            for (int i = N - 1; i > -1; i--) {
                long c = (k - 1) / dp[i];
                int r = oneToN.remove((int)c);
                k -= c * dp[i];
                sb.append(r).append(" ");
            }
            System.out.println(sb.toString());
        // if 2, print numberth of the given permutation
        } else if (a == 2) {
            int answer = 1;
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken());
                int index = oneToN.indexOf(n);
                answer += index * dp[N - 1 - i];
                oneToN.remove(index);
            }
            System.out.println(answer);
        }
    }
}
