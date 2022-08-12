package DAY08.BOJ_5719;
// package DAY08.BJ5719;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.PriorityQueue;
// import java.util.StringTokenizer;
// import java.util.Vector;

// public class BJ5719Fail {
//     static int N, M;
//     static int S, D;
//     static boolean[][] isShortest;
//     static int[] dist;
//     static List<Integer>[] parent;
//     static Vector<Edge>[] adj;

//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st;
//         StringBuilder sb = new StringBuilder();
//         while (true) {
//             st = new StringTokenizer(br.readLine());
//             N = Integer.parseInt(st.nextToken());
//             M = Integer.parseInt(st.nextToken());
//             if (N == 0 && M == 0) { break; }
//             isShortest = new boolean[N][N];
//             dist = new int[N];
//             parent = new ArrayList[N];
//             adj = new Vector[N];
//             for (int i = 0; i < N; i++) {
//                 parent[i] = new ArrayList<>();
//                 adj[i] = new Vector<>();
//             }
//             st = new StringTokenizer(br.readLine());
//             S = Integer.parseInt(st.nextToken());
//             D = Integer.parseInt(st.nextToken());
//             int u, v, p;
//             for (int i = 0; i < M; i++) {
//                 st = new StringTokenizer(br.readLine());
//                 u = Integer.parseInt(st.nextToken());
//                 v = Integer.parseInt(st.nextToken());
//                 p = Integer.parseInt(st.nextToken());
//                 adj[u].add(new Edge(v, p));
//             }
            
//             dijkstra(S, D);
//             backTracking(S, D);
//             dijkstra(S, D);
            
//             if (dist[D] == Integer.MAX_VALUE) { sb.append("-1\n"); }
//             else { sb.append(dist[D] + "\n"); }
//         }
//         System.out.print(sb.toString());
//     }

//     static void dijkstra(int source, int destination) {
//         for (int i = 0; i < N; i++) {
//             dist[i] = Integer.MAX_VALUE;
//         }
//         PriorityQueue<Edge> pq = new PriorityQueue<>();
//         dist[source] = 0;
//         pq.offer(new Edge(source, 0));
//         while (!pq.isEmpty()) {
//             Edge currEdge = pq.poll();
//             if (dist[currEdge.dest] < currEdge.length) { continue; }
//             for (Edge nextEdge : adj[currEdge.dest]) {
//                 if (!isShortest[currEdge.dest][nextEdge.dest]) {
//                     int newLength = dist[currEdge.dest] + nextEdge.length;
//                     if (dist[nextEdge.dest] == newLength) {
//                         parent[nextEdge.dest].add(currEdge.dest);
//                     } else if (dist[nextEdge.dest] > newLength) {
//                         dist[nextEdge.length] = newLength;
//                         parent[nextEdge.dest].clear();
//                         parent[nextEdge.dest].add(currEdge.dest);
//                         pq.offer(new Edge(nextEdge.dest, dist[nextEdge.dest]));
//                     }
//                 }
//             }
//         }
//     }

//     static void backTracking(int source, int current) {
//         if (source == current) { return; }
//         for (int next : parent[current]) {
//             if (!isShortest[next][current]) {
//                 isShortest[next][current] = true;
//                 backTracking(source, next);
//             }
//         }
//     }
// }

// class Edge implements Comparable<Edge> {
//     int dest;
//     int length;

//     public Edge(int dest, int length) {
//         this.dest = dest;
//         this.length = length;
//     }

//     @Override
//     public int compareTo(Edge o) {
//         return this.length - o.length;
//     }
// }
