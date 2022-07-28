package DAY09.BJ2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2579 {
    static int N;
    static int[] stairs;
    static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stairs = new int[N];
        score = new int[N];
        for (int i = 0; i < N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        score[0] = stairs[0];
        if (N == 1) { System.out.println(score[0]); return; }
        score[1] = stairs[0] + stairs[1];
        if (N == 2) { System.out.println(score[1]); return; }
        score[2] = Math.max(stairs[0], stairs[1]) + stairs[2];
        if (N == 3) { System.out.println(score[2]); return; }
        for (int i = 3; i < N; i++) {
            score[i] = stairs[i] + Math.max(score[i-3] + stairs[i-1], score[i-2]);
        }
        System.out.println(score[N-1]);
    }
}
