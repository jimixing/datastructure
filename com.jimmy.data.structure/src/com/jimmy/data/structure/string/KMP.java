package com.jimmy.data.structure.string;

import java.util.Arrays;

public class KMP {

	
	private char[] pat;
	private int M;
	private int[] next;
	public KMP(String pat) {
		this.pat=pat.toCharArray();
		M=pat.length();
		next=generateNext();
	}
	
	
	private int[] generateNext() {
			int[] next=new int[M];
			int i=1,j=0;
			next[0]=0;
			while(i<M) {
				if(pat[i]==pat[j]) {
					next[i]=j+1;
					i++;
					j++;
				}else if(j>0){
					j=next[j-1];	
				}else {
					next[i]=0;
					i++;
				}
			}
			return next;

	}
	public int processKMP(String str) {
		char[] chstr=str.toCharArray();
		System.out.println(Arrays.toString(next));
		int i=0,j=0;
		while(i<chstr.length) {
			if(j<pat.length&&chstr[i]==pat[j]) {
				i++;
				j++;
			}else if(j>0){
				j=next[j-1];
			}else{
				i++;
			}
			if(j==pat.length) {
				return i-j;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		String str="bacbabababacaca";//"fsdfadsfadsfsadfsaf";
		String find="ababaca";
		
		KMP kmp=new KMP(find);
		int index=kmp.processKMP(str);
		System.out.print(index);

		
	}

}
