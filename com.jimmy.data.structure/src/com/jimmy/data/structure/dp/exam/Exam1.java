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
			if(array[i]+M[i-1]>=0) {
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
	
	private int[][] generateTwoArray(int m, int n){
		int[][] array=new int[m][n];
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				array[i][j]=(int)(Math.random()*50);
			}
		}
		
		for(int i=0;i<m;i++) {
			System.out.println(Arrays.toString(array[i]));
		}
		return array;
	}
	
	
	
	public void question40_shortestPath() {
		int m=10,n=12;
		int[][] array=generateTwoArray(m,n);
		int[][] dp=new int[m][n];
		dp[0][0]=array[0][0];
		
		for(int i=1;i<m;i++) {
			dp[i][0]=array[i][0];
		}
		for(int j=1;j<n;j++) {
			dp[0][j]=array[0][j];
		}
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				dp[i][j]=Math.min(dp[i-1][j], dp[i][j-1])+array[i][j];
			}
		}
		System.out.println(dp[m-1][n-1]);
		
		for(int i=0;i<m;i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		
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
	
	
	public void question44_findchange() {
		int[] coinKind= {1,2,5,10,20};
		int change =54;
		
		int[] f=new int[change+1];
		f[0]=0;
		f[1]=1;
		f[2]=1;
		f[3]=f[2]+1;
		f[4]=Math.min(f[3]+1, f[4-2]+1);
		for(int i=4;i<=change;i++) {
			int min=f[i-1]+1;
			for(int j=0;j<coinKind.length;j++) {
				if(i<coinKind[j]) {
					continue;				
				}else {
					if(f[i-coinKind[j]]<min) {
						min=f[i-coinKind[j]];
					}
				}
			}
			f[i]=min+1;

		}
		
		System.out.println(f[change]);	
	}
	
	public void question45_maxLenString() {
		String str1="acbbsdef";
		String str2="acbesdsd";
		char[] ch1=str1.toCharArray();
		char[] ch2=str2.toCharArray();
		int[][] dp=new int[ch1.length][ch2.length];
		for(int i=0;i<ch2.length;i++) {
			if(ch1[0]==ch2[i]) {
				dp[0][i]=1;
			}
		}
		for(int j=0;j<ch1.length;j++) {
			if(ch2[0]==ch1[j]) {
				dp[j][0]=1;
			}
		}
		
		int max=0,ch1end=0;
		for(int i=1;i<ch1.length;i++) {
			for(int j=1;j<ch2.length;j++) {
				if(ch1[i]==ch2[j]) {
					dp[i][j]=dp[i-1][j-1]+1;
					if(dp[i][j]>max) {
						max=dp[i][j];
						ch1end=i;
					}
				}
				
			}
		}
		System.out.println(max);
		System.out.println(str1.substring(ch1end-max+1,ch1end+1));
		
	}
	
	public void question46_minCostStringEdit() {
		String str1="adcmn";
		String str2="abcn";
		int add=5,del=3, mod=5+3;
		int[][] dp=new int[str1.length()+1][str2.length()+1];
		dp[0][0]=0;
		for(int i=1;i<=str2.length();i++) {
			dp[0][i]=add*i;
		}
		for(int i=1;i<=str1.length();i++) {
			dp[i][0]=del*i;
		}
		for(int i=1;i<=str1.length();i++) {
			for(int j=1;j<=str2.length();j++) {
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					int tem=dp[i][j-1]+add>dp[i-1][j]+del?dp[i-1][j]+del:dp[i][j-1]+add;
					dp[i][j]=tem>dp[i-1][j-1]?dp[i-1][j-1]:tem;
				}else {
					int tem=dp[i][j-1]+add>dp[i-1][j]+del?dp[i-1][j]+del:dp[i][j-1]+add;
					dp[i][j]=tem>dp[i-1][j-1]+mod?dp[i-1][j-1]+mod:tem;
				}
			}
			
		}
		System.out.print(dp[str1.length()][str2.length()]);
		
	}
	
	
	public void question47_maxUpSubValue() {
		
		int[] array = new int[]{1, 4, 2, 5, 3};
		int[] dp=new int[array.length];
		dp[0]=1;
		
		for(int i=1;i<array.length;i++) {
			int max=0;
			for(int j=0;j<i;j++) {
				if(array[j]<array[i]) {
					max=Math.max(dp[j],max);
				}
			}
			dp[i]=max+1;
		}
		int max=0;
		for(int i=0;i<dp.length;i++) {
			if(max<dp[i]) {
				max=dp[i];
			}
			
		}
		
		System.out.print(max);
		
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam1 ex=new Exam1();
		ex.question47_maxUpSubValue();
	}

}
