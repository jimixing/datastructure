package com.jimmy.data.structure.exam1;

import java.util.PriorityQueue;
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
	
	public void question2_findMininStack() {
		minStack ms=new minStack();
		
		ms.push(3);
		ms.push(8);
		ms.push(12);
		ms.push(4);

		
		int value=ms.min();
		System.out.print(value);
	}
	
	
	public void question3_findMaxWindowOfArray() {
		int[] array= {1,-2,3,10,-4,7,2,-5};
		
		int[] dp=new int[array.length];
		dp[0]=array[0];
		int max=dp[0];
		for(int i=1;i<array.length;i++) {
			
			dp[i]=Math.max(dp[i-1]+array[i], 0);
			if(dp[i]>max) {
				max=dp[i];
			}
			
		}
		System.out.print(max);
	}
	
	public void question4_maxSumInTree() {
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
		
		int sum=36;
		int[] PATH=new int[100];
		maxSumInTree(root,sum,PATH,0);
		
		
	}
	
	private void printPath(int []Path) {
		for(int i=0;i<Path.length;i++) {
			if(Path[i]!=0) {
				System.out.print(Path[i]+",");
			}
		}
		
		
	}
	public void maxSumInTree(Node root,int sum,int[] PATH,int pos) {
		PATH[pos]=root.getData();
		
		if(root.getLeft()==null&&root.getRight()==null) {
			if(sum==root.getData()) {
				printPath(PATH);
			}
		}
		if(root.getLeft()!=null&&sum>root.getData()) {
			maxSumInTree(root.getLeft(),sum-root.getData(),PATH,pos+1);
		} 
		
		if(root.getRight()!=null&&sum>root.getData()) {
			maxSumInTree(root.getRight(),sum-root.getData(),PATH,pos+1);
		}
	}
	
	
	public void question5_findKthInArray() {
		
		int[] array= {4,3,6,5,7,1,8,2};
		
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
		
		for(int i=0;i<array.length;i++) {
			pq.add(array[i]);
		}
		for(int i=0;i<4;i++) {
			System.out.print(pq.poll()+",");
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam1 ex=new Exam1();
		ex.question5_findKthInArray();
	//	ex.question1_convertTreeToBiList();
		
	}

	

	@Data
	public class Node{
		private int data;
		private Node left;
		private Node right;
	}
	
	 
	
}
