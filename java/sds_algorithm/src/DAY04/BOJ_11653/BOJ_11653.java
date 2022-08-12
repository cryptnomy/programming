package DAY04.BOJ_11653;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11653 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int p = 2; p <= Math.sqrt(N); p++) {
            while (N % p == 0) {
                sb.append(p).append('\n');
                N /= p;
            }
        }
        if (N != 1) { sb.append(N); }
        System.out.print(sb);
    }
}
