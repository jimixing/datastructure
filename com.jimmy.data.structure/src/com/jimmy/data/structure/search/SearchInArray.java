package com.jimmy.data.structure.search;

import java.util.Arrays;

public class SearchInArray {
	
	public int search(int array[],int data) {
		for(int i=0;i<array.length;i++) {
			if(array[i]==data)return i;
		}
		return -1;
	}
	

	public static void main(String[] args) {
		int [] array=new int[40];
		for(int i=0;i<40;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		
		SearchInArray si=new SearchInArray();
		int pos=si.search(array, 10);
		System.out.println(pos);
	}

}
