package com.jimmy.data.structure.string.exam;

import java.util.Arrays;

import lombok.Data;


public class HeapString {
	
	private int capacity;
	private int count=0;
	private int[] array;
	private int type;
	private String[] arrayStr;
	
	
	public HeapString(int capacity, int type) {
		this.capacity=capacity;
		this.type=type;
		this.array=new int[this.capacity];
		this.arrayStr=new String[this.capacity];
		
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
	public HeapMapping deleteMax() {
		if(type==1) return null;
		if(count==0) {
			return null;
		}
		int value=array[0];
		array[0]=array[count-1];
		String strValue=arrayStr[0];

		count--;
		percolateDown(0);
		return new HeapMapping(value,strValue);
	}
	
	public HeapMapping deleteMin() {
		if(type==2) return null;
		if(count==0) {
			return null;
		}
		int value=array[0];
		array[0]=array[count-1];
		String strValue=arrayStr[0];
		arrayStr[0]=arrayStr[count-1];
		count--;
		percolateDown(0);
		return new HeapMapping(value,strValue);
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
				
				String temstr=arrayStr[i];
				arrayStr[i]=arrayStr[2*i+1];
				arrayStr[2*i+1]=temstr;
				
				percolateDown(2*i+1);
				
			}else {
				int tem=array[i];
				array[i]=array[2*i+2];
				array[2*i+2]=tem;
				
				String temstr=arrayStr[i];
				arrayStr[i]=arrayStr[2*i+2];
				arrayStr[2*i+2]=temstr;
				
				percolateDown(2*i+2);
			}
		}else if(type==1) {
			if(left<right) {
				int tem=array[i];
				array[i]=array[2*i+1];
				array[2*i+1]=tem;
				String temstr=arrayStr[i];
				arrayStr[i]=arrayStr[2*i+1];
				arrayStr[2*i+1]=temstr;
				
				percolateDown(2*i+1);
			}else {
				int tem=array[i];
				array[i]=array[2*i+2];
				array[2*i+2]=tem;
				
				String temstr=arrayStr[i];
				arrayStr[i]=arrayStr[2*i+2];
				arrayStr[2*i+2]=temstr;
				
				percolateDown(2*i+2);
			}
		}
		
	}
	
	public void insert(int data,String key) {
		if(count>=capacity) {
			throw new ArrayIndexOutOfBoundsException();
		}
		int cnt=count;
		array[cnt]=data;
		arrayStr[cnt]=key;
		count++;
		int tem=count-1;
		if(type==2) {
			while(tem>0&&array[tem]>array[(tem-1)/2]) {
				int temp=array[tem];
				array[tem]=array[(tem-1)/2];
				array[(tem-1)/2]=temp;
				tem=(tem-1)/2;
				
				String temstr=arrayStr[tem];
				arrayStr[tem]=arrayStr[(tem-1)/2];
				arrayStr[(tem-1)/2]=temstr;
				
			}
		}else if(type==1) {
			while(tem>0&&array[tem]<array[(tem-1)/2]) {
				int temp=array[tem];
				array[tem]=array[(tem-1)/2];
				array[(tem-1)/2]=temp;
				tem=(tem-1)/2;
				
				String temstr=arrayStr[tem];
				arrayStr[tem]=arrayStr[(tem-1)/2];
				arrayStr[(tem-1)/2]=temstr;
				
			}
		}
		
		
		
	}
	public String toString() {
		int[] newarr=Arrays.copyOfRange(array, 0, count);
		return Arrays.toString(newarr);
	}
	
//	public int[] sortHeap() {
//		int[] copy=Arrays.copyOf(array, array.length);
//		int[] newArray=new int[copy.length];
//		for(int i=0;i<copy.length;i++) {
//			newArray[i]=deleteMax();
//		}
//		array=Arrays.copyOf(copy, copy.length);
//		return newArray;
//	}

	
	public int[] getArray() {
		return array;
		
	}
	
	@Data
	public class HeapMapping{
		private int value;
		private String value2;
		
		public HeapMapping(int value,String value2) {
			this.value=value;
			this.value2=value2;
		}
		
	}

}
