package DAY02.BJ1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1072 {
    static long x, y, z;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());

        z = y * 100 / x;
        if (z >= 99) {
            System.out.println(-1);
        } else {
            binarySearch(1, x);
        }
    }

    static void binarySearch(long start, long end) {
        long mid = 0, percentage = 0;
        while (start <= end) {
            mid = (start+end) / 2;
            // Caution for arithmetic order
            // (y + mid) / (x + mid) * 100 -> different result
            percentage = (y + mid) * 100 / (x + mid);
            if (percentage > z) end = mid - 1;
            else start = mid + 1;
        }
        System.out.println(start);
    }
}
