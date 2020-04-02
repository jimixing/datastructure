package com.jimmy.data.structure.tree;

import com.jimmy.data.structure.stack.ArrayStack;

public class BinSearchTree extends BinTree{
	
	
	public BinTreeNode createBinSearchTree(int[] array) {
		BinTreeNode root=new BinTreeNode();
		root.setData(array[0]);
		for(int i=1;i<array.length;i++) {
			BinTreeNode node=new BinTreeNode();
			node.setData(array[i]);
			insertIntoTree(node,root);
		}
		return root;
		
	}
	
	public   BinTreeNode createBinSearchTree(int length) {
		
		BinTreeNode root=new BinTreeNode();
		root.setData(25);
		for(int i=1;i<length;i++) {
			int data=(int)(50*Math.random());
			if(data==25) {
				data=(int)(50*Math.random());
			}
			BinTreeNode node=new BinTreeNode();
			node.setData(data);
			insertIntoTree(node,root);
		}
		return root;
		
	}
	
	public void insertIntoTree(BinTreeNode node,BinTreeNode root) {
		if(node.getData()<root.getData()) {
			if(root.getLeft()!=null) {
				insertIntoTree(node,root.getLeft());
			}else {
				root.setLeft(node);
			}
			
		}else {
			if(root.getRight()!=null) {
				insertIntoTree(node,root.getRight());
			}else {
				root.setRight(node);
			}
			
		}
	}
	
	
	public boolean findItem(BinTreeNode root , int data) {
		if(root.getData()<data) {
			if(root.getRight()!=null) {
				return findItem(root.getRight(),data);
			}else {
				return false;
			}
		}else if(root.getData()>data) {
			if(root.getLeft()!=null) {
				return findItem(root.getLeft(),data);
			}else {
				return false;
			}
			
		}
		return true;
	}
	
	public BinTreeNode findItemUnRetroverse(BinTreeNode root , int data) {
		BinTreeNode temp=root;
		while(true) {
			if(temp==null) return null;
			if(temp.getData()==data) return temp;
			if(temp.getData()>data) {
				temp=temp.getLeft();
			}else {
				temp=temp.getRight();
			}
		}
	}
	
	
	public BinTreeNode findMin(BinTreeNode root) {
		BinTreeNode tem=root;
		while(tem.getLeft()!=null) {
			tem=tem.getLeft();
		}
		return tem;
	}
	
	public BinTreeNode findMax(BinTreeNode root) {
		BinTreeNode tem=root;
		while(tem.getRight()!=null) {
			tem=tem.getRight();
		}
		return tem;
	}
	
	
	public void deleteNode(BinTreeNode root , int data ) {
		ArrayStack<BinTreeNode> stack=new ArrayStack<BinTreeNode>(BinTreeNode.class);
		delete(root,data,stack);
		
	}
	private void delete(BinTreeNode root , int data, ArrayStack<BinTreeNode> stack) {
		if(root==null)return ;
		stack.push(root);
		if(root.getData()>data) {
			delete(root.getLeft(),data,stack);
		}else if(root.getData()<data) {
			delete(root.getRight(),data,stack);
		}else {
			if(root.getLeft()==null&&root.getRight()==null) {
				root=null;
			}else if(root.getLeft()==null) {
				BinTreeNode parent=stack.pop();
				parent=stack.pop();
				root=root.getRight();
				parent.setRight(root);
			}else if(root.getRight()==null) {
				BinTreeNode parent=stack.pop();
				parent=stack.pop();
				root=root.getLeft();
				parent.setLeft(root);
			}else {
				BinTreeNode temp=findMax(root.getLeft());
				root.setData(temp.getData());
				deleteNode(root.getLeft(), temp.getData());
			}
		}
	}
	
	

}
