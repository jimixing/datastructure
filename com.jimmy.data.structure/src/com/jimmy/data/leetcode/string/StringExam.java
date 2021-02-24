package com.jimmy.data.leetcode.string;

import com.jimmy.data.structure.string.Trie;

public class StringExam {

	
	private String reverseString(String str) {
		char[] ch2=str.toCharArray();
		for(int i=0,j=ch2.length-1;i<j;i++,j--) {
			char tem=ch2[j];
			ch2[j]=ch2[i];
			ch2[i]=tem;
		}
		return  new String(ch2);
		
	}
    //给定一个原字符串A和他的长度，请返回逆序后的字符串。如输入："dog loves pig",13，返回："pig loves dog"。	

	public void question1_reverseSentence() {
		String source="dog loves pig";
		source=reverseString(source);
		String[] word=source.split("\\s");
		for(int i=0;i<word.length;i++) {
			word[i]=reverseString(word[i]);
			System.out.print(word[i]+" ");
		}
		
		
	}
	//如果对于一个字符串A，将A的前面任意一部分挪到后边去形成的字符串称为A的旋转词。比如A="12345",A的旋转词有"12345","23451","34512","45123"和"51234"。对于两个字符串A和B，请判断A和B是否互为旋转词。
	public void question2_rotate() {
		
		String source ="12345";
		
		Trie trie=new Trie();
		trie.addNode(source);
		for(int i=1;i<source.length();i++) {
			trie.addNode(source.substring(i)+source.substring(0, i));
		}
		
		
		System.out.print(trie.search("4513"));
		
	}
	
	//对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词
	public void question3_transformat() {
		String source="12345654321";
		String target="11342243565";
		int[] src=new int[256];
		for(int i=0;i<source.length();i++) {
			src[source.charAt(i)]++;
		}
		
		int[] tar=new int[256];
		for(int i=0;i<target.length();i++) {
			tar[target.charAt(i)]++;
		}
		boolean isTransformation=true;
		for( int i=0;i<256;i++) {
			if(src[i]!=tar[i]) {
				isTransformation=false;
				break;
			}
		}
		System.out.print(isTransformation);
	}
	//字符串只包含*和数字，现在把*全部放到前面
	public void question4_moveToFirst() {
			String str="12**3445****565*";
			char[] src=str.toCharArray();
			for(int i=0,j=0;i<src.length;i++) {
				if(src[i]=='*') {
					char tem=src[i];
					src[i]=src[j];
					src[j]=tem;
					j++;
				}
			}
			System.out.print(String.valueOf(src));
	}
	//给定一个字符串，将其中连续出现的空格压缩成1个
	public void question5_compress() {
		String str="dsfa  fasda    fadd  ad dfsa";
		char[] src=str.toCharArray();
		char[] tar=new char[src.length];
		for(int i=0, j=1,k=0;i<src.length;) {
			tar[k++]=src[i];
			if(src[i]==' ') {
				while(i+j<src.length&&src[i]==src[i+j]) {
					j++;
				}
				i=i+j;
			}else {
				i++;
			}
		}
		System.out.print(new String(tar));
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringExam se=new StringExam();
		se.question5_compress();
	}

}
