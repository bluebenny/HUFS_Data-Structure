package assignment;

import java.util.Scanner;
// import java.io.*;

class Assignment1_3 {
	// 피보나치 수열을 계산하는 아래 fib 메소드를 작성하시오.
	// 이때 동적 프로그래밍 기법을 이용하여 코드를 작성하시오.
	// 필요하다고 판단되는 필드나 메소드가 있다면 추가하여도 됩니다.
	public static long fib(int n) {
		
		if (n == 0) return 0;
		if (n == 1) return 1;
		
		long[] a = new long[n];
		
		return fib(n - 1, a) + fib(n - 2, a);
	}

	public static long fib(int n, long[] a) {
		
		if (n == 0) return 0;
		if (n == 1) return 1;
		
		if (a[n - 1] != 0) return a[n - 1];
		
		long result = fib(n - 1, a) + fib(n - 2, a);
        a[n - 1] = result;

        return result;
		
	}

    // main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();			// 데이터의 갯수 입력
		
		System.out.println(fib(n));
	}
}