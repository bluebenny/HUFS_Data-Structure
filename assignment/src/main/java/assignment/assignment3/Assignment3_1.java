package assignment.assignment3;

// import java.io.*;
import java.util.Scanner;

class Polynomial {
	public int[][] term;
	public int curNoTerm = 0;

	// @param noTerm 항의 개수
	public Polynomial(int noTerm) {
		term = new int[noTerm][2];
	}

	public Polynomial() {
		this(20); // default로 최대 20개의 항을 저장함
	}

	/**
	 * @param coef 계수
	 * @param exp  지수
	 */
	public void addTerm(int coef, int exp) {

		System.out.println("add: " + coef + "^" + exp);

		term[curNoTerm][0] = exp; //
		term[curNoTerm][1] = coef;
		curNoTerm++;
	}

	// @param exp
	// 작성하시오
	public void delTerm(int exp) {

		System.out.println("del: " + exp);
		/* 작성 부분 */
		int delIndex = -1;
		for (int i = 0; i < curNoTerm; i++) {
			if (term[i][0] == exp) {
				delIndex = i;
				break;
			}
		}
		if (delIndex == -1) {
			System.out.println("No such element");
			return;
		}

		curNoTerm--;
		for (int i = delIndex; i < curNoTerm; i++)
			term[i] = term[i + 1];

		/* 작성 부분 끝 */
	}

	/**
	 * 출력할 때 사용
	 * 
	 * @return 객체를 문자열로 반환 (예: 3x^15+2x^3+4x^2+x+5 )
	 *         작성하시오.
	 */
	public String toString() {
		/* 작성 부분 */
		String str = "";

		for (int i = 0; i < this.curNoTerm; i++) {

			System.out.println("str: " + this.term[i][1] + "^" + this.term[i][0]);

			if (this.term[i][0] > 0) { // 1차 이상의 항인 경우
				if (this.term[i][1] != 1) // 계수는 1이 아닌 경우에만 표시
					str += this.term[i][1];
				
				if (this.term[i][0] != 1) // 차수는 1이 아닌 경우에만 표시
					str += "x^" + this.term[i][0];
				else
					str += "x";
			} else { // 상수항인 경우
				str += this.term[i][1];
			}
			
			if (i < this.curNoTerm - 1) str += "+";
		}

		if (str.equals("")) return "0";
		else return str;

		/* 작성 부분 끝 */

		/*
		 * if (this.curNoTerm == 0) return "0";

		int i;
		String str = "";

		for (i = 0; i < this.curNoTerm - 1; i++) {

			if (this.term[i][1] != 1)
				str += this.term[i][1];
			
			if (this.term[i][0] != 1)
				str += "x^" + this.term[i][0];
			else
				str += "x";
			
			str += "+";
		}

		if (this.term[i][0] > 0) {
			if (this.term[i][1] != 1)
				str += this.term[i][1];
			
			if (this.term[i][0] != 1)
				str += "x^" + this.term[i][0];
			else
				str += "x";
		} else { // 상수항인 경우
			str += this.term[i][1];
		}

		if (str.equals("")) return "0";


		return str;
		 */
	}

	/**
	 * 두 개의 다항식을 더한다.
	 * 
	 * @param p1 첫번째 다항식
	 * @param p2 두번째 다항식
	 * @return 두 개의 다항식을 더한 결과
	 *         작성할 것
	 */
	public static Polynomial polyAdd(Polynomial p1, Polynomial p2) {
		/* 작성 부분 */
		int newNoTerm = p1.curNoTerm + p2.curNoTerm;
		Polynomial p = new Polynomial(newNoTerm);

		int expIndex1 = 0, expIndex2 = 0;
		while (expIndex1 + expIndex2 < newNoTerm) {
			if (p1.term[expIndex1][0] > p2.term[expIndex2][0]) {
				p.addTerm(p1.term[expIndex1][1], p1.term[expIndex1++][0]);
			} else if (p1.term[expIndex1][0] == p2.term[expIndex2][0]) {
				if (p1.term[expIndex1][1] + p2.term[expIndex2][1] != 0)
					p.addTerm(p1.term[expIndex1][1] + p2.term[expIndex2][1], p1.term[expIndex1][0]);
				expIndex1++;
				expIndex2++;
			} else {
				p.addTerm(p2.term[expIndex2][1], p2.term[expIndex2++][0]);
			}
		}

		return p;

		/* 작성 부분 끝 */

		/*
		 * 
		int newNoTerm = p1.curNoTerm + p2.curNoTerm;
		Polynomial p = new Polynomial(newNoTerm);

		int cnt = 0;
		int expIndex1 = 0, expIndex2 = 0;
		while (cnt < newNoTerm) {
			if (p1.term[expIndex1][0] > p2.term[expIndex2][0]) {
				
				p.addTerm(p1.term[expIndex1][1], p1.term[expIndex1++][0]);
				cnt++;
			} else if (p1.term[expIndex1][0] == p2.term[expIndex2][0]) {
				if (p1.term[expIndex1][1] + p2.term[expIndex2][1] != 0)
					p.addTerm(p1.term[expIndex1][1] + p2.term[expIndex2][1], p1.term[expIndex1][0]);
				
				expIndex1++;
				expIndex2++;
				cnt += 2;
			} else {
				p.addTerm(p2.term[expIndex2][1], p2.term[expIndex2++][0]);
				cnt++;
			}
		}

		return p;
		 */
	}
}

public class Assignment3_1 {

	/*
Test Case 1

3
2 3 4 2 5 0
2
3 15 1 1

3x^15+2x^3+4x^2+x+5
3x^15 2x^3 4x^2 x 5

3x^15+2x^3+4x^2+x^1+5
3x^15 2x^3 4x^2 1x^1 5x^0
	 */

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		// 첫번째 다항식 입력
		Polynomial p1 = new Polynomial();
		int no = scan.nextInt();
		for (int i = 0; i < no; i++) {
			int coef = scan.nextInt();
			int exp = scan.nextInt();
			p1.addTerm(coef, exp);
		}

		Polynomial p2 = new Polynomial();

		/* 작성 부분 */
		no = scan.nextInt();
		for (int i = 0; i < no; i++) {
			int coef = scan.nextInt();
			int exp = scan.nextInt();
			p2.addTerm(coef, exp);
		}

		/* 작성 부분 끝 */

		// 두개의 다항식 덧셈
		Polynomial p3 = Polynomial.polyAdd(p1, p2);

		System.out.println(p3.curNoTerm);
		System.out.print(p3); // 이것은 System.out.print(p3.toString())과 동일

		scan.close();
	}
}