package DAY01.BJ1759;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
import java.util.Arrays;
//import java.util.StringTokenizer;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;

public class BJ1759My {
    static char[] arr, given;
    static boolean[] visited;
    static int L, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        L = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);

        given = new char[C];
        visited = new boolean[C];

        str = br.readLine().split(" ");
        for (int i = 0; i < C; i++) {
            given[i] = str[i].charAt(0);
        }

        Arrays.sort(given);

        dfs(0, 0);
    }

    static void dfs(int start, int depth) {
        if (depth == L) {
            int vowel = 0;
            int consonant = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < C; i++) {
                if (visited[i]) {
                    sb.append(given[i]);
                    if (isVowel(given[i])) {
                        vowel++;
                    } else {
                        consonant++;
                    }
                }
            }
            if (vowel > 0 && consonant > 1)
                System.out.println(sb);
        }

        for (int i = start; i < C; i++) {
            visited[i] = true;
            dfs(i+1, depth+1);
            visited[i] = false;
        }
    }

    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        else
            return false;
    }
}
