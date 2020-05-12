package com.jimmy.data.structure.dp.exam;

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
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam1 ex=new Exam1();
		ex.question3_recur();
	}

}
