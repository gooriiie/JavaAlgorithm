package BFS_DFS;

import java.util.*;

public class baekjoon_2178 {	// 미로찾기
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Queue<Point> q = new LinkedList<Point>();
		
		int[] x = {-1, 1, 0, 0};
		int[] y = {0, 0, -1, 1};
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		
		int[][] maze = new int[n][m];
		Boolean[][] visit = new Boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			char[] ch = sc.nextLine().toCharArray();
			
			for(int j = 0; j < m; j++) {
				visit[i][j] = false;
				maze[i][j] = ch[j] -'0';
				
				if(i == 0 && j == 0) {
					q.add(new Point(0,0));
					visit[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int newx = p.x + x[i];
				int newy = p.y + y[i];
				
				if(newx >= 0 && newx < n && newy >= 0 && newy < m && visit[newx][newy] == false && maze[newx][newy] == 1) {
					q.add(new Point(newx, newy));
					visit[newx][newy] = true;
					maze[newx][newy] = maze[p.x][p.y] + 1;
				}
				
			}
		}
		
		System.out.println(maze[n-1][m-1]);
		
	}
}

class Point {
	int x,y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
