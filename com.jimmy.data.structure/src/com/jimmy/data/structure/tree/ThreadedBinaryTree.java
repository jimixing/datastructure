package com.jimmy.data.structure.tree;

import com.jimmy.data.structure.stack.ArrayStack;

public class ThreadedBinaryTree {
	
	public ThreadedBinaryTreeNode createThreadBinTree() {
		int length=10;
		ThreadedBinaryTreeNode[] source=new  ThreadedBinaryTreeNode[length];
		for(int i=0;i<length;i++) {
			int data=(int)(50*Math.random());
			source[i]=new ThreadedBinaryTreeNode();
			source[i].setData(data);
			System.out.print(data+",");
		}
		for(int i=0;i<length/2;i++) {
			if(2*i+1<length) {
				source[i].setLeft(source[2*i+1]);
			}
			if(2*i+2<length) {
				source[i].setRight(source[2*i+2]);
			}
			
		}
		ThreadedBinaryTreeNode root=source[0];

		ArrayStack<ThreadedBinaryTreeNode> stack=new ArrayStack<ThreadedBinaryTreeNode>(ThreadedBinaryTreeNode.class);
		stack.push(root);
		while(!stack.isEmpty()) {
			ThreadedBinaryTreeNode head=stack.pop();

			if(head.getRight()!=null) {
				head.setLTag(1);
				stack.push(head.getRight());
			}
			if(head.getLeft()!=null) {
				head.setLTag(1);
				stack.push(head.getLeft());
			}
		}
		
		source[7].setRight(source[3]);
		source[8].setLeft(source[3]);
		source[8].setRight(source[1]);
		source[9].setLeft(source[1]);
		source[9].setRight(source[4]);
		source[4].setRight(source[0]);
		source[5].setLeft(source[0]);
		source[5].setRight(source[2]);
		source[5].setLeft(source[2]);
		

		return root;
		
		
	}
	
	public ThreadedBinaryTreeNode preOrderSuccessor(ThreadedBinaryTreeNode node) {
		if(node.getLTag()==1) {
			return node.getLeft();
		}else {
			ThreadedBinaryTreeNode p=node;
			while(p.getRTag()==0) {
				p=p.getRight();
				
			}
			return  p;
		}
		
		
	}
	
	public void preOrderTraversal(ThreadedBinaryTreeNode root) {
		ThreadedBinaryTreeNode p=root;
		while(true) {
			p=preOrderSuccessor(p);
			if(p==root) return ;
			System.out.print(p.getData()+",");
		}
	}
	
	
	public ThreadedBinaryTreeNode InSuccessor(ThreadedBinaryTreeNode node) {
		if(node.getRTag()==0) {
			return node.getRight();
		}else {
			ThreadedBinaryTreeNode temp=node.getRight();
			while(temp.getLTag()==1) {
				temp=temp.getLeft();
			}
			return temp;
		}
		
		
	}
	
	public void InOrderTraversal(ThreadedBinaryTreeNode root) {
		ThreadedBinaryTreeNode p=root;
		while(true) {
			p=InSuccessor(p);
			if(p==root)return;
			System.out.print(p.getData()+",");
			
		}
		
	}

}
