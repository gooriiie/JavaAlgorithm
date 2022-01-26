package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Baekjoon11055 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		
		for(int i = 1; i < N; i++) {
			dp[i] = arr[i];
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[j] + arr[i], dp[i]);
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			if(dp[i] > max) {
				max = dp[i];
			}
		}
		System.out.println(max);
		
	}
}
