// package DAY06.BJ1922;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.PriorityQueue;
// import java.util.StringTokenizer;

// public class BJ1922My1 {
//     static int N, M;
//     static int[] parent;
    
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st;
//         N = Integer.parseInt(br.readLine());
//         M = Integer.parseInt(br.readLine());

//         PriorityQueue<Edge> pq = new PriorityQueue<>();
        
//         parent = new int[N+1];
//         for(int i = 1; i <= N; i++){
//             parent[i] = i;
//         }
        
//         int a, b, c;
//         for(int i = 0 ; i < M; i++){
//             st = new StringTokenizer(br.readLine());
//             a = Integer.parseInt(st.nextToken());
//             b = Integer.parseInt(st.nextToken());
//             c = Integer.parseInt(st.nextToken());
//             pq.add(new Edge(a, b, c));
//         }
        
//         int cnt = 0, total = 0;
//         while(cnt < N-1 && !pq.isEmpty()){
//             Edge tmp = pq.poll();
//             if(find(tmp.u) != find(tmp.v)){
//                 cnt++;
//                 union(tmp.u, tmp.v);
//                 total += tmp.w;
//             }
//         }
        
//         System.out.println(total);
//     }
    
//     static int find(int x){
//         return parent[x] = (parent[x] == x) ? x : find(parent[x]);
//     }
    
//     static void union(int a, int b) {
//         a = find(a);
//         b = find(b);
//         parent[a] = b;
//     }
// }

// class Edge implements Comparable<Edge> {
//     int u, v, w;

//     public Edge(int u, int v, int w) {
//         this.u = u;
//         this.v = v;
//         this.w = w;
//     }

//     @Override
//     public int compareTo(Edge o) {
//         return this.w - o.w;
//     }
// }
