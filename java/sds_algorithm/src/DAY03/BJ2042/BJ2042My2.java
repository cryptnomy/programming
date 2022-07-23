package DAY03.BJ2042;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ2042My2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static long[] tree;
	static int N, M, K;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// Make index tree
		int temp = 1;
		while (temp < N) {
			temp <<= 1;
		}	
		tree = new long[temp*2];
		// Bottom-up initialization
		for (int i=temp; i<N+temp; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}
		for (int i=temp; i<N+temp; i++) {
			int p = i >> 1;
			while (p != 0) {
				tree[p] = tree[p] + tree[i];
				p >>= 1;
			}
		}
		
		for (int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if (a == 1) update(b, c, temp);
			else sb.append(query(b, (int)c, temp)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	
	static void update(int index, long num, int temp) {
        index += temp - 1;
		long diff = num - tree[index];
		while (index != 0) {
			tree[index] += diff;
			index >>=1;
		}
	}
	
	static long query(int left, int right, int temp) {
        left += temp - 1;
        right += temp - 1;
		long sum = 0;
		while (left < right) {
			if ((left & 1) == 1) sum += tree[left++];
			if ((right & 1) == 0) sum += tree[right--];
			left >>= 1;
			right >>= 1;
		}
		if (left == right) sum += tree[left];
		return sum;
	}
}
