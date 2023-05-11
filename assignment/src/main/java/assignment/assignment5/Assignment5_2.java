package assignment.assignment5;

import java.util.HashMap;
import java.util.Map;
// import java.io.*;
import java.util.Scanner;

class Assignment5_2 {
	
	// 필요한 필드나 메소드가 있으면 작성하시오.
	static final Map<String, Integer> PIS;
	static final Map<String, Integer> PIE;
	static {
		PIS = new HashMap<String, Integer>();
		PIS.put("^", 3);
		PIS.put("*", 2);
		PIS.put("/", 2);
		PIS.put("+", 1);
		PIS.put("-", 1);
		PIS.put("(", 0);

		PIE = new HashMap<String, Integer>();
		PIE.put("^", 3);
		PIE.put("*", 2);
		PIE.put("/", 2);
		PIE.put("+", 1);
		PIE.put("-", 1);
		PIE.put("(", 4);
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		int top = -1;
		String[] stk = new String[100];
		String out = "";
		
		// 아래 코드를 작성하시오.
		String str = scan.next();
		while (!str.equals("$")) {
			
			switch(str) {
				case ")": {
					while (top != -1 && !stk[top].equals("("))
						out += stk[top--] + " ";
					top--;
					break;
				}
				case "(":
				case "+":
				case "-":
				case "*":
				case "/":
				case "^": {
					while (top != -1 && PIS.get(stk[top]) >= PIE.get(str))
						out += stk[top--] + " ";
					stk[++top] = str;
					break;
				}
				case " ":
					break;
				default:
					out += str + " ";
					break;
			}
			
			str = scan.next();
		}

		for (int i = top; i >= 0; i--) {
			out += stk[i] + " ";
		}

		System.out.println(out);

        scan.close();
	}
}
