package assignment.assignment4;

/*
 * main: 두번째 다항식 코드 (O)
 * Polynomial: toString(), polyAdd() 
 */

// import java.io.*;
import java.util.Scanner;

class Polynomial {

	/**
	 * 클래스 내부에 클래스를 만드는 경우를 예로 든 것이다.
	 * 이렇게 할 경우 클래스 Term은 Polynomial 클래스 내에서만
	 * 의미가 있다는 것을 알 수 있다.
	 */
	class Term {
		int coef;
		int exp;
		Term link;
	}

	private Term head; // 첫번째 항을 가리키는 레퍼런스 변수
	private Term tail; // 마지막 항을 가리키는 레퍼런스 변수

	public Polynomial() {
		head = tail = null; // 원래 객체의 인스턴스 필드는 null로 초기화되지만 이해를 위해 초기화함
	}

	/**
	 * @param coef 계수
	 * @param exp  지수
	 */
	public void addTerm(int coef, int exp) {

		System.out.println("add: " + coef + "^" + exp);

		Term term = new Term();
		term.coef = coef;
		term.exp = exp;
		term.link = null;

		if (head == null) { // 처음으로 항이 추가되는 경우
			head = tail = term;
		} else {
			tail.link = term;
			tail = term; // 마지막을 가리키는 항을 재지정
		}
	}

	/**
	 * 출력할 때 사용
	 * 
	 * @return 객체를 문자열로 반환 (예: 3x^15+2x^3+4x^2+x+5 )
	 *         메소드를 완성하시오.
	 */
	public String toString() {

		if (this.head == null)
			return "0";

		String str = "";
		Term termPointer = this.head;

		while (true) {
			if (termPointer.exp > 0) {
				if (termPointer.coef != 1)
					str += termPointer.coef;

				if (termPointer.exp != 1)
					str += "x^" + termPointer.exp;
				else
					str += "x";
			} else {
				str += termPointer.coef;
			}

			if (termPointer.link == null) {
				break;
			} else {
				str += "+";

				termPointer = termPointer.link;
				continue;
			}
		}

		return str;
	}

	/**
	 * 두 개의 다항식을 더한다.
	 * 
	 * @param p1 첫번째 다항식
	 * @param p2 두번째 다항식
	 * @return 두 개의 다항식을 더한 결과
	 *         메소드를 완성하시오.
	 */
	public static Polynomial polyAdd(Polynomial p1, Polynomial p2) {

		Polynomial p = new Polynomial();

		Polynomial.Term termPointer1 = p1.head;
		Polynomial.Term termPointer2 = p2.head;

		while (termPointer1 != null || termPointer2 != null) {
			if (termPointer1 == null) {
				p.addTerm(termPointer2.coef, termPointer2.exp);
				termPointer2 = termPointer2.link;
			} else if (termPointer2 == null) {
				p.addTerm(termPointer1.coef, termPointer1.exp);
				termPointer1 = termPointer1.link;
			} else if (termPointer1.exp > termPointer2.exp) {
				p.addTerm(termPointer1.coef, termPointer1.exp);
				termPointer1 = termPointer1.link;
			} else if (termPointer1.exp == termPointer2.exp) {
				if (termPointer1.coef + termPointer2.coef != 0)
					p.addTerm(termPointer1.coef + termPointer2.coef, termPointer1.exp);
				termPointer1 = termPointer1.link;
				termPointer2 = termPointer2.link;
			} else {
				p.addTerm(termPointer2.coef, termPointer2.exp);
				termPointer2 = termPointer2.link;
			}
		}

		return p;
	}
}

public class Assignment4_1 {
	// main 메소드는 수정하지 마시오.
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

		// 두번째 다항식 입력 코드 작성할 것

		no = scan.nextInt();
		for (int i = 0; i < no; i++) {
			int coef = scan.nextInt();
			int exp = scan.nextInt();
			p2.addTerm(coef, exp);
		}

		// 두개의 다항식 덧셈
		Polynomial p3 = Polynomial.polyAdd(p1, p2);

		System.out.print(p3); // 이것은 System.out.print(p3.toString())과 동일

		scan.close();
	}
}
