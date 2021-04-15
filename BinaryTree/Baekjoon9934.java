package BinaryTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Baekjoon9934 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		int deep = Integer.parseInt(br.readLine());
		int node = (int)Math.pow(2,deep) - 1;
		
		MyNode tree = null;
		
		for(int i = 0; i < node; i++) {
			if(i == 0) {
				tree = new MyNode(i);
			}
			else {
				insert(tree, i);	
			}
			
		}
		
		inorder(tree);
		
	}
	
	public static void insert(MyNode root, int key) {

			if(root.left == null) {
				root.left = new MyNode(key);
			}
			else if(root.right == null){
				root.right = new MyNode(key);
			}
			else {
				insert(root.left, key);
			}
	}
	
	public static void inorder(MyNode root) {
		if(root.left != null) {
			inorder(root.left);
		}
		System.out.print(root.data +" ");
		if(root.right != null) {
			inorder(root.right);
		}
	}
}



class MyNode {

	MyNode left;
	MyNode right;
	int data;

	MyNode(int data){
		this.data = data;
	}
}