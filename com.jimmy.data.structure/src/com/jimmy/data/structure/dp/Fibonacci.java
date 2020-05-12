package com.jimmy.data.structure.dp;

public class Fibonacci {

	
	public int Fib_1(int n) {
		if(n==1||n==0) {
			return 1;
		}
		return Fib_1(n-1)+Fib_1(n-2);
		
	}
	
	
	public void Fib_2(int n) {
		if(n==1||n==0) {
			return ;
		}
		int[] array=new int[n+1];
		array[0]=1;
		array[1]=1;

		for(int i=2;i<=n;i++) {
			array[i]=array[i-1]+array[i-2];
		}
		System.out.print(array[n]);
		
	}
	
	public void Fib_3(int n) {
		if(n==1||n==0) {
			return ;
		}
		int i=2;
		int a=1,b=1,sum=0;
		while(i<=n) {
			sum=a+b;
			a=b;
			b=sum;
			i++;
		}
		System.out.print(sum);

	}
	
	public static void main(String[] args) {

		Fibonacci fb=new Fibonacci();
		int n=10;
		//int res=fb.Fib_1(n);
		//System.out.print(res);
		//fb.Fib_2(n);
		fb.Fib_3(n);
		
	}

}
