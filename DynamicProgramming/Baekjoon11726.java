package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11726 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i < n+1; i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % 10007;
		}
		
		System.out.println(dp[n] % 10007);
		
	}

}
