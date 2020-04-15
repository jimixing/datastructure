package com.jimmy.data.structure.sorted.exam;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
	
	public void question11_KafterMiddle() {
		
		
		
		
		
		
	}
	
	
	public void question16_CountSort() {
		int length=20;
		int [] array=new int[length];
		for(int i=0;i<length;i++) {
			int data=(int)(Math.random()*3);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
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
		for(int i=0;i<len;i++) {
			if(number[i]!=0) {
				int k=0;
				while(k<number[i]) {
					System.out.print(min+i+",");
					k++;
				}
				
			}
		}
		
	}
	
	 public void question17_QuickSort() {
		int length=20;
		int [] array=new int[length];
		for(int i=0;i<length;i++) {
			int data=(int)(Math.random()*3);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		int i=0,j=length-1;
		while(i<j) {
			while(array[i]==0||array[i]==1&&i<j) {
				i++;
			}
			while(array[j]==2&&i<j) {
				j--;
			}
			int tem=array[i];
			array[i]=array[j];
			array[j]=tem;
			
		}
		System.out.println(Arrays.toString(array));
		for(i=0;i<length;i++) {
			if(array[i]==2) {
				break;
			}
		}
		j=0;
		int l=i-1;
		while(j<l) {
			while(array[j]==0&&j<l) {
				j++;
			}
			while(array[l]==1&&j<l) {
				l--;
			}
			int tem=array[j];
			array[j]=array[l];
			array[l]=tem;
			
		}
		System.out.println(Arrays.toString(array));

		
	 }
	 
	 public void question18_maxCountInArray() {
		int length=20;
		int [] array=new int[length];
		for(int i=0;i<length;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		QuikSorted qs=new QuikSorted();
		qs.quickSort(array, 0, length-1);
		System.out.println(Arrays.toString(array));
			
		int maxcount=0;
		int Value=0;
		for(int i=0;i<length;) {
			int j=0;
			int count=0;
			while(i+j<length&&array[i+j]==array[i]) {
				count++;
				j++;
			}
			if(count>maxcount) {
				maxcount=count;
				Value=array[i];
			}
			i=i+j;
			
		}
		System.out.print("value:"+Value+",count:"+maxcount);
			
		 
	 }
	
	 public void question20_maxCountInArray() {
		int length=20;
		int [] array=new int[length];
		for(int i=0;i<length;i++) {
			int data=(int)(Math.random()*30);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		Map<Integer,Integer> res=new HashMap<Integer,Integer>();
		for(int i=0;i<length;i++) {
			if(res.get(array[i])==null) {
				res.put(array[i],1);
			}else {
				int count=res.get(array[i]);
				res.put(array[i],count+1);
			}
		}
		int maxcount=0;
		int value=0;
		Set<Integer> keys=res.keySet();
		 for(Integer key:keys) {
			 if(maxcount<res.get(key)) {
				 maxcount=res.get(key);
				 value=key;
			 }
		 }
		System.out.print("value:"+value+",count:"+maxcount);

		 
	 }
	 
	 public void question22_nearSorted() {
		 int[] array=new int[]{2,1,4,3,6,5,7,9,8,10};
		 Heap heap=new Heap(array.length,1);
		 int k=4;
		 for(int i=0;i<k;i++) {
			 heap.insert(array[i]);
		 }
		 
		 for(int j=0;j<array.length-k;j++) {
			 array[j]=heap.deleteMin();
			 heap.insert(array[j+k]);
		 }
		 for(int j=array.length-k;j<array.length;j++) {
			 heap.insert(array[j]);
		 }
		 for(int j=array.length-k;j<array.length;j++) {
			 heap.insert(heap.deleteMin());
		 }
		System.out.println(Arrays.toString(array));

		 
	 }
	 
	 public void question24_mergeSorted(){
		 int k=4;
		 int len=10;
		 int[][] array=new int[k][len];
		 
		 for(int i=0;i<k;i++) {
			 int value=(int)(50*Math.random());
			 for(int j=0;j<len;j++) {
				 int nextData=value+(int)(10*Math.random());
				 array[i][j]=nextData;
				 value=nextData;
			 }
		 }
		 for(int i=0;i<k;i++) {
			 System.out.println(Arrays.toString(array[i]));

		 }
		 int[] newArray=new int[k*len];
		 int m=0;
		 for(int i=0;i<len;i++) {
			 newArray[i]=array[0][i];
		 }
		 int[] temArray=new int[len];
		 for(int i=0;i<len;i++) {
			 temArray[i]=array[0][i];
		 }
		 for(int i=1;i<k;i++) {
			 int[] a2=array[i];
			 int[] tem=new int[temArray.length+a2.length];
			 int a=0,b=0,c=0;
			 while(a<temArray.length&&b<a2.length) {
				 if(temArray[a]<a2[b]) {
					 tem[c++]=temArray[a++];
				 }else {
					 tem[c++]=a2[b++]; 
				 }
			 }
			 while(a<temArray.length) {
				 tem[c++]=temArray[a++];
			 }
			 while(b<a2.length) {
				 tem[c++]=a2[b++]; 
			 }
			 temArray=tem;
			 
		 }
		 System.out.println(Arrays.toString(temArray)); 
	 }
	 
	 public void question26_mergeSorted() {
		 int k=4;
		 int len=10;
		 int[][] array=new int[k][len];
		 
		 for(int i=0;i<k;i++) {
			 int value=(int)(50*Math.random());
			 for(int j=0;j<len;j++) {
				 int nextData=value+(int)(10*Math.random());
				 array[i][j]=nextData;
				 value=nextData;
			 }
		 }
		 for(int i=0;i<k;i++) {
			 System.out.println(Arrays.toString(array[i]));
		 }
		 Heap heap=new Heap(k*len,1);
		 for(int i=0;i<k;i++) {
			 for(int j=0;j<len;j++) {
				 heap.insert(array[i][j]);
			 }
		 }
		 int[] tem=new int[k*len];
		 int i=0;
		 while(i<k*len) {
			 tem[i++]=heap.deleteMin();
		 }
		 System.out.println(Arrays.toString(tem)); 

		 
	 }
	 
	 public void question33_sortedInOneArray() {
		 int len1=10;
		 int len2=10;
		 
		 int[] a=new int[len1+len2];
		 int[] b=new int[len2];
		 int value=(int)(50*Math.random());
		 for(int i=0;i<len1;i++) {
			 int nextData=value+(int)(10*Math.random());
			 a[i]=nextData;
			 value=nextData;
		 }
		 System.out.println(Arrays.toString(a)); 
		 value=(int)(50*Math.random());
		 for(int i=0;i<len2;i++) {
			 int nextData=value+(int)(10*Math.random());
			 b[i]=nextData;
			 value=nextData;
		 }
		 System.out.println(Arrays.toString(b)); 
		 int m=len1-1,n=len2-1,c=len1+len2-1;
		 while(m>=0&&n>=0) {
			 if(a[m]>b[n]) {
				 a[c--]=a[m--];
			 }else {
				 a[c--]=b[n--];
			 }
		 }
		 while(m>=0) {
			 a[c--]=a[m--];
		 }
		 while(n>=0) {
			 a[c--]=b[n--];
		 }
		 System.out.println(Arrays.toString(a)); 
	 }
	 
	 
	 public void question34_nutnap() {
		 int len=10;
		 int[] array=new int[len];
		 for(int j=0;j<len;j++) {
			 int nextData=(int)(50*Math.random());
			 array[j]=nextData;
		 }
		 System.out.println(Arrays.toString(array)); 

		 int[] arrayB=new int[len];
		 for(int j=0;j<len;j++) {
			 arrayB[j]=array[j];
		 }
		 for(int j=len-1;j>=0;j--) {
			int r=(int)((j)*Math.random());
			int tem=arrayB[j];
			arrayB[j]=arrayB[r];
			arrayB[r]=tem;
		 }
		 System.out.println(Arrays.toString(arrayB)); 
		 Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		 for(int i=0;i<len;i++) {
			 for(int j=0;j<len;j++) {
				 if(array[i]==arrayB[j]) {
					 map.put(i, j);
				 }
			 }
		 }
		 Iterator it=map.keySet().iterator();
		 while(it.hasNext()) {
			 int next=(int)it.next();
			 System.out.print(next+":"+map.get(next)+",");
		 }
	 }

	 public void question36_nutnap() {
		 int len=10;
		 int[] array=new int[len];
		 for(int j=0;j<len;j++) {
			 int nextData=(int)(50*Math.random());
			 array[j]=nextData;
		 }
		 System.out.println(Arrays.toString(array)); 

		 int[] arrayB=new int[len];
		 for(int j=0;j<len;j++) {
			 arrayB[j]=array[j];
		 }
		 for(int j=len-1;j>=0;j--) {
			int r=(int)((j)*Math.random());
			int tem=arrayB[j];
			arrayB[j]=arrayB[r];
			arrayB[r]=tem;
		 }
		 System.out.println(Arrays.toString(arrayB)); 
		 
		 BinSearchTree bst=new BinSearchTree();
		 BinTreeNode root= bst.createBinSearchTree(arrayB);
		 for(int i=0;i<len;i++) {
			 if(bst.findItem(root, array[i])) {
				 System.out.print(array[i]+",");
			 }
		 }
		 
		 
		 
		 
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam1 ex=new Exam1();
		ex.question34_nutnap();
	}

}
