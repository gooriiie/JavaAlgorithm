package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon1920 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int sizeOfA = Integer.parseInt(st.nextToken());
		
		int[] A = new int[sizeOfA];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		int sizeOfNumber = Integer.parseInt(st.nextToken());
		
		int[] number = new int[sizeOfNumber];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < number.length; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(A);
		
		for(int i = 0; i < sizeOfNumber; i++) {
			
			int mid;
			int left = 0;
			int right = A.length - 1;
			
			while(left <= right) {
				
				mid = (left + right) / 2;
				
				if(number[i] == A[mid]) {
					System.out.println(1);
					break;
				}
				else if(number[i] > A[mid]) {
					left = mid + 1;
				}
				else if(number[i] < A[mid]) {
					right = mid - 1;
				}
				
				if(right < left) {
					System.out.println(0);
				}
				
			}
			
		}
		
	}

}
