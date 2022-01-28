package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11048 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] candy = new int[N+1][M+1];
		int[][] dp = new int[1001][1001];
		
		for(int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < M+1; j++) {
				candy[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][1] = candy[1][1];
		
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < M+1; j++) {
				dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + candy[i][j];
			}
		}
		System.out.println(dp[N][M]);
	}

}
