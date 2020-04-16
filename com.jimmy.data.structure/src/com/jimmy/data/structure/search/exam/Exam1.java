package com.jimmy.data.structure.search.exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.jimmy.data.structure.sorted.MergeSorted;

public class Exam1 {
	
	
	public void question1_findrepeate() {
		int [] array=new int[40];
		for(int i=0;i<40;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		boolean repeate=false;
		int pos=0;
		for(int i=0;i<array.length;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i]==array[j]) {
					repeate=true;
					pos=i;
					break;
				}
			}
			if(repeate) {
				break;
			}
		}
		System.out.println("Find repeatable!"+array[pos]);
		
	}
	
	public void question2_findRepeat() {
		int [] array=new int[40];
		for(int i=0;i<40;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		
		int pos=-1;
		MergeSorted ms=new MergeSorted();
		ms.mergeSorted(array, 0, array.length-1);
		for(int i=0;i<array.length-1;i++) {
			if(array[i]==array[i+1]) {
				pos=i;
				break;
			}
		}
		System.out.println("Find repeatable!"+array[pos]);
		
	}
	
	
	public void question3_findRepeat() {
		int [] array=new int[10];
		for(int i=0;i<10;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		int pos=-1;
		for(int i=0;i<array.length;i++) {
			if(map.get(array[i])==null) {
				map.put(array[i], 1);
			}else {
				pos=i;
				break;
			}
		}
		System.out.println("Find repeatable!"+array[pos]);	
	}
	
	public void question4_findRepeat() {
		int [] array=new int[10];
		for(int i=0;i<10;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		
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
		int pos=-1;
		for(int i=0;i<len;i++) {
			if(number[i]>1) {
				pos=i;
				break;
			}
		}
		if(pos>-1) {
			System.out.println("Find repeatable!"+(pos+min));	
		}else {
			System.out.println("No repeat number!");
		}	
		
	}
	
	public void question5_findMaxRepeateInArray() {
		int len=10;
		int [] array=new int[len];
		for(int i=0;i<len;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		
		int max=-1;
		int value=-1;
		for(int i=0;i<len;i++) {
			int number=1;
			for(int j=i+1;j<len;j++) {
				if(array[i]==array[j]) {
					number++;
				}
			}
			if(number>max) {
				max=number;
				value=array[i];
			}
		}
		
		System.out.print("Max Repeat data in array: "+value+", and repeate time is : "+max);
		
		
	}
	
	
	public void question6_findMaxRepeateInArray() {
		
		int len=40;
		int [] array=new int[len];
		for(int i=0;i<len;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		MergeSorted ms=new MergeSorted();
		ms.mergeSorted(array, 0, len-1);
		System.out.println(Arrays.toString(array));
		int value=-1,max=-1;
		for(int i=0;i<len;) {
			int count=1;
			while(i+count<len&&array[i]==array[i+count]) {
				count++;
			}
			if(count>max) {
				max=count;
				value=array[i];
			}
			i+=count;
		}
		System.out.print("Max Repeat data in array: "+value+", and repeate time is : "+max);
		
	}
	

	public static void main(String[] args) {
		Exam1 ex=new Exam1();
		ex.question6_findMaxRepeateInArray();
	}

}
