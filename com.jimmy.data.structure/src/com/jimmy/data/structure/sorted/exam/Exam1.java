package com.jimmy.data.structure.sorted.exam;

import java.util.Arrays;

import com.jimmy.data.structure.heap.Heap;
import com.jimmy.data.structure.sorted.QuikSorted;
import com.jimmy.data.structure.tree.BinSearchTree;
import com.jimmy.data.structure.tree.BinTreeNode;

public class Exam1 {
	
	
	public void question1_findRepeatElement() {
		int [] array=new int[10];
		for(int i=0;i<10;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		boolean repeatable=false;
		for(int i=0;i<array.length;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i]==array[j]) {
					repeatable=true;
					break;
				}
			}
		}
		
		System.out.print(repeatable);
		
	}
	
	public void question2_findrepeatElement() {
		int [] array=new int[10];
		for(int i=0;i<10;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		
		QuikSorted qs=new QuikSorted();
		qs.quickSort(array, 0, array.length-1);
		
		System.out.println(Arrays.toString(array));
		boolean repeatable=false;
		for(int i=0;i<array.length-1;i++) {
			if(array[i]==array[i+1]) {
				repeatable=true;
			}
		}
		System.out.print(repeatable);

		
	}
	
	public void question3_winnerOfVote() {
		int length=20;
		int [] array=new int[length];
		for(int i=0;i<length;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		
		int min=array[0];
		int max=array[0];
		for(int i=0;i<array.length;i++) {
			if(array[i]<min) {
				min=array[i];
			}
			if(array[i]>max) {
				max=array[i];
			}
		}
		int len=max-min+1;
		int[] number=new int[len];
		for(int i=0;i<array.length;i++) {
			number[array[i]-min]++;
		}
		max=number[0];
		int pos=0;
		for(int j=0;j<len;j++) {
			if(max<number[j]) {
				max=number[j];
				pos=j;
			}
		}
		System.out.print("candinate Id: "+ number[pos]+min+" and it's vote number:"+max);
		
	}
	
	
	public void question6_sortForN() {
		
		int length=20;
		int [] array=new int[length];
		for(int i=0;i<length;i++) {
			int data=(int)(Math.random()*length);
			array[i]=data*data;
		}
		System.out.println(Arrays.toString(array));
		
		for(int i=0;i<length;i++) {
			array[i]=(int)Math.sqrt(array[i]);
		}
		System.out.println(Arrays.toString(array));
		
		int[] number=new int[length];
		for(int i=0;i<array.length;i++) {
			number[array[i]]++;
		}
		for(int i=0;i<length;i++) {
			if(number[i]!=0) {
				int k=0;
				while(k<number[i]) {
					System.out.print(i*i+",");
					k++;
				}
				
			}
		}
		
		
	}
	
	
	public void question9_TwoArraysForK() {
		int length=20;
		int [] arrayA=new int[length];
		int [] arrayB=new int[length];

		for(int i=0;i<length;i++) {
			int data=(int)(Math.random()*50);
			arrayA[i]=data;
		}
		System.out.println(Arrays.toString(arrayA));
		
		for(int i=0;i<length;i++) {
			int data=(int)(Math.random()*50);
			arrayB[i]=data;
		}
		System.out.println(Arrays.toString(arrayB));
		int K=50;
		BinSearchTree bst=new BinSearchTree();
		BinTreeNode root=bst.createBinSearchTree(arrayA);
		for(int i=0;i<length;i++) {
			int value=K-arrayB[i];
			if(bst.findItem(root, value)) {
				System.out.print("Find K value in two array!"+arrayB[i]);
				break;
			}	
		}

	}
	public void question10_ThreeArrayForK() {
		int length=20;
		int [] arrayA=new int[length];
		int [] arrayB=new int[length];
		int [] arrayC=new int[length];

		for(int i=0;i<length;i++) {
			int data=(int)(Math.random()*50);
			arrayA[i]=data;
		}
		System.out.println(Arrays.toString(arrayA));
		
		for(int i=0;i<length;i++) {
			int data=(int)(Math.random()*50);
			arrayB[i]=data;
		}
		System.out.println(Arrays.toString(arrayB));
		
		for(int i=0;i<length;i++) {
			int data=(int)(Math.random()*50);
			arrayC[i]=data;
		}
		System.out.println(Arrays.toString(arrayC));
		
		int K=50;
		BinSearchTree bst=new BinSearchTree();
		BinTreeNode root=bst.createBinSearchTree(arrayC);
		for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) {
				int value=K-arrayA[i]-arrayB[j];
				if(bst.findItem(root, value)) {
					System.out.print("Find K value in three array!"+arrayA[i]+","+arrayB[j]);
					return ;
				}
				
			}
		}
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam1 ex=new Exam1();
		ex.question10_ThreeArrayForK();
	}

}
