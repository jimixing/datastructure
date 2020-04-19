package com.jimmy.data.structure.search;

import java.util.Arrays;

public class SearchInBinArray {
	
	public int search(int[] array,int low, int high,int data) {
//		int low=0;
//		int high=array.length-1;
		while(low<=high) {
			int middle=(low+high)/2;
			if(array[middle]==data) {
				return middle;
			}else if(array[middle]>data) {
				high=middle-1;
			}else {
				low=middle+1;
			}
		}
		return -1;
	}
	
	public int search2(int[] array, int data, int left, int right) {
		if(left>right) return -1;
		int middle=(left+right)/2;
		if(array[middle]==data)return middle;
		else if(array[middle]>data) {
			return search2(array,data,left,middle-1);
		}else {
			return search2(array,data,middle+1,right);
		}
	}
	
	

	public static void main(String[] args) {
		 int len=40;
		 int[] array=new int[len];
		 int value=(int)(20*Math.random());
		 for(int j=0;j<len;j++) {
			 int nextData=value+(int)(3*Math.random());
			 array[j]=nextData;
			 value=nextData;
		 }
//		 array[4]=40;
		System.out.println(Arrays.toString(array));
		
		SearchInBinArray si=new SearchInBinArray();
		int pos=si.search2(array, 40,0,len-1);
		System.out.println(pos);
	}
	
}
