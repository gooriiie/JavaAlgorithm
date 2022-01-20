package Stack;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class BracketScore {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int result = 0;
		
		Stack<String> stack = new Stack<String>();
		HashMap<String, Integer> map = new HashMap<String,Integer>();

		while(sc.hasNextLine()) {
			
			String line = sc.nextLine();
			String[] c = line.split(" ");
			
			for(int i = 0; i < c.length; i++) {
				
				if(c[i].equals("(") || c[i].equals("[") || c[i].equals("{")) {
					stack.push(c[i]);
				}
				else if(c[i].equals(")")) {
					if(!stack.isEmpty()) {
						if(stack.peek().equals("(")) {
							stack.pop();
						}
						else {
							result += Integer.parseInt(stack.pop());
							stack.pop();
							result *= 2;
						}
					}
				}
				else if(c[i].equals("}")) {
					if(!stack.isEmpty()) {
						if(stack.peek().equals("{")) {
							stack.pop();
						}
						else {
							result += Integer.parseInt(stack.pop());
							stack.pop();
							result *= 3;
						}
					}
				}
				else if(c[i].equals("}")) {
					if(!stack.isEmpty()) {
						if(stack.peek().equals("{")) {
							stack.pop();
						}
						else {
							result += Integer.parseInt(stack.pop());
							stack.pop();
							result *= 3;
						}
					}
				}
				else if(c[i].equals("]")) {
					if(!stack.isEmpty()) {
						if(stack.peek().equals("[")) {
							stack.pop();
						}
						else {
							result += Integer.parseInt(stack.pop());
							stack.pop();
							result *= 4;
						}
					}
				}
				else {
					stack.push(c[i]);
				}
			}
		
		}
		System.out.println(result);
	}

}
