package com.jimmy.data.structure.tree;

public class AVLTree {
	
	public  int height(AVLTreeNode root) {
		return root.getHeight();
	}
	
	
	public AVLTreeNode singleRotateLeft(AVLTreeNode x) {
		AVLTreeNode w=x.getLeft();
		x.setLeft(w.getRight());
		w.setRight(x);
		x.setHeight(Math.max(height(x.getLeft()), height(x.getRight()))+1);
		w.setHeight(Math.max(height(w.getLeft()),x.getHeight())+1);
		return w;
		
	}
	
	
	public AVLTreeNode singleRotateRight(AVLTreeNode w) {
		AVLTreeNode  x=w.getRight();
		w.setRight(x.getLeft());
		x.setLeft(w);
		w.setHeight(Math.max(height(w.getLeft()),height(w.getRight()))+1);
		x.setHeight(Math.max(height(x.getRight()), w.getHeight())+1);
		return x;
	}

	public AVLTreeNode doubleRotateLeft(AVLTreeNode z) {
		z.setLeft(singleRotateRight(z.getLeft()));
		return singleRotateLeft(z);
	}
	
	
	public AVLTreeNode doubleRotateRight(AVLTreeNode x) {
		x.setRight(singleRotateLeft(x.getRight()));
		return singleRotateRight(x);
	}
	
	public AVLTreeNode findMax(AVLTreeNode root) {
		AVLTreeNode tem=root;
		while(tem.getRight()!=null) {
			tem=tem.getRight();
		}
		return tem;
	}
	public AVLTreeNode findMin(AVLTreeNode root) {
		AVLTreeNode tem=root;
		while(tem.getLeft()!=null) {
			tem=tem.getLeft();
		}
		return tem;
	}
	
	public AVLTreeNode insert(AVLTreeNode root, int data) {
		if(root==null) {
			root =new AVLTreeNode();
			root.setData(data);
			root.setHeight(0);
		}else {
			if(data<root.getData()) {
				root.setLeft(insert(root.getLeft(),data));
				if(height(root.getLeft())-height(root.getRight())==2) {
					if(data<root.getLeft().getData()) {
						root=singleRotateLeft(root);
					}else {
						root=doubleRotateLeft(root);
					}
				}
				
			}else {
				root.setRight(insert(root.getRight(),data));
				if(height(root.getRight())-height(root.getLeft())==2) {
					if(data<root.getRight().getData()) {
						root=doubleRotateRight(root);
					}else {
						root=singleRotateRight(root);
					}
					
				}	

			}	
		}
		root.setHeight(Math.max(root.getLeft().getHeight(),root.getRight().getHeight())+1);
		return root;
	}
	
	
	public AVLTreeNode remove(AVLTreeNode root, int data) {
		if(root==null) return null;
		if(root.getData()>data) {
			root.setLeft(remove(root.getLeft(),data));
			if(root.getRight().getHeight()-root.getLeft().getHeight()==2) {
				if(height(root.getRight().getLeft())>height(root.getRight().getRight())) {
					root=doubleRotateLeft(root);
				}else {
					root=doubleRotateRight(root);
				}
			}
			
		}else if(root.getData()<data){
			root.setRight(remove(root.getRight(),data));
			if(root.getLeft().getHeight()-root.getRight().getHeight()==2) {
				if(height(root.getLeft().getRight())>height(root.getLeft().getLeft())) {
					root=doubleRotateRight(root);
				}else {
					root=singleRotateLeft(root);
				}
			}
			
			
		}else {
			if(root.getLeft()!=null&&root.getRight()!=null) {
				if(height(root.getLeft())>height(root.getRight())) {
					AVLTreeNode tem=findMax(root.getLeft());
					root.setData(tem.getData());
					root.setLeft(remove(root.getLeft(),tem.getData()));
				}else {
					AVLTreeNode tem=findMin(root.getRight());
					root.setData(tem.getData());
					root.setRight(remove(root.getRight(),tem.getData()));
				}
			}else {
				AVLTreeNode temp=root.getLeft()==null?root.getRight():root.getLeft();
				return temp;
			}
		}
		
		
		
		return root;
		
	}
}
