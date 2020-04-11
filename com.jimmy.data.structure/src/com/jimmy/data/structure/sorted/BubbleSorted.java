package com.jimmy.data.structure.sorted;

import java.util.Arrays;

public class BubbleSorted {

	public void bubbleSorted(int []array) {
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array.length-1-i;j++) {
				if(array[j]>array[j+1]) {
					int tem=array[j];
					array[j]=array[j+1];
					array[j+1]=tem;
				}
			}
		}
	}
	
	public void bubbleSortedImprove(int[] array) {
		boolean swapped=true;
		for(int i=0;i<array.length&&swapped;i++) {
			swapped=false;
			for(int j=0;j<array.length-1-i;j++) {
				if(array[j]>array[j+1]) {
					int tem=array[j];
					array[j]=array[j+1];
					array[j+1]=tem;
					swapped=true;
				}	
			}	
		}	
	}
	
	
	
	public static void main(String[] args) {
		int [] array=new int[20];
		for(int i=0;i<20;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		BubbleSorted bs=new BubbleSorted();
		//bs.bubbleSorted(array)
		bs.bubbleSortedImprove(array);
		System.out.println(Arrays.toString(array));

	}

}
