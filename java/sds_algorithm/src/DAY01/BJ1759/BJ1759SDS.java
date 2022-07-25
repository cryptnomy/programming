package DAY01.BJ1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1759SDS {
    static char[] data;
    static boolean[] visited;
    static int L, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        data = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            data[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(data);

        dfs(0, 0, 0, -1, "");
    }

    static void dfs(int length, int consonant, int vowel, int current, String pwd) {
        // 1. 체크인 - 생략 가능
        // 2. 목적지인가?: length == L => consonant 개수, vowel 개수 확인 암호 가능 판별
        if (length == L) {
            if (consonant > 1 && vowel > 0) { System.out.println(pwd); } // 정답 처리
        } else {
            // 3. 연결된 곳을 순회: current + 1 ~ C
            for (int i = current + 1; i < C; i++) {
                // 4. 갈 수 있는가?: 모두 갈 수 있음
                // 5. 간다 -> consonant, vowel
                if (isVowel(data[i])) {
                    dfs(length + 1, consonant, vowel + 1, i, pwd + data[i]);
                } else {
                    dfs(length + 1, consonant + 1, vowel, i, pwd + data[i]);
                }
            }
        }
        // 6. 체크아웃 - 생략 가능
    }

    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') { return true; }
        else { return false; }
    }
}
