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
    //����һ��ԭ�ַ���A�����ĳ��ȣ��뷵���������ַ����������룺"dog loves pig",13�����أ�"pig loves dog"��	

	public void question1_reverseSentence() {
		String source="dog loves pig";
		source=reverseString(source);
		String[] word=source.split("\\s");
		for(int i=0;i<word.length;i++) {
			word[i]=reverseString(word[i]);
			System.out.print(word[i]+" ");
		}
		
		
	}
	//�������һ���ַ���A����A��ǰ������һ����Ų�����ȥ�γɵ��ַ�����ΪA����ת�ʡ�����A="12345",A����ת����"12345","23451","34512","45123"��"51234"�����������ַ���A��B�����ж�A��B�Ƿ�Ϊ��ת�ʡ�
	public void question2_rotate() {
		
		String source ="12345";
		
		Trie trie=new Trie();
		trie.addNode(source);
		for(int i=1;i<source.length();i++) {
			trie.addNode(source.substring(i)+source.substring(0, i));
		}
		
		
		System.out.print(trie.search("4513"));
		
	}
	
	//���������ַ���A��B�����A��B�г��ֵ��ַ�������ͬ��ÿ���ַ����ֵĴ�����ͬ����A��B��Ϊ���δʣ������һ����Ч�㷨��������������Ƿ�Ϊ���δ�
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
	//�ַ���ֻ����*�����֣����ڰ�*ȫ���ŵ�ǰ��
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
	//����һ���ַ������������������ֵĿո�ѹ����1��
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
