package com.jimmy.data.structure.sorted;

import java.util.Arrays;

public class QuikSorted {
	
	public void quickSort(int[] array, int left, int right) {
		if(left<right) {
			int pos=partition(array,left, right);
			quickSort(array,left,pos-1);
			quickSort(array,pos+1,right);
		}

	}
	
	public int partition(int[]array, int left, int right) {
		int p1=left,p2=right;
		int value=array[left];
		while(p1<p2) {
			
			while(array[p2]>value&&p1<p2) {
				p2--;
			}
			while(array[p1]<=value&&p1<p2) {
				p1++;
			}
			
			if(p1<p2) {
				int tem=array[p1];
				array[p1]=array[p2];
				array[p2]=tem;
			}
		}
		array[left]=array[p2];
		array[p2]=value;
		
		
		return p2;
	}
	
	

	public static void main(String[] args) {
		int lenth=20;
		int [] array=new int[lenth];
		for(int i=0;i<lenth;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		
		QuikSorted ss=new QuikSorted();
		ss.quickSort(array,0,array.length-1);
		System.out.println(Arrays.toString(array));
	}

}
