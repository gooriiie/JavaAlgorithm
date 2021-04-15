package BinaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Baekjoon9934 {
	
	static int k;
	static ArrayList<ArrayList<Integer>> result;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
				
		StringTokenizer st;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());	// k개의 줄에 걸쳐서 정답 출력

		st = new StringTokenizer(br.readLine());	// 빌딩 방문순서 입력
		
		arr = new int[st.countTokens()];		// 방문순서 저장할 배열
		
		for(int i = 0; i < arr.length; i++) {	// arr 배열에 방문순서 저장
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		result = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i < k; i++) {
			result.add(new ArrayList<Integer>());
		}
		
		solve(0, arr.length - 1, 0);
		
		for(int i = 0; i < k; i++) {
			for(int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) +" ");
			}
			System.out.println();
		}
		
		
	}
	
	public static void solve(int start, int end, int floor) {
		
		if(floor == k) {
			return;
		}
		
		int mid = (start + end) / 2;
		
		result.get(floor).add(arr[mid]);
		
		solve(start, mid-1, floor+1);
		solve(mid+1, end, floor+1);
		
	}
}