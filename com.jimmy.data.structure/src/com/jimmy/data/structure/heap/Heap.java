package com.jimmy.data.structure.heap;

import java.util.Arrays;

public class Heap {
	
	private int capacity;
	private int count=0;
	private int[] array;
	private int type;
	
	
	public Heap(int capacity, int type) {
		this.capacity=capacity;
		this.type=type;
		this.array=new int[this.capacity];
	}
	
	public int size() {
		return count;
	}
	public void setSize(int count) {
		this.count=count;
	}
	
	public int getParent(int i) {
		if(i<0||i>this.count) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return array[(i-1)/2];
		
	}
	
	public int getLeftChild(int i) {
		int leftchild=2*i+1;
		if(leftchild>count) {
			return -1;
		}
		return  array[leftchild];
		
	}
	
	public int getRightChild(int i) {
		int rightchild=2*i+2;
		if(rightchild>count) {
				return -1;
		}
		return  array[rightchild];
	}
	
	public int getMax() {
		if(type==2) {
			if(count==0) {
				throw new ArrayIndexOutOfBoundsException();
			}
			return array[0];
		}
		return -1;
	}
	
	public int getMin() {
		if(type==1) {
			if(count==0) {
				throw new ArrayIndexOutOfBoundsException();
			}
			return array[0];
		}
		return -1;
		
	}
	public int deleteMax() {
		if(type==1) return -1;
		if(count==0) {
			return -1;
		}
		int value=array[0];
		array[0]=array[count-1];
		count--;
		percolateDown(0);
		return value;
	}
	
	public int deleteMin() {
		if(type==2) return -1;
		if(count==0) {
			return -1;
		}
		int value=array[0];
		array[0]=array[count-1];
		count--;
		percolateDown(0);
		return value;
	}
	
	public void percolateDown(int i) {
		if(i>=count)return ;
		int left=getLeftChild(i);
		int right=getRightChild(i);
		if(left==-1||right==-1)return;
		if(type==2) {
			if(left>right) {
				int tem=array[i];
				array[i]=array[2*i+1];
				array[2*i+1]=tem;
				percolateDown(2*i+1);
			}else {
				int tem=array[i];
				array[i]=array[2*i+2];
				array[2*i+2]=tem;
				percolateDown(2*i+2);
			}
		}else if(type==1) {
			if(left<right) {
				int tem=array[i];
				array[i]=array[2*i+1];
				array[2*i+1]=tem;
				percolateDown(2*i+1);
			}else {
				int tem=array[i];
				array[i]=array[2*i+2];
				array[2*i+2]=tem;
				percolateDown(2*i+2);
			}
		}
		
	}
	
	public void insert(int data) {
		if(count>=capacity) {
			throw new ArrayIndexOutOfBoundsException();
		}
		array[count++]=data;
		int tem=count-1;
		if(type==2) {
			while(tem>0&&array[tem]>array[(tem-1)/2]) {
				int temp=array[tem];
				array[tem]=array[(tem-1)/2];
				array[(tem-1)/2]=temp;
				tem=(tem-1)/2;
			}
		}else if(type==1) {
			while(tem>0&&array[tem]<array[(tem-1)/2]) {
				int temp=array[tem];
				array[tem]=array[(tem-1)/2];
				array[(tem-1)/2]=temp;
				tem=(tem-1)/2;
			}
		}
		
		
		
	}
	public String toString() {
		int[] newarr=Arrays.copyOfRange(array, 0, count);
		return Arrays.toString(newarr);
	}
	
	public int[] sortHeap() {
		int[] copy=Arrays.copyOf(array, array.length);
		int[] newArray=new int[copy.length];
		for(int i=0;i<copy.length;i++) {
			newArray[i]=deleteMax();
		}
		array=Arrays.copyOf(copy, copy.length);
		return newArray;
	}
	public int[] getLeave() {
		return Arrays.copyOfRange(array, (count-1)/2, count-1);
	}
	
	public int[] getArray() {
		return array;
		
	}
	public static void main(String[] args) {
		
		Heap heap=new Heap(10,1);
		
		int [] arr=new int[] {10,12,3,4,22,56,7};
		for(int i=0;i<arr.length;i++) {
			heap.insert(arr[i]);
		}
		for(int i=0;i<2;i++) {
			System.out.println(heap.deleteMin()+",");
		}
		
//		int[] sort= heap.sortHeap();
//		System.out.print(Arrays.toString(sort));
		
	}

}
