package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11057 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int result = 0;

		int[][] dp = new int[N+1][10];

		dp[0][0] = 0;
		dp[1][1] = 1; // 0 1 2 3 4 5 6 7 8 9
		
		for(int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 1; i < N+1; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k <= j; k++) {
					dp[i][j] += dp[i-1][k];					
					dp[i][j] %= 10007;
				}
			}
		}
		
		for(int i = 0; i < 10; i++) {
			result += dp[N][i];
		}
		
		System.out.println(result % 10007);
	}

}
