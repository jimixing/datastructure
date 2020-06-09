package com.jimmy.data.structure.exam1;

import java.util.Stack;

import lombok.Data;

public class Exam1 {

	
	public void question1_convertTreeToBiList() {
		
		Node root=new Node();
		root.setData(10);
		
		Node left1=new Node();
		left1.setData(6);
		
		Node right1=new Node();
		right1.setData(14);
		
		root.setLeft(left1);
		root.setRight(right1);
		
		Node left11=new Node();
		left11.setData(4);
		
		Node left12=new Node();
		left12.setData(8);
		
		left1.setLeft(left11);
		left1.setRight(left12);
		
		
		Node right11=new Node();
		right11.setData(12);
		
		Node right12=new Node();
		right12.setData(16);
		right1.setLeft(right11);
		right1.setRight(right12);
		
		Node head=convertTreeToBiList(root,false);
		while(head.getLeft()!=null) {
			head=head.getLeft();
		}
		while(head!=null) {
			System.out.print(head.getData()+",");
			head=head.getRight();
		}
		
		
	}
	
	
	private Node convertTreeToBiList(Node root,boolean leftflag) {
		if(root==null|| root.getLeft()==null&&root.getRight()==null) {
			return root;
		}
		Node left=convertTreeToBiList(root.getLeft(),false);
		
		Node right=convertTreeToBiList(root.getRight(),true);
		
		if(left!=null) {
			left.setRight(root);
			root.setLeft(left);
		}
		if(right!=null) {
			root.setRight(right);
			right.setLeft(root);
		}
		
		if(!leftflag) {
			return right==null?root:right;
		}else {
			return left==null?root:left;
		}
		
		
		
	}
	
	
	
	public class  minStack{
		private Stack<Integer> stack=new Stack<Integer>();
		private Stack<Integer> temp=new Stack<Integer>();
		
		public void push(int data) {
			if(stack.isEmpty()) {
				stack.push(data);
				return;
			}
			while(!stack.isEmpty()&&stack.peek()<data) {
				temp.push(stack.pop());
			}
			stack.push(data);
			while(!temp.isEmpty()) {
				stack.push(temp.pop());
			}
			
		}
		public Integer min() {
			if(!stack.isEmpty()) {
				return stack.peek();
			}
			return -1;
		}
		
		public Integer pop() {
			if(!stack.isEmpty()) {
				return stack.pop();
			}
			return -1;
		}
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam1 ex=new Exam1();
	//	ex.question1_convertTreeToBiList();
		minStack ms=ex.new minStack();
		
		ms.push(3);
		ms.push(8);
		ms.push(12);
		ms.push(4);

		
		int value=ms.min();
		System.out.print(value);
	}

	

	@Data
	public class Node{
		private int data;
		private Node left;
		private Node right;
	}
	
	 
	
}
