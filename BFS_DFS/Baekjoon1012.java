package BFS_DFS;

/*
2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1012 {

	static boolean[][] visit;
	static int[][] field;
	static int[] plusX = { -1, 1, 0 , 0};
	static int[] plusY = { 0, 0, -1, 1}; 
	static int row;
	static int col;
	static int number;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int k = 0; k < testCase; k++) {
			
			int count = 0;
			
			st = new StringTokenizer(br.readLine());
			
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			number = Integer.parseInt(st.nextToken());
			
			field = new int[row][col];
			visit = new boolean[row][col];
			
			for(int i = 0; i < field.length; i++) {	// 諛곗텛 湲� 0�쑝濡� 珥덇린�솕
				for(int j = 0; j < field[i].length; j++) {
					field[i][j] = 0;
				}
			}
			
			for(int i = 0; i < field.length; i++) {	// 諛곗텛 諛⑸Ц �뿬遺� 珥덇린�솕
				for(int j = 0; j < field[i].length; j++) {
					visit[i][j] = false;
				}
			}
			
			for(int i = 0; i < number; i++) {	// 諛곗텛媛� �엳�뒗 �쐞移섎뒗 1濡� 諛붽퓞
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				field[x][y] = 1;
			}
			
			for(int i = 0; i < field.length; i++) {
				for(int j = 0; j < field[i].length; j++) {
					
					if(field[i][j] == 1 && visit[i][j] == false) {
						Dfs(i,j);
						count++;
					}
				}
			}
			
			System.out.println(count);
			
		}
		
		
	}
	
	public static void Dfs(int x, int y) {
		visit[x][y] = true;
		
		for(int a = 0; a < plusX.length; a++) {
			
			int new_x = x + plusX[a];	// �쁽�옱吏��젏�뿉�꽌 �깉濡쒖슫 x媛�
			int new_y = y + plusY[a];	// �쁽�옱吏��젏�뿉�꽌 �깉濡쒖슫 y媛�
			
			if(new_x >= 0 && new_x < row && new_y >= 0 && new_y < col) { // �깉濡쒖슫 x,y�쓽 媛믪씠 踰붿쐞 �븞�씠怨�
				if(field[new_x][new_y] == 1 && visit[new_x][new_y] == false) { // �깉濡쒖슫 [x,y]吏��젏�씠 湲몄씠 �엳怨�, 諛⑸Ц�븯吏� �븡�� 寃쎌슦
					Dfs(new_x, new_y);
				}
			}
		}
	}
	
}
