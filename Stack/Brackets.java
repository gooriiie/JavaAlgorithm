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
				
				if(c[i].equals("(") || c[i].equals("{") || c[i].equals("[")) {			// (,{,[ ?΄λ©? stack? push
					stack.push(c[i]);
				}
				
				else if((c[i].equals(")"))) {			// ) ?΄λ©?  
					if(!stack.isEmpty()) {				// stack?΄ λΉμ? ???€λ©?
						if(stack.peek().equals("(")) {	// stack? λ§? ?κ°? ( ?Όλ©?
							stack.pop();				// pop? ??€.
						}
						else {							// λ§¨μκ°? ( ?΄ ??λ©?
							stack.push(c[i]);			// push λ₯? ??€.
						}
					}
					else {
						stack.push(c[i]);				// stack?΄ λΉμ?€λ©? push
					}
				}
				
				else if((c[i].equals("}"))) {			// } ?Ό?
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
				
				else if((c[i].equals("]"))) {			// ] ?Ό?
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
				
				else if((c[i].equals("\""))) {			// " ?Ό?
					if(!stack.isEmpty()) {				// stack?΄ λΉμ? ???€λ©?
						if(stack.peek().equals("\"")) {	// stack? λ§¨μκ°? " ?΄?Όλ©?
							stack.pop();				// pop? ??€.
						}
						else {							// λ§¨μκ°? " κ°? ???Όλ©?
							stack.push(c[i]);			// pushλ₯? ??€.
							countone += 1;				// countone? +1
							if(countone ==2) {			// countone?΄ 2κ°? ?λ©?
								stack.pop();			// pop? ??€.
								while(!stack.peek().equals("\"")) {	// λ§¨μκ°? " κ°? ? ?κΉμ? pop???€.
									stack.pop();
								}
								stack.pop();		// ?λ²λ pop? ??€.
								countone = 0;		// countone? 0?Όλ‘? λ°κΎΌ?€.
							}
						}
					}
					else {							// stack?΄ λΉμ?€λ©? push
						stack.push(c[i]);
					}
				}
				
				else if((c[i].equals("\'"))) {		// ' ?Έ κ²½μ°
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
		
		
		
		if(stack.isEmpty()) {				// stack?΄ λΉμ?Όλ©? No Error | λΉμ? ???Όλ©? Compile Error
			System.out.println("No Error");
		}
		else {
			System.out.println("Compile Error");
		}
	}
}