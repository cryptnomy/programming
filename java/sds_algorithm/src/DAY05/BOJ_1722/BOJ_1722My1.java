package DAY05.BOJ_1722;

import java.io.*;
import java.util.*;

public class BOJ_1722My1 {
    static int N;
    static int command;
    static long K;
    static long[] factorial;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        factorial = new long[N+1];
        factorial[0] = 1;
        for (int i = 1; i <= N; i++) {
            factorial[i] = factorial[i-1] * i;
        }
        visited = new boolean[N+1];

        st = new StringTokenizer(br.readLine());
        command = Integer.parseInt(st.nextToken());
        if (command == 1) {
            K = Long.parseLong(st.nextToken());
            for (int i = 1; i <= N; i++) {
                int j = 0;
                while (K > factorial[N-i]) {
                    K -= factorial[N-i];
                    ++j;
                }
                for (int k = 1; k <= N; k++) {
                    if (visited[k]) { continue; }
                    if (j == 0) {
                        visited[k] = true;
                        bw.append(k + " ");
                        break;
                    }
                    --j;
                }
            }
            bw.append("\n");
        } else if (command == 2) {
            K = 1;
            int num, k;
            for (int i = 1; i <= N; i++) {
                num = Integer.parseInt(st.nextToken());
                k = 0;
                for (int j = 1; j < num; j++) {
                    if (!visited[j]) {
                        ++k;
                    }
                }
                K += k * factorial[N-i];
                visited[num] = true;
            }
            bw.append(K + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
