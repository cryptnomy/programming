package sds_algorithm.src.DAY02.BJ1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1806 {
    static int N, S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        /*
         * two pointer method
         * Initialization: sum = 1st elem of given array
         * left -> postfix
         * right -> prefix
         */
        int low = 0, high = 0, minLength = Integer.MAX_VALUE, pSum = arr[0];
        while (true) {
            if (pSum >= S) {
                pSum -= arr[low];
                minLength = Math.min(minLength, high + 1 - (low++));
            } else {
                pSum += arr[++high];
            }
            if (high == N) break;
        }
        if (minLength == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(minLength);
    }
}
