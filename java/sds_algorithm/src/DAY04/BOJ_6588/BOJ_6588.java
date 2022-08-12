package DAY04.BOJ_6588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6588 {
    static int LIMIT = 1000001;
    //seiveOfEratosthenes, false for prime number
    static boolean[] isNotPrime = new boolean[LIMIT];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Seive of Eratosthenes initialization
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i < LIMIT; i++) {
            if (!isNotPrime[i]) {   // for prime number                
                for (int j = i + i; j < LIMIT; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        while (true) {
            int evenNum = Integer.parseInt(br.readLine());
            if (evenNum == 0) { break; }
            boolean isProven = false;
            for (int i = 2; i <= evenNum/2; i++) {
                if (!isNotPrime[i] && !isNotPrime[evenNum - i]) {
                    System.out.println(evenNum + " = " + i + " + " + (evenNum - i));
                    isProven = true;
                    break;
                }
            }
            if (!isProven) { System.out.println("Goldbach's conjecture is wrong."); }
        }
    }
}
