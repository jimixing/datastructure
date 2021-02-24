package com.jimmy.data.structure.string.exam;

import java.util.HashMap;
import java.util.Random;

import com.jimmy.data.structure.heap.Heap;
import com.jimmy.data.structure.stack.ArrayStack;
import com.jimmy.data.structure.string.SuffexTree;
import com.jimmy.data.structure.string.TripleSearchNode;

public class Exam1 {
	
	public void isHuiWen() {
		String str="abaabXbaaba";
		int i=0,j=str.length()-1;
		boolean isHuiWen=true;
		while(i!=j&&str.charAt(i)!='X'&&str.charAt(j)!='X') {
			if(str.charAt(i)!=str.charAt(j)) {
				isHuiWen=false;
				break;
			}
			i++;
			j--;
		}
		System.out.print(isHuiWen);
		
		
	}
	public static String ALPHABET="abcdefghijklmnopqrstuvwxyz";

	private String generateStr(int length) {
		Random random=new Random();
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<length;i++) {
			int num=random.nextInt(ALPHABET.length());
			sb.append(ALPHABET.charAt(num));
		}
		return sb.toString();	
	}
	
	public void question1_maxTimesStr() {
		
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		HeapString heap=new HeapString(10,1);
		
		for(int i=0;i<100000;i++) {
			String str=generateStr(3);
			if(map.get(str)==null) {
				map.put(str, 1);
				if(i<10) {
					heap.insert(1,str);
				}
			}else {
				int count=map.get(str)+1; 
				map.put(str, count);
				if(count>heap.getMin()) {
					heap.deleteMin();
					heap.insert(count,str);
				}
				
			}	
		}
		for(int i=0;i<10;i++) {
			HeapString.HeapMapping hm=heap.deleteMin();
			System.out.println("String is "+hm.getValue2()+", and time is "+hm.getValue());
			
		}	
	}
	
	public void question2_maxLenOfStr() {
		String str="abdbdbdbdbafjdsfdsfadsffdfasdfwfwf";
		String str2="afjdsfffdsfttt";
		
		SuffexTree st=new SuffexTree();
		TripleSearchNode root =st.insert(str);
		boolean res=false;
		for(int i=0;i<str2.length();i++) {
			res= st.search(root, str2.substring(i), 0);
			if(res) {
				System.out.print("max length of string: "+str2.substring(i));
				break;
			}
		}
		if(!res) {
			for(int i=str2.length()-1;i>=0;i--) {
				res= st.search(root, str2.substring(0,i), 0);
				if(res) {
					System.out.print("max length of string: "+str2.substring(0,i));
					break;
				}
			}
		}
	}
	
	public void question3_maxLenHuiwen() {
		String str="abdbdbdyyyyyybdbafjdsfdsfadsffdfasdfwfwf";//"aabxbaaaa";
		SuffexTree st=new SuffexTree();
		TripleSearchNode root =st.insert(str);
		String newStr=reverse(str);
		SuffexTree st2=new SuffexTree();
		TripleSearchNode root2=st2.insert(newStr);
		String str1=null,str2=null;
		for(int i=0;i<str.length();i++) {
			boolean res=st.search(root, str.substring(i), 0);
			boolean res2=st2.search(root2, str.substring(i), 0);
			if(res&&res2) {
				str1=str.substring(i,str.length());
				break;

			}
		}
		for(int i=0;i<newStr.length();i++) {
			boolean res=st.search(root, newStr.substring(i), 0);
			boolean res2=st2.search(root2, newStr.substring(i), 0);
			if(res&&res2) {
				str2=newStr.substring(i,newStr.length());
				break;

			}
		}
		String str3=str1.length()>str2.length()?str1:str2;
		System.out.print("max length of huiwen: "+str3);
		
		
	}
	
	private String reverse(String str) {
		char[] ch=str.toCharArray();
		for(int i=0;i<ch.length/2;i++) {
			char tem=ch[i];
			ch[i]=ch[ch.length-1-i];
			ch[ch.length-1-i]=tem;
		}
		
		String newStr=new String(ch);
		return newStr;
		
	}
	
	public void question4_reverse() {
		String str="afdsfasdfsadf";
		String newStr=reverse(str);
		System.out.print(newStr);
		
		
	}
	
	private String reverse2(String str) {
		int i,len=str.length();
		StringBuffer sb=new StringBuffer();
		for(i=len-1;i>=0;i--) {
			sb.append(str.charAt(i));
		}
		return sb.toString();
		
	}
	
	public void question5_reverse() {
		String str="afdsfasdfsadf";
		String newStr=reverse2(str);
		System.out.print(newStr);

	}
	
	public void question6_reserse() {
		String str="afdsfasdfsadf";
		char[] ch=str.toCharArray();
		int start=0, end=str.length()-1;
		while(start<end) {
			ch[start]=(char)(ch[start]^ch[end]);
			ch[end]=(char)(ch[start]^ch[end]);
			ch[start]=(char)(ch[start]^ch[end]);
			start++;
			end--;
		}
		System.out.print(ch);
	}
	
	public void question8_reverseSentence() {
		String str="This is a career monk string";
		String[] split=str.split("\\s");
		int i=0,j=split.length-1;
		while(i<j) {
			String tem=split[i];
			split[i]=split[j];
			split[j]=tem;
			i++;
			j--;
		}
		System.out.print(String.join(" ", split));	
	}
	
	
	private void Premutatian(String prefix,String str) {
		if(str.length()==0) {
			System.out.println(prefix);
			
		}else {
			for(int i=0;i<str.length();i++) {
				Premutatian(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1));
			}
		}
		
		
	}
	
	public void question9_allPremutatian() {
		
		String str="abc";
		Premutatian("",str);
		
		
	}
	
	private void combination(String prefix,String str) {
		System.out.println(prefix);
		for(int i=0;i<str.length();i++) {
			combination(prefix+str.charAt(i),str.substring(i+1));
		}
		
		
	}
	
	public void question10_combination() {
		String str="abc";
		combination("",str);
		
		
	}
	
	
	public void question11_deleteRepeat() {
		String str="abccccbccba";
		char[] ch=str.toCharArray();
		int j=0;
		for(int i=1;i<ch.length;i++) {
			while(ch[i]==ch[j]&&j>=0) {
				j--;
				i++;
			}
			ch[++j]=ch[i];	
		}
		for(++j;j<ch.length;j++) {
			ch[j]='\0';
		}
		String newStr=new String(ch);
		System.out.print(newStr);
		
		
	}
	
	public void question11_deleteRepeat2() {
		String str="abcccbcba";
		char[] ch=str.toCharArray();
		int j=0;
		
		for(int i=1;i<ch.length;) {
			boolean isfound=false;
			while(j>=0&&ch[i]==ch[j]&&ch[i]!='\0') {
				isfound=true;
				i++;
			}
			if(isfound) {
				int repeateTime=i-j;
				int k=j;
				for(;k<ch.length-repeateTime;k++) {
					ch[k]=ch[k+repeateTime];
				}
				for(;k<ch.length;k++) {
					ch[k]='\0';
				}
				j--;
				i=j+1;
				
			}else {
				i++;
				j++;
			}
			
			
			
		}
		String newStr=new String(ch);
		System.out.print(newStr);
		
	}
	
	
	public void question11_repeat3() {
		String str="abcccbcba";
		char[] ch=str.toCharArray();
		
		ArrayStack ar=new ArrayStack(Character.class);
		
		ar.push(ch[0]);
		char temp=ch[0];
		for(int i=1;i<ch.length;) {
			char cha=(char)ar.top();
			if(cha!=ch[i]) {
				ar.push(ch[i]);
				i++;
			}else {
				temp=cha;
				while(i<ch.length) {
					if(ch[i]==temp) {
						i++;
					}else {
						break;
					}
				}
				ar.pop();
			}
			
		}
		ar.printStack();
		
	}
	
	
	public void question12_minWindow() {
		String str="abbacbndndaa";
		char[] cha=str.toCharArray();
		String pat="cn";
		int[] ch=new int[26];
		int count=0;
		int left=0, right=0;
		int min=Integer.MAX_VALUE;
		
		int[] patch=new int[26];
		int sum=0;
		for(int m=0;m<pat.length();m++) {
			patch[pat.charAt(m)-'a']++;
			sum++;
		}
		
		for(int i=0,j=0;i<cha.length;i++) {
			int pos=cha[i]-'a';
			ch[pos]++;
			if(patch[pos]!=0&&ch[pos]<=patch[pos]) {
				count++;
			}
			
			for(;j<=i-(pat.length()-1)&&count==sum;j++) {
				int pos2=cha[j]-'a';

				if(ch[pos2]==patch[pos2]) {
					count--;
				}
				ch[pos2]--;
				
				if((i-j)<min&&(i-j)>=pat.length()-1) {
					left=j;
					right=i;
					min=i-j;
				}
				


			}	
		}
		
		System.out.print(str.substring(left, right+1));

	}
	public void question12_minWindow2() {
		String str="abbacbndndaa";
		char[] cha_src=str.toCharArray();
		String pat="cnnd";
		char[] cha_pat=pat.toCharArray();
		int[] shouldFound=new int[26];
		for(int i=0;i<cha_pat.length;i++) {
			shouldFound[cha_pat[i]-'a']++;
		}
		int[] hasFound=new int[26];
		int left=0,right=0,count=0,minWindow=Integer.MAX_VALUE;
		for(int i=0;i<cha_src.length;i++) {
			if(shouldFound[cha_src[i]-'a']==0) {
				continue;
			}
			hasFound[cha_src[i]-'a']++;
			if(shouldFound[cha_src[i]-'a']>=hasFound[cha_src[i]-'a']) {
				count++;
			}
			
			if(count==cha_pat.length) {
				right=i;
				while(hasFound[cha_src[left]-'a']==0||hasFound[cha_src[left]-'a']>shouldFound[cha_src[left]-'a']) {
					if(hasFound[cha_src[left]-'a']>shouldFound[cha_src[left]-'a']) {
						hasFound[cha_src[left]-'a']--;
					}
					left++;
				}
				if(minWindow>right-left+1) {
					minWindow=right-left+1;
				}
			}
			
			
		}
		System.out.print(str.substring(left, right));

		
		
	}

	
	
	
	private boolean findPatInTwoDemasion(char[][] ch, char[] pat, int pos,int row,int col,int M,int N) {
		
		if(pos==pat.length) {
			return true;
		}
		
		if(ch[(row-1+M)%M][col]==pat[pos]&&findPatInTwoDemasion(ch,pat,pos+1,(row-1+M)%M, col ,M,N)) {
			return true;
		}
		if(ch[(row-1+M)%M][(col+1+M)%M]==pat[pos]&&findPatInTwoDemasion(ch,pat,pos+1,(row-1+M)%M,(col+1+M)%M,M,N)) {
			return true;
		}
		if(ch[row][(col+1+M)%M]==pat[pos]&&findPatInTwoDemasion(ch,pat,pos+1,row,(col+1+M)%M,M,N)) {
			return true;
		}
		if(ch[(row+1+M)%M][(col+1+M)%M]==pat[pos]&&findPatInTwoDemasion(ch,pat,pos+1,(row+1+M)%M,(col+1+M)%M,M,N)) {
			return true;
		}
		if(ch[(row+1+M)%M][col]==pat[pos]&&findPatInTwoDemasion(ch,pat,pos+1,(row+1+M)%M,col,M,N)) {
			return true;
		}
		if(ch[(row+1+M)%M][(col-1+M)%M]==pat[pos]&&findPatInTwoDemasion(ch,pat,pos+1,(row+1+M)%M,(col-1+M)%M,M,N)) {
			return true;
		}
		if(ch[row][(col-1+M)%M]==pat[pos]&&findPatInTwoDemasion(ch,pat,pos+1,row,(col-1+M)%M,M,N)) {
			return true;
		}
		if(ch[(row-1+M)%M][(col-1+M)%M]==pat[pos]&&findPatInTwoDemasion(ch,pat,pos+1,(row-1+M)%M,(col-1+M)%M,M,N)) {
			return true;
		}
		return false;
		
		
	}
	
	public void question13_findPatInTwoDemasion() {
		char[][] ch= {
				{'a','c','p','r','c'},
				{'x','s','o','p','c'},
				{'v','o','v','n','l'},
				{'w','g','f','m','n'},
				{'q','a','t','i','t'},		
		};
		char[] pat="microsoft".toCharArray();
		int  row=-1, col=-1;
		int M=ch.length;
		int N=ch[0].length;
		for(int i=0;i<ch.length;i++) {
			for(int j=0;j<ch[i].length;j++) {
				if(ch[i][j]==pat[0]) {
					row=i;
					col=j;
					break;
				}
			}
		}
		if(row==-1) {
			System.out.print(false);
		}else {
			boolean res=findPatInTwoDemasion(ch,pat,1,row,col,M,N);
			System.out.print(res);
		}
		
		
		
		
		
	}
	
	
	public void question14_findSamePattern() {
		int Len=10;
		int[][] array=new int[Len][Len];
		for(int i=0;i<Len;i++) {
			for(int j=0;j<Len;j++) {
				array[i][j]=(int)(Math.random()*50);
			}
		}
		for(int i=0;i<Len;i++) {
			array[9][i]=array[i][9];
		}
		int row=-1;
		HashMap<Integer,Integer> maprow=new HashMap<Integer,Integer>();
		for(int i=0;i<Len;i++) {
			for(int j=0;j<Len;j++) {
				maprow.put(array[j][i], 1);
			}
			boolean rowFound=true;
			for(int j=0;j<Len;j++) {
				if(maprow.get(array[i][j])==null) {
					rowFound=false;
				}
			}
			if(rowFound) {
				row=i;
				break;
			}
			maprow.clear();
			
		}
		System.out.print("found item in "+ row);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Exam1 ex=new Exam1();
		ex.question10_combination();
	}

}
