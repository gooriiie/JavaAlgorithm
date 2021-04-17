package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_10815 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int[] card = new int[n];
		
		String[] str = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(str[i]);
		}
		
		int m = Integer.parseInt(br.readLine());
		String[] str2 = br.readLine().split(" ");
		
		Arrays.sort(card);
		
		for(int i = 0; i < m; i++) {
			int answer = search(Integer.parseInt(str2[i]), card);
			
			if(answer == -1) {
				System.out.print(0 + " ");
			}
			else {
				System.out.print(1 + " ");
			}
		}
		
	}
	
	static int search(int goal, int[] card) {
		
		int left = 0;
		int right = card.length - 1;
		int mid;
		
		while(left <= right) {
			mid = (left + right) / 2;
			if(card[mid] < goal) {
				left = mid + 1;
			}
			else if(card[mid] > goal) {
				right = mid - 1;
			}
			else if(card[mid] == goal){
				return mid;
			}
		}
		return -1;
	}

}
