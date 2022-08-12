package DAY02.BOJ_2143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2143SDS {
    static long T; 
    static int N, M;
    static long[] inputA, inputB;
    static List<Long> subA, subB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // Initialize T, N, M, inputA, inputB
        T = Long.parseLong(br.readLine());
        N = Integer.parseInt(br.readLine());
        inputA = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inputA[i] = Long.parseLong(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        inputB = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            inputB[i] = Long.parseLong(st.nextToken());
        }
        // Initialization of sub arrays
        subA = new ArrayList<>();
        subB = new ArrayList<>();
        // subA
        for (int i = 0; i < N; i++) {
            long sum = inputA[i];
            subA.add(sum);
            for (int j = i + 1; j < N; j++) {
                sum += inputA[j];
                subA.add(sum);
            }
        }
        // subB
        for (int i = 0; i < M; i++) {
            long sum = inputB[i];
            subB.add(sum);
            for (int j = i + 1; j < M; j++) {
                sum += inputB[j];
                subB.add(sum);
            }
        }
        // Sort subA, subB
        Collections.sort(subA);
        Collections.sort(subB, Comparator.reverseOrder());
        // Two pointer method
        long result = 0;
        int ptA = 0;
        int ptB = 0;
        while (true) {
            long currentA = subA.get(ptA);
            long target = T - currentA;
            // currentB == target -> Check the same # of subA, subB -> Get solution
            if (subB.get(ptB) == target) {
                long countA = 0;
                long countB = 0;
                while (ptA < subA.size() && subA.get(ptA) == currentA) {
                    ++countA;
                    ++ptA;
                }
                while (ptB < subB.size() && subB.get(ptB) == target) {
                    ++countB;
                    ++ptB;
                }
                result += countA * countB;
            }
            // currentB > target -> ptB++
            else if (subB.get(ptB) > target) {
                ++ptB;
            }
            // currentB < target -> ptA++
            else {
                ++ptA;
            }
            // Escape condition
            if (ptA == subA.size() || ptB == subB.size()) break;
        }

        System.out.println(result);
    }
}
