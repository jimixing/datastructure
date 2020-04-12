package com.jimmy.data.structure.sorted;

import java.util.Arrays;

public class ShellSorted {
	
	public void shellSort(int array[]) {
		int n=array.length;
		int tem,i,j, gap=n;
		while(gap>1) {
			gap=gap/2;
			for(i=gap;i<n;i++) {
				for(j=i;j-gap>=0&&array[j-gap]>array[j];j-=gap) {
					tem=array[j];
					array[j]=array[j-gap];
					array[j-gap]=tem;
				}
				
			}
			
		}
		
		
	}
	

	public static void main(String[] args) {
		int [] array=new int[8];
		for(int i=0;i<8;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		ShellSorted bs=new ShellSorted();
		bs.shellSort(array);
		System.out.println(Arrays.toString(array));

	}

}
