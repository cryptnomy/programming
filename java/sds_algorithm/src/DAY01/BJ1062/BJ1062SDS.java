package DAY01.BJ1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1062SDS {

    static int N, K;
    static boolean[] visited;
    static String[] words;
    static int selectedCount = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine().replaceAll("[antic]", "");
        }

        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;

        selectedCount = 5;
        max = countWords();

        for (int i = 0; i < 26; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        System.out.println(max);
    }

    // index: 몇 번째 알파벳인가
    static void dfs(int index) {
        // 1. 체크인
        visited[index] = true;
        selectedCount++;
        // 2. 목적지인가?: selectedCount == K => 읽을 수 있는 단어 개수
        if (selectedCount == K) { max = Math.max(max, countWords()); }  // 계산
        else {
            // 3. 연결된 곳을 순회: index + 1 ~ 25(= 26-1) 번째까지
            for (int i = index + 1; i < 26; i++) {
                // 4. 갈 수 있는가?: 방문 여부
                if (!visited[i]) {
                    // 5. 간다: dfs()
                    dfs(i);
                }
            }
        }
        // 6. 체크아웃
        visited[index] = false;
        selectedCount--;
    }

    static int countWords() {
        int count = 0;
        for (int n = 0; n < N; n++) {
            boolean isPossible = true;
            String word = words[n];
            for (int i = 0; i < word.length(); i++) {
                if (!visited[word.charAt(i) - 'a']) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                count++;
            }
        }
        return count;
    }
}
