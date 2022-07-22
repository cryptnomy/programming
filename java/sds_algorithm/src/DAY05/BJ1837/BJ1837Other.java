package sds_algorithm.src.DAY05.BJ1837;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1837Other {
    static char[] P;
    static int K;
    static boolean[] isNotPrime;
    static int[] primes;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        P = st.nextToken().toCharArray();
        K = Integer.parseInt(st.nextToken());
        // Make Eratosthenes
        primes = new int[K];
        isNotPrime = new boolean[K];
        isNotPrime[0] = isNotPrime[1] = true;
        int pSize = 0;
        for (int i = 2; i < K; i++) {
            if (!isNotPrime[i]) {
                primes[pSize++] = i;
                for (int j = i + i; j < K; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
        // Primality test
        //int x;
        flag = false;   // prime not found
        for (int i = 0; i < pSize; i++) {
            if(isBad(primes[i])) {
                System.out.println("BAD " + primes[i]);
                return;
            }
            // x = 0;
            // for (int j = 0; j < P.length; j++) {
            //     x = (x * 10 + (int)(P[j] - '0')) % primes[i];
            // }
            // if (x == 0) {
            //     System.out.println("BAD " + primes[i]);
            //     flag = true;
            //     return;
            // }
        }
        System.out.println("GOOD");
    }

    static boolean isBad(int x) {
        int ret = 0;
        for (int i = 0; i < P.length; i++) {
            ret = (10 * ret + (int)(P[i] - '0')) % x;
        }
        if (ret == 0) return true;
        else return false;
    }
}
