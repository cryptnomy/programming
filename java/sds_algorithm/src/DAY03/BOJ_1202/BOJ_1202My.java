package DAY03.BOJ_1202;
// 4 n log(n) ~ O(n log(n))

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1202My {
    static int N, K;
    static List<Jewel> jewels;
    static List<Bag> bags;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewels = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(M, V));
        }

        bags = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int C = Integer.parseInt(br.readLine());
            bags.add(new Bag(C));
        }

        Collections.sort(bags);
        Collections.sort(jewels);

        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        long answer = 0;
        int j = 0;

        for (int i = 0; i < K; i++) {
            while (true) {
                if (j >= N) break;
                Jewel jewel = jewels.get(j);
                if (bags.get(i).C < jewels.get(j).M) break;
                pq.add(jewel.V);
                j++;
            }
            if (!pq.isEmpty()) answer += Math.abs(pq.poll());
        }

        System.out.println(answer);
    }
}

class Jewel implements Comparable<Jewel> {
    int M;  // mass
    int V;  // value

    Jewel(int M, int V) {
        this.M = M;
        this.V = V;
    }

    @Override
    public int compareTo(Jewel o) {
        return this.M - o.M;    // ascending order w.r.t. mass
    }
}

class Bag implements Comparable<Bag> {
    int C;

    Bag(int C) {
        this.C = C;
    }

    @Override
    public int compareTo(Bag o) {
        return this.C - o.C;
    }
}
