package com.jimmy.data.structure.sorted;

import java.util.Arrays;

public class CountSorted {
	
	public void countSort(int[] array ) {
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
	
	

	public static void main(String[] args) {
		int lenth=20;
		int [] array=new int[lenth];
		for(int i=0;i<lenth;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		CountSorted ss=new CountSorted();
		ss.countSort(array);
	}

}
