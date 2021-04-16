package MinimumSpanningTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon1197 {

	static int v, e;
	static int[] parent;
	static PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
	static int result = 0;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());

		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		parent = new int[v + 1];

		for(int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			queue.add(new Edge(start, end, weight));
		}
		
		for(int i = 0; i < e; i++) {
			Edge edge = queue.poll();
			
			int start = find(edge.start);
			int end = find(edge.end);
			
			if(start != end) {
				union(start, end);
				result += edge.weight;
			}
			else {
				continue;
			}
		}
		
		System.out.println(result);

	}
	
	public static int find(int a) {
		
		if(parent[a] == a) {
			return a;
		}
		else {
			parent[a] = find(parent[a]);
			return parent[a];
		}
	}
	
	public static void union(int a, int b) {
		
		parent[a] = b;
		
	}
}

class Edge implements Comparable<Edge> {

	int start;
	int end;
	int weight;

	public Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Edge e) {
		return (this.weight > e.weight)? 1 : -1;
	}
}
