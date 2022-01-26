package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2294 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[n];
		int[] dp = new int[k+1];
		
		for(int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		
		for(int i = 0; i < k+1; i++) {
			dp[i] = 100001;
		}
		
		dp[0] = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = coin[i]; j < k+1; j++) {
				dp[j] = Math.min(dp[j - coin[i]] + 1, dp[j]);
			}
		}
		
		System.out.println(dp[k] == 100001 ? -1 : dp[k]);
	}

}
