package com.jimmy.data.structure.string;

import java.util.ArrayList;
import java.util.List;

import com.jimmy.data.structure.string.Trie.TrieNode;


public class SuffixTree{
	
	public class TrieNode{
		private char value;
		private int value_count;
		private List<Integer> line_no=new ArrayList<Integer>();
		private List<TrieNode> children=new ArrayList<TrieNode>();
		
		public TrieNode() {
			
		}
		public TrieNode(char ch) {
			this.value=ch;
		}
		
		public char getValue() {
			return value;
		}

		public List<Integer> getLine_no() {
			return line_no;
		}
		public void setLine_no(List<Integer> line_no) {
			this.line_no = line_no;
		}
		public void setValue(char value) {
			this.value = value;
		}
		public List<TrieNode> getChild() {
			return children;
		}
		public void setChild(List<TrieNode> child) {
			this.children = child;
		}
		
		public void addChild(TrieNode child) {
			children.add(child);
		}
		
		
		public int getValue_count() {
			return value_count;
		}
		public void setValue_count(int value_count) {
			this.value_count = value_count;
		}
		public int getCount() {
			return children.size();
		}
		
		
		public TrieNode getNode(char value) {
			for(TrieNode node:children ) {
				if(value==node.getValue()) {
					return node;
				}
			}
			return null;
		}
		
		public boolean isExist(char value) {
			for(TrieNode node:children ) {
				if(value==node.getValue()) {
					return true;
				}
			}
			return false;
		}
	}
	
	TrieNode root=new TrieNode();
	
	
	public void addNode(String str,int line_no) {
		char ch= str.charAt(0);
		TrieNode sub;
		if(root.isExist(ch)) {
			 sub=root.getNode(ch);
		}else {
			sub=new TrieNode();
			root.addChild(sub);
		}
		addNode(sub,str,line_no);
	}
	
	public void addNode(TrieNode node, String str,int line_no) {
		if(str.length()<1) return ;
		char ch= str.charAt(0);
		char value=node.getValue();
		if(value==0) {
			node.setValue(ch);
			node.setValue_count(1);
			node.getLine_no().add(line_no);
		}else if(value==ch) {
			node.setValue_count(node.getValue_count()+1);
			if(!node.getLine_no().contains(line_no)) {
				node.getLine_no().add(line_no);
			}
		}else {
			return ;
		}
		if(str.length()==1 ) return;
		boolean exist=node.isExist(str.charAt(1));
		TrieNode sub;
		if(exist) {
			sub=node.getNode(str.charAt(1));
		}else {
			sub=new TrieNode();
			node.addChild(sub);
		}
		addNode(sub,str.substring(1),line_no);
		
	}
	
	public void findCommon(int lineCount) {
		List<StringBuilder> list=new ArrayList<StringBuilder>();
		for(TrieNode node: root.getChild()) {
			if(node.getLine_no().size()==lineCount) {
				StringBuilder sb=new StringBuilder();
				findCommon(node,lineCount,sb);
				list.add(sb);
			}	
		}
		int maxlen=0;
		StringBuilder sbmax=null;
		for(StringBuilder sb:list) {
			if(maxlen<sb.length()) {
				sbmax=sb;
				maxlen=sb.length();
			}
		}
		System.out.println(sbmax.toString());

	}
	public void findCommon(TrieNode node,int lineCount,StringBuilder sb) {
		sb.append(node.getValue());
		for(TrieNode sub:node.getChild()) {
			if(sub.getLine_no().size()==lineCount) {
				findCommon(sub,lineCount,sb);
			}
		}
		
	}
	
	public boolean  search(String str) {
		
		for(TrieNode node: root.getChild()) {
			if(search(node,str))return true;
		}
		return false;
	}
	
	public boolean search(TrieNode node, String str) {
		if(str.length()==1&&node.getValue()==str.charAt(0))return true;
		char value=str.charAt(0);
		if(node.getValue()==value) {
			for(TrieNode child:node.getChild()) {
				boolean result=search(child, str.substring(1));
				if (result) return true;
				
			}
		}
		return false;
	}
	
	public void searchInsuffixTree() {
		SuffixTree trie=new SuffixTree();
		String string="dfasfad";
		for(int i=0;i<string.length();i++) {
			trie.addNode(string.substring(i),0);
		}

       boolean result= trie.search("fas");
       System.out.print(result);
	}

	
	public void findCommon() {
		SuffixTree trie=new SuffixTree();
		String[] str= {"abcde","cdef","ccde"};
		int no=0;
		for(String string:str) {
			for(int i=0;i<string.length();i++) {
				trie.addNode(string.substring(i), no);
			}
			no++;
		}
		trie.findCommon(str.length);
	}
	
	public void findMaxHuiWen() {
		SuffixTree trie=new SuffixTree();
        String str= "banana";
		
        for(int i=0;i<str.length();i++) {
			trie.addNode(str.substring(i),0);
		}
        
        char[] arrays=str.toCharArray();
        int len=arrays.length-1;
        for(int i=0;i<arrays.length/2;i++) {
        	char tem=arrays[i];
        	arrays[i]=arrays[len-i];
        	arrays[len-i]=tem;
        }
        String str2=new String(arrays);
        
        for(int i=0;i<str2.length();i++) {
			trie.addNode(str2.substring(i),1);
		}
        trie.findCommon(2);
        
		
	}
	public static void main(String[] args) {
		SuffixTree trie=new SuffixTree();
		trie.findMaxHuiWen();

		
	}

}
