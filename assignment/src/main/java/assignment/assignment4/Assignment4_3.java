package assignment.assignment4;

/*
 * GenList: equals()
 * GenList.ListNode: clone()
 */

// import java.io.*;
// import java.util.Scanner;

// @SuppressWarnings("serial")
class NoDeepCopiedObjectException extends RuntimeException {
}

class GenList implements Cloneable {
	
	private class ListNode implements Cloneable {
		private Object data;
		private ListNode link;
	
		public ListNode() {
			data = null;
			link = null;
		}

		// 작성해야 함 (deep copy)
		public Object clone() throws CloneNotSupportedException {

			ListNode n = new ListNode();

			if (this.data instanceof GenList) {
				n.data = ((GenList) this.data).clone();
			} else {
				n.data = this.data;
			}

			if (this.link != null) {
				n.link = (ListNode) this.link.clone();
			}

			return n;

		}

		// 수정하면 안됨.
		public boolean equals(Object obj) {
			if (this == obj) {
				throw new NoDeepCopiedObjectException();
			}

			if (!(obj instanceof ListNode))
				return false;

			ListNode node = (ListNode)obj;

			boolean b = false;
			if (data == null && node.data == null)
				b = true;
			else if (data != null && node.data != null)
				b = data.equals(node.data);

			if (b) {
				if (link == null && node.link == null)
					b = true;
				else if (link != null && node.link != null)
					b = link.equals(node.link);
			}
			
			return b;
		}
	}

    	
	private ListNode head;
	
	public void insertData(Object data) {
		ListNode newNode = new ListNode();
		newNode.data = data;
		newNode.link = head;
		head = newNode;
	}
	
	public void print() {
		System.out.print("(");
		for(ListNode p = head; p != null; p = p.link) {
			if (p.data instanceof GenList)
				((GenList)p.data).print();
			else
				System.out.print(p.data);
			
			if (p.link != null)
				System.out.print(", ");
		}
		System.out.print(")");
	}

    @Override
	public boolean equals(Object obj) {
		// 보통 obj instanceof GenList 형태로 검사하나
		// 이렇게 할 경우 obj가 GenList의 하위 클래스인
		// 경우에도 일치하는 것으로 평가되기 때문에
		// 두 클래스가 정확히 일치하는지 검사하는 방법 사용
		if (this.getClass() != obj.getClass())
			return false;
		
		return head.equals(((GenList)obj).head);
	}


    @Override
	protected Object clone() throws CloneNotSupportedException {
		GenList list = new GenList();
		list.head = (ListNode) head.clone();
		return list;
	}

	// public void specificPrint() {
	// 	((GenList)((GenList)head.link.data).head.link.data).print();
	// 	System.out.println();
	// 	((GenList)((GenList)((GenList)head.link.link.data).head.link.data).head.link.data).print();
	// 	System.out.println();

	// 	System.out.print("Same object?: ");
	// 	if (((GenList)((GenList)head.link.data).head.link.data) == ((GenList)((GenList)((GenList)head.link.link.data).head.link.data).head.link.data))
	// 		System.out.println("true");
	// 	else
	// 		System.out.println("false");
	// 	System.out.println();

	// 	((GenList)((GenList)head.link.data).head.link.data).head.data = "hello";
	// }
}


class Assignment4_3 {
	
	// main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		GenList p = new GenList();
		p.insertData(82);
		p.insertData("Korea");

		GenList q = new GenList();
		q.insertData(p);
		q.insertData("Seoul");

		GenList r = new GenList();
		r.insertData(q);
		r.insertData("Busan");

		GenList l = new GenList();
		l.insertData(r);
		l.insertData(q);
		l.insertData("City");
	
		// 디버깅을 할 때 print 함수 이용	
		// l.print();
		// System.out.println();

		GenList k = null;
		try {
			k = (GenList)(l.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		// k.print();
		// l.specificPrint();
		// k.specificPrint();

		// l.print();
		// System.out.println();
		// k.print();
		// System.out.println();

		System.out.println(l.equals(k));
	}
}