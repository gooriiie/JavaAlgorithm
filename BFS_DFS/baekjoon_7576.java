package BFS_DFS;

import java.util.*;

public class baekjoon_7576 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Queue<Tomato> q = new LinkedList<Tomato>();

		int[] x = {-1, 1, 0, 0};
		int[] y = {0, 0, -1, 1};

		int m = sc.nextInt();
		int n = sc.nextInt();

		int[][] tomato = new int[n][m];
		Boolean[][] visit = new Boolean[n][m];

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				visit[i][j] = false;
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				tomato[i][j] = sc.nextInt();

				if(tomato[i][j] == 1) {
					visit[i][j] = true;
					q.add(new Tomato(i,j,0));
				}
				else if(tomato[i][j] == -1) {
					visit[i][j] = true;
				}
			}
		}

		int finalday = 0;
		while(!q.isEmpty()) {
			Tomato t = q.poll();

			for(int i = 0; i < 4; i++) {
				int newx = t.x + x[i];
				int newy = t.y + y[i];

				if(newx >= 0 && newx < n && newy >= 0 && newy < m && visit[newx][newy] == false) {
					q.add(new Tomato(newx, newy, t.day + 1));

					tomato[newx][newy] = 1;
					visit[newx][newy] = true;
				}
			}

			if(finalday < t.day) {
				finalday = t.day;
			}
		}

		if(isCheck(tomato) && finalday != 0) {
			System.out.println(finalday);
		}
		else if(isCheck(tomato) && finalday == 0) {
			System.out.println(0);
		}
		else {
			System.out.println(-1);
		}
	}
	public static boolean isCheck(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] != 1 && arr[i][j] != -1) {
					return false;
				}
			}
		}
		return true;
	}

}
class Tomato {
	int x,y;
	int day;

	Tomato(int x, int y, int day){
		this.x = x;
		this.y = y;
		this.day = day;
	}
}
