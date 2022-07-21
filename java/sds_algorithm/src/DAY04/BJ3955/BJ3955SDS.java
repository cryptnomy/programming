package sds_algorithm.src.DAY04.BJ3955;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3955SDS {
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

            EGResult result = extendedGcd(K, C);
            if (result.r != 1) { System.out.println("IMPOSSIBLE"); }
            else {
                long y0 = result.t;

                y0 %= K;
                if (y0 < 0) { y0 += K; }
                y0 = Math.max(y0, (K + C)/C);

                if (y0 <= 1e9) { System.out.println(y0); }
                else { System.out.println("IMPOSSIBLE"); }
            }
        }
    }

    static EGResult extendedGcd(long a, long b) {
        long s0 = 1, t0 = 0, r0 = a;
        long s1 = 0, t1 = 1, r1 = b;

        long temp;
        while (r1 != 0) {
            long q = r0 / r1;

            temp = r0 - q * r1;
            r0 = r1;
            r1 = temp;

            temp = s0 - q * s1;
            s0 = s1;
            s1 = temp;

            temp = t0 - q * t1;
            t0 = t1;
            t1 = temp;
        }
        return new EGResult(s0, t0, r0);
    }
}

class EGResult {
    long s;
    long t;
    long r;

    public EGResult(long s, long t, long r) {
        super();
        this.s = s;
        this.t = t;
        this.r = r;
    }
}