package com.jimmy.data.structure.tree;

import com.jimmy.data.structure.queue.ArrayQueue;
import com.jimmy.data.structure.stack.ArrayStack;

public class BinTree {
	
	public   BinTreeNode createBinTree(int length) {
		
		BinTreeNode[] source=new  BinTreeNode[length];
		for(int i=0;i<length;i++) {
			int data=(int)(50*Math.random());
			source[i]=new BinTreeNode();
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
		return source[0];
	}
	
	public BinTreeNode clone(BinTreeNode root) {
		if(root!=null) {
			BinTreeNode node=new BinTreeNode();
			node.setData(root.getData());
			node.setLeft(clone(root.getLeft()));
			node.setRight(clone(root.getRight()));
			return node;
		}
		return null;
	}
	
	public void deleteTree(BinTreeNode root) {

		if(root.getLeft()!=null) {
			deleteTree(root.getLeft());
		}
		if(root.getRight()!=null) {
			deleteTree(root.getRight());
		}
		root.setLeft(null);
		root.setRight(null);
		root=null;
		
	}
	
	public void levelOrderTree(BinTreeNode root) {
		ArrayQueue<BinTreeNode> aq=new ArrayQueue<BinTreeNode>(BinTreeNode.class);
		aq.enqueue(root);
		while(!aq.isEmpty()) {
			BinTreeNode node=aq.dequeue();
			System.out.print(node.getData()+",");

			if(node.getLeft()!=null) {
				aq.enqueue(node.getLeft());
			}
			if(node.getRight()!=null) {
				aq.enqueue(node.getRight());
			}
			
		}
		
	}
	
	
	public void preOrderTreeStack(BinTreeNode root) {
		ArrayStack<BinTreeNode> stack=new ArrayStack<BinTreeNode>(BinTreeNode.class);
		stack.push(root);
		while(!stack.isEmpty()) {
			BinTreeNode head=stack.pop();
			System.out.print(head.getData()+",");	
			
			if(head.getRight()!=null) {
				stack.push(head.getRight());
			}
			if(head.getLeft()!=null) {
				stack.push(head.getLeft());
			}
		}
		
	}
	
	public void preOrderTree(BinTreeNode root) {
		if(root!=null) {
			System.out.print(root.getData()+",");		
			preOrderTree(root.getLeft());
			preOrderTree(root.getRight());
		}
		
	}
	
	public void inOrderTree(BinTreeNode root) {
		if(root!=null) {
			inOrderTree(root.getLeft());
			System.out.print(root.getData()+",");		
			inOrderTree(root.getRight());

		}
	}
	
	public void inOrderTreeStack(BinTreeNode root) {
		ArrayStack<BinTreeNode> stack=new ArrayStack<BinTreeNode>(BinTreeNode.class);
		stack.push(root);
		while(!stack.isEmpty()) {

			BinTreeNode head=stack.top();
			if(head.getLeft()!=null) {
				stack.push(head.getLeft());
				head.setLeft(null);
			}else {
				BinTreeNode node=stack.pop();
				System.out.print(node.getData()+",");
				if(node.getRight()!=null) {
					stack.push(node.getRight());
				}
			}
		}
		
		
	}
	
	public void postOrderTreeStack(BinTreeNode root) {

		ArrayStack<BinTreeNode> stack=new ArrayStack<BinTreeNode>(BinTreeNode.class);
		stack.push(root);
		while(!stack.isEmpty()) {
			BinTreeNode head=stack.top();
			BinTreeNode left=head.getLeft();
			BinTreeNode right=head.getRight();
			head.setLeft(null);
			head.setRight(null);
			if(right!=null) {
				stack.push(right);
			}
			if(left!=null) {
				stack.push(left);
			}
			if(right==null&&left==null) {
				BinTreeNode node=stack.pop();
				System.out.print(node.getData()+",");
			}
		}
		
		
	
	}
	
	
	
	public void postOrderTree(BinTreeNode root) {
		if(root!=null) {
			postOrderTree(root.getLeft());
			postOrderTree(root.getRight());
			System.out.print(root.getData()+",");		

		}
	}
	

}
