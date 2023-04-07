package assignment.assignment3;

// import java.io.*;
import java.util.Scanner;

class SparseMatrix {
	int[][] m;

	/**
	 * @param row 행의 갯수
	 * @param col 열의 갯수
	 * @param no  0이 아닌 항의 갯수
	 */
	public SparseMatrix(int row, int col, int no) {
		m = new int[no + 1][3];
		m[0][0] = col;
		m[0][1] = row;
		m[0][2] = no;
	}

	// 이 행렬을 전치 행렬로 변환하는 알고리즘을 작성하시오.
	public void transpose() {

		int[][] t = new int[m[0][2] + 1][3];

		int nCol = t[0][0] = m[0][1];
		int nTerm = t[0][2] = m[0][2];

		int[] rowTerms = new int[nCol + 1];
		int[] rowBegins = new int[nCol + 1];

		for (int i = 1; i <= m[0][2]; i++) {
			rowTerms[m[i][1]] += 1;
		}
		rowBegins[0] = 0;
		for (int i = 1; i <= nCol; i++) {
			rowBegins[i] = rowTerms[i - 1] + rowBegins[i - 1];
		}

		for (int i = 1; i <= nTerm; i++) {
			int curNo = ++rowBegins[m[i][1]];

			t[curNo][0] = m[i][1];
			t[curNo][1] = m[i][0];
			t[curNo][2] = m[i][2];

		}

		m = t;

	}

	// 전치 행렬의 내용을 출력하는 코드를 작성하시오.
	public String toString() {
		StringBuffer str = new StringBuffer();

		for (int i = 0; i <= m[0][2]; i++) {
			str.append(m[i][0]).append(" ")
					.append(m[i][1]).append(" ")
					.append(m[i][2]).append("\n");
		}

		return str.toString();
	}
}

class Assignment3_2 {

	// main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int col = scan.nextInt();
		int row = scan.nextInt();
		int no = scan.nextInt();

		SparseMatrix matrix = new SparseMatrix(row, col, no);

		for (int i = 1; i <= no; i++) {
			matrix.m[i][0] = scan.nextInt();
			matrix.m[i][1] = scan.nextInt();
			matrix.m[i][2] = scan.nextInt();
		}

		matrix.transpose();

		System.out.print(matrix);

		scan.close();
	}
}

/*
 * 6 7 8
 * 0 0 76
 * 0 4 -19
 * 1 3 25
 * 3 4 56
 * 4 0 13
 * 0 0 0
 * 5 2 3
 * 5 5 13
 * 
 * 6 7 8
 * 0 0 76
 * 0 4 -19
 * 1 3 25
 * 2 6 3
 * 3 4 56
 * 4 0 13
 * 5 2 3
 * 5 5 13
 * 
 * 7 6 8
 * 0 0 76
 * 0 4 13
 * 2 5 3
 * 3 1 25
 * 4 0 -19
 * 4 3 56
 * 0 0 0
 * 6 2 3
 */