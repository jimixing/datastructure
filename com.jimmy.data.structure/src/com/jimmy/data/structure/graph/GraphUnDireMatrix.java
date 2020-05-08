package com.jimmy.data.structure.graph;

import com.jimmy.data.structure.queue.ArrayQueue;
import com.jimmy.data.structure.stack.ArrayStack;

public class GraphUnDireMatrix {
	private boolean adjMatrix[][];
	private VertexNode[] vertexNode;
	private int vertex;
	
	public GraphUnDireMatrix(int vertex) {
		this.vertex=vertex;
		this.adjMatrix=new boolean[vertex][vertex];
		this.vertexNode=new VertexNode[vertex];
		for(int i=0;i<vertex;i++) {
			char data=(char)(i+'a');
			VertexNode node=new VertexNode(data);
			vertexNode[i]=node;
			
		}
	}
	
	public void addRelation(char source,char dest) {
		int i=source-'a';
		int j=dest-'a';
		if(i<vertex&&i>=0&&j<vertex&&j>=0) {
			adjMatrix[i][j]=true;
			adjMatrix[j][i]=true;
		}
		
	}
	
	
	public void removeRelation(char source,char dest) {
		int i=source-'a';
		int j=dest-'a';
		if(i<vertex&&i>=0&&j<vertex&&j>=0) {
			adjMatrix[i][j]=false;
			adjMatrix[j][i]=false;
		}
	}
	
	public boolean hasRelation(char source,char dest) {
		int i=source-'a';
		int j=dest-'a';
		if(i<vertex&&i>=0&&j<vertex&&j>=0) {
			return adjMatrix[i][j];
		}
		return false;
	}
	
	public int getNextAdj(int i) {
		for(int j=0;j<vertex;j++) {
			if(adjMatrix[i][j]&&!vertexNode[j].isVisited()) {
				return  j;
			}
		}
		
		return -1;
		
	}
	public void dfs() {
		ArrayStack<Integer> stack=new ArrayStack<Integer>(Integer.class);
		vertexNode[0].setVisited(true);
		System.out.print(vertexNode[0].getLabel()+",");
		stack.push(0);
		while(!stack.isEmpty()) {
				int next=getNextAdj(stack.top());
				if(next==-1) {
					stack.pop();
				}else {
					vertexNode[next].setVisited(true);
					System.out.print(vertexNode[next].getLabel()+",");
					stack.push(next);
				}	
		}
		
		
		for(int i=0;i<vertex;i++) {
			vertexNode[i].setVisited(false);
		}
		
	}

	public void bfs() {
		
		ArrayQueue<Integer> aq=new ArrayQueue<Integer>(Integer.class);
		vertexNode[0].setVisited(true);
		System.out.print(vertexNode[0].getLabel()+",");
		aq.enqueue(0);
		while(!aq.isEmpty()) {	
			int next=aq.dequeue();
			int tem;
			while((tem=getNextAdj(next))!=-1) {
				vertexNode[tem].setVisited(true);
				System.out.print(vertexNode[tem].getLabel()+",");
				aq.enqueue(tem);
			}
			
		}
		for(int i=0;i<vertex;i++) {
			vertexNode[i].setVisited(false);
		}
		
		
	}
	
	
	
	public static void main(String[] args) {

		GraphUnDireMatrix gm=new GraphUnDireMatrix(8);
		gm.addRelation('a', 'b');
		gm.addRelation('b', 'c');
		gm.addRelation('b', 'h');
		gm.addRelation('c', 'd');
		gm.addRelation('c', 'e');
		gm.addRelation('e', 'h');
		gm.addRelation('e', 'f');
		gm.addRelation('e', 'g');

		
		gm.bfs();

	}

}
