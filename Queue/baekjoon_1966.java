package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_1966 {	// 프린터 큐

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;		

		int number = Integer.parseInt(br.readLine());

		for(int i = 0; i < number; i ++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int loc = Integer.parseInt(st.nextToken());

			List<document> printer = new ArrayList<document>();

			st = new StringTokenizer(br.readLine());
			for(int a = 0; a < n; a++) {
				printer.add(new document(Integer.parseInt(st.nextToken()), a));
			}

			int count = 1;
			loop:
				while(!printer.isEmpty()) {
					document doc = printer.get(0);

					for(int j = 1; j < printer.size(); j++) {
						if(doc.imp < printer.get(j).imp) {
							printer.remove(doc);
							printer.add(doc);
							continue loop;
						}
					}

					if(doc.loc == loc) {
						break;
					}
					else {
						printer.remove(0);
						count++;
					}
				}
			System.out.println(count);
		}
	}

	static class document {
		int imp;
		int loc;

		public document(int imp, int loc) {
			this.imp = imp;
			this.loc = loc;
		}
	}
}
