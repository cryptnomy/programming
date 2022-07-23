package DAY01.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.Arrays;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class Dfs {
    static int N, K;
    static int max;
    static String[] words;
    static byte visited[] = new byte[26];

    public static void main(String[] args) throws IOException {
        //String filepath = "c:/Users/after/Documents/Programming/java/sds_algorithm/";
        String filepath = "d:/GT/Programming/java/jumptojava/";
        System.setIn(new FileInputStream(filepath + "/src/DAY01/DFS/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];

        if (K < 5) {
            System.out.println(0);
        } else if (K == 26) {
            System.out.println(N);
        }
        else {            
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                sb = new StringBuilder(str);
                sb.replace(str.length() - 4, str.length(), "");
                sb.replace(0, 4, "");
                words[i] = sb.toString();
            }
            System.out.println(Arrays.toString(words));
            for (int j = 0; j < visited.length; j++) {
                visited[j] = 0; // WHITE ~ 0
            }
            // BLACK ~ 1
            visited['a' - 'a'] = 1;
            visited['n' - 'a'] = 1;
            visited['t' - 'a'] = 1;
            visited['i' - 'a'] = 1;
            visited['c' - 'a'] = 1;

            dfs(visited, 0, 5);
            
            System.out.println(max);
        }
        // System.out.println(N + ", " + K);
    }

    static void dfs(byte[] visited, int start, int depth) {
        // 1. 체크인
        visited[start] = -1;    // GRAY ~ -1
        // 2. 목적지인가?
        if (depth == K) {
            int cnt = 0;
            
            for (int i = 0; i < N; i++) {
                String str = words[i];

                loop: for (int j = 0; j < str.length(); j++) {
                    char c = str.charAt(j);
                    if (visited[c - 'a'] == 0)
                        continue loop;
                }
                ++cnt;
            }
            max = Math.max(max, cnt);
            return;
        }
        // 3. 연결된 곳을 순회
        for (int i = 0; i < visited.length; i++) {
            // 4. 갈 수 있는가?
            if (visited[i] == 0) {
                // 5. 간다
                dfs(visited, i, depth + 1);
            }
        }
        // 6. 체크아웃
        visited[start] = 1;
    }
}
