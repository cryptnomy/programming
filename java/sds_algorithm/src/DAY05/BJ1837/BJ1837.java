package sds_algorithm.src.DAY05.BJ1837;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1837 {
    static String P;
    static int K;
    static boolean[] isNotPrime;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        P = st.nextToken();
        K = Integer.parseInt(st.nextToken());
        // Make Eratosthenes
        isNotPrime = new boolean[K];
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i < K; i++) {
            if (!isNotPrime[i]) {
                for (int j = i + i; j < K; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
        
        flag = false;   // Prime not found
        for (int i = 2; i < K; i++) {
            if (!isNotPrime[i]) {
                int x = 0;
                int strIndex = 0;
                while (true) {
                    int a = Integer.parseInt(P.substring(strIndex, strIndex + 1));
                    x = 10 * x + a;
                    x %= i;
                    System.out.printf("a: %d, x: %d, i: %d\n", a, x, i);
                    if (strIndex == P.length() - 1) { break; }
                    strIndex++;
                }
                if (x == 0) {
                    flag = true;
                    System.out.printf("BAD %d\n", i);
                    return;
                }
            }
        }
        if (!flag) { System.out.println("GOOD"); }
    }
}
