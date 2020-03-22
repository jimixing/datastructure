package com.jimmy.data.structure.tree.exam;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	public void question10_heightOfTree() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(30);
		System.out.println();
		int height=bt.calHeightOfTree(root);
		System.out.println(height);

	}
	
	public void question11_heightOfTree() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(10);
		System.out.println();
		ArrayQueue<BinTreeNode> aq=new ArrayQueue<BinTreeNode>(BinTreeNode.class);
		aq.enqueue(root);
		aq.enqueue(null);
		int level=0;
		while(!aq.isEmpty()) {
			BinTreeNode node=aq.dequeue();
			if(node==null) {
				level++;
				if(!aq.isEmpty()) {
					aq.enqueue(null);
				}
			}else {
				if(node.getLeft()!=null) {
					aq.enqueue(node.getLeft());
				}
				if(node.getRight()!=null) {
					aq.enqueue(node.getRight());
				}
			}
		}
		System.out.println(level);

		
	}
	public void question12_GetDeepestTreeNode() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(10);
		System.out.println();
		ArrayQueue<BinTreeNode> aq=new ArrayQueue<BinTreeNode>(BinTreeNode.class);
		aq.enqueue(root);
		ArrayStack<BinTreeNode> as=new ArrayStack<BinTreeNode>(BinTreeNode.class);
		while(!aq.isEmpty()) {
			BinTreeNode node=aq.dequeue();
			as.push(node);
			if(node.getLeft()!=null) {
				aq.enqueue(node.getLeft());
			}
			if(node.getRight()!=null) {
				aq.enqueue(node.getRight());

			}
		}
		
		BinTreeNode node=as.pop();
		System.out.print(node.getData());
		
	}
	
	public void question13_deleteTreeNode() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(10);
		System.out.println();
		ArrayQueue<BinTreeNode> aq=new ArrayQueue<BinTreeNode>(BinTreeNode.class);
		aq.enqueue(root);
		int delete=20;
		ArrayStack<BinTreeNode> as=new ArrayStack<BinTreeNode>(BinTreeNode.class);
		BinTreeNode deleteNode=null;
		while(!aq.isEmpty()) {
			BinTreeNode node=aq.dequeue();
			if(node.getData()==delete) {
				deleteNode=node;
			}
			as.push(node);
			if(node.getLeft()!=null) {
				aq.enqueue(node.getLeft());
			}
			if(node.getRight()!=null) {
				aq.enqueue(node.getRight());

			}
		}
		if(deleteNode==null) {
			System.out.print("Node does not found!");
		}
		
		BinTreeNode node=as.pop();
		deleteNode.setData(node.getData());
		while(!as.isEmpty()) {
			node=as.pop();
			if(node.getLeft()==deleteNode) {
				node.setLeft(null);
				break;
			}else if(node.getRight()==deleteNode) {
				node.setRight(null);
				break;
			}
			
		}
		bt.preOrderTree(root);
	}

	
	public void question14_countLeaveNode() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(30);
		System.out.println();
		ArrayQueue<BinTreeNode> aq=new ArrayQueue<BinTreeNode>(BinTreeNode.class);
		aq.enqueue(root);
		int leaveCon=0;
		while(!aq.isEmpty()) {
			BinTreeNode node=aq.dequeue();
			if(node.getLeft()==null&&node.getRight()==null) {
				leaveCon++;
			}
			if(node.getLeft()!=null) {
				aq.enqueue(node.getLeft());
			}
			if(node.getRight()!=null) {
				aq.enqueue(node.getRight());

			}
		}
		System.out.print(leaveCon);

	}
	
	public void question15_countFullNode() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(30);
		System.out.println();
		ArrayQueue<BinTreeNode> aq=new ArrayQueue<BinTreeNode>(BinTreeNode.class);
		aq.enqueue(root);
		int fullCon=0;
		while(!aq.isEmpty()) {
			BinTreeNode node=aq.dequeue();
			if(node.getLeft()!=null&&node.getRight()!=null) {
				fullCon++;
			}
			if(node.getLeft()!=null) {
				aq.enqueue(node.getLeft());
			}
			if(node.getRight()!=null) {
				aq.enqueue(node.getRight());

			}
		}
		System.out.print(fullCon);
	}
	
	public void question16_countHalfNode() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(30);
		System.out.println();
		ArrayQueue<BinTreeNode> aq=new ArrayQueue<BinTreeNode>(BinTreeNode.class);
		aq.enqueue(root);
		int fullCon=0;
		while(!aq.isEmpty()) {
			BinTreeNode node=aq.dequeue();
			if(node.getLeft()!=null||node.getRight()!=null) {
				fullCon++;
			}
			if(node.getLeft()!=null) {
				aq.enqueue(node.getLeft());
			}
			if(node.getRight()!=null) {
				aq.enqueue(node.getRight());

			}
		}
		System.out.print(fullCon);
	}
	
	public void question17_isTwoTreeSame() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(10);
		System.out.println();
		BinTreeNode root2=bt.clone(root);
		//BinTreeNode root2=bt.createBinTree(11);
		boolean isMatch=isTreeNodeIndentify(root, root2);
		System.out.print(isMatch);

	}
	private boolean isTreeNodeIndentify(BinTreeNode source, BinTreeNode target) {
		if(source==null&&target==null)return true;
		if(source==null||target==null) return false;
		if(source.getData()!=target.getData()) return false;
		
		return isTreeNodeIndentify(source.getLeft(),target.getLeft())&&isTreeNodeIndentify(source.getRight(),target.getRight());
	}
	
	
	public void question18_DiameterOfTree() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(10);
		System.out.println();
		Integer diamater=new Integer(0);
		diameterOfTree(root,diamater);
		System.out.println(diamater);
	}
	
	public int diameterOfTree(BinTreeNode root,Integer diamater) {
		if(root==null) return 0;
		int left=diameterOfTree(root.getLeft(),diamater);
		int right=diameterOfTree(root.getRight(),diamater);
		if(left+right>diamater) diamater=left+right;
		return Math.max(left, right)+1;
	}
	
	
	public void question19_MaxValueOfLevel() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(10);
		System.out.println();
		ArrayQueue<BinTreeNode> aq=new ArrayQueue<BinTreeNode>(BinTreeNode.class);
		aq.enqueue(root);
		aq.enqueue(null);
		int max=0;
		int levelValue=0;
		int level=0;
		int maxLevel=0;
		while(!aq.isEmpty()) {
			BinTreeNode node=aq.dequeue();
			if(node==null) {
				level++;
				if(max<levelValue) {
					max=levelValue;
					maxLevel=level;
				}
				levelValue=0;
				if(!aq.isEmpty()) {
					aq.enqueue(null);
				}
				continue;
			}
			levelValue+=node.getData();
			if(node.getLeft()!=null) {
				aq.enqueue(node.getLeft());
			}
			if(node.getRight()!=null) {
				aq.enqueue(node.getRight());
			}
		}
		System.out.println("max value is "+ max+" and level is "+maxLevel);
	}
	
	public void question20_printPathOfTree() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(30);
		System.out.println();
		int[] path=new int[100];
		int pathLen=0;
		findPath(root,path,pathLen);
		
		
	}
	
	private void findPath(BinTreeNode root, int[] path,int pathLen) {
		if(root!=null) {
			path[pathLen++]=root.getData();
			if(root.getLeft()==null&&root.getRight()==null) {
				printTreeNode(path,pathLen);
			}
			findPath(root.getLeft(),path,pathLen);
			findPath(root.getRight(),path,pathLen);
			
		}
	}
	
	private void printTreeNode(int []path, int lenth) {
		for(int i=0;i<lenth;i++) {
			System.out.print(path[i]+",");
		}
		System.out.println();
	}
	
	
	public void question21_matchGivenSumOfPath() {
		BinTree bt=new BinTree();
		//while(true) {
			BinTreeNode root=bt.createBinTree(30);
			System.out.println();
			int sum=120;
			int[] path=new int[100];
			int pathLen=0;
			findPath(root,path,pathLen,sum);
		//}
	}
	
	private void findPath(BinTreeNode root, int[] path,int pathLen,int sum) {
		if(root!=null) {
			path[pathLen++]=root.getData();
			if(Arrays.stream(path).sum()==sum) {
				printTreeNode(path,pathLen);
				return ;
			}
			
			findPath(root.getLeft(),path,pathLen,sum);
			findPath(root.getRight(),path,pathLen,sum);
			
		}
	}
	
	
	public void question22_SumTreeNode() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(4);
		System.out.println();
		int sum=sumOfTree(root);
		
		System.out.println(sum);
	}
	
	private int sumOfTree(BinTreeNode root) {
		if(root!=null) {
			return root.getData()+sumOfTree(root.getLeft())+sumOfTree(root.getRight());
		}else {
			return 0;
		}	
	}
	
	public void question23_SumTreeNode() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(10);
		System.out.println();
		ArrayQueue<BinTreeNode> aq=new ArrayQueue<BinTreeNode>(BinTreeNode.class);
		aq.enqueue(root);
		int sum=0;
		while(!aq.isEmpty()) {
			BinTreeNode node=aq.dequeue();
			sum+=node.getData();
			if(node.getLeft()!=null) {
				aq.enqueue(node.getLeft());
			}
			if(node.getRight()!=null) {
				aq.enqueue(node.getRight());
			}
		}
		
		System.out.println(sum);	
	}
	
	public void question24_exchangeLeftRight() {
		
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(10);
		System.out.println();
		bt.preOrderTree(root);
		mirrorLeftRight(root);
		System.out.println();
		bt.preOrderTree(root);	
	}
	
	private void mirrorLeftRight(BinTreeNode root) {
		if(root!=null) {
			BinTreeNode left=root.getLeft();
			BinTreeNode right=root.getRight();
			root.setRight(left);
			root.setLeft(right);
			
			if(root.getLeft()!=null) {
				mirrorLeftRight(root.getLeft());
			}
			if(root.getRight()!=null) {
				mirrorLeftRight(root.getRight());

			}
		}
		
	}
	
	public void question25_isMirrowForLeftRight() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(10);
		BinTreeNode root2=bt.clone(root);
//		mirrorLeftRight(root2);
		
		boolean isMirrow=isMirrowLeftRight(root,root2);
		System.out.print(isMirrow);
		
	}
	
	private boolean isMirrowLeftRight(BinTreeNode left, BinTreeNode right) { 
		if(left==null&&right==null) return true;
		if(left==null||right==null) return false;
		return left.getData()==right.getData()&&isMirrowLeftRight(left.getLeft(),right.getRight())
				&&isMirrowLeftRight(left.getRight(),right.getLeft());
		
	}
	
	
	public void question26_BuildTree() {
		int[] inOrder=new int[]{4,2,5,1,6,3};
		int[] preOrder=new int[] {1,2,4,5,3,6};
		int preindex=0;
		BinTreeNode root= buildTreeNode(inOrder,preOrder,0,inOrder.length-1);
		BinTree bt=new BinTree();
		bt.inOrderTree(root);
	}
	static int preindex=0;
		
	public BinTreeNode buildTreeNode(int[] inOrder,int[] preOrder, int start, int end) {
		
		if(start>end) return null;		
		BinTreeNode root=new BinTreeNode();
		root.setData(preOrder[preindex]);
		preindex++;
		if(start==end) return root;
		int inindex=searchInInOrder(inOrder, root.getData());
		root.setLeft(buildTreeNode(inOrder,preOrder,start,inindex-1));
		root.setRight(buildTreeNode(inOrder,preOrder,inindex+1,end));
		return root;
	}
	
	public int searchInInOrder(int[] inOrder, int data) {
		for(int i=0;i<inOrder.length;i++) {
			if(inOrder[i]==data) {
				return i;
			}
		}
		return 0;
	}
	
	public void question28_printAncester() {
		
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(30);
		System.out.println();
		int[] path=new int[100];
		int pathLen=0;
		int data=30;
		printPath(root,path,pathLen,data);
		
		
		
	}
	
	private void printPath(BinTreeNode root, int[] path,int pathLen, int data) {
		if(root!=null) {
			path[pathLen++]=root.getData();
			if(root.getData()==data) {
				printTreeNode(path,pathLen);
			}
			printPath(root.getLeft(),path,pathLen,data);
			printPath(root.getRight(),path,pathLen,data);
			
		}
	}
	
	public static void main(String[] args) {
		Exam1 ex=new Exam1();
		ex.question28_printAncester();
	}

}
