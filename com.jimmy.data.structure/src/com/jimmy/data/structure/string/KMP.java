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
			next[0]=-1;
			
			for(int i=1;i<M;i++) {
				int u=next[i-1];
				while(pat[i]!=pat[u+1]&&u>=0)u=next[u];
				if(pat[i]==pat[u+1])next[i]=u+1;
				else next[i]=-1;
				
			}
			
			return next;

	}
	public int processKMP(String str) {
		char[] chstr=str.toCharArray();
		System.out.println(Arrays.toString(next));
		int i=0,j=0;
		while(i<chstr.length) {
			if(j<M&&chstr[i]==pat[j]) {
				i++;
				j++;
			}else if(next[j]>=0){
				i+=j-next[j-1];
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
		String find="cbab";
		
		KMP kmp=new KMP(find);
		int index=kmp.processKMP(str);
		System.out.print(index);

		
	}

}
