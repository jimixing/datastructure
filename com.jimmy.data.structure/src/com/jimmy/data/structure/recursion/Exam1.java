package com.jimmy.data.structure.recursion;

public class Exam1 {

	private void hannota(int n, char from , char to , char aux) {
		if(n==1) {
			System.out.println("move from "+from +" to "+to);
			return;
		}
		hannota(n-1,from , aux, to);
		System.out.println("move from "+ from +" to "+ to+",");
		hannota(n-1, aux,to,from);
		
	}
	
	
	public void question1_hannota() {
		int n=3;
		char s='a', t='c', au='b';
		hannota(n, s,t,au);
		
	}
	
	
	public void question2_isArraySort() {
		int[] array={1,2,5,4,5,6};
		boolean res=isArraySort(array, array.length-1);
		System.out.print(res);
	}
	
	public boolean isArraySort(int [] array, int index) {
		if(index==1) {
			return array[index]>array[index-1];
		}
		return array[index]>array[index-1]? isArraySort(array,index-1):false;
	}
	
	public void question3_generateBinString() {
		int len=6;
		generateBinString("",len);
		
		
	}
	
	private void generateBinString(String prefx,int n) {
		if(n==1) {
			System.out.println(prefx+"0");
			System.out.println(prefx+"1");
			return ;
		}
		generateBinString(prefx+"0", n-1);
		generateBinString(prefx+"1", n-1);

		
	}
	
	
	public static void main(String[] args) {
		Exam1 ex=new Exam1();
		
		ex.question3_generateBinString();

	}

}
