package com.jimmy.data.structure.string;

public class SuffexTree extends TripleSearchTree {

	public TripleSearchNode insert(String str) {
		
		TripleSearchNode root=insert(null,str,0);
		
		for(int i=1;i<str.length();i++) {
			 String sub=str.substring(i);
			 insert(root,sub,0);
		}
		return root;
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SuffexTree st=new SuffexTree();
		TripleSearchNode root=st.insert("bananas");
		boolean res=st.search(root, "ana", 0);
		System.out.print(res);
		
	}

}
