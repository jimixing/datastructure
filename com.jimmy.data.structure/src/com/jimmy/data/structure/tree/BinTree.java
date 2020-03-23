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
	
	
	public TreeNode createTree() {
		TreeNode root=new TreeNode();
		root.setData(2);
		TreeNode child1=new TreeNode();
		child1.setData(10);
		root.setChild(child1);
		
		TreeNode child2=new TreeNode();
		child2.setData(22);
		child1.setChild(child2);
		
		TreeNode sil1=new TreeNode();
		sil1.setData(13);
		child1.setSilbling(sil1);
		
		TreeNode sil21=new TreeNode();
		sil21.setData(24);
		sil1.setChild(sil21);
		TreeNode sil22=new TreeNode();
		sil22.setData(25);
		sil21.setSilbling(sil22);
		
		TreeNode sil2=new TreeNode();
		sil2.setData(14);
		sil1.setSilbling(sil2);
		TreeNode sil3=new TreeNode();
		sil3.setData(15);
		sil2.setSilbling(sil3);
		
		TreeNode sil31=new TreeNode();
		sil31.setData(26);
		sil3.setChild(sil31);
		
		return root;
		
		
	}
	
	public void levelOrderTree(TreeNode root) {

		ArrayQueue<TreeNode> aq=new ArrayQueue<TreeNode>(TreeNode.class);
		aq.enqueue(root);
		while(!aq.isEmpty()) {
			TreeNode node=aq.dequeue();
			System.out.print(node.getData()+",");

			if(node.getChild()!=null) {
				aq.enqueue(node.getChild());
				TreeNode temp=node.getChild().getSilbling();
				while(temp!=null) {
					aq.enqueue(temp);
					temp=temp.getSilbling();
				}
			}
		}
	}
	
	public TreeNode findNodeInTree(TreeNode root, int data) {
		ArrayQueue<TreeNode> aq=new ArrayQueue<TreeNode>(TreeNode.class);
		aq.enqueue(root);
		while(!aq.isEmpty()) {
			TreeNode node=aq.dequeue();
			if(node.getData()==data) {
				return node;
			}
			if(node.getChild()!=null) {
				aq.enqueue(node.getChild());
				TreeNode temp=node.getChild().getSilbling();
				while(temp!=null) {
					aq.enqueue(temp);
					temp=temp.getSilbling();
				}
			}
		}
		return null;
		
	}
	
	
	public int countOfSilibing(TreeNode root) {
		int count=0;
		if(root!=null) {
			TreeNode sil=root.getSilbling();
			while(sil!=null) {
				count++;
				sil=sil.getSilbling();
			}
		}
		return count;
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
	
	
	
	
	public void deleteTreeNode(BinTreeNode root,int data) {
		ArrayQueue<BinTreeNode> aq=new ArrayQueue<BinTreeNode>(BinTreeNode.class);
		aq.enqueue(root);
		while(!aq.isEmpty()) {
			BinTreeNode node=aq.dequeue();
			if(node.getData()==data) {
				if(node.getLeft()==null&&node.getRight()==null) {
					node=null;
					break;
				}
			}
			if(node.getLeft()!=null) {
				aq.enqueue(node.getLeft());
			}
			if(node.getRight()!=null) {
				aq.enqueue(node.getRight());
			}
			
		}
	}
	
	
	public int calHeightOfTree(BinTreeNode root) {
		int height=0;
		if(root!=null) {
			int left=calHeightOfTree(root.getLeft());
			int right=calHeightOfTree(root.getRight());
			height=left>right?left+1:right+1;
			
		}
		return height;
	}
	
	public BinTreeNode findTreeNode(BinTreeNode root, int data) {
		if(root!=null) {
			if(root.getData()==data) {
				return  root;
			}
			BinTreeNode node=findTreeNode(root.getLeft(),data);
			if(node==null) {
				node=findTreeNode(root.getRight(),data);
			}
			return node;
		}
		return null;
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
