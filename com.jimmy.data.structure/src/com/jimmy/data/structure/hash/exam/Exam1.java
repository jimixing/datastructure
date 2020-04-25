package com.jimmy.data.structure.hash.exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.jimmy.data.structure.hash.HashTableOp;
import com.jimmy.data.structure.list.ListUtil;
import com.jimmy.data.structure.list.SingListNode;
import com.jimmy.data.structure.sorted.MergeSorted;

public class Exam1 {
	private HashTableOp op=new HashTableOp(20);

	public void question2_findrepeate() {
		String str="abdcodkdjjemdldk";
		char[] ch=str.toCharArray();
		int len=ch.length;
		for(int i=0;i<len;i++) {	
			for(int j=i+1;j<len;j++) {
				if(ch[i]==ch[j]) {
					ch[j]='\0';
				}
			}	
		}
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<len;i++) {
			if(ch[i]!='\0') {
				sb.append(ch[i]);
			}
		}
		System.out.print(sb);
	}
	
	public void question3_findRepeate() {
		String str="abdcodkdjjemdldk";
		char[] ch=str.toCharArray();
		
		int[] newch=new int[ch.length];
		for(int i=0;i<newch.length;i++) {
			newch[i]=(int)(ch[i]);
		}
		MergeSorted ms=new MergeSorted();
		ms.mergeSorted(newch, 0, newch.length-1);
		for(int i=0;i<newch.length;i++) {
			ch[i]=(char)(newch[i]);
		}
		int len=ch.length;
		int repeat=1;
		for(int i=0;i<len;i+=repeat) {
			repeat=1;
			while((i+repeat)<len&&ch[i]==ch[i+repeat]) {
				ch[i+repeat]='\0';
				repeat++;
			}
		}
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<len;i++) {
			if(ch[i]!='\0') {
				sb.append(ch[i]);
			}
		}
		System.out.print(sb);

	}
	
	public void question4_findRepeat() {
		String str="abdcodkdjjemdldk";
		char[] ch=str.toCharArray();
		//HashTableOp op=new HashTableOp(20);
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<ch.length;i++) {
			if(!op.search((int)ch[i])) {
				sb.append(ch[i]);
				op.insert((int)ch[i]);
			}
			
			
		}
		System.out.print(sb);	
		
	}
	
	public void question5_findSameData() {
		int[] array1=new int[] {2,6,4,7,8,12,3,14,9};
		int[] array2=new int[] {6,7,4,2,3,8,12,9,14};
		MergeSorted ms=new MergeSorted();
		ms.mergeSorted(array1, 0, array1.length-1);
		ms.mergeSorted(array2, 0, array2.length-1);
		boolean isSame=true;
		for(int i=0;i<array1.length;i++) {
			if(array1[i]!=array2[i]) {
				isSame=false;
				break;
			}
		}
		System.out.print(isSame);
		
		
	}
	
	public void question7_findSameData() {
		int[] array1=new int[] {2,6,4,7,8,12,3,14,9};
		int[] array2=new int[] {6,7,4,2,3,8,12,9,14};
		for(int i=0;i<array1.length;i++) {
			op.insert(array1[i]);
		}
		boolean isSame=true;
		for(int i=0;i<array2.length;i++) {
			if(!op.search(array2[i])) {
				isSame=false;
				break;
			}
			
		}
		System.out.print(isSame);

	}
	
	
	public void question8_findNumber() {
		int[][] a= new int[][]{{1,3},{2,6},{3,5},{7,4},{5,3},{8,7}};
		
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		for(int i=0;i<a.length;i++) {
			map.put(a[i][0], a[i][1]);
		}
		for(int i=0;i<a.length;i++) {
			if(map.get(a[i][0])!=null&&map.get(map.get(a[i][0]))!=null&&map.get(map.get(a[i][0]))==a[i][0]) {
				System.out.print("{"+a[i][0]+","+a[i][1]+"}");
			}	
		}	
	}
	
	public void question9_findCycle() {
		SingListNode head=ListUtil.generateSingList(20);
		SingListNode tem=head;
		boolean isCycle=false;
		Map<SingListNode,Integer> map=new HashMap<SingListNode,Integer>();
		while(tem!=null) {
			if(map.get(tem)==null) {
				map.put(tem, 1);
				tem=tem.getNext();
			}else {
				isCycle=true;
				break;
			}
		}
		
		System.out.print(isCycle);
		
		
	}
	
	public void question10_findRepeat() {
		int[] array=new int[101];
		for(int i=0;i<50;i++) {
			array[i]=(int)(Math.random()*200);
		}
		int value=400+(int)(Math.random()*200);
		for(int i=50;i<53;i++) {
			array[i]=value;
		}
		for(int i=53;i<101;i+=2) {
			value=200+(int)(Math.random()*200);
			array[i]=value;
			array[i+1]=value;
		}
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<101;i++) {
			if(map.get(array[i])==null) {
				map.put(array[i],1);
			}else {
				map.put(array[i],map.get(array[i])+1);
			}
			if(map.get(array[i])==3) {
				System.out.println("last element of 3 times: "+array[i]);
			}
		}
		
		
	}
	public int[]  generateArray(int len) {
	//	int len=20;
		int [] array=new int[len];
		for(int i=0;i<len;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		return array;
	}
	public void question11_findMaxCount() {
		int M=5;
		int N=20;
		int[][] array=new int[5][20];
		for(int i=0;i<M;i++) {
			array[i]=generateArray(20);
		}
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		int count=0;
		int value=-1;
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(map.get(array[i][j])==null) {
					map.put(array[i][j],1);
				}else {
					map.put(array[i][j],map.get(array[i][j])+1);
				}
				if(map.get(array[i][j])>count) {
					count=map.get(array[i][j]);
					value=array[i][j];
				}
			}
		}
		System.out.print("value is "+value +"and repeate time is "+count);
		
	}
	
	public void question12_findSum() {
		int[] array1=generateArray(20);
		int[] array2=generateArray(10);
		int sum=40;
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		
		for(int i=0;i<array2.length;i++) {
			map.put(sum-array2[i], 1);
		}
		for(int i=0;i<array1.length;i++) {
			if(map.get(array1[i])!=null) {
				System.out.println("value in array1 is "+array1[i]+ " and value in array2 is "+(sum-array1[i]));
			}
		}
		
		
		
	}
	
	public void question14_findFirstUnRepeate() {
		String str="abzddab";
		char[] ch=str.toCharArray();
		for(int i=0;i<ch.length;i++) {
			boolean isRepeat=false;
			for(int j=0;j<ch.length;j++) {
				if(i!=j&&ch[i]==ch[j]) {
					isRepeat=true;
				}
			}
			if(!isRepeat) {
				System.out.println("UnRepeat value is "+ ch[i]);
			}
		}
		
		
		
	}
	
	public void question15_findFirstUnRepeate() {
		
		String str="abzddab";
		char[] ch=str.toCharArray();
		
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0;i<ch.length;i++) {
			if(map.get(ch[i])==null) {
				map.put(ch[i], 1);
			}else {
				map.put(ch[i], map.get(ch[i])+1);
			}
		}
		for(int i=0;i<ch.length;i++) {
			if(map.get(ch[i])==1) {
				System.out.println("UnRepeat value is "+ ch[i]);
				break;
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam1 ex=new Exam1();
		ex.question15_findFirstUnRepeate();
	}

}
