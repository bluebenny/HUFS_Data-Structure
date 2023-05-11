package assignment.assignment5;

// import java.io.*;
import java.util.Scanner;

class Assignment5_1 {
	
	// 필요한 필드나 메소드가 있으면 작성하시오.
	
	
	public static void main(String[] args) throws Exception {

		int top = 0;
		double[] stk = new double[100];


		// double num = 0;
		double a1, a2;
		Scanner scan = new Scanner(System.in);
		
		// 아래 코드를 완성하시오.
		String str = scan.next();
		while (!str.equals("$")) {
			if (str.equals("+")) {
				a1 = stk[--top];
				a2 = stk[--top];

				stk[top++] = a2 + a1;

				// System.out.println(a1);
				// System.out.println(a2);
				// System.out.println(stk[top]);
				// System.out.println();
			} else if (str.equals("-")) {
				a1 = stk[--top];
				a2 = stk[--top];

				stk[top++] = a2 - a1;

				// System.out.println(a1);
				// System.out.println(a2);
				// System.out.println(stk[top]);
				// System.out.println();
				
			} else if (str.equals("*")) {
				a1 = stk[--top];
				a2 = stk[--top];

				stk[top++] = a2 * a1;
				// System.out.println(a1);
				// System.out.println(a2);
				// System.out.println(stk[top]);
				// System.out.println();
				
			} else if (str.equals("/")) {
				a1 = stk[--top];
				a2 = stk[--top];

				stk[top++] = a2 / a1;
				// System.out.println(a1);
				// System.out.println(a2);
				// System.out.println(stk[top]);
				// System.out.println();
				
			} else {
				stk[top++] = Double.parseDouble(str);	
			}
			
			str = scan.next();
		}

		System.out.println(stk[0]);

        scan.close();
	}
}