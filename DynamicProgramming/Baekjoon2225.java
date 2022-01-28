package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2225 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long [][] dp = new long[N+1][K+1];
		
		for(int i = 0; i < N+1; i++) {
			dp[i][0] = 0;
			dp[i][1] = 1;
		}
		
		for(int j = 2; j < K+1; j++) {
			for(int i = 0; i < N+1; i++) {
				for(int h = 0; h <= i; h++) {
					dp[i][j] += dp[h][j-1] % 1000000000;
				}
			}
		}
		
		System.out.println(dp[N][K] % 1000000000);
	}
}
