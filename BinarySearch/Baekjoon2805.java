package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2805 {		// 나무자르기 문제

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int numberOfTree = Integer.parseInt(st.nextToken()); 
		
		long length = Long.parseLong(st.nextToken()); 
		
		st = new StringTokenizer(br.readLine());
		
		int[] tree = new int[numberOfTree];	
		
		int left = 1; 
		int right = Integer.MIN_VALUE; 
		
		for(int i = 0; i < tree.length; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			
			if(tree[i] > right) {	
				right = tree[i];
			}
		}
		
		Arrays.sort(tree);
		
		long sumOfLength;
		int answer = 0;
		
		while(left <= right) {
			sumOfLength = 0;
			
			int mid = (left + right) / 2;
			
			for(int i = 0; i < tree.length; i++) {
				
				long cutting;
				
				if(tree[i] > mid) {
					cutting = tree[i] - mid;
				}
				else {
					cutting = 0;
				}
				
				sumOfLength += cutting;
			}
			
			if(sumOfLength >= length) { 
				left = mid + 1;
				answer = (answer < mid)? mid : answer;
			}
			else if(sumOfLength < length) { 
				right = mid - 1;
			}
		}
		
		System.out.println(answer);
		
		
		
		
		
		
		
		
	}

}
