package DynamicProgramming;

import java.util.Scanner;

public class Baekjoon10844 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long count = 0;
		long mod = 1000000000;
		
		long[][] dp = new long[N+1][10];
		
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i < N+1; i++) {
			for(int j = 0; j < 10; j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][j+1];
				}
				else if(j == 9) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]);
				}
			}
		}
		
		for(int i = 0; i < 10; i++) {
			count += dp[N][i] % mod;
		}
		
		System.out.println(count % mod);
	}

}
