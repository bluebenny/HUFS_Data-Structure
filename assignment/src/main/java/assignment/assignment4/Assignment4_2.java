package assignment.assignment4;

/*
 * DoubleLinkedList : insert(), delete() 
 */


// import java.io.*;
import java.util.Scanner;

class ListNode {
	String data;
	ListNode rlink;
	ListNode llink;
}

class DoubleLinkedList {
	private ListNode head; // 리스트의 첫번째 노드를 가리킴
	private ListNode tail; // 리스트의 마지막 노드를 가리킴

	public DoubleLinkedList() {
		head = tail = null; // 리스트가 비어있을 때는 모두 null 이다.
	}

    	/**
	 * 리스트는 이름순으로 정렬되므로 정렬된 적절한 위치에 삽입한다.
	 * @param str 삽입하고자 하는 데이터
	 * 작성하여야 한다.
	 */
	public void insert(String str) {
		ListNode nodeInserted = new ListNode();
		nodeInserted.data = str;

		if (this.head == null) { // case 0: <-- 김건우
			this.head = this.tail = nodeInserted;

			// System.out.println("insert: case 0 succeed -- " + str);
			return;
		}

		// case 1 or case 3
		// System.out.println("insert: case 1 or case 3 process -- " + str);
		
		for (ListNode nodePointer = this.head; nodePointer != null; nodePointer = nodePointer.rlink) { // case 1
			if (nodePointer.data.compareTo(str) >= 0) { // case 1: 김건우 나현흠 <-- 김도훈 // case 2: 김건우 김도훈 <-- 나현흠 // case 3: 김도훈 나현흠 <-- 김건우
				if (nodePointer.llink == null) {
					this.head = nodeInserted;
					nodeInserted.llink = null;
					nodeInserted.rlink = nodePointer;
					nodePointer.llink = nodeInserted;
				} else {
					nodeInserted.llink = nodePointer.llink;
					nodeInserted.rlink = nodePointer;
					nodePointer.llink.rlink = nodeInserted;
					nodePointer.llink = nodeInserted;
				}
				return;
			}
		}

		this.tail.rlink = nodeInserted; // case 2
		nodeInserted.llink = this.tail;
		this.tail = nodeInserted;

	}

	/**
	 * 인자로 입력받은 데이터를 삭제한다.
	 * @param str 삭제하고자 하는 데이터
	 * 작성하여야 한다.
	 */
	public void delete(String str) {
		// ListNode nodePointer = this.head;
		
		// System.out.println("delete: " + str);

		for (ListNode nodePointer = this.head; nodePointer != null; nodePointer = nodePointer.rlink) {
			if (nodePointer.data.equals(str)) {

				// algorithm Lecture 230407

				if (nodePointer.llink != null)
					nodePointer.llink.rlink = nodePointer.rlink;
				else
					head = head.rlink;
				
				if (nodePointer.rlink != null)
					nodePointer.rlink.llink = nodePointer.llink;
				// else
				// 	tail = tail.llink;

				
				// if (nodePointer.llink == null) {
				// 	this.head = nodePointer.rlink;
				// 	if (nodePointer.rlink != null)
				// 		nodePointer.rlink.llink = null;
				// } else if (nodePointer.rlink == null) {
				// 	if (nodePointer.llink != null)
				// 		nodePointer.llink.rlink = null;
				// } else {
				// 	nodePointer.llink.rlink = nodePointer.rlink;
				// 	nodePointer.rlink.llink = nodePointer.llink;
				// }
			}
		}

		// while (nodePointer.rlink != null) {
		// 	if (nodePointer.data.equals(str)) {
		// 		if (nodePointer.llink == null)
		// 			this.head = nodePointer.rlink;
		// 		else
		// 			nodePointer.llink.rlink = nodePointer.rlink;
		// 	}

		// 	nodePointer = nodePointer.rlink;
		// }
	}


	// 저장된 모든 데이터를 출력한다.
	public void print() {
		if (head == null) {
			System.out.println("EMPTY");
			return;
		}

		for(ListNode p = head; p != null; p = p.rlink)
			System.out.print(p.data + " ");
		System.out.println();
	}
}

class Assignment4_2 {
	
	// main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		DoubleLinkedList list = new DoubleLinkedList();
	
		while (true) {
			String cmd = scan.next();
			if (cmd.equals("E"))
				break;

			if (cmd.equals("I")) {
				list.insert(scan.next());
			} else if (cmd.equals("D")) {
				list.delete(scan.next());
			} else if (cmd.equals("P")) {
				list.print();
			} else {
				System.out.println("ERROR");
			}
		}

        scan.close();
	}
}

