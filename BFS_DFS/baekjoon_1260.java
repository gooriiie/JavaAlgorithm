package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_1260 {
	
	static Boolean[][] line;
	static Boolean[] check;
	static int n;
	static int m;
	static int v; 
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		line = new Boolean[n+1][n+1];
		check = new Boolean[n+1];
		
		for(int i = 0; i < line.length; i++) {
			check[i] = false;
			for(int j = 0; j < line.length; j++) {
				line[i][j] = false;
			}
		}
		
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			line[a][b] = line[b][a] = true;
		}
		
		dfs(v);
		
		System.out.println();
		for(int i = 0; i < line.length; i++) {
			check[i] = false;
		}
		
		bfs(v);
		
	}
	
	static void dfs(int v) {
		check[v] = true;
		System.out.print(v +" ");
		
		for(int i = 1; i <= n; i++) {
			if(check[i] == false && line[v][i] == true) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(v);
		
		check[v] = true;
		System.out.print(v +" ");
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int i = 1; i <= n; i++) {
				if(check[i] == false && line[tmp][i] == true) {
					q.add(i);
					check[i] = true;
					System.out.print(i +" ");
				}
			}
		}
	}
	
}
