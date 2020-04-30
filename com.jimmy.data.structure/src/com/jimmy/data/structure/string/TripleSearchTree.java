package com.jimmy.data.structure.string;

public class TripleSearchTree {
	
	
	
	public TripleSearchNode insert(TripleSearchNode root, String word,int pos) {
		if(root==null) {
			root=new TripleSearchNode();
			root.setData(word.charAt(pos));
			if(word.length()-1==pos) {
				root.setEndofStr(true);
				return root;
			}
			root.setEq(insert(root.getEq(),word,pos+1));
		}else {
			if(root.getData()>word.charAt(pos)) {
				root.setLeft(insert(root.getLeft(),word,pos));
			}else if(root.getData()<word.charAt(pos)){
				root.setRight(insert(root.getRight(),word,pos));
			}else {
				root.setEq(insert(root.getEq(),word,pos+1));
			}
		}
		return root;
	}
	
	public boolean search(TripleSearchNode root, String word,int pos) {
		if(root==null) {
			return false;
		}

		if(root.getData()>word.charAt(pos)) {
			return search(root.getLeft(),word,pos);
		}else if(root.getData()<word.charAt(pos)) {
			return search(root.getRight(), word,pos);
		}else if(root.getData()==word.charAt(pos)) {
			if(pos==word.length()-1) {
				return true;
			}
			return search(root.getEq(),word,pos+1);
		}
		return false;
	}
	
	
//	public void print(TripleSearchNode root) {
//		if(root==null) return ;
//		print(root.getLeft());
//		
//	}
	
	public int maxLengthofWord(TripleSearchNode root) {
		if(root==null) return 0;
		int leftLen=maxLengthofWord(root.getLeft());
		int middLen=maxLengthofWord(root.getEq())+1;
		int right=maxLengthofWord(root.getRight());
		if(leftLen>middLen) {
			return leftLen>right?leftLen:right;
		}else {
			return middLen>right?middLen:right;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		TripleSearchTree tst=new TripleSearchTree();
		TripleSearchNode root=tst.insert(null, "bat", 0);
		tst.insert(root, "boat",0);
		tst.insert(root, "boats", 0);
		
		//boolean res=tst.search(root,"boatsd",0);
		int max=tst.maxLengthofWord(root);
		System.out.print(max);

	}

}
