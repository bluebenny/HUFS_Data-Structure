// package assignment.assignment7;

// // import java.io.*;
// import java.util.Scanner;

// class BinaryTree {
// 	String data;
// 	BinaryTree left;
// 	BinaryTree right;
	
// 	public BinaryTree(String data) {
// 		this.data = data;
// 		left = right = null;
// 	}
	
// 	public void setChildren(BinaryTree left, BinaryTree right) {
// 		this.left = left;
// 		this.right = right;
// 	}
// }

// // Stack 클래스에 필요한 필드와 메소드를 추가하고, push, pop, isEmpty를 수정하여 완성하시오.
// class Stack {
//     int top = -1;
//     BinaryTree[] stack;

//     public Stack() {
//         this(50);
//     }

//     public Stack(int initLength) {
//         stack = new BinaryTree[initLength];
//     }

//     // 필요한 필드와 메소드를 추가하시오.

//     public void push(BinaryTree item) {
//         stack[++top] = item;
//     }

//     public BinaryTree pop() {
//         return stack[top--];
//     }

//     public boolean isEmpty() {
//         return (top == -1);
//     }
// }

// class Queue {
//     int front = 0;
//     int rear = 0;
//     BinaryTree[] queue;

//     public Queue() {
//         this(50);
//     }

//     public Queue(int initLength) {
//         queue = new BinaryTree[initLength];
//     }

//     public void enqueue(BinaryTree item) {
//         queue[rear++] = item;
//     }

//     public BinaryTree dequeue() {
//         return queue[front++];
//     }

//     public boolean isEmpty() {
//         return (front == rear && rear != 0);
//     }

//     public boolean isNotEmpty() {
//         return !isEmpty();
//     }
// }

// // 추가적으로 필요한 클래스(예를 들어 큐)가 있으면 작성하시오.




// class Assignment7_1 {
	
	
// 	/***********************************
// 	 * 아래 4개의 메소드를 작성하시오. *
// 	***********************************/

// 	public static void inorder(BinaryTree node) {
//         if (node.left != null)
//             inorder(node.left);
        
//         System.out.print(node.data + " ");

//         if (node.right != null)
//             inorder(node.right);
// 	}
	
// 	public static void preorder(BinaryTree node) {

//         System.out.print(node.data + " ");

// 		if (node.left != null)
//             preorder(node.left);
        

//         if (node.right != null)
//             preorder(node.right);
		
// 	}
	
// 	public static void postorder(BinaryTree node) {
// 		if (node.left != null)
//             postorder(node.left);

//         if (node.right != null)
//             postorder(node.right);

//         System.out.print(node.data + " ");
		
// 	}
	
// 	public static void levelorder(BinaryTree node) {
//         Queue queue = new Queue(100);

//         queue.enqueue(node);

//         while (queue.isNotEmpty()) {
//             node = queue.dequeue();
//             System.out.print(node.data + " ");

//             if (node.left != null)
//                 queue.enqueue(node.left);
//             if (node.right != null)
//                 queue.enqueue(node.right);
//         }
// 	}
	
// 	// 아래 main 메소드는 수정하지 마시오.
// 	public static void main(String[] args) throws Exception {
// 		Scanner scan = new Scanner(System.in);
// 		Stack stack = new Stack();
		
// 		BinaryTree root = null;
		
// 		// 이진 트리 생성
// 		while(scan.hasNext()) {
// 			String token = scan.next();
// 			if (token.equals("null")) {
// 				stack.push(null);
// 			} else if (token.equals(")")) {
// 				BinaryTree right = stack.pop();
// 				if (stack.isEmpty()) {
// 					root = right;
// 					break;
// 				}
// 				BinaryTree left = stack.pop();
// 				root = stack.pop();
// 				root.setChildren(left, right);
// 				stack.push(root);
// 			} else if (token.equals("(")) {
// 				continue;
// 			} else {
// 				stack.push(new BinaryTree(token));
// 			}
// 		}
		
// 		scan.close();
		
// 		inorder(root);
// 		System.out.println();
// 		preorder(root);
// 		System.out.println();
// 		postorder(root);
// 		System.out.println();
// 		levelorder(root);
// 	}
// }