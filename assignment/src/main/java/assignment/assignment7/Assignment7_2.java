package assignment.assignment7;

// import java.io.*;
import java.util.Scanner;

// 필요한 클래스는 추가하시오.

class Queue {
    int front = 0;
    int rear = 0;
    int[] queue;

    public Queue() {
        this(50);
    }

    public Queue(int initLength) {
        queue = new int[initLength];
    }

    public void enqueue(int item) {
        queue[rear++] = item;
    }

    public int dequeue() {
        return queue[front++];
    }

    public boolean isEmpty() {
        return (front == rear && rear != 0);
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }
}



class BinaryTree {
	String[] array;
	public static final int INIT_SIZE = 10;
	public static final int ROOT = 1;
    
	public BinaryTree() {
		array = new String[INIT_SIZE];
	}
	
	public void set(int index, String data) {
		if (index >= array.length) {
			String[] newArray = new String[index + 10];
			for(int i = 0; i < array.length; i++)
				newArray[i] = array[i];
			array = newArray;
		}
		array[index] = data;
	}
	
	// 배열에서 원소를 얻는 메소드
	public String get(int index) {
		if (index >= array.length)
			return null;
		
		return array[index];
	}
	
	public void inorder() {
		inorder(ROOT);
	}
	
	public void preorder() {
		preorder(ROOT);
	}
	
	public void postorder() {
		postorder(ROOT);
	}
	
	public void levelorder() {
		levelorder(ROOT);
	}
	
	/*************************************
	 * 작성해야 하는 함수
	 *************************************/

	private void inorder(int idx) {
        if (idx * 2 < array.length)
		if (array[idx * 2] != null)
            inorder(idx * 2);

        System.out.print(array[idx] + " ");

        if (idx * 2 + 1 < array.length)
        if (array[idx * 2 + 1] != null)
            inorder(idx * 2 + 1);
	}
	
	private void preorder(int idx) {
        System.out.print(array[idx] + " ");

        if (idx * 2 < array.length)
		if (array[idx * 2] != null)
            preorder(idx * 2);
        
        if (idx * 2 + 1 < array.length)
        if (array[idx * 2 + 1] != null)
            preorder(idx * 2 + 1);
		
	}
	
	private void postorder(int idx) {
		if (idx * 2 < array.length)
		if (array[idx * 2] != null)
            postorder(idx * 2);
        
        if (idx * 2 + 1 < array.length)
        if (array[idx * 2 + 1] != null)
            postorder(idx * 2 + 1);

        System.out.print(array[idx] + " ");
	}
	
	private void levelorder(int idx) {
		Queue queue = new Queue(100);

        queue.enqueue(idx);

        while (queue.isNotEmpty()) {
            idx = queue.dequeue();
            System.out.print(array[idx] + " ");

            if (idx * 2 < array.length)
		    if (array[idx * 2] != null)
                queue.enqueue(idx * 2);
            
            if (idx * 2 + 1 < array.length)
            if (array[idx * 2 + 1] != null)
                queue.enqueue(idx * 2 + 1);
        }
	}
}


class Assignment7_2 {
	
	// 아래 main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		
		BinaryTree tree = new BinaryTree();
		
		int no = scan.nextInt();
		for(int i = 0; i < no; i++) {
			int index = scan.nextInt();
			String data = scan.next();
			
			tree.set(index, data);
		}
		
		scan.close();
		
		tree.inorder();
		System.out.println();
		
		tree.preorder();
		System.out.println();
		 
		tree.postorder();
		System.out.println();
		
		tree.levelorder();
	}
}
