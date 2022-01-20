package Stack;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Brackets {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Stack<String> stack = new Stack<String>();
		HashMap<String, Integer> map = new HashMap<String,Integer>();

		while(sc.hasNextLine()) {

			String line = sc.nextLine();
			String[] c = line.split("");
			int countone = 0;
			int counttwo = 0;
			
			for(int i = 0; i < c.length; i++) {
				
				if(c[i].equals("(") || c[i].equals("{") || c[i].equals("[")) {			// (,{,[ ?���? stack?�� push
					stack.push(c[i]);
				}
				
				else if((c[i].equals(")"))) {			// ) ?���?  
					if(!stack.isEmpty()) {				// stack?�� 비�? ?��?��?���?
						if(stack.peek().equals("(")) {	// stack?�� �? ?���? ( ?���?
							stack.pop();				// pop?�� ?��?��.
						}
						else {							// 맨위�? ( ?�� ?��?���?
							stack.push(c[i]);			// push �? ?��?��.
						}
					}
					else {
						stack.push(c[i]);				// stack?�� 비었?���? push
					}
				}
				
				else if((c[i].equals("}"))) {			// } ?��?��
					if(!stack.isEmpty()) {		
						if(stack.peek().equals("{")) {
							stack.pop();
						}
						else {
							stack.push(c[i]);
						}
					}
					else {
						stack.push(c[i]);
					}
				}
				
				else if((c[i].equals("]"))) {			// ] ?��?��
					if(!stack.isEmpty()) {
						if(stack.peek().equals("[")) {
							stack.pop();
						}
						else {
							stack.push(c[i]);
						}
					}
					else {
						stack.push(c[i]);
					}
				}
				
				else if((c[i].equals("\""))) {			// " ?��?��
					if(!stack.isEmpty()) {				// stack?�� 비�? ?��?��?���?
						if(stack.peek().equals("\"")) {	// stack?�� 맨위�? " ?��?���?
							stack.pop();				// pop?�� ?��?��.
						}
						else {							// 맨위�? " �? ?��?��?���?
							stack.push(c[i]);			// push�? ?��?��.
							countone += 1;				// countone?�� +1
							if(countone ==2) {			// countone?�� 2�? ?���?
								stack.pop();			// pop?�� ?��?��.
								while(!stack.peek().equals("\"")) {	// 맨위�? " �? ?��?��까�? pop?��?��?��.
									stack.pop();
								}
								stack.pop();		// ?��번더 pop?�� ?��?��.
								countone = 0;		// countone?�� 0?���? 바꾼?��.
							}
						}
					}
					else {							// stack?�� 비었?���? push
						stack.push(c[i]);
					}
				}
				
				else if((c[i].equals("\'"))) {		// ' ?�� 경우
					if(!stack.isEmpty()) {
						if(stack.peek().equals("\'")) {
							stack.pop();
						}
						else {
							stack.push(c[i]);
							counttwo += 1;
							if(counttwo ==2) {
								stack.pop();
								while(!stack.peek().equals("\'")) {
									stack.pop();
								}
								stack.pop();
								counttwo = 0;
							}
						}
					}
					else {
						stack.push(c[i]);
					}
				}
				
				else {
					continue;
				}
			}


		}
		
		
		
		if(stack.isEmpty()) {				// stack?�� 비었?���? No Error | 비�? ?��?��?���? Compile Error
			System.out.println("No Error");
		}
		else {
			System.out.println("Compile Error");
		}
	}
}