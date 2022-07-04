package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj_2675 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCase; i++) {
			String[] input = br.readLine().split(" ");
			int repeat = Integer.parseInt(input[0]);
			char[] chars = input[1].toCharArray();
			for (int j = 0; j < chars.length; j++) {
				for (int k = 0; k < repeat; k++) {
					sb.append(chars[j]);
				}
			}
			System.out.println(sb);
			sb.delete(0, sb.length());
		}

	}
}

