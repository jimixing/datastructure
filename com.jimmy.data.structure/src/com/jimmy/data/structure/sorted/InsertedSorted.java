package com.jimmy.data.structure.sorted;

import java.util.Arrays;

public class InsertedSorted {
	
	
	public void insertedSorted(int array[]) {
		for(int i=1;i<array.length;i++) {
			int j=i;
			int tem=array[i];
			while(j>0&&array[j-1]>tem) {
				array[j]=array[j-1];
				j--;
			}
			array[j]=tem;
			
		}
		
		
		
	}

	public static void main(String[] args) {
		int [] array=new int[20];
		for(int i=0;i<20;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		
		InsertedSorted is=new InsertedSorted();
		is.insertedSorted(array);
		System.out.println(Arrays.toString(array));

	}

}
