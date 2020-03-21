package com.jimmy.data.structure.tree.exam;

import java.util.ArrayList;
import java.util.List;

import com.jimmy.data.structure.queue.ArrayQueue;
import com.jimmy.data.structure.stack.ArrayStack;
import com.jimmy.data.structure.tree.BinTree;
import com.jimmy.data.structure.tree.BinTreeNode;

public class Exam1 {

	public void question1_MaxOfTree() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(10);
		System.out.println();
		int max=findMaxOfTree(root);
		System.out.println(max);
		
	}
	private int findMaxOfTree(BinTreeNode node) {
		int max=0,left=0,right=0;
		if(node!=null) {
			left=findMaxOfTree(node.getLeft());
			right=findMaxOfTree(node.getRight());
			max= left>right? left:right;
			max=max>node.getData()?max:node.getData();
		}
		return max;
		
	}
	
	public void question2_MaxOfTree() {
		ArrayQueue<BinTreeNode> aq=new ArrayQueue<BinTreeNode>(BinTreeNode.class);
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(10);
		System.out.println();
		int max=0;
		aq.enqueue(root);
		while(!aq.isEmpty()) {
			BinTreeNode node=aq.dequeue();
			max=max>node.getData()?max:node.getData();
			if(node.getLeft()!=null) {
				aq.enqueue(node.getLeft());
			}
			if(node.getRight()!=null) {
				aq.enqueue(node.getRight());
			}
			
		}
		System.out.print(max);	
	}
	
	
	public void question3_findNode() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(30);
		System.out.println();
		ArrayQueue<BinTreeNode> aq=new ArrayQueue<BinTreeNode>(BinTreeNode.class);
		aq.enqueue(root);
		List<BinTreeNode> result=new ArrayList<BinTreeNode>();
		int target=20;
		while(!aq.isEmpty()) {
			BinTreeNode node=aq.dequeue();
			if(node.getData()==target) {
				result.add(node);
			}
			if(node.getLeft()!=null) {
				aq.enqueue(node.getLeft());
			}
			if(node.getRight()!=null) {
				aq.enqueue(node.getRight());
			}
		}
		System.out.print(result.toString());
		
		
	}
	
	public void question5_insertNode() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(10);
		System.out.println();
		bt.preOrderTree(root);
		System.out.println();
		ArrayQueue<BinTreeNode> aq=new ArrayQueue<BinTreeNode>(BinTreeNode.class);
		aq.enqueue(root);
		BinTreeNode insertedNode=new BinTreeNode();
		insertedNode.setData(30);
		while(!aq.isEmpty()) {
			BinTreeNode node=aq.dequeue();
			if(node.getLeft()!=null) {
				aq.enqueue(node.getLeft());
			}
			if(node.getLeft()==null) {
				node.setLeft(insertedNode);
				break;
			}
			if(node.getRight()!=null) {
				aq.enqueue(node.getRight());
			}
			if(node.getRight()==null) {
				node.setRight(insertedNode);
				break;
			}
			
		}
		bt.preOrderTree(root);
	}
	
	public void question6_GetTreeNode() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(15);
		System.out.println();

		int count=getTreeNode(root);
		System.out.println(count);
		
	}
	public int getTreeNode(BinTreeNode node) {
		if(node == null) return 0;
		else {
			return getTreeNode(node.getLeft())+getTreeNode(node.getRight())+1;
		}
	}
	
	public void question7_GetTreeNode() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(15);
		System.out.println();
		ArrayQueue<BinTreeNode> aq=new ArrayQueue<BinTreeNode>(BinTreeNode.class);
		aq.enqueue(root);
		int count=0;
		while(!aq.isEmpty()) {
			BinTreeNode node=aq.dequeue();
			count++;
			if(node.getLeft()!=null) {
				aq.enqueue(node.getLeft());
			}
			if(node.getRight()!=null) {
				aq.enqueue(node.getRight());
			}
		}
		System.out.println(count);
	}
	
	public void question8_deleteTree() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(4);
		System.out.println();
		bt.deleteTree(root);
		
		
	}
	
	public void question9_reverseprint() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(10);
		System.out.println();
		ArrayQueue<BinTreeNode> aq=new ArrayQueue<BinTreeNode>(BinTreeNode.class);
		ArrayStack<BinTreeNode> as=new ArrayStack<BinTreeNode>(BinTreeNode.class);
		aq.enqueue(root);
		as.push(root);
		while(!aq.isEmpty()) {
			BinTreeNode node=aq.dequeue();
			BinTreeNode left=node.getLeft();
			BinTreeNode right=node.getRight();
			
			if(right!=null) {
				aq.enqueue(right);
				as.push(right);
			}
			if(left!=null) {
				aq.enqueue(left);
				as.push(left);
			}
			
		}
		while(!as.isEmpty()) {
			BinTreeNode node =as.pop();
			System.out.print(node.getData()+",");
		}
		
		
	}
	
	
	public static void main(String[] args) {
		Exam1 ex=new Exam1();
		ex.question9_reverseprint();
	}

}
