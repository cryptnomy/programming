package DAY01.BJ1759;

import java.io.IOException;
import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
import java.util.Scanner;

public class BJ1759SDS {
    static char[] data;
    static boolean[] visited;
    // static List<String> result;
    static int L, C;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        data = new char[C];
        // result = new LinkedList<>();

        for (int i = 0; i < C; i++) {
            data[i] = sc.next().charAt(0);
        }
        sc.close();

        Arrays.sort(data);

        dfs(0, 0, 0, -1, "");

        //for (String res: result) {
        //    System.out.println(res);
        //}
    }

    static void dfs(int length, int consonant, int vowel, int current, String pwd) {
        // 1. 체크인 - 생략 가능
        // 2. 목적지인가?: length == L => consonant 개수, vowel 개수 확인 암호 가능 판별
        if (length == L) {
            if (consonant > 1 && vowel > 0) {
                // 정답 처리
                //result.add(pwd);
                System.out.println(pwd);
            }
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
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        else
            return false;
    }
}
