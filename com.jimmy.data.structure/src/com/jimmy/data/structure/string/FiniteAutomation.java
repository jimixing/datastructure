package com.jimmy.data.structure.string;

import java.util.Arrays;

public class FiniteAutomation {

	private int[][] fm;
	private int M;
	private char base_char='a';
	
	public FiniteAutomation(String find) {
		
		char[] ch=find.toCharArray();
		M=find.length();
		fm=new int[M][3];
		for(int i=0;i<M;i++) {
			for(int j=0;j<3;j++) {
				fm[i][j]=generateFinitMachine(ch, M,i,j);
			}
		}
		
	}
	
	
	public int generateFinitMachine(char[] pat, int len,int state, int input) {
		
		if(pat[state]==input+base_char) {
			return state+1;
		}
		int i=0;
		for(int ns=state-1;ns>0;ns--) {
			if(pat[ns]==input+base_char) {
				for(i=0;i<ns-1;i++) {
					if(pat[i]!=pat[state-ns+1+i]) {
						break;
					}
				}
				if(i==ns-1) return ns;
			}		
		}

		return 0;
	}
	
	
	public int finiteAuto(String str) {
		char[] ori=str.toCharArray();
		int len=str.length();
		int state=0;
		System.out.print(Arrays.deepToString(fm));
		for(int i=0;i<len;i++) {
			 state=fm[state][ori[i]-base_char];
			 if(state==M) {
				 state=0;
				 int index=i-M+1;
				 return index;
			 }
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		String str="abcababacabbcac";//"fsdfadsfadsfsadfsaf";
		String find="ababaca";//"fad";
		
		FiniteAutomation fa=new FiniteAutomation(find);
		int index=fa.finiteAuto(str);
		System.out.print(index);

	}

}
