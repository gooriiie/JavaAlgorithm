package exercise;

import java.util.Scanner;

public class CodeTypeCheck {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] lowerCase = new int[26];
		int[] upperCase = new int[26];
		int[] digit = new int[10];
		
		String str = "";
		
		while(sc.hasNextLine()) {
			str += sc.nextLine();
		}
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				lowerCase[str.charAt(i) -'a'] += 1;
			}
			else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
				upperCase[str.charAt(i) -'A'] += 1;
			}
			else if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				digit[str.charAt(i) -'0'] += 1;
			}
			else if(str.charAt(i) == '#') {
				break;
			}
			else if(str.charAt(i) == '$') {
				lowerCase = new int[26];
				upperCase = new int[26];
				digit = new int[10];
			}
		}
		
		int lowerCaseMax = 0;
		int lowerCaseMaxIndex = 0;
		
		int upperCaseMax = 0;
		int upperCaseMaxIndex = 0;
		
		int digitMax = 0;
		int digitMaxIndex = 0;
		
		for(int i = 0; i < lowerCase.length; i++ ) {
			if(lowerCase[i] > lowerCaseMax) {
				lowerCaseMax = lowerCase[i];
				lowerCaseMaxIndex = i;
			}
			if(upperCase[i] > upperCaseMax) {
				upperCaseMax = upperCase[i];
				upperCaseMaxIndex = i;
			}
		}
		
		for(int i = 0; i < digit.length; i++) {
			if(digit[i] > digitMax) {
				digitMax = digit[i];
				digitMaxIndex = i;
			}
		}
		
		if(lowerCaseMax > upperCaseMax && lowerCaseMax > digitMax) {
			System.out.println("L" + (char)(lowerCaseMaxIndex + 'a') + lowerCaseMax);
		}
		else if(upperCaseMax > lowerCaseMax && upperCaseMax > digitMax) {
			System.out.println("U" + (char)(upperCaseMaxIndex + 'A') + upperCaseMax);
		}
		else if(digitMax > lowerCaseMax && digitMax > upperCaseMax) {
			System.out.println("D" + (char)(digitMaxIndex + '0') + digitMax);
		}
		else if(digitMax == upperCaseMax && digitMax == lowerCaseMax && lowerCaseMax == upperCaseMax) {
			System.out.println("D" + (char)(digitMaxIndex + '0') + digitMax);
		}
		else if(digitMax == upperCaseMax || digitMax == lowerCaseMax) {
			System.out.println("D" + (char)(digitMaxIndex + '0') + digitMax);
		}
		else if(lowerCaseMax == upperCaseMax) {
			System.out.println("L" + (char)(lowerCaseMaxIndex + 'a') + lowerCaseMax);
		}
	}

}
