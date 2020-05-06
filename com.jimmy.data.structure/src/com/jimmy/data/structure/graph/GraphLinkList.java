package com.jimmy.data.structure.graph;

public class GraphLinkList {

	private int vertex;
	private GraphListNode[] vertexArray;
	
	public GraphLinkList(int vertex) {
		this.vertex=vertex;
		vertexArray=new GraphListNode[vertex];
		for(int i=0;i<vertex;i++) {
			GraphListNode node=new GraphListNode();
			node.setData(i);
			vertexArray[i]=node;
		}
		
	}
	
	
	public void addRelation(int i, int j) {
		if(i<0||i>=vertex||j<=0||j>=vertex) {
			return ;
		}
		GraphListNode head=vertexArray[i];
		GraphListNode tem=head.getNext();
		while(tem!=null) {
			if(tem.getData()==j) {
				return ;
			}
			head=tem;
			tem=tem.getNext();
		}
		GraphListNode node=new GraphListNode();
		node.setData(j);
		head.setNext(node);
	}
	
	
	public void removeRelation(int i,int j) {
		if(i<0||i>=vertex||j<=0||j>=vertex) {
			return ;
		}
		GraphListNode head=vertexArray[i];
		GraphListNode tem=head.getNext();
		while(tem!=null) {
			if(tem.getData()==j) {
				head.setNext(tem.getNext());
				return ;
			}
			head=tem;
			tem=tem.getNext();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
