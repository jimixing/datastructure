package com.jimmy.data.structure.exam1;

import java.util.Arrays;
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
	
	
	public void question7_findListCross() {
		Node2 head1=new Node2();
		head1.setData(1);
		Node2 headtem=head1;
		Node2 cross=null;
		for(int i=0;i<10;i++) {
			Node2 tem=new Node2();
			tem.setData((int)(Math.random()*20));
			headtem.setNext(tem);
			headtem=headtem.getNext();
			if(i==6) {
				cross=headtem;
			}
		}
		
		
		Node2 head2=new Node2();
		head2.setData(2);
		headtem=head2;
		for(int i=0;i<3;i++) {
			Node2 tem=new Node2();
			tem.setData((int)(Math.random()*20));
			headtem.setNext(tem);
			headtem=headtem.getNext();
		}
		headtem.setNext(cross);
		
		Node2 node=findListCross(head1,head2);
		System.out.print(node.getData());
		
	}
	
	private Node2 findListCross(Node2 head1,Node2 head2) {
		
		Node2 tem1=head1;
		int len1=0;
		while(tem1!=null) {
			len1++;
			tem1=tem1.getNext();
		}
		
		Node2 tem2=head2;
		int len2=0;
		while(tem2!=null) {
			len2++;
			tem2=tem2.getNext();
		}
		
		if(len1>len2) {
			int l=0;
			tem1=head1;
			while(l<len1-len2) {
				tem1=tem1.getNext();
				l++;
			}
			tem2=head2;
		}else if(len2>len1) {
			int l=0;
			tem2=head2;
			while(l<len2-len1) {
				tem2=tem2.getNext();
				l++;
			}
			tem1=head1;
		}
		
		int pos=0;
		while(tem1!=null&&tem2!=null&&tem1!=tem2) {
			tem1=tem1.getNext();
			tem2=tem2.getNext();
			pos++;
		}
		System.out.print(pos+" ");
		return tem1;
	}
	
	public void question8_reverseList() {
		Node2 head1=new Node2();
		head1.setData(1);
		Node2 headtem=head1;
		for(int i=0;i<10;i++) {
			Node2 tem=new Node2();
			tem.setData((int)(Math.random()*20));
			headtem.setNext(tem);
			headtem=headtem.getNext();
		}
		printList(head1);
		
		Node2 res=reverseList(head1);
		printList(res);
		
		Node2 pre=null;
		Node2 cur=res;
		Node2 next=null;
		while(cur!=null) {
			next=cur.getNext();
			cur.setNext(pre);
			pre=cur;
			cur=next;	
		}
		printList(pre);
		
		
//		int Num=1000;
//		int[] array=new int[Num+1];
//		int repeat=findRepeate(array,Num);
//		System.out.print(repeat);
		
		int value=100;
		int leftmove=value<<3;
		System.out.print(leftmove- value);
	}
	private int findRepeate(int[] array,int arrange) {
		int sum=0;
		for(int i=0;i<array.length;i++) {
			sum+=array[i];
		}
		for(int i=0;i<arrange;i++) {
			sum-=arrange;
		}
		return sum;
		
	}
	
	private void printList(Node2 head) {
		while(head!=null) {
			System.out.print(head.getData()+",");
			head=head.getNext();
		}
		System.out.println();
		
	}
	private Node2 reverseList(Node2 head) {
		
		if(head.getNext()==null) {
			return head;
		}
		Node2 tem=reverseList(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);
		return  tem;
		
	}
	
	private boolean findPostBinTree(int[] array,int start, int end) {
		if(start==end) return true;
		int i=start;
		while(i<=end&&array[i]<array[end])i++;
		if(i>=end) return false;
		return findPostBinTree(array,start,i-1)&&findPostBinTree(array,i,end-1);
		
		
	}
	
	
	public void question9_findPostBinTree() {
		int[] array= {5,7,6,9,11,10,8};
		//int[] array= {7,4,6,5};
		boolean isPost=findPostBinTree(array,0,array.length-1);
		System.out.print(isPost);
		
	}
	
	
	public void question10_reversesentence() {
		String str="i am a student.";
		String[] split=str.split("\\s");
		for(int i=0;i<split.length/2;i++) {
			String tem=split[i];
			split[i]=split[split.length-1-i];
			split[split.length-1-i]=tem;
		}
		System.out.print(Arrays.toString(split));
		
		
	}
	
	private Node generateTree() {
		
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
		return root;
	}
	
	public void question11_maxDistance() {
	
		Node root=generateTree();
		Int dep=new Int();
		int maxValue=maxDistance(root,dep);
		System.out.print(maxValue);
		
	}
	private int maxDistance(Node root,Int depth) {
		if(root==null) return 0;
		Int depL=new Int(),depR=new Int();
		int maxLeft=maxDistance(root.getLeft(),depL);
		int maxRight=maxDistance(root.getRight(),depR);
		depth.setData(Math.max(depL.getData(), depR.getData())+1);
		return Math.max(maxLeft, Math.max(maxRight, depL.getData()+depR.getData()));
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam1 ex=new Exam1();
		ex.question11_maxDistance();
	//	ex.question1_convertTreeToBiList();
		
	}

	

	@Data
	public class Node{
		private int data;
		private Node left;
		private Node right;
	}
	
	@Data
	public class Node2{
		private int data;
		private Node2 next;
		
		
	}
	
	@Data
	public class Int{
		private int data;
		
		
	}
	
}
