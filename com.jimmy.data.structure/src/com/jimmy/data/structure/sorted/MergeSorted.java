package com.jimmy.data.structure.sorted;

import java.util.Arrays;

public class MergeSorted {
	
	public void mergeSorted(int array[],int start, int end) {
		if(start>=end) return ;
		int middle=(start+end)/2;
		
		mergeSorted(array, start,middle);
		mergeSorted(array,middle+1, end );
		merge(array,start,middle,end);
		
	}
	
	public void merge(int[] array, int left, int middle, int end) {
		int[] tem=new int[array.length];
		int p1=left, p2=middle+1;
		int p3=left;
		while(p1<=middle&&p2<=end) {
			if(array[p1]<array[p2]) {
				tem[p3++]=array[p1++];
			}else {
				tem[p3++]=array[p2++];
			}
		}
		while(p1<=middle) {
			tem[p3++]=array[p1++];
		}
		while(p2<=end) {
			tem[p3++]=array[p2++];
		}
		for(int i=left;i<=end;i++) {
			array[i]=tem[i];
		}
		
	}
	

	public static void main(String[] args) {
		int [] array=new int[20];
		for(int i=0;i<20;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		
		MergeSorted ss=new MergeSorted();
		//bs.bubbleSorted(array)
		ss.mergeSorted(array,0,array.length-1);
		System.out.println(Arrays.toString(array));

	}

}
