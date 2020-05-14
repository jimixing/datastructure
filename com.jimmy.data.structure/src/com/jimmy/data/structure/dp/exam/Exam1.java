package com.jimmy.data.structure.dp.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exam1 {
	
	
	private int recur(int n) {
		if(n==0||n==1) {
			return 2;
		}
		int sum=0;
		for(int i=1;i<n;i++) {
			sum+=2*recur(i)*recur(i-1);
		}
		return sum ;
	}
	
	public void question1_recur() {
		
		int n=5;
		int res=recur(n);
		System.out.print(res);
	}
	
	
	public void queistion2_recur() {
		
		int n=5;
		int[] fin=new int[n+1];
		fin[0]=2;
		fin[1]=2;
		for(int i=2;i<=n;i++) {
			int sum=0;
			for(int j=1;j<i;j++) {
				sum+=2*fin[j]*fin[j-1];
			}
			fin[i]=sum;
			
		}
		
		System.out.print(fin[n]);
	}
	
	public void question3_recur() {
		
		int n=5;
		int[] T=new int[n+1];
		T[0]=2;
		T[1]=2;
		T[2]=2*T[0]*T[1];
		for(int i=3;i<=n;i++) {
			T[i]=T[i-1]+2*T[i-1]*T[i-2];
		}
		
		System.out.print(T[n]);
	}
	
	public int[]  generateArray(boolean isNegative) {
		int len=20;
		int [] array=new int[len];
		for(int i=0;i<len;i++) {
			int data=(int)(Math.random()*50);
			if(isNegative) {
				array[i]=Math.random()>0.5?data:-data;
			}else {
				array[i]=data;
			}
			
		}
		System.out.println(Arrays.toString(array));
		return array;
	}
	
	public void question4_maxInCon() {
		int[]  array=generateArray(true);
		int maxSum=0;
		int Len=array.length;
		int start=0,end=0;
		
		for(int i=0;i<Len;i++) {
			for(int j=i+1;j<Len;j++) {
				int sum=0;
				for(int k=i;k<j;k++) {
					sum+=array[k];
				}
				if(sum>maxSum) {
					start=i;
					end=j;
					maxSum=sum;
				}		
			}	
		}
		System.out.println("start is "+start+" and end is "+end+" max consequence Sum is "+maxSum);
	}
	
	
	public void question5_maxInCon() {
		int[]  array=generateArray(true);
		int maxSum=0;
		int Len=array.length;
		int start=0,end=0;
		for(int i=0;i<Len;i++) {
			int sum=0;
			for(int j=i;j<Len;j++) {
				sum+=array[j];
				if(sum>maxSum) {
					start=i;
					end=j;
					maxSum=sum;
				}	
				
			}
		}
		System.out.println("start is "+start+" and end is "+end+" max consequence Sum is "+maxSum);

	}
	
	
	
	public void question6_maxInCon() {
		int[]  array=generateArray(true);
		int maxSum=0;
		int Len=array.length;
		int start=0,end=0;
		int[] M=new int[Len];
		if(array[0]>0) {
			M[0]=array[0];
		}else {
			M[0]=0;
		}
		for(int i=1;i<Len;i++) {
			if(array[i]>=0) {
				M[i]=M[i-1]+array[i];
			}else {
				M[i]=0;
			}
		}
		for(int i=0;i<Len;i++) {
			if(M[i]>maxSum) {
				maxSum=M[i];
			}		
		}
		System.out.println("max consequence Sum is "+maxSum);

		
	}
	
	
	public void question7_maxInCon() {
		int[]  array=generateArray(true);
		int maxSum=0;
		int Len=array.length;
		int start=0,end=0;
		int sum=0;
		for(int i=0;i<Len;i++) {
			sum+=array[i];
			if(sum<0) {
				sum=0;
				start=i;
				continue;
			}
			if(sum>maxSum) {
				end=i;
				maxSum=sum;
			}
		}
		System.out.println("start is "+start+" and end is "+end+" max consequence Sum is "+maxSum);
		
	}
	
	
	public void question8_maxInCon() {
		
		int[]  array=generateArray(true);
		int maxSum=0;
		int Len=array.length;
		int start=0,end=0;
		int[] M=new int[Len];
		if(array[Len-1]>0) {
			M[Len-1]=array[Len-1];
		}else {
			M[Len-1]=0;
		}
		for(int i=Len-2;i>=0;i--) {
			if(array[i]>=0) {
				M[i]=M[i+1]+array[i];
			}else {
				M[i]=0;
			}
			
		}
		for(int i=0;i<Len;i++) {
			if(M[i]>maxSum) {
				maxSum=M[i];
			}		
		}
		System.out.println("max consequence Sum is "+maxSum);
	}
	
	public void question9_MaxInUnCon() {
		int[]  array=generateArray(true);
		int maxSum=0;
		int Len=array.length;

		int[] M=new int[Len];
		
		M[0]=array[0];
		M[1]=M[0]>array[1]?M[0]:array[1];
		for(int i=2;i<Len;i++) {
			M[i]=Math.max(M[i-1], array[i]+M[i-2]);

		}
		maxSum=M[Len-1]>M[Len-2]?M[Len-1]:M[Len-2];
		System.out.println("max consequence Sum is "+maxSum);
		
		
		
		
	}
	
	private int catalan(int n) {
		if(n==0) return 1;
		int count=0;
		for(int i=1;i<n;i++) {
			count+=catalan(i-1)*catalan(n-i);
		}
		return count;
		
	}
	
	
	public void question13_catalan() {
		int n=10;
		int res=catalan(n);
		System.out.println(res);
		
	}
	
	public void question42_leastCount() {
		int n=20;
		int[] dp=new int[n+1];
		Map<Integer,ArrayList<Integer>> res=new HashMap<Integer, ArrayList<Integer>>();
		dp[0]=0;
		for(int i=1;i<=n;i++) {
			dp[i]=i;
			
			ArrayList<Integer> tem=new ArrayList<Integer>();
			for(int j=1;i-j*j>=0;j++) {
				dp[i]=Math.min(dp[i],dp[i-j*j]+1);
				tem.add(dp[i]);
			}
			res.put(i, tem);
			
		}
		System.out.print("least sqrt is:"+dp[n]+"and index is "+Arrays.toString(res.get(n).toArray()));
		
		
	}
	
	

	
	public void question43_minJump() {
		int len=20;
		int [] array=new int[len];
		for(int i=0;i<len;i++) {
			int data=(int)(Math.random()*4)+1;
			array[i]=data;
		}
		System.out.println(Arrays.toString(array));

		int count=0;
		for(int i=0;i<len;) {
			int pos=array[i];
			int maxBe=0;
			for(int j=1;j<=pos;j++) {
				if(i+j<len&&maxBe<array[j+i]) {
					maxBe=array[j+i];
				}
			}
			i=i+maxBe;
			count++;
			if(i>=len) {
				break;
			}
			
		}
		System.out.println("max hop is "+ count);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam1 ex=new Exam1();
		ex.question42_leastCount();
	}

}
