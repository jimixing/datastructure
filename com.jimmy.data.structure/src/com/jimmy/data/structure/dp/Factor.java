package com.jimmy.data.structure.dp;

public class Factor {

	public int fac_01(int n) {
		if(n==1||n==0) return 1;
		return n*fac_01(n-1);
	}
	
	public void fac_02(int n) {
		if(n==1||n==0) return ;
		int[] array=new int[n+1];
		array[0]=1;
		
		for(int i=1;i<=n;i++) {
			array[i]=i*array[i-1];
		}
		System.out.print(array[n]);
		
	}
	
	public void fac_03(int n) {
		
		if(n==1||n==0) return ;
		
		int a=1,mul=1;
		int i=2;
		while(i<=n) {
			mul=i*a;
			i++;
		}
		System.out.print(mul);	
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factor fa=new Factor();
		int n=10;
//		int res=fa.fac_01(n);
//		System.out.print(res);
		fa.fac_02(n);

	}

}
