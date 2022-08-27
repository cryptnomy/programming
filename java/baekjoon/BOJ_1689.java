package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1689 {
    static int N;
    static int s, e;
    static List<Segment> segments;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        segments = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            segments.add(new Segment(s, e));
        }

        Collections.sort(segments);

        // for (int i = 0; i < N; ++i) {
        //     bw.append(segments.get(i).s + " " + segments.get(i).e + "\n");
        // }
        // bw.append("----------\n");

        pq = new PriorityQueue<>();
        pq.offer(segments.get(0).e);

        int result = 1;
        for (int i = 1; i < N; ++i) {
            while (!pq.isEmpty() && pq.peek() <= segments.get(i).s) {
                pq.poll();
            }
            pq.offer(segments.get(i).e);

            // for (int j = 0; j < pq.size(); ++j) {
            //     bw.append(pq.toArray()[j] + " ");
            // }
            // bw.append("\n");

            result = Math.max(result, pq.size());
        }
        bw.append(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

class Segment implements Comparable<Segment> {
    int s, e;
    public Segment(int s, int e) {
        this.s = s;
        this.e = e;
    }
    @Override
    public int compareTo(Segment o) {
        return this.s - o.s;
    }
}
