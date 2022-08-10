package DAY06.BJ2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2252SDS {
	static int N, M;
	static int[] in;
	static List<Integer>[] adj;
	static Queue<Integer> q;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		in = new int[N+1];
		adj = new ArrayList[N+1];
		for(int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		int from, to;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			adj[from].add(to);
			in[to]++;
		}

		q = new LinkedList<>();
		for(int i = 1; i < N+1; i++) {
			if(in[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(" ");
			for(int next: adj[now]) {
				in[next]--;
				if(in[next] == 0) {
					q.add(next);
				}
			}
		}
		System.out.println(sb);		
	}
}