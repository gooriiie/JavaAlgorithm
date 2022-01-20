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
				
				if(c[i].equals("(") || c[i].equals("{") || c[i].equals("[")) {			// (,{,[ ?´ë©? stack?— push
					stack.push(c[i]);
				}
				
				else if((c[i].equals(")"))) {			// ) ?´ë©?  
					if(!stack.isEmpty()) {				// stack?´ ë¹„ì? ?•Š?•˜?‹¤ë©?
						if(stack.peek().equals("(")) {	// stack?˜ ë§? ?œ„ê°? ( ?¼ë©?
							stack.pop();				// pop?„ ?•œ?‹¤.
						}
						else {							// ë§¨ìœ„ê°? ( ?´ ?•„?‹ˆë©?
							stack.push(c[i]);			// push ë¥? ?•œ?‹¤.
						}
					}
					else {
						stack.push(c[i]);				// stack?´ ë¹„ì—ˆ?‹¤ë©? push
					}
				}
				
				else if((c[i].equals("}"))) {			// } ?¼?•Œ
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
				
				else if((c[i].equals("]"))) {			// ] ?¼?•Œ
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
				
				else if((c[i].equals("\""))) {			// " ?¼?•Œ
					if(!stack.isEmpty()) {				// stack?´ ë¹„ì? ?•Š?•˜?‹¤ë©?
						if(stack.peek().equals("\"")) {	// stack?˜ ë§¨ìœ„ê°? " ?´?¼ë©?
							stack.pop();				// pop?„ ?•œ?‹¤.
						}
						else {							// ë§¨ìœ„ê°? " ê°? ?•„?‹ˆ?¼ë©?
							stack.push(c[i]);			// pushë¥? ?•œ?‹¤.
							countone += 1;				// countone?— +1
							if(countone ==2) {			// countone?´ 2ê°? ?˜ë©?
								stack.pop();			// pop?„ ?•œ?‹¤.
								while(!stack.peek().equals("\"")) {	// ë§¨ìœ„ê°? " ê°? ? ?•Œê¹Œì? pop?„?•œ?‹¤.
									stack.pop();
								}
								stack.pop();		// ?•œë²ˆë” pop?„ ?•œ?‹¤.
								countone = 0;		// countone?„ 0?œ¼ë¡? ë°”ê¾¼?‹¤.
							}
						}
					}
					else {							// stack?´ ë¹„ì—ˆ?‹¤ë©? push
						stack.push(c[i]);
					}
				}
				
				else if((c[i].equals("\'"))) {		// ' ?¸ ê²½ìš°
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
		
		
		
		if(stack.isEmpty()) {				// stack?´ ë¹„ì—ˆ?œ¼ë©? No Error | ë¹„ì? ?•Š?•˜?œ¼ë©? Compile Error
			System.out.println("No Error");
		}
		else {
			System.out.println("Compile Error");
		}
	}
}