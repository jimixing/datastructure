package com.jimmy.data.structure.sorted;

import java.util.Arrays;

public class SelectSorted {

	public void selectedSorted(int[] array) {
		for(int i=0;i<array.length;i++) {
			int min=i;
			for(int j=i+1;j<array.length;j++) {
				if(array[j]<array[min]) {
					min=j;
				}
			}
			int tem=array[min];
			array[min]=array[i];
			array[i]=tem;
		}
	}
	
	
	public static void main(String[] args) {
		int [] array=new int[20];
		for(int i=0;i<20;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		SelectSorted ss=new SelectSorted();
		//bs.bubbleSorted(array)
		ss.selectedSorted(array);
		System.out.println(Arrays.toString(array));

	}

}
