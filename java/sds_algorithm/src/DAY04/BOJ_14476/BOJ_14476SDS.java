package DAY04.BOJ_14476;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14476SDS {
    static int N;
    static int[] nums, gcdLtoR, gcdRtoL;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N];
        gcdLtoR = new int[N];
        gcdRtoL = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // LtoR 만들기
        gcdLtoR[0] = nums[0];
        for (int i = 1; i < N; i++) {
            gcdLtoR[i] = gcd(gcdLtoR[i - 1], nums[i]);
        }
        // RtoL 만들기
        gcdRtoL[N - 1] = nums[N - 1];
        for (int i = N - 2; i > -1; i--) {
            gcdRtoL[i] = gcd(gcdRtoL[i + 1], nums[i]);
        }
        // k 선정하기
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < N; i++) {
            int gcd = 0;
            // 0
            if (i == 0) { gcd = gcdRtoL[1]; }
            // N - 1
            else if (i == N - 1) { gcd = gcdLtoR[N - 2]; }
            // 중간
            else { gcd = gcd(gcdLtoR[i - 1], gcdRtoL[i + 1]); }

            if (nums[i] % gcd != 0 && gcd > max) {
                max = gcd;
                maxIndex = i;
            }
        }
        if (max == 0) { System.out.println(-1); }
        else { System.out.println(max + " " + nums[maxIndex]); }
    }

    //static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
