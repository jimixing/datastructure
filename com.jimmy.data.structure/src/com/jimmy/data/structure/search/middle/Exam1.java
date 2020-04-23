package com.jimmy.data.structure.search.middle;

import java.util.Arrays;

import com.jimmy.data.structure.heap.Heap;
import com.jimmy.data.structure.sorted.MergeSorted;
import com.jimmy.data.structure.tree.BinSearchTree;
import com.jimmy.data.structure.tree.BinTreeNode;

public class Exam1 {

	public int[]  generateArray(int len) {
	//	int len=20;
		int [] array=new int[len];
		for(int i=0;i<len;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		return array;
	}
	
	
	public void question1_findMax() {
		int[] array=generateArray(20);
		int max=Integer.MIN_VALUE;
		for(int i=0;i<array.length;i++) {
			if(max<array[i]) {
				max=array[i];
			}
		}
		System.out.println(max);
		
		
	}
	
	public void question2_findMaxMin()
	{	
		int[] array=generateArray(20);
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<array.length;i++) {
			if(max<array[i]) {
				max=array[i];
			}
			if(min>array[i]) {
				min=array[i];
			}
		}
		System.out.println("Max value is "+max+", Min value is"+ min);
		
	}
	public void question3_findMaxMin() {
		int[] array=generateArray(20);
		int max=Integer.MIN_VALUE;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<array.length-1;i+=2) {
			if(array[i]>array[i+1]) {
				if(max<array[i]) {
					max=array[i];
				}
				if(min>array[i+1]) {
					min=array[i+1];
				}
			}else {
				if(max<array[i+1]) {
					max=array[i+1];
				}
				if(min>array[i]) {
					min=array[i];
				}
			}
			
			
		}
		System.out.println("Max value is "+max+", Min value is"+ min);

	}
	
	public void question4_findSecMax() {
		int[] array=generateArray(20);
		int max=Integer.MIN_VALUE;
		int pos=-1;
		for(int i=0;i<array.length-1;i+=2) {
			if(max<array[i]) {
				pos=i;
			}
		}
		array[pos]=0;
		max=Integer.MIN_VALUE;
		for(int i=0;i<array.length-1;i+=2) {
			if(max<array[i]) {
				max=array[i];
			}
		}
		System.out.println("Max value is "+max);
		
	}
	
	public void question5_findSecMax() {
		int[] array=generateArray(20);
		int max=array[0];
		int sec=Integer.MIN_VALUE;
		
		for(int i=0;i<array.length;i++) {
			if(array[i]>max) {
				max=array[i];
			}
			if(array[i]>sec&&array[i]<max) {
				sec=array[i];
			}
		}
		System.out.println("second value is "+sec);

	}
	
	
	public void question6_findKth() {
		
		int[] array=generateArray(20);
		int K=4;
		int min=Integer.MAX_VALUE;
		int pos=-1;
		for(int j=1;j<=K;j++) {
			for(int i=0;i<array.length;i++) {
				if(array[i]<min) {
					min=array[i];
					pos=i;
				}
			}
			if(j==4) {
				break;
			}else {
				array[pos]=Integer.MAX_VALUE;
				min=Integer.MAX_VALUE;
				pos=-1;
			}
		}
		System.out.println("Kth value is "+array[pos]);
		
	}
	
	public void question7_findKth() {
		
		int[] array=generateArray(20);
		int K=4;
		MergeSorted ms=new MergeSorted();
		
		ms.mergeSorted(array, 0, array.length-1);
		
		System.out.println("Kth value is "+array[K-1]);
	}
	
	public void inOrderTree(BinTreeNode root,int [] array) {
		if(root!=null) {
			inOrderTree(root.getLeft(),array);
			array[pos++]=root.getData();
			inOrderTree(root.getRight(),array);

		}
	}
	int pos=0;
	
	public void question8_findKth() {
		int[] array=generateArray(20);
		int K=4;
		BinSearchTree bst=new BinSearchTree();
		BinTreeNode root=bst.createBinSearchTree(array);
		inOrderTree(root,array);
		System.out.println("Kth value is "+array[K-1]);

		
	}
	
	
	public void question9_findKth() {
		int[] array=generateArray(20);
		int K=4;
		Heap heap=new Heap(K,2);
		for(int i=0;i<K;i++) {
			heap.insert(array[i]);
		}
		for(int i=K;i<array.length;i++) {
			if(array[i]>heap.getMax()) {
				continue;
			}else {
				heap.deleteMax();
				heap.insert(array[i]);
			}
		}
		System.out.println("Kth value is "+heap.getMax());
		
	}
	
	
	private int findPivot(int[] array,int left, int right,int K) {
		if(left==right) return array[left];
		int piovt=array[left];
		int i=left+1,j=right;
		while(i<j) {
			while(i<j&&array[i]<piovt) {
				i++;
			}
			while(i<j&&array[j]>piovt) {
				j--;
			}
			int tem=array[i];
			array[i]=array[j];
			array[j]=tem;
		}
		int tem=array[i-1];
		array[i-1]=array[left];
		array[left]=tem;
		
		if(i-left>K) {
			return findPivot(array,left,i-1,K);
		}else if(i-left<K) {
			return findPivot(array,i+1,right,K-(i-left));
		}else {
			return piovt;
		}
		
		
		
	}
	
	
	public void question10_findKth() {
		
		int[] array=generateArray(10);
		int K=4;
		int value=findPivot(array,0,array.length-1,K);
		System.out.println("Kth value is "+value);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam1 ex=new Exam1();
		ex.question10_findKth();
		
	}

}
