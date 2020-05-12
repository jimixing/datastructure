package com.jimmy.data.structure.dp;

public class LCS {
	
	public int LCS_01(char[] a1, int i, int m, char[] a2, int j, int n) {
		if(i==m||j==n) return 0;
		if(a1[i]==a2[j]) {
			return LCS_01(a1,i+1,m,a2,j+1,n)+1;
		}else {
			return Math.max(LCS_01(a1,i+1,m,a2,j,n), LCS_01(a1,i,m,a2,j+1,n));
		}

	}
	
	public int LCS_02(char[] a1, int m, char[] a2, int n) {
		int[][] res=new int[m+1][n+1];
//		char[] res2=new char[n];
//		int count=0;
		for(int i=m-1;i>=0;i--) {
			for(int j=n-1;j>=0;j--) {
				res[i][j]=res[i+1][j+1];
				if(a1[i]==a2[j]) {
					res[i][j]++;
//					res2[count]=a1[i];
//					count++;
				}else {
					if(res[i][j]<res[i+1][j]) {
						res[i][j]=res[i+1][j];
//						res2[count]=a1[i+1];
//						count++;
					}else if(res[i][j]<res[i][j+1]) {
						res[i][j]=res[i][j+1];
//						res2[count]=a2[j+1];
//						count++;
					}
				}
				
			}
		}
//		System.out.print(new String(res2));

		return res[0][0];
		
		
		
		
	}

	public static void main(String[] args) {

		String str1="abcbdab",str2="bdcaba";
		
		LCS lcs=new LCS();
	//	int res=lcs.LCS_01(str1.toCharArray(),0, str1.length(), str2.toCharArray(),0,str2.length());
		int res=lcs.LCS_02(str1.toCharArray(), str1.length(), str2.toCharArray(),str2.length());
		System.out.print(res);
		
		

	}

}
