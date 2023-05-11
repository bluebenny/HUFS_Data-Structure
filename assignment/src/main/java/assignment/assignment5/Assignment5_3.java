package assignment.assignment5;

import java.util.Scanner;

class Point {
	public int x, y;
}

class Status {
	public int x, y;
	public int position;
}

public class Assignment5_3 {
    // 필요한 메소드가 있으면 작성하시오.

	static int xMove(int position) {
		switch(position) {
			case 0:
				return -1;
			case 2:
				return 1;
			default:
				return 0;
		}
	}

	static int yMove(int position) {
		switch(position) {
			case 3:
				return -1;
			case 1:
				return 1;
			default:
				return 0;
		}
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int sizeX = scan.nextInt();
		int sizeY = scan.nextInt();
		
		Point start = new Point();
		start.x = scan.nextInt();
		start.y = scan.nextInt();
		
		Point exit = new Point();
		exit.x = scan.nextInt();
		exit.y = scan.nextInt();
		
		int maze[][] = new int[sizeY][sizeX];
		
		for(int i = 0; i < sizeY; i++)
			for (int j = 0; j < sizeX; j++)
				maze[i][j] = scan.nextInt();

		scan.close();
		
		// 아래 코드를 작성하시오.
		
		int[][] mark = new int[sizeY][sizeX];
		for(int i = 0; i < sizeY; i++)
			for (int j = 0; j < sizeX; j++)
				mark[i][j] = 0;

		Status[] stk = new Status[sizeX * sizeY];
		int top = -1;

		// initialize stk
		{ // push
			Status status = new Status();
			
			status.x = start.x;
			status.y = start.y;
			status.position = 0;

			stk[++top] = status;
		}

		mark[start.y][start.x] = 1;

		int x, y, position;
		while(top != -1) {
			{ // pop
				x = stk[top].x;
				y = stk[top].y;
				position = stk[top].position;
			} top--;
			
			while (position <= 3) {
				System.out.println("for position " + position);
				Point next = new Point();
				int[][] move = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
				next.x = x + move[position][0];
				next.y = y + move[position][1];

				// next.x = x + xMove(position);
				// next.y = y + yMove(position);

				if (next.x == exit.x && next.y == exit.y) {
					System.out.println("The path is as follows.");
					// 출력 형식
					System.out.println((next.x) + " " + (next.y));
					return;
				}

				if (maze[next.y][next.x] == 0 && mark[next.y][next.x] == 0) {
					mark[next.y][next.x] = 1;
					{ // push
						Status status = new Status();
						
						status.x = x;
						status.y = y;
						status.position = 0;
			
						stk[++top] = status;
						System.out.println("push: " + x + " " + y + " " + position);
					}

					x = next.x;
					y = next.y;
					position = 0;
					System.out.println("Goto " + x + " " + y);
					
				} else {
					position += 1;
				}
			}
			System.out.println("position not found");
		}
		System.out.println("There is no path");

	}
}
