package com.jimmy.data.structure.search.exam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.jimmy.data.structure.heap.Heap;
import com.jimmy.data.structure.search.SearchInBinArray;
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
	
	public void question7_findMaxRepeateInArray() {
		int [] array=new int[40];
		for(int i=0;i<40;i++) {
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
				map.put(array[i], map.get(array[i])+1);
			}
		}
		Iterator it=map.keySet().iterator();
		int max=-1;
		int value=-1;
		while(it.hasNext()) {
			int key=(int)it.next();
			if(map.get(key)>max) {
				max=map.get(key);
				value=key;
			}
		}
		
		System.out.println("Find repeatable for " +max+ "times of value" +value );	
	}
	
	
	public void question8_findMaxRepeateInArray() {
		
		int [] array=new int[40];
		for(int i=0;i<40;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		
		int[] newArray=new int[50];
		for(int i=0;i<40;i++) {
			newArray[array[i]]++;
		}
		int count=-1;
		int value=-1;
		for(int i=0;i<50;i++) {
			if(newArray[i]>count) {
				count=(newArray[i]);
				value=i;
			}
		}
		System.out.println("Find repeatable for " +count+ "times of value" +value );	

	}
	
	
	public void question9_findFirstRepeate() {
		int [] array=new int[40];
		for(int i=0;i<40;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		int pos=-1;
		for(int i=0;i<array.length;i++) {
			boolean find=false;
			for(int j=i+1;j<array.length;j++) {
				if(array[i]==array[j]) {
					find=true;
					break;
				}
			}
			if(find) {
				System.out.print("Position is "+i);
				break;
			}
		}
	}
	public void question13_findMissing() {
		int[] data=new int[] {1,2,4,6,3,7,8};
	
		for(int i=1;i<8;i++) {
			boolean found=false;
			for(int j=0;j<data.length;j++) {
				if(data[j]==i) {
					found=true;
				}
			}
			if(!found) {
				System.out.print("missing value "+i);
				break;
			}
		}
		
	}
	
	public void question14_findMissing() {
		int[] data=new int[] {1,2,4,6,3,7,8};
		MergeSorted ms=new MergeSorted();
		ms.mergeSorted(data, 0, data.length-1);
		for(int i=0;i<data.length-1;i++) {
			if(data[i+1]-data[i]!=1) {
				System.out.print("missing value "+i);
				break;
			}
		}
		
	}
	
	public void question16_findMissing() {
		//{1~8}
		int[] data=new int[] {1,2,4,6,3,7,8};
		
		int sum=0;
		for(int i=1;i<=8;i++) {
			sum+=i;
		}
		int sum2=0;
		for(int j=0;j<data.length;j++) {
			sum2+=data[j];
		}
		int value=sum-sum2;
		System.out.print("missing value "+value);
		
	}
	
	public void question17_findMissing() {
		int[] data=new int[] {1,2,4,6,3,7,8};
		int Xor=0;
		for(int i=1;i<=8;i++) {
			Xor^=i;
		}
		int sum2=0;
		for(int j=0;j<data.length;j++) {
			sum2^=data[j];
		}
		int value=Xor^sum2;
		System.out.print("missing value "+value);	
	}
	
	public void question18_findOddUmber() {
		int[] data=new int[]{1,2,3,2,3,1,3};
		int value=0;
		for(int i=0;i<data.length;i++) {
			value^=data[i];
		}
		System.out.print("odd number value "+value);	
	}
	
	
	public void question19_findTwoRepeate() {
		int[] data=new int[] {4,2,4,5,2,3,1};
		int len=7;
		int n=5;
		for(int i=0;i<len;i++) {
			for(int j=i+1;j<len;j++) {
				if(data[i]==data[j]) {
					System.out.print(data[i]+",");
				}
			}
		}
		
		
	}
	
	
	public void question20_findTwoRepeate() {
		int[] array=new int[] {4,2,4,5,2,3,1};
		MergeSorted ms=new MergeSorted();
		ms.mergeSorted(array, 0, array.length-1);
		for(int i=0;i<array.length-1;i++) {
			if(array[i]==array[i+1]) {
				System.out.print(array[i]+",");
			}
		}
	}
	
	public void question21_findTwoRepeate() {
		int[] array=new int[] {4,2,4,5,2,3,1};
		int len=7;
		int n=5;
		int[]  number=new int[n+1];
		for(int i=0;i<len;i++) {
			number[array[i]]++;
		}
		for(int i=0;i<n;i++) {
			if(number[i]==2) {
				System.out.print(i+",");

			}
		}
	}
	
	public void question22_findTwoRepeate() {
		int[] array=new int[] {4,2,4,5,2,3,1};
		int len=7;
		int n=5;
		int value=0;
		for(int i=0;i<len;i++) {
			value^=array[i];
		}
		for(int j=1;j<=n;j++) {
			value^=j;
		}
		int bit_1=value&~(value-1);
		int x=0,y=0;
		for(int i=0;i<array.length;i++) {
			if((array[i]&bit_1)!=0) {
				x^=array[i];
			}else {
				y^=array[i];
			}
		}
		for(int i=1;i<=n;i++) {
			if((i&bit_1)!=0) {
				x^=i;
			}else {
				y^=i;
			}
		}
		System.out.print("value is"+x+ "and the ther is "+y);

	}
	
	
	public void question23_findTwoRepeate() {
		int[] array=new int[] {4,2,4,5,2,3,1};
		int sum1=0;
		int sum2=0;
		int mul1=1;
		int mul2=1;
		int len=7;
		int n=5;
		for(int i=0;i<len;i++) {
			sum1+=array[i];
			
		}
		for(int i=0;i<=n;i++) {
			sum2+=i;
		}
		int twosum=sum1-sum2;
		for(int i=0;i<len;i++) {
			mul1*=array[i];
		}
		for(int i=1;i<=n;i++) {
			mul2*=i;
		}
		int towMul=mul1/mul2;
		
		System.out.print("two sum is "+twosum +" and it's mul result is "+towMul);

	}

	public void question25_twoSum(){
		int [] array=new int[40];
		for(int i=0;i<40;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		int K=50;
		for(int i=0;i<array.length;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i]+array[j]==K) {
					System.out.print("("+array[i]+","+array[j]+")");
				}
			}
		}	
	}
	
	
	public void question26_twoSum() {
		int [] array=new int[40];
		for(int i=0;i<40;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		
		
		MergeSorted ms=new MergeSorted();
		ms.mergeSorted(array, 0, array.length-1);
		int K=50;
		for(int i=0,j=array.length-1;i<j;) {
			if(array[i]+array[j]==K) {
				System.out.print("("+array[i]+","+array[j]+")");
				i++;
			}else if(array[i]+array[j]>K) {
				j=j-1;
			}else {
				i=i+1;
			}	
		}
	}
	
	
	public void question27_twoSum() {
		int [] array=new int[20];
		for(int i=0;i<20;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<array.length;i++) {
			map.put(array[i], 1);
		}
		int K=50;
		Iterator it=map.keySet().iterator();
		while(it.hasNext()) {
			Integer key=(Integer)it.next();
			if(map.get(50-key)!=null) {
				System.out.print("("+key+","+(K-key)+")");
			}
		}
		
	}
	
	
	public void question29_twoSumofsquare() {
		int len=20;
		int [] array=new int[len];
		for(int i=0;i<len;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		for(int i=0;i<len;i++) {
			array[i]=array[i]*array[i];
		}
		MergeSorted ms=new MergeSorted();
		ms.mergeSorted(array, 0, array.length-1);
		for(int l=array.length-1;l>=0;l--) {
			int K=array[l];
			for(int i=0,j=array.length-2;i<j;) {
				if(array[i]+array[j]==K) {
					System.out.print("("+Math.sqrt(array[i])+","+Math.sqrt(array[j])+","+Math.sqrt(array[l])+")");
					i++;
				}else if(array[i]+array[j]>K) {
					j=j-1;
				}else {
					i=i+1;
				}	
			}
		}
		
	}
	
	public void question30_sumCloseToZero() {
		int len=20;
		int [] array=new int[len];
		for(int i=0;i<len;i++) {
			int data=(int)(Math.random()*50);
			double flag=Math.random();
			array[i]=flag>0.5?data:-data;
		}
		System.out.println(Arrays.toString(array));
		
		int min_i=0, min_j=0,min_sun=Integer.MAX_VALUE;
		for(int i=0;i<array.length;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(Math.abs(array[i]+array[j])<min_sun) {
					min_i=i;
					min_j=j;
					min_sun=Math.abs(array[i]+array[j]);
				}
			}
		}
		System.out.print("("+array[min_i]+","+array[min_j]+","+min_sun+")");
		
	}
	
	public void question31_sumCloseToZero() {
		int len=20;
		int [] array=new int[len];
		for(int i=0;i<len;i++) {
			int data=(int)(Math.random()*50);
			double flag=Math.random();
			array[i]=flag>0.5?data:-data;
		}
		System.out.println(Arrays.toString(array));
		
		MergeSorted ms=new MergeSorted();
		ms.mergeSorted(array, 0, array.length-1);
		int min_i=0,min_j=array.length-1, posi=Integer.MAX_VALUE;
		int i=0,j=array.length-1;
		while(i<j) {
			int tem=array[i]+array[j];
			if(tem>0) {
				if(tem<posi) {
					posi=tem;
					min_i=i;
					min_j=j;
				}
				j--;
				
			}else {
				if(Math.abs(tem)<posi) {
					posi=tem;
					min_i=i;
					min_j=j;
				}
				i++;
			}
		}
		System.out.print("("+array[min_i]+","+array[min_j]+","+posi+")");
		
	}
	
	
	public void question32_ThreeSum() {
		int len=20;
		int [] array=new int[len];
		for(int i=0;i<len;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		int K=50;
		for(int i=0;i<array.length;i++) {
			for(int j=i+1;j<array.length;j++) {
				for(int k=j+1;k<array.length;k++) {
					if(array[i]+array[j]+array[k]==K) {
						System.out.print("("+array[i]+","+array[j]+","+array[k]+")");

					}
				}
			}
		}	
	}
	
	public int[]  generateArray() {
		int len=20;
		int [] array=new int[len];
		for(int i=0;i<len;i++) {
			int data=(int)(Math.random()*50);
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));
		return array;
	}
	
	public void question34_threeSum() {
		int[] array=generateArray();
		
		MergeSorted ms=new MergeSorted();
		ms.mergeSorted(array, 0, array.length-1);
		int K=50;
		for(int i=0;i<array.length;i++) {
			
			for(int j=i+1, k=array.length-1;j<k;) {
				if(array[i]+array[j]+array[k]==K) {
					System.out.print("("+array[i]+","+array[j]+","+array[k]+")");
					k--;
					j++;
				}else if(array[i]+array[j]+array[k]>=K) {
					k--;
				}else {
					j++;
				}
			}
			
		}	
		
	}
	
	
	public void question35_threeSum() {
		int[] array=generateArray();
		int K=50;
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		
		for(int i=0;i<array.length;i++) {
			map.put(K-array[i], i);
		}
		for(int i=0;i<array.length;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(map.get(array[i]+array[j])!=null&&map.get(array[i]+array[j])!=i&&map.get(array[i]+array[j])!=j) {
					System.out.print("("+array[i]+","+array[j]+","+map.get(array[i]+array[j])+")");
				}
			}
		}
		
	}
	
	public void question36_checkMax() {
		int len=20;
		int [] array=new int[len];
		int value=(int)(Math.random()*50);
		for(int i=0;i<12;i++) {
			int data=value+(int)(Math.random()*10);
			array[i]=data;
			value=data;
		}
		for(int i=12;i<len;i++) {
			int data=value-(int)(Math.random()*10);
			array[i]=data;
			value=data;
		}
		
		System.out.println(Arrays.toString(array));
		int i=0,j=array.length-1;
		int pos=-1;
		while(i<=j) {
			int m=(i+j)/2;
			if(i==j) {
				pos=i;
				break;
			}
			if(i==j-1) {
				pos= array[i]>array[j]?i:j;
				break;
			}
			if(array[m-1]<=array[m]&&array[m]>=array[m+1]) {
				pos=m;
				break;
			}else if(array[m-1]>=array[m]&&array[m]>=array[m+1]) {
				j=m-1;
			}else if(array[m-1]<=array[m]&&array[m]<=array[m+1]) {
				i=m+1;
			}	
		}
		System.out.println(pos);
		
	}
	
	
	public void question37_checkMax() {
		int len=500;
		int [] array=new int[len];
		int value=(int)(Math.random()*500);
		int pos=(int)(Math.random()*500);
		for(int i=0;i<pos;i++) {
			int data=value+(int)(Math.random()*10);
			array[i]=data;
			value=data;
		}
		for(int i=pos;i<len;i++) {
			int data=value-(int)(Math.random()*10);
			array[i]=data;
			value=data;
		}
		
		int i=1;
		int left=-1, right=-1;
		while(true) {
			int j=i*2;
			int k=j*2;
			if(array[j]>array[i]&&array[j]>array[k]) {
				left=i;
				right=k;
				break;
			}else {
				i=j;
				
			}
			
		}
		i=left;
		int j=right;
		while(i<=j) {
			int m=(i+j)/2;
			if(i==j) {
				pos=i;
				break;
			}
			if(i==j-1) {
				pos= array[i]>array[j]?i:j;
				break;
			}
			if(array[m-1]<=array[m]&&array[m]>=array[m+1]) {
				pos=m;
				break;
			}else if(array[m-1]>=array[m]&&array[m]>=array[m+1]) {
				j=m-1;
			}else if(array[m-1]<=array[m]&&array[m]<=array[m+1]) {
				i=m+1;
			}	
		}
		System.out.println(pos);
		
		
	}
	
	private int findPivot(int array[],int left, int right) {
		if(left==right) return left;
		if(left==right-1) return array[left]>array[right]?left:right;
		
		int middle=(left+right)/2;
		if(array[left]>array[middle]) {
			return findPivot(array,left,middle);
		}else {
			return findPivot(array,middle,right);
		}
		
	}
	
	public void question40_findRevert() {
		int[] array=new int[]{15,16,19,20,1,2,3,4,5,7,10,14};
		int pos=findPivot(array,0,array.length-1);
		
		int K=5;
		SearchInBinArray sib=new SearchInBinArray();
		if(array[pos]==K) {
			System.out.println(pos);
		}else{
			int pos1=sib.search(array, 0,pos-1,K);
			if(pos1>-1) {
				System.out.println(pos1);
			}else {
				int pos2=sib.search(array, pos+1,array.length-1,K);
				if(pos2>-1) {
					System.out.println(pos2);

				}
			}

		}
		
	}
	
	private int findRevert(int[] array, int left, int right, int data) {
		if(left>right) return -1;
		int middle=(left+right)/2;
		if(array[middle]==data)return middle;
		if(array[middle]>array[left]) {
			if(data<array[middle]&&data>=array[left]) {
				return findRevert(array,left,middle-1,data);
			}else {
				return findRevert(array,middle+1, right,data);
			}
		}else {
			if(data>array[middle]&&data<=array[right]) {
				return findRevert(array,middle+1, right,data);
			}else {
				return findRevert(array,left,middle-1,data);
			}
		}
		
		
	}
	
	
	public void question41_findRevert() {
		int[] array=new int[]{15,16,19,20,1,3,4,5,7,10,14};
		int left=0, right=array.length-1;
		int K=5;
		
		int pos=findRevert(array,left,right,K);
		System.out.println(pos);
		
	}
	
	public void question44_findMiddle() {
		int[] array=generateArray();
		MergeSorted ms=new MergeSorted();
		ms.mergeSorted(array, 0, array.length-1);
		int pos=(array.length-1)/2;
		System.out.println("Middle data is:"+array[pos]);
		
		
	}
	
	private int findFirstReapte(int[] array, int left, int right,int data) {
		int middle=(left+right)/2;
		if(middle==left&&array[middle]==data||array[middle]==data&&array[middle]<data) {
			return middle;
		}else if(array[middle]>data) {
			return findFirstReapte(array,left,middle-1,data);
		}else {
			return findFirstReapte(array,middle+1,right,data);
		}
	}
	
	private int findMiddle(int[] array1,int array1Left, int array1Right, int[]array2, int array2left,int array2Right) {
		if(array1Left>array1Right)return -1;
		if(array2left>array2Right) return -1;
		
		int array1Mid=(array1Left+array1Right)/2;
		int array2Mid=(array2left+array2Right)/2;
		if(array1[array1Mid]==array2[array2Mid]) {
			return array1[array1Mid];
		}else if(array1[array1Mid]<array2[array2Mid]) {
			return findMiddle(array1,array1Mid+1,array1Right, array2,array2left,array2Mid-1 );
		}else {
			return findMiddle(array1,array1Left,array1Mid-1,array2,array2Mid+1,array2Right);
		}
		
		
	}
	
	
	public void question45_findMiddle() {
		int[] array1=generateArray();
		int[] array2=generateArray();
		MergeSorted ms=new MergeSorted();
		ms.mergeSorted(array1, 0, array1.length-1);
		ms.mergeSorted(array2, 0, array2.length-1);
		
		System.out.println(Arrays.toString(array1));
		System.out.println(Arrays.toString(array2));
		
		int value=findMiddle(array1,0,array1.length-1,array2,0,array2.length);

		System.out.println("Middle data is: "+value);
		
	}
	
	
	
	public void question46_findFirstRepeate() {
		int[] array=generateArray();
		MergeSorted ms=new MergeSorted();
		ms.mergeSorted(array, 0, array.length-1);
		SearchInBinArray sib=new SearchInBinArray();
		int K=30;
		while(sib.search(array, 0, array.length-1, K)<0) {
			array=generateArray();
			ms.mergeSorted(array, 0, array.length-1);
		}
		System.out.print(Arrays.toString(array));
		
		
		int pos=findFirstReapte(array,0,array.length-1,K);
		
		System.out.println(pos);
		
	}
	private int findLastReapte(int[] array, int left, int right,int data) {
		int middle=(left+right)/2;
		if(middle==right&&array[middle]==data||array[middle]==data&&array[middle+1]>data) {
			return middle;
		}else if(array[middle]>data) {
			return findFirstReapte(array,left,middle-1,data);
		}else {
			return findFirstReapte(array,middle+1,right,data);
		}
	}
	
	public void question47_findLastRepeate() {
		int[] array=generateArray();
		MergeSorted ms=new MergeSorted();
		ms.mergeSorted(array, 0, array.length-1);
		SearchInBinArray sib=new SearchInBinArray();
		int K=30;
		while(sib.search(array, 0, array.length-1, K)<0) {
			array=generateArray();
			ms.mergeSorted(array, 0, array.length-1);
		}
		System.out.print(Arrays.toString(array));
		int pos=findLastReapte(array,0,array.length-1,K);
		
		System.out.println(pos);
		
	}
	
	public void question48_findMaxRepeate() {
		int[] array=generateArray();
		MergeSorted ms=new MergeSorted();
		ms.mergeSorted(array, 0, array.length-1);
		SearchInBinArray sib=new SearchInBinArray();
		int K=30;
		while(sib.search(array, 0, array.length-1, K)<0) {
			array=generateArray();
			ms.mergeSorted(array, 0, array.length-1);
		}
		System.out.print(Arrays.toString(array));
		int count=0;
		for(int i=0;i<array.length;i++) {
			if(array[i]==K) {
				count++;
			}
		}
		System.out.println(count);	
	}
	
	
	public void question49_findMaxRepeate() {
		int[] array=generateArray();
		MergeSorted ms=new MergeSorted();
		ms.mergeSorted(array, 0, array.length-1);
		SearchInBinArray sib=new SearchInBinArray();
		int K=30;
		while(sib.search(array, 0, array.length-1, K)<0) {
			array=generateArray();
			ms.mergeSorted(array, 0, array.length-1);
		}
		System.out.print(Arrays.toString(array));
		
		//int pos=sib.search(array, 0, array.length-1, K);
		int first=findFirstReapte(array, 0, array.length-1, K);
		int last=findLastReapte(array, 0, array.length-1, K);
		int count=last-first+1;;
		System.out.println(count);	

		
		
	}
	
	public void question52_findSecondMin() {
		int[] array=generateArray();

		Heap heap=new Heap(array.length,1);
		for(int i=0;i<array.length;i++) {
			heap.insert(array[i]);
		}
		int value=heap.deleteMin();
		value=heap.deleteMin();
		System.out.print(value);
		
		
	}
	
	public void question53_findSecondMin() {
		int[] array=generateArray();
		int min=Integer.MAX_VALUE;
		int sec=Integer.MAX_VALUE;
		for(int i=0; i<array.length;i++) {
			if(min>array[i]) {
				sec=min;
				min=array[i];
			}
			
		}
		System.out.print(sec);
	}
	
	public void question54_findMainEle() {
		int[] array=new int[] {2,3,2,4,3,4,2,2,2};
		int len=array.length;
		
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		boolean isFind=false;
		for(int i=0;i<array.length;i++) {
			if(map.get(array[i])==null) {
				map.put(array[i],1);
			}else {
				map.put(array[i],1+map.get(array[i]));
				if(map.get(array[i])>len/2) {
					isFind=true;
					System.out.print("Main element is: "+array[i]);
					break;
				}
			}
		}
		if(!isFind) {
			System.out.print("No main element");
		}
	}
	
	public void question55_findMainEle() {
		int[] array=new int[] {2,3,2,4,3,4,2,2,2};
		int len=array.length;
		
		MergeSorted ms=new MergeSorted();
		ms.mergeSorted(array, 0, array.length-1);
		boolean isFind=false;
		for(int i=0;i<len/2;i++) {
			if(array[i]==array[i+len/2]) {
				isFind=true;
				System.out.print("Main element is: "+array[i]);
				break;
			}
		}
		if(!isFind) {
			System.out.print("No main element");
		}
		
		
	}
	
	public void question58_findMainEle() {
		int[] array=new int[] {2,2,2,4,3,2,2,2,2};
		int len=array.length;
		int count=0;
		int value=-1;
		for(int i=0;i<len-1;i++) {
			if(count==0) {
				value=array[i];
			}else if(value==array[i]) {
				count++;
			}else {
				count--;
			}
		}
		System.out.print("Main element is: "+value);
//		for(int i=0;i<len-1;) {
//			if(array[i]!=array[i+1]) {
//				array[i]=0;
//				array[i+1]=0;
//				i+=2;
//			}else {
//				array[i]=0;
//				i++;
//			}
//		}
//		for(int i=0;i<len;i++) {
//			if(array[i]!=0) {
//				System.out.print("Main element is: "+array[i]);
//			}
//		}
	}
	
	
	public void question59_findNRepeate() {
		int[] array=new int[] {2,2,2,4,3,2,2,2,2};
		for(int i=0;i<array.length-2;i++) {
			if(array[i]==array[i+1]||array[i]==array[i+2]) {
				System.out.print("Main element is: "+array[i]);
				break;
			}
		}	
		
	}
	
	
	public void question60_findSingleEle() {
		int[] array=new int[] {2,2,4,4,3,2,2,3,6};
		int value=0;
		for(int i=0;i<array.length;i++) {
			value^=array[i];
		}
		System.out.print(value);
	}
	
	
	public void question61_FindNInBroken() {
		int len=40;
		boolean[] array=new boolean[len];
		int broken=(int)(Math.random()*40);
		int i=0;
		for(;i<broken;i++) {
			array[i]=false;
		}
		for(i=broken;i<len;i++) {
			array[i]=true;
		}
		System.out.println("pos"+broken);
		
		int j=1;
		for(i=1;i<len;) {
			j=i*2;
			if(j<len&&array[i]!=array[j]) {
				break;
			}
			i=i*2;
		}
		int middle=1;
		while(i<j) {
			middle=(i+j)/2;
			if(!array[middle]&&array[middle+1]) {
				break;
			}
			if(!array[middle]) {
				i=middle;
			}else {
				j=middle;
			}
		}
		System.out.print("pos"+middle);
		
		
	}
	private int findLocalMin(int[]array, int left, int right) {
		if(array[left]<array[left+1])return left;
		if(array[right]<array[right-1])return right;
		int middle=(left+right)/2;
		if(array[middle]<array[middle-1]&&array[middle]<array[middle+1]) {
			return middle;
		}
		if(array[middle-1]<array[middle]) {
			return findLocalMin(array,left,middle);
		}
		if(array[middle+1]>array[middle]) {
			return findLocalMin(array,middle,right);
		}
		return -1;
		
		
	}
	
	private int[][] generateTwoDArray(int length){
		int[][] array=new int[length][length];
		int value=(int)(Math.random()*30);
		int data=0;
		for(int i=0;i<length;i++) {
			array[i][0]=value;
			for(int j=1;j<length;j++) {
				int delta=(int)(Math.random()*5);
				data=value+delta;
				array[i][j]=data;
				value=data;
			}
			int delta2=(int)(Math.random()*5);
			data=array[i][0]+delta2;
			value=data;
		}
		return array;
		
		
	}
	
	public void question63_FindItem() {
		int[][] array=generateTwoDArray(20);
		for(int i=0;i<array.length;i++) {
			System.out.println(Arrays.toString(array[i]));
		}
		int i=array.length-1,j=0;
		int K=70;
		int row=-1,col=-1;
		while(i>=0&&j<array.length) {
			if(array[i][j]<K) {
				j++;
			}else if(array[i][j]>K) {
				i--;
			}else {
				row=i;
				col=j;
				break;
			}
		}
		System.out.print("row:"+row+" col:"+col);
		
	}
	
	public void question62_findLocalMin() {
		int[] array=generateArray();
		
		int pos=findLocalMin(array,0,array.length-1);
		System.out.print(pos);
		
	}
	
	private int[][] generateTwoArray(int len){
		int[][] array=new int[len][len];
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				int value=(int)(Math.random()*50);
				array[i][j]=value;
				
			}
		}
		return array;
		
	}
	
	
	
	public void question64_findLocalMinInArrayTD() {
		int[][] array=generateTwoArray(20);
		for(int i=0;i<array.length;i++) {
			System.out.println(Arrays.toString(array[i]));
		}
		
		
		
	}
	
	
	public void question65_findMostZero() {
		int[][] array=new int[][] {
			{1,1,1,1,1,0,0,0,0,0},
			{1,1,1,1,1,1,1,0,0,0},
			{1,1,1,1,1,0,0,0,0,0},
			{1,1,1,1,1,1,1,0,0,0},
			{1,1,1,0,0,0,0,0,0,0},
			{1,1,1,1,1,1,1,0,0,0},
			{1,1,1,1,1,0,0,0,0,0},
			{1,1,1,1,1,1,0,0,0,0},
			{1,1,0,0,0,0,0,0,0,0},
			{1,1,1,1,1,1,1,0,0,0}
		};
		int maxZeroCount=0;
		int j=Integer.MAX_VALUE;
		for(int i=0;i<array.length;i++) {
				j=array.length-1-maxZeroCount;
				for(;j>=0;j--) {
					if(array[i][j]==0) {
						maxZeroCount++;
					}else {
						break;
					}
				}
		}
		System.out.print(maxZeroCount);
	}
	
	public void question67_splitOddAndEven() {
		int[] array=generateArray();
		
		int i=0,j=array.length-1;
		while(i<j) {
			while(i<j&&array[i]%2==0) {
				i++;
			}
			while(i<j&&array[j]%2==1) {
				j--;
			}
			int tem=array[i];
			array[i]=array[j];
			array[j]=tem;
			
		}
		System.out.print(Arrays.toString(array));
		
	}
	public void question68_splitZeroToOne() {
		int[] array=new int[] {0,1,0,1,0,0,1,1,1,0};
		int zeroCount=0;
		for(int i=0;i<array.length;i++) {
			if(array[i]==0) {
				zeroCount++;
			}
		}
		for(int i=0;i<zeroCount;i++) {
			array[i]=0;
		}
		for(int i=zeroCount;i<array.length;i++) {
			array[i]=1;
		}
		System.out.print(Arrays.toString(array));
	}
	
	
	public void question70_splitWithZeroOneTwo() {
		int[]  array=new int[] {0,1,2,1,0,1,2,1,2,0,0,0,1};
		
		int i=0,j=array.length-1;
		while(i<j) {
			while(i<j&&array[i]!=2) {
				i++;
			}
			while(i<j&&array[j]==2) {
				j--;
			}
			int tem=array[i];
			array[i]=array[j];
			array[j]=tem;
			i++;
			j--;
		}
		i=0;
		while(i<j) {
			while(i<j&&array[i]!=1) {
				i++;
			}
			while(i<j&&array[j]==1) {
				j--;
			}
			int tem=array[i];
			array[i]=array[j];
			array[j]=tem;
			i++;
			j--;
		}		
		System.out.print(Arrays.toString(array));
		
	}
	
	
	public void question71_findMaxDis() {
		int[] array=generateArray();
		
		int min=array[0]>array[1]?array[1]:array[0];
		int value=Integer.MIN_VALUE;
		for(int i=2;i<array.length;i++) {
			if(array[i]-min>value) {
				value=array[i]-min;
			}
			if(array[i]<min) {
				min=array[i];
			}
		}
		System.out.print(value);
	}
	
	public void question73_findZeroNumByMul() {
		int K=200;
		int number=0;
		while(K>0) {
			number+=K/5;
			K=K/5;
		}
		
		System.out.print(number);
	}
	
	public void question75_reorderforOddEven() {
		
		int[] array=generateArray();//new int[] {1,3,5,7,2,4,6,8};
		int Mid=array.length/2;
		for(int i=0;i<array.length;i+=2,Mid++) {
			for(int j=Mid;j>i+1;j--) {
				int tem=array[j];
				array[j]=array[j-1];
				array[j-1]=tem;
			}
		}
		System.out.print(Arrays.toString(array));
	}
	
	
	
	public void question76_FindMaxDis() {
		int[] array=generateArray();
		
		int dis=-1;
		for(int i=0;i<array.length;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[j]>array[i]&&(j-i)>dis) {
					dis=j-i;
				}
			}
		}
		System.out.print(dis);

		
	}
	public void question77_FindMaxDis() {
		int[] array=generateArray();
		
		int[] leftMin=new int[array.length];
		int[] rightMax=new int[array.length];
		leftMin[0]=array[0];
		for(int i=1;i<array.length;i++) {
			leftMin[i]=Math.min(leftMin[0], array[i]);
		}
		rightMax[array.length-1]=array[array.length-1];
		for(int i=array.length-2;i>=0;i--) {
			rightMax[i]=Math.max(rightMax[i+1], array[i]);
		}
		int i=0,j=0,maxDis=-1;
		while(i<array.length&&j<array.length) {
			if(leftMin[i]<rightMax[j]) {
				maxDis=Math.max(maxDis, j-i);
				j++;
			}else {
				i++;
			}
		}
		System.out.print(maxDis);
		
	}
	
	
	public void question78_findIsOrder() {
		int[] array=generateArray();
				//new int []{12,13,34,45,35,67,12,34};
		boolean isOrder=true;
		
		for(int i=0;i<array.length-1;i+=2) {
			if(array[i]>array[i+1]) {
				isOrder=false;
				break;
			}
		}
		
		System.out.print(isOrder);

		
		
	}
	
	public static void main(String[] args) {
		Exam1 ex=new Exam1();
		ex.question45_findMiddle();
		
	}

}

