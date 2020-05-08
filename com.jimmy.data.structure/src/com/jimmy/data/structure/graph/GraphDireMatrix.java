package com.jimmy.data.structure.graph;

import com.jimmy.data.structure.queue.ArrayQueue;
import com.jimmy.data.structure.stack.ArrayStack;

public class GraphDireMatrix {
	private boolean adjMatrix[][];
	private VertexNode[] vertexNode;
	private int vertex;
	
	public GraphDireMatrix(int vertex) {
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
		}
		
	}

	public void removeRelation(char source,char dest) {
		int i=source-'a';
		int j=dest-'a';
		if(i<vertex&&i>=0&&j<vertex&&j>=0) {
			adjMatrix[i][j]=false;
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
	
	public int outDegree(char source) {
		int j=source-'a';
		int sum=0;
		if(j<vertex&&j>=0) {
			for(int i=0;i<vertex;i++) {
				if(adjMatrix[j][i]) {
					sum++;
				}
			}
		}
		return  sum;

	}
	
	public int inDegree(char source) {
		int j=source-'a';
		int sum=0;
		if(j<vertex&&j>=0) {
			for(int i=0;i<vertex;i++) {
				if(adjMatrix[i][j]) {
					sum++;
				}
			}

		}
		return sum;
	}
	
	
	public void topuSort() {
		boolean adjMatrix2[][]=new boolean[vertex][vertex];
		for(int i=0;i<vertex;i++) {
			System.arraycopy(adjMatrix[i], 0, adjMatrix2[i], 0, vertex);
		}
		
		ArrayQueue<Integer> aq=new ArrayQueue<Integer>(Integer.class);
		
		for(int i=0;i<vertex;i++) {
			int indegree=inDegree(vertexNode[i].getLabel());
			if(indegree==0) {
				vertexNode[i].setVisited(true);
				aq.enqueue(i);
				break;
			}
		}
		
		while(!aq.isEmpty()) {
			int i=aq.dequeue();
			System.out.print(vertexNode[i].getLabel()+",");
			for(int j=0;j<vertex;j++){ 
				removeRelation((char)(i+'a'),(char)(j+'a'));
				int ind=inDegree(vertexNode[j].getLabel());
				if(ind==0&&!vertexNode[j].isVisited()) {
					vertexNode[j].setVisited(true);
					aq.enqueue(j);
				}
			}	
		}
		for(int i=0;i<vertex;i++) {
			System.arraycopy(adjMatrix2[i], 0, adjMatrix[i], 0, vertex);
		}
		System.out.println();
		for(int i=0;i<vertex;i++) {
			vertexNode[i].setVisited(false);
		}
		dfs();
	}
	
	
	
	public static void main(String[] args) {
		
		GraphDireMatrix gm=new GraphDireMatrix(8);
		gm.addRelation('a', 'd');
		gm.addRelation('a', 'e');
		gm.addRelation('b', 'd');
		gm.addRelation('c', 'e');
		gm.addRelation('d', 'f');
		gm.addRelation('d', 'g');
		gm.addRelation('d', 'h');
		gm.addRelation('e', 'g');
		gm.topuSort();

	}

}
