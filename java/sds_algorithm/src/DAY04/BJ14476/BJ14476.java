package sds_algorithm.src.DAY04.BJ14476;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ14476 {
    static int N;
    static int[] nums;
    static int[] leftGCD, rightGCD;
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nums = new int[N+2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        // Two pointer
        leftGCD = new int[N+2];
        for (int i = 1; i <= N; i++) { leftGCD[i] = gcd(nums[i], leftGCD[i - 1]); }

        rightGCD = new int[N+2];
        for (int i = N; i > 0; i--) { rightGCD[i] = gcd(nums[i], rightGCD[i + 1]); }

        int ans = -1;
        int max = -1;
        for (int i = 1; i < N; i++) {
            int res = gcd(leftGCD[i - 1], rightGCD[i + 1]);
            if (res > max) {
                if (nums[i] % res != 0) {
                    max = res;
                    ans = nums[i];
                }
            }
        }

        if (ans == -1) { System.out.println(-1); }
        else { System.out.println(max + " " + ans); }
    }

    static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }
}
