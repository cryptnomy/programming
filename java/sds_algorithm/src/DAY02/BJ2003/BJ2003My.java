package sds_algorithm.src.DAY02.BJ2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2003My {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0, high = 0, count = 0, sum = arr[0];
        while (true) {
            if (sum == M) {
                count++;
                sum -= arr[low++];
            } else if (sum > M) {
                sum -= arr[low++];
            } else {
                sum += arr[++high];
            }
            if (high == N) {
                break;
            }
        }
        System.out.println(count);
    }

    // static int twoPointer(int[] arr, int N, int M) {
    //     int low = 0, high = 0, count = 0, sum = 0;        
    //     while (true) {
    //         /* sum == M -> 답 low ++
    //          * sum > M -> low++
    //          * sum < M -> high++
    //          */

    //         // My answer
    //         // if (sum >= M) {
    //         //     sum -= arr[low++];
    //         // } else if (high == N) break;
    //         // else {  // if (sum < M && high != N)
    //         //     sum += arr[high++];
    //         // }
    //         // if (sum == M) {
    //         //     count++;
    //         // }

    //         // SDS answer
    //         if (sum == M) {
    //             count++;
    //             sum -= arr[low++];
    //         } else if (sum > M) {
    //             sum -= arr[low++];
    //         } else {
    //             sum += arr[++high];
    //         }
    //         if (high == N) {
    //             break;
    //         }
            
    //         // Wrong
    //         // if (high == N) {
    //         //     break;
    //         // } else if (sum >= M) {
    //         //     sum -= arr[low++];
    //         // } else {
    //         //     sum += arr[high++];
    //         // if (sum == M)
    //         //     count++;
    //         // }
    //     }
    //     return count;
    //}
}
