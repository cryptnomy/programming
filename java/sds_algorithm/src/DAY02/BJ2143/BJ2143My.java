package DAY02.BJ2143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2143My {
    static long T; 
    static int n, m;
    static int[] A, B;
    static List<Integer> subA, subB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());
        // Make array A
        n = Integer.parseInt(br.readLine());
        A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        // Make array B
        m = Integer.parseInt(br.readLine());
        B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        // Make partial sum
        subA = new ArrayList<>();
        subB = new ArrayList<>();
        makeSublist(A, subA, n);
        makeSublist(B, subB, m);
        // Sort
        Collections.sort(subA);
        Collections.sort(subB);
        // Print result
        System.out.println(twoPointer(subA, subB));
    }

    static List<Integer> makeSublist(int[] arr, List<Integer> subArray, int len) {
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += arr[j];
                subArray.add(sum);
            }
        }
        return subArray;
    }

    static long twoPointer(List<Integer> subA, List<Integer> subB) {
        int pA = 0;
        int pB = subB.size() - 1;
        long count = 0;

        while (pA < subA.size() && pB > -1) {
            long sum = subA.get(pA) + subB.get(pB);

            if (sum < T) {
                pA++;
            }
            else if (sum > T) {
                pB--;
            }
            else {  // sum == T
                int a = subA.get(pA);
                int b = subB.get(pB);
                long aCount = 0;
                long bCount = 0;
                
                while (pA < subA.size() && subA.get(pA) == a) {
                    aCount++;
                    pA++;
                }
                while (pB > -1 && subB.get(pB) == b) {
                    bCount++;
                    pB--;
                }

                count += aCount * bCount;
            }
        }
        return count;
    }
}
