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
		k = Integer.parseInt(br.readLine());	// k���� �ٿ� ���ļ� ���� ���

		st = new StringTokenizer(br.readLine());	// ���� �湮���� �Է�
		
		arr = new int[st.countTokens()];		// �湮���� ������ �迭
		
		for(int i = 0; i < arr.length; i++) {	// arr �迭�� �湮���� ����
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