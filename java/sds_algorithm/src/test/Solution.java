package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;

/* Problem formulation
 * Graph = (V, E)
 * Edges consist of two types
 *  - (1) unidirectional ... disappear once used
 *  - (2) bidirectional ... can freely move among any node linked with this type
 * Score on each node
 * Goal: Among routes from 1 to N, find maximum score hit sequence
 */

 /*
 T ~ 30
 |V| |E| (|V| \in [2, 100_000], |E| \in [1, 200_000])
 scores \in [0, 1_000_000_000]
 (M lines of edges with direction type)
1
10 12
8 3 7 4 9 2 6 5 7 2
2 3 2
8 9 2
1 6 1
4 3 2
2 5 2
7 6 2
9 7 2
2 4 2
8 6 2
9 10 1
9 8 2
1 2 2
  */

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int T, V, E;
    static long answer;
    static long[] score;
    static int[] parent;
    static List<?>[] adj; // <Edge>

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            adj = new ArrayList[V+1];
            for (int i = 0; i < V + 1; ++i) {
                adj[i] = new ArrayList<Edge>();
            }

            bw.write("#" + tc + " " + answer + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) { parent[b] = a; }
        else { parent[a] = b; }
        
    }

    static int find(int x) {
        return parent[x] == x ? x : (parent[x] = find(parent[x]));
    }
}

class Edge implements Comparable<Edge> {
    int v, w;

    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }
}