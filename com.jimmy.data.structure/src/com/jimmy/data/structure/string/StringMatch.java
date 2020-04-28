package com.jimmy.data.structure.string;

import java.util.Arrays;

public class StringMatch{
	
	public void forceMatch() {
		String str="fsdfadsfadsfsadfsaf";
		String find="fad";
		char[] ch=str.toCharArray();
		char[] re=find.toCharArray();
		boolean isFind=false;
		for(int i=0;i<ch.length-re.length;i++) {
			int count=0;
			for(int j=0;j<re.length;j++) {
				if(ch[i+count]==re[j]) {
					count++;
				}
			}
			if(count==re.length) {
				isFind=true;
				break;
			}
			
		}
		System.out.print(isFind);
		
	}
	
	final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
	
	
	
	public void robinKarp() {
		String str="fsdfadsfadsfsadfsaf";
		String find="fad";
		
		int pat=hash(find);
		for(int i=0;i<str.length()-find.length();i++) {
			String tem=str.substring(i, i+find.length());
			if(hash(tem)==pat) {
				System.out.print(i+",");
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
	
	
	
	public void FinitMachine() {
		String str="AABAACAADAABAAABAA";//"fsdfadsfadsfsadfsaf";
		String find="AABA";//"fad";
		char[] ch=find.toCharArray();
		int M=find.length();
		int[][] fm=new int[M][256];
		for(int i=0;i<M;i++) {
			for(int j=0;j<256;j++) {
				fm[i][j]=generateFinitMachine(ch, M,i,j);
			}
		}
		char[] ori=str.toCharArray();
		int len=str.length();
		int state=0;
		for(int i=0;i<len;i++) {
			 state=fm[state][ori[i]];
			 if(state==M) {
				 state=0;
				 int index=i-M+1;
				 System.out.print("index is "+index);
			 }
		}
	}

	public int[] generateNext(char[] pat) {
		int[] next=new int[pat.length];
		int i=1,j=0;
		next[0]=0;
		while(i<pat.length) {
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
	
	
	public void KMP() {
		String str="bacbabababacaca";//"fsdfadsfadsfsadfsaf";
		String find="ababaca";
		char[] chstr=str.toCharArray();
		char[] findstr=find.toCharArray();
		int[] next=generateNext(findstr);
		System.out.println(Arrays.toString(next));
		int i=0,j=0;
		while(i<chstr.length) {
			if(j<findstr.length&&chstr[i]==findstr[j]) {
				i++;
				j++;
			}else if(j>0){
				j=next[j-1];
			}else{
				i++;
			}
			if(j==findstr.length) {
				System.out.print("find item index is "+(i-j));
			}
		}
		
		
	}
	
	
	public static void main(java.lang.String[] args) {
			
		StringMatch sm=new StringMatch();
		sm.KMP();
		
		
	}

}
