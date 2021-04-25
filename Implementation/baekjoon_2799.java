package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2799 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int floor = Integer.parseInt(st.nextToken());
		int number = Integer.parseInt(st.nextToken());
		
		char[][] apt = new char[5 * floor + 1][5 * number + 1];
		
		for(int i = 0; i < apt.length; i++	) {
			char[] ch = br.readLine().toCharArray();
			for(int j = 0; j < apt[0].length; j++) {
				apt[i][j] = ch[j];
			}
		}
		
		int[] count = new int[5];
		for(int i = 1; i < apt.length; i += 5) {
			for(int j = 1; j < apt[0].length; j += 5) {
				if(apt[i][j] == '.') {
					count[0]++;
				}
				else if(apt[i+1][j] == '.'){
					count[1]++;
				}
				else if(apt[i+2][j] == '.') {
					count[2]++;
				}
				else if(apt[i+3][j] == '.') {
					count[3]++;
				}
				else{
					count[4]++;
				}
			}
		}
		for(int i = 0; i < count.length; i++) {
			System.out.print(count[i] +" ");
		}
	}

}
