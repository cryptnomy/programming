/* BOJ 1759 - Securing the barn
   https://www.acmicpc.net/problem/1759
*/ 

package AlgorithmBasics.BOJ_1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1759 {
    static int L, C;
    static char[] characters;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        characters = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            characters[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(characters);

        dfs(0, 0, 0, -1, "");

        System.out.println(sb);
        br.close();
    }

    static void dfs(int length, int consonant, int vowel, int current, String pwd) {
        if (length == L) {
            if (consonant > 1 && vowel > 0) {
                sb.append(pwd + "\n");
                return;
            }
        }
        for (int i = current + 1; i < C; i++) {
            if (isVowel(characters[i])) {
                dfs(length + 1, consonant, vowel + 1, i, pwd + characters[i]);
            } else {
                dfs(length + 1, consonant + 1, vowel, i, pwd + characters[i]);
            }
        }
    }

    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        } else {
            return false;
        }
    }
}