package DynamicProgramming;

import java.util.Scanner;

public class Baekjoon1010 {

	public static int[][] dp = new int[30][30];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		
		
		for(int t = 0; t < testCase; t++) {
			
			for(int i = 0; i < 30; i++) {
				dp[i][i] = 1;
				dp[i][0] = 1;
			}
			
			for(int i = 1; i < 30; i++) {
				for(int j = 1; j < 30; j++) {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}
			}
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println(dp[M][N]);
		}
	}
	
}
