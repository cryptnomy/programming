// Time limit exceeded

import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MowTheLawn {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // T: test cases
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T+1; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // N: row, M: col, D: iterations
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int lawnSize = N * M;
            Integer[] lawn = new Integer[lawnSize];
            // N by M lawn
            for (int n = 0; n < N; ++n) {
                int m = 0;
                st = new StringTokenizer(br.readLine(), " ");
                while (st.hasMoreTokens()) {
                    int lawnNum = M*n + m;
                    lawn[lawnNum] = Integer.parseInt(st.nextToken());
                    ++m;
                }
            }
            // Oil amount
            int[] oil = new int[D];
            for (int d = 0; d < D; ++d) {
                st = new StringTokenizer(br.readLine(), " ");
                while (st.hasMoreTokens()) {
                    oil[d] = Integer.parseInt(st.nextToken());
                    ++d;
                }
            }
            // Maximum length to trim the lawn on each day
            int[] trim = new int[D];
            Arrays.fill(trim, 0);
            for (int d = 0; d < D; ++d) {
                for (int l = 0; l < lawnSize; ++l) {
                    ++lawn[l];
                }
                Arrays.sort(lawn, Collections.reverseOrder());
                for (int k = 0; k < oil[d]; ++k) {
                    trim[d] += (lawn[k] - 1);
                    lawn[k] = 1;
                }                
            }
            // Determine the anwer
            long answer = 0;
            for (int d = 0; d < D; ++d) {
                answer += (d+1)*trim[d];
            }
            System.out.printf("#%d ", t);
            System.out.println(answer);
        }
    }
}
