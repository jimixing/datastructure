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
	
	

	public static void main(String[] args) {

		String str1="abcbdab",str2="bdcaba";
		
		LCS lcs=new LCS();
		int res=lcs.LCS_01(str1.toCharArray(),0, str1.length()-1, str2.toCharArray(),0,str2.length()-1);
		System.out.print(res);
		
		

	}

}
