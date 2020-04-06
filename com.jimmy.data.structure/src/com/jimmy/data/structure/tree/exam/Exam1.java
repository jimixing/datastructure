package com.jimmy.data.structure.tree.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.jimmy.data.structure.list.SingListNode;
import com.jimmy.data.structure.queue.ArrayQueue;
import com.jimmy.data.structure.stack.ArrayStack;
import com.jimmy.data.structure.tree.BinSearchTree;
import com.jimmy.data.structure.tree.BinTree;
import com.jimmy.data.structure.tree.BinTreeNode;
import com.jimmy.data.structure.tree.BinTreeThreeNode;
import com.jimmy.data.structure.tree.TreeNode;

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
	
	
	public void question29_findLatesAncestor() {
		BinTree bt=new BinTree();
		while(true) {
			BinTreeNode root=bt.createBinTree(10);
			System.out.println();
			if(bt.findTreeNode(root, 20)!=null&&bt.findTreeNode(root, 30)!=null) {
				BinTreeNode node=findLatesAncestor(root, 20,30);
				System.out.println(node.getData());
				break;
			}
		}	
	}
	public BinTreeNode findLatesAncestor(BinTreeNode root, int a, int b) {
		if(root!=null) {
			if(root.getData()==a||root.getData()==b) {
				return  root;
			}
			
			BinTreeNode left=findLatesAncestor(root.getLeft(), a, b);
			BinTreeNode right=findLatesAncestor(root.getRight(), a, b);
			
			if(left!=null&&right!=null) {
				return root;
			}
			
			return left!=null?left:right;
			
			
		}
		return null;
	}
	
	
	public void question30_zigzag() {
		BinTree bt=new BinTree();

		BinTreeNode root=bt.createBinTree(30);
		System.out.println();
		ArrayStack<BinTreeNode> as1=new ArrayStack<BinTreeNode>(BinTreeNode.class);
		ArrayStack<BinTreeNode> as2=new ArrayStack<BinTreeNode>(BinTreeNode.class);

		as1.push(root);
		while(!(as1.isEmpty()&&as2.isEmpty())){
			while(!as1.isEmpty()) {
				BinTreeNode node=as1.pop();
				System.out.print(node.getData()+",");
				if(node.getLeft()!=null) {
					as2.push(node.getLeft());
				}
				if(node.getRight()!=null) {
					as2.push(node.getRight());
				}
			}
			while(!as2.isEmpty()) {
				BinTreeNode node=as2.pop();
				System.out.print(node.getData()+",");
				
				if(node.getRight()!=null) {
					as1.push(node.getRight());
				}
				if(node.getLeft()!=null) {
					as1.push(node.getLeft());
				}
			}
			
		}
		
	}
	
	public void question34_fillSilibing() {
		BinTree bt=new BinTree();
		int length=10;
		BinTreeThreeNode[] source=new  BinTreeThreeNode[length];
		for(int i=0;i<length;i++) {
			int data=(int)(50*Math.random());
			source[i]=new BinTreeThreeNode();
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
		BinTreeThreeNode root=source[0];

		System.out.println();
		ArrayQueue<BinTreeThreeNode> aq=new ArrayQueue<BinTreeThreeNode>(BinTreeThreeNode.class);
		aq.enqueue(root);
		aq.enqueue(null);
		while(!aq.isEmpty()) {
			BinTreeThreeNode node=aq.dequeue();
			BinTreeThreeNode temp;
			if(node==null) {
				break;
			}
			if(node.getLeft()!=null) {
				aq.enqueue(node.getLeft());
			}
			if(node.getRight()!=null) {
				aq.enqueue(node.getRight());
			}
			while(true) {	
				temp=aq.dequeue();
				if(temp==null) {
					aq.enqueue(null);
					break;
				}else {
					node.setSilbling(temp);
					if(temp.getLeft()!=null) {
						aq.enqueue(temp.getLeft());
					}
					if(temp.getRight()!=null) {
						aq.enqueue(temp.getRight());
					}
					
					node=temp;
				}
			}
					
					
		}

	}

	public void question36_calSumOfTree() {
		BinTree bt=new BinTree();
		TreeNode root=bt.createTree();
		int sum=sumOfTree(root);
		System.out.print(sum);
		
	}
	private int sumOfTree(TreeNode root) {
		if(root!=null) {
			return root.getData()+sumOfTree(root.getChild())+sumOfTree(root.getSilbling());
		}
		return 0;
	}
	
	public void question35_printTree() {
		BinTree bt=new BinTree();
		TreeNode root=bt.createTree();
		bt.levelOrderTree(root);
	}
	public void question40_countOfNodeSilb() {
		BinTree bt=new BinTree();
		TreeNode root=bt.createTree();
		
		TreeNode node=bt.findNodeInTree(root,13);
		int count=bt.countOfSilibing(node);
		System.out.print(count);
		
	}
	
	
	public void question41_isIsomorphic() {
		BinTree bt=new BinTree();
		TreeNode root1=bt.createTree();
		TreeNode root2=bt.createTree();

		boolean ismorphic=ismorphic(root1,root2);
		System.out.print(ismorphic);
		
	}
	
	private boolean ismorphic(TreeNode node1, TreeNode node2) {
		if(node1==null&&node2==null)return true;
		else if(node1==null||node2==null) return false;
		else {
			return ismorphic(node1.getChild(),node2.getChild())&&ismorphic(node1.getSilbling(),node2.getSilbling());
		}
	}
	
	public void question43_sumOfChild() {
		BinTree bt=new BinTree();
		TreeNode root1=bt.createTree();
		TreeNode node=bt.findNodeInTree(root1,13);

		TreeNode child=node.getChild();
		int count=0;
		if(child!=null) {
			count++;
			while(child.getSilbling()!=null) {
				count++;
				child=child.getSilbling();
			}
		}
		System.out.print(count);
		
	}
	
	public void question45_findNextNodeOfPreOrder() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(10);
		while(true) {
			if(bt.findTreeNode(root, 10)!=null) {
				break;
			}
			System.out.println();
			root=bt.createBinTree(10);

		}
		ArrayStack<BinTreeNode> as=new ArrayStack<BinTreeNode>(BinTreeNode.class);

		as.push(root);
		int data=10;
		BinTreeNode temp=null;
		
		while(!as.isEmpty()) {
			BinTreeNode node=as.pop();
			if(node.getData()==data) {
				temp=node;
				if(temp.getLeft()!=null) {
					 temp=temp.getLeft();
				}else {
					if(temp.getRight()!=null) {
						 temp=temp.getRight();
					}

					while(temp.getRight()==null) {
						temp=as.pop();
						
					}
					temp=node;
				}
				break;
	
			}
			if(node.getRight()!=null) {
				as.push(node.getLeft());
			}
			if(node.getLeft()!=null) {
				as.push(node.getRight());
			}

		}
		System.out.println();
		System.out.print(temp.getData());
		
		
	}
	
	public void question46_inOrderSuccessor() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(10);
		while(true) {
			if(bt.findTreeNode(root, 10)!=null) {
				break;
			}
			System.out.println();
			root=bt.createBinTree(10);

		}
		ArrayStack<BinTreeNode> stack=new ArrayStack<BinTreeNode>(BinTreeNode.class);

		stack.push(root);
		int data=10;
		BinTreeNode temp=null;
		while(!stack.isEmpty()) {
			BinTreeNode head=stack.top();
			if(head.getData()==data) {
				if(head.getRight()!=null) {
					temp=head.getRight();
					while(temp.getLeft()!=null) {
						temp=temp.getLeft();
					}
					
				}else {
					temp=stack.pop();
				}
				break;
				
			}
			if(head.getLeft()!=null) {
				stack.push(head.getLeft());
				head.setLeft(null);
			}else {
				BinTreeNode node=stack.pop();
				if(node.getRight()!=null) {
					stack.push(node.getRight());
				}
			}
		}
		System.out.println();
		System.out.print(temp.getData());
		
	}
	
	
	public void question46_1_createBinSearchTree() {
		BinSearchTree bt=new BinSearchTree();
		BinTreeNode root=bt.createBinSearchTree(10);
		bt.inOrderTree(root);	
	}
	public void question49_findLatestAncesor() {
		BinSearchTree bt=new BinSearchTree();
		BinTreeNode root=null;
		int a=10,b=20;
		while(true) {
			root=bt.createBinSearchTree(10);
			bt.inOrderTree(root);
			System.out.println();
			if(bt.findItem(root, a)&&bt.findItem(root, b)) {
				BinTreeNode node=findLatestAncesor(root, a,b);
				System.out.println(node.getData());
				break;
			}
		}	
	}
	private BinTreeNode findLatestAncesor(BinTreeNode root,int a,int b) {
		if(root==null) return null;
		if(root.getData()<a) {
			return findLatestAncesor(root.getRight(),a,b);
		}else if(root.getData()>b) {
			return findLatestAncesor(root.getLeft(),a,b);
		}else {
			return root;
		}
	}
	
	
	public void question50_isBst() {
		BinSearchTree bt=new BinSearchTree();
		BinTreeNode root=bt.createBinSearchTree(10);
		boolean isBST=isWrongBst(root);
		System.out.print(isBST);
		
	}
	private boolean isWrongBst(BinTreeNode root) {
		if(root==null) return true;
		if(root.getLeft()!=null) {
			return root.getData()>root.getLeft().getData()&&isWrongBst(root.getLeft());
		}
		if(root.getRight()!=null) {
			return root.getData()<root.getRight().getData()&&isWrongBst(root.getRight());
		}
		return  true;
		
	}
	
	public void question51_isBst() {
		BinSearchTree bt=new BinSearchTree();
		BinTreeNode root=bt.createBinSearchTree(10);
		boolean isBST=isBst(root,bt);
		System.out.print(isBST);

	}
	private boolean isBst(BinTreeNode root,BinSearchTree bt) {
		if(root==null) return true;
		if(root.getLeft()!=null) {
			return root.getData()>bt.findMax(root.getLeft()).getData()&&isBst(root.getLeft(),bt);
		}
		if(root.getRight()!=null) {
			return root.getData()<bt.findMin(root.getRight()).getData()&&isBst(root.getRight(),bt);
		}
		return  true;
	}
	
	public void question52_isBst() {
		BinSearchTree bt=new BinSearchTree();
		BinTreeNode root=bt.createBinSearchTree(10);
		int[] array=new int[10];
		int pos=0;
		ArrayStack<BinTreeNode> stack=new ArrayStack<BinTreeNode>(BinTreeNode.class);
		stack.push(root);
		while(!stack.isEmpty()) {
			BinTreeNode head=stack.top();
			if(head.getLeft()!=null) {
				stack.push(head.getLeft());
				head.setLeft(null);
			}else {
				BinTreeNode node=stack.pop();
				array[pos++]=node.getData();
				if(node.getRight()!=null) {
					stack.push(node.getRight());
				}
			}
		}
		boolean flag=true;
		System.out.print(Arrays.toString(array));
		for(int i=0;i<array.length-1;i++) {
			if(array[i]>array[i+1]) {
				flag=false;
				break;
					
			}
		}
		
		System.out.print(flag);
		
	}
	
	public void question54_BSTconvertToBioList() {
		BinSearchTree bt=new BinSearchTree();
		BinTreeNode root=bt.createBinSearchTree(10);
		BinTreeNode left=BSTconvertToBioList(root);
		BinTreeNode left2=left;
		while(left2.getRight()!=null) {
			System.out.print(left2.getData()+",");
			left2=left2.getRight();
		}
		left.setLeft(left2);
		left2.setRight(left);
	}
	
	private BinTreeNode BSTconvertToBioList(BinTreeNode root) {
		if(root==null) return null;
		if(root.getLeft()==null&&root.getRight()==null) return root;
		BinTreeNode left=root;
		BinTreeNode right=null;
		if(root.getLeft()!=null) {
			left=BSTconvertToBioList(root.getLeft());
			while(left.getRight()!=null)left=left.getRight();
			if(left!=null) {
				left.setRight(root);
				root.setLeft(left);
			}
		}
		if(root.getRight()!=null) {
			right=BSTconvertToBioList(root.getRight());
			right.setLeft(root);
			root.setRight(right);
		}
		while(left.getLeft()!=null) {
			left=left.getLeft();
		}
		return left;
		
		
	}

	public void question55_BiolistConvertToBST(){
		BinSearchTree bt=new BinSearchTree();
		BinTreeNode root=bt.createBinSearchTree(10);
		bt.inOrderTree(root);
		System.out.println();
		BinTreeNode left=BSTconvertToBioList(root);
		BinTreeNode root2=BiolistConvertToBST(left);
		bt.inOrderTree(root2);
		
	}
	private BinTreeNode BiolistConvertToBST(BinTreeNode head) {
		if(head==null||head.getRight()==null) return head;
		
		BinTreeNode temp=findMiddleOfNode(head);
		BinTreeNode left=head;
		while(left.getRight()!=temp) {
			left=left.getRight();
		}
		BinTreeNode right=temp.getRight();
		left.setRight(null);
		if(right!=null) {
			right.setLeft(null);
		}
		
		BinTreeNode left2=BiolistConvertToBST(head);
		BinTreeNode right2=BiolistConvertToBST(right);
		temp.setLeft(left2);
		temp.setRight(right2);		
		
		return temp;
		
	}
	
	private BinTreeNode findMiddleOfNode(BinTreeNode head) {
		
		BinTreeNode slow=head;
		BinTreeNode fast=head;
		while(fast!=null) {
			if(fast.getRight()!=null) {
				fast=fast.getRight().getRight();
			}else {
				break;
			}
			slow=slow.getRight();
		}
		return slow;
		
	}
	
	public void question56_sortedArrayConvertToBST() {
		int length=13;
		int[] array=new int[length];
		for(int i=0;i<length;i++) {
			array[i]=(int)(50*Math.random());
		}
		Arrays.sort(array);
		System.out.print(Arrays.toString(array));
		System.out.println();
		BinTreeNode root=sortedArrayConvertToBST(array,0,array.length-1);
		BinSearchTree bt=new BinSearchTree();
		bt.inOrderTree(root);
	}
	
	private BinTreeNode sortedArrayConvertToBST(int[] array,int start,int end) {
		if(start==end) {
			BinTreeNode node=new BinTreeNode();
			node.setData(array[start]);
			return  node;
		}
		if(start>end) {
			return null;
		}
		BinTreeNode middle=findMiddle(array,start,end);
		BinTreeNode left=sortedArrayConvertToBST(array,start,(int)((start+end)/2)-1);
		BinTreeNode right=sortedArrayConvertToBST(array,(int)((start+end)/2)+1,end);
		middle.setLeft(left);
		middle.setRight(right);
		return middle;
		
		
		
	}
	
	private BinTreeNode findMiddle(int[] array,int start,int end) {
		BinTreeNode node=new BinTreeNode();
		node.setData(array[(int)(start+end)/2]);
		return node;
	}
	
	public void question59_findKElement() {
		
		BinSearchTree bt=new BinSearchTree();
		BinTreeNode root=bt.createBinSearchTree(10);
		bt.inOrderTree(root);
		System.out.println();
		int k=2;
		int count=0;
		ArrayStack<BinTreeNode> stack=new ArrayStack<BinTreeNode>(BinTreeNode.class);
		stack.push(root);
		BinTreeNode temp=null;
		while(!stack.isEmpty()) {
			BinTreeNode head=stack.top();
			if(head.getLeft()!=null) {
				stack.push(head.getLeft());
				head.setLeft(null);
			}else {
				BinTreeNode node=stack.pop();
				if(++count==k) {
					temp=node;
					break;
				}
			
				if(node.getRight()!=null) {
					stack.push(node.getRight());
				}
			}
		}
		System.out.print(temp.getData()+",");
		
	}
	
	
	public void question61_BSTUnionAndInter() {
		BinSearchTree bt=new BinSearchTree();
		BinTreeNode root1=bt.createBinSearchTree(10);
		bt.inOrderTree(root1);
		System.out.println();
		BinTreeNode root2=bt.createBinSearchTree(10);
		bt.inOrderTree(root2);
		System.out.println();

		BinTreeNode root1list=BSTconvertToBioList(root1);
		BinTreeNode root2list=BSTconvertToBioList(root2);
		BinTreeNode unionlist=UnitOfList(root1list,root2list);
		BinTreeNode root11=BiolistConvertToBST(unionlist);
		bt.inOrderTree(root11);
		System.out.println();
		
		
		BinTreeNode root3=bt.createBinSearchTree(10);
		bt.inOrderTree(root3);
		System.out.println();
		BinTreeNode root4=bt.createBinSearchTree(10);
		bt.inOrderTree(root4);
		System.out.println();
		
		BinTreeNode root3list=BSTconvertToBioList(root3);
		BinTreeNode root4list=BSTconvertToBioList(root4);
		BinTreeNode interlist=InterOfList(root3list,root4list);
		BinTreeNode root31=BiolistConvertToBST(interlist);
		bt.inOrderTree(root31);
		System.out.println();
		
		
	}
	private BinTreeNode InterOfList(BinTreeNode head1,BinTreeNode head2) {
		//BinTreeNode newHead=head1.getData()>head2.getData()?head2:head1;
		BinTreeNode cur3=null,cur4=null;
		BinTreeNode cur1=head1,cur2=head2;
		int i=0;
		
		while(cur1!=null&&cur2!=null) {
			if(cur1.getData()>cur2.getData()) {
				cur2=cur2.getRight();
			}else if(cur1.getData()<cur2.getData()) {
				cur1=cur1.getRight();
			}else {
				if(i==0) {
					cur3=cur1;
					cur4=cur1;
					cur1=cur1.getRight();
					cur2=cur2.getRight();
					cur3.setLeft(null);
					i++;
				}else {
					cur3.setRight(cur1);
					cur1.setLeft(cur3);
					cur1=cur1.getRight();
					cur2=cur2.getRight();
					cur3=cur3.getRight();
					cur3.setRight(null);
				}
				
				
			}
		}
		return  cur4;
		
		
	}
	
	
	private BinTreeNode UnitOfList(BinTreeNode root1list,BinTreeNode root2list) {
		BinTreeNode head1=root1list;
		BinTreeNode head2=root2list;
		BinTreeNode newHead=head1.getData()>head2.getData()?head2:head1;
		BinTreeNode cur3=newHead;
		BinTreeNode cur1=head1,cur2=head2;
		if(newHead==head1) {
			cur1=head1.getRight();
		}
		if(newHead==head2) {
			cur2=head2.getRight();
		}
		
		while(cur1!=null&&cur2!=null) {
			if(cur1.getData()>=cur2.getData()) {
				cur3.setRight(cur2);
				cur2.setLeft(cur3);
				cur2=cur2.getRight();
			}else {
				cur3.setRight(cur1);
				cur1.setLeft(cur3);
				cur1=cur1.getRight();
			}
			cur3=cur3.getRight();
			
		}
		while(cur1!=null) {
			cur3.setRight(cur1);
			cur1.setLeft(cur3);
			cur3=cur3.getRight();
			cur1=cur1.getRight();
		}
		while(cur2!=null) {
			cur3.setRight(cur2);
			cur2.setLeft(cur3);
			cur3=cur3.getRight();
			cur2=cur2.getRight();
		}
		return newHead;
	}
	
	public void question64_printk1tok3() {
		
		BinSearchTree bt=new BinSearchTree();
		BinTreeNode root1=bt.createBinSearchTree(10);
		int k1=10, k2=35;
		bt.inOrderTree(root1);
		System.out.println();
		printk1tok2(root1,k1, k2);
		
		
	}
	
	private void printk1tok2(BinTreeNode root , int k1, int k2) {
		if(root==null) return ;
		if(root.getData()<k1) {
			printk1tok2(root.getRight(),k1,k2);
		}else if(root.getData()>k2) {
			printk1tok2(root.getLeft(),k1,k2);
		}else {
			System.out.print(root.getData()+",");
			printk1tok2(root.getLeft(),k1,k2);
			printk1tok2(root.getRight(),k1,k2);
		}
	}
	
	
	public void question65_printk1tok2() {
		BinSearchTree bt=new BinSearchTree();
		BinTreeNode root=bt.createBinSearchTree(10);
		int k1=10, k2=35;
		bt.inOrderTree(root);
		System.out.println();
		ArrayQueue<BinTreeNode> aq=new ArrayQueue<BinTreeNode>(BinTreeNode.class); 
		aq.enqueue(root);
		while(!aq.isEmpty()) {
			BinTreeNode node=aq.dequeue();
			if(node==null) continue;
			if(node.getData()>k1&&node.getData()<k2) {
				System.out.print(node.getData()+",");
				aq.enqueue(node.getLeft());
				aq.enqueue(node.getRight());
			}else if(node.getData()<k1) {
				aq.enqueue(node.getRight());
			}else if(node.getData()>k2) {
				aq.enqueue(node.getLeft());
			}
		}
		
		
	}
	
	
	public void question67_cutBST() {
		BinSearchTree bt=new BinSearchTree();
		BinTreeNode root=bt.createBinSearchTree(4);
		int k1=10, k2=35;
		bt.inOrderTree(root);
		System.out.println();
		cutBST(root,k1,k2);
		bt.inOrderTree(root);
		
	}
	private void cutBST(BinTreeNode root, int k1, int k2) {
		if(root==null)return;
		if(root.getData()>k1) {
			if(root.getLeft()!=null&&root.getLeft().getData()<k1) {
				root.getLeft().setLeft(null);;
			}else {
				cutBST(root.getLeft(),k1,k2);
			}
		}else {
			cutBST(root.getRight(),k1,k2);
		}
		if(root.getData()<k2) {
			if(root.getRight()!=null&&root.getRight().getData()>k2) {
				root.getRight().setRight(null);
			}else {
				cutBST(root.getRight(),k1,k2);
			}
		}else {
			cutBST(root.getLeft(),k1,k2);
		}
		

		
	}
	
	
	public void question69_isSameBST() {
//		int[] b1=new int[] {10,5,20,15,30};
//		int[] b2=new int[] {10,20,15,30,5};
		int[] b1=new int[] {10,5,20,15,30};
		int[] b2=new int[] {10,15,30,20,5};

		BinSearchTree bt=new BinSearchTree();
		BinTreeNode root1=bt.createBinSearchTree(b1);
		BinTreeNode root2=bt.createBinSearchTree(b2);
		boolean isSame=isSameBst(root1,root2);
		System.out.println(isSame);
	}
	
	private boolean isSameBst(BinTreeNode root1, BinTreeNode root2) {
		boolean isSame=true;
		if(root1!=null&&root2!=null) {
			return isSameBst(root1.getLeft(),root2.getLeft())&&root1.getData()==root2.getData()
					&&isSameBst(root1.getRight(),root2.getRight());	
		}else if(root1!=null||root2!=null) {
			isSame= false;
		}
		return isSame;
	}
	
	static private int init=0;
	public void question70_buildHb0() {
		
		int h=3;
		BinTreeNode root=buildHb0(h);
		
	}
	
	private BinTreeNode buildHb0(int h) {
		BinTreeNode root=new BinTreeNode();
		if(h==0) return null;
		root.setLeft(buildHb0(h-1));
		root.setData(init++);
		root.setRight(buildHb0(h-1));
		return root;
		
	}
	
	public void question74_isAVL() {
		BinTree bt=new BinTree();
		BinTreeNode root=bt.createBinTree(10);
		int isavl=isAVL(root);
		System.out.print(isavl);
		
		
	}
	
	private int isAVL(BinTreeNode root) {
		if(root==null) return 0;
		int left=isAVL(root.getLeft());
		if(left==-1) {
			return left;
		}
		int right=isAVL(root.getRight());
		if(right==-1) {
			return right;
		}
		
		if(Math.abs(left-right)>1) {
			return -1;
		}
		return Math.max(left, right)+1;
	}
	
	public static void main(String[] args) {
		Exam1 ex=new Exam1();
		ex.question69_isSameBST();
	}

}
