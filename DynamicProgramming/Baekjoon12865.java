package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon12865 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] weight = new int[N+1];
		int[] value = new int[N+1];
		int[][] dp = new int[N+1][K+1];
		
		for(int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			weight[i] = W;
			value[i] = V;
		}
		
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < K+1; j++) {
				dp[i][j] = dp[i-1][j];
				if(j - weight[i] >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j - weight[i]] + value[i]);
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
	}

}
