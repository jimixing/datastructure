package com.jimmy.data.structure.graph;

import com.jimmy.data.structure.queue.ArrayQueue;
import com.jimmy.data.structure.stack.ArrayStack;

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
	
	private int getNextAdj(int i) {
		
		GraphListNode head=vertexArray[i];
		GraphListNode next=head.getNext();
		
		while(next!=null) {

			if(next.isVisited()||vertexArray[next.getData()].isVisited()) {
				next=next.getNext();
			}else {
				next.setVisited(true);
				return next.getData();
			}
			
		}
		return -1;
		
	}
	
	public void dfs() {
		ArrayStack<Integer> stack=new ArrayStack<Integer>(Integer.class);
		vertexArray[0].setVisited(true);
		System.out.print(vertexArray[0].getData()+",");
		stack.push(0);
		while(!stack.isEmpty()) {
			int next=getNextAdj(stack.top());
			if(next==-1) {
				stack.pop();
			}else {
				vertexArray[next].setVisited(true);
				System.out.print(vertexArray[next].getData()+",");
				stack.push(next);
			}
			
			
		}
		
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
	
	public void bfs() {
		ArrayQueue<Integer> aq=new ArrayQueue<Integer>(Integer.class);
		vertexArray[0].setVisited(true);
		System.out.print(vertexArray[0].getData()+",");
		aq.enqueue(0);
		while(!aq.isEmpty()) {
			int next=aq.dequeue();
			int tem;
			while((tem=getNextAdj(next))!=-1){
				vertexArray[tem].setVisited(true);
				System.out.print(vertexArray[tem].getData()+",");
				aq.enqueue(tem);
			}
			
		}
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphLinkList graphlist=new GraphLinkList(4);
		graphlist.addRelation(0, 1);
		graphlist.addRelation(0, 3);
		graphlist.addRelation(1, 2);
		graphlist.addRelation(2, 1);
		graphlist.addRelation(2, 3);
		graphlist.bfs();
	}

}
