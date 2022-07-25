package DAY04.BJ3955;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3955 {
    static int T;
    static int K, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            // Kx + 1 = Cy, or (-K)x + Cy = 1
            // x = x0 + (C/d)k
            // y = y0 - (-K/d)k
            //int answer = linearDiophantine(-K, C);
            int answer = linearDiophantine(-K, C);
        }
    }

    static int linearDiophantine(int a, int b) {
        // ax + by = 1
        return 0;
    }

    static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
}
