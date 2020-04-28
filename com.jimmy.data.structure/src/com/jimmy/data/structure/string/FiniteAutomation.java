package com.jimmy.data.structure.string;

public class FiniteAutomation {

	private int[][] fm;
	private int M;
	
	public FiniteAutomation(String find) {
		
		char[] ch=find.toCharArray();
		M=find.length();
		fm=new int[M][256];
		for(int i=0;i<M;i++) {
			for(int j=0;j<256;j++) {
				fm[i][j]=generateFinitMachine(ch, M,i,j);
			}
		}
		
	}
	
	
	public int generateFinitMachine(char[] pat, int len,int state, int input) {
		
		if(pat[state]==input) {
			return state+1;
		}
		int ns, i;
		for(ns=state;ns>0;ns--) {
			if(pat[ns-1]==input) {
				for(i=0;i<ns-1;i++) {
					if(pat[i]!=pat[state-ns+1+i]) {
						break;
					}
				}
				if(i==ns-1) {
					return ns;
				}		
			}
		}
		return 0;
	}
	
	
	public int finiteAuto(String str) {
		char[] ori=str.toCharArray();
		int len=str.length();
		int state=0;
		for(int i=0;i<len;i++) {
			 state=fm[state][ori[i]];
			 if(state==M) {
				 state=0;
				 int index=i-M+1;
				 return index;
			 }
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		String str="AABAACAADAABAAABAA";//"fsdfadsfadsfsadfsaf";
		String find="ADAA";//"fad";
		
		FiniteAutomation fa=new FiniteAutomation(find);
		int index=fa.finiteAuto(str);
		System.out.print(index);

	}

}
