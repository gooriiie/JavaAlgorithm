package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon11052 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] pack = new int[N+1];
		int[] dp = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < N+1; i++) {
			pack[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = pack[1];
		for(int i = 2; i < N+1; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i-j] + pack[j], dp[i]);
			}
		}
		System.out.println(dp[N]);
	}

}
