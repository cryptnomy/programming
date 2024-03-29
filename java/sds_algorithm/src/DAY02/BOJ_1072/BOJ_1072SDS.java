package DAY02.BOJ_1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072SDS {
    static long x, y, z;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());

        z = 100 * y / x;
        if (z >= 99) {
            System.out.println(-1);
        } else {
            long start = 0;
            long end = x;
            while (start < end) {
                long mid = (start + end) / 2;
                long newRate = 100 * (y + mid) / 2;
                // 승률이 그대로인 경우
                if (newRate == z) {
                    start = mid + 1;
                }
                // 승률이 변한 경우
                else {
                    end = mid;
                }
            }
            System.out.println(end);
        }
    }
}
