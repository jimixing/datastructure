package com.jimmy.data.structure.string;

import java.util.ArrayList;
import java.util.List;

public class Trie {

	public class TrieNode{
		private char value;
		private int value_count;
		private List<TrieNode> children=new ArrayList<TrieNode>();
		
		public TrieNode() {
			
		}
		public TrieNode(char ch) {
			this.value=ch;
		}
		
		public char getValue() {
			return value;
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
	
	
	public void addNode(String str) {
		char ch= str.charAt(0);
		TrieNode sub;
		if(root.isExist(ch)) {
			 sub=root.getNode(ch);
		}else {
			sub=new TrieNode();
			root.addChild(sub);
		}
		addNode(sub,str);
	}
	
	public void addNode(TrieNode node, String str) {
		if(str.length()<1) return ;
		char ch= str.charAt(0);
		char value=node.getValue();
		if(value==0) {
			node.setValue(ch);
			node.setValue_count(1);
		}else if(value==ch) {
			node.setValue_count(node.getValue_count()+1);
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
		addNode(sub,str.substring(1));
		
	}

	public boolean  search(String str) {
		
		for(TrieNode node: root.getChild()) {
			if(search(node,str))return true;
		}
		return false;
	}
	
	public boolean search(TrieNode node, String str) {
		if(str.length()==1&&node.getValue()==str.charAt(0)&&node.getCount()==0)return true;
		char value=str.charAt(0);
		if(node.getValue()==value) {
			for(TrieNode child:node.getChild()) {
				boolean result=search(child, str.substring(1));
				if (result) return true;
				
			}
		}
		return false;
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie trie=new Trie();
		String[] str= {"abcrfd","abcdef","bbdtg"};
       for( String string:str) {
    	   trie.addNode(string);
       }
        
       boolean result= trie.search("bbdtgr");
       System.out.print(result);
	}

}
