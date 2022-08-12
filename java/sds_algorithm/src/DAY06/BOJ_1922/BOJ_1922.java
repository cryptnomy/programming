package DAY06.BOJ_1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1922 {
    static int N, M;
    static int[] parent;
    static int minCost;
    static PriorityQueue<Computer> pq;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        pq = new PriorityQueue<>();

        int u, v, w;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            pq.offer(new Computer(u, v, w));
        }
        
        while (!pq.isEmpty()) {
            Computer cmp = pq.poll();
            if (find(cmp.u) != find(cmp.v)) {
                union(cmp.u, cmp.v);
                minCost += cmp.weight;
            }
        }

        System.out.println(minCost);
    }

    static int find(int x) {
        return x == parent[x] ? x : (parent[x] = find(parent[x]));
    }

    static void union(int u, int v) {
        u = find(u);
        v = find(v);
        if(u != v) {
            if (u < v) { parent[v] = u;}
            else { parent[u] = v; }
        }
    }
}

class Computer implements Comparable<Computer> {
    int u;
    int v;
    int weight;

    public Computer(int u, int v, int weight) {
        super();
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Computer o) {
        return this.weight - o.weight;
    }
}
