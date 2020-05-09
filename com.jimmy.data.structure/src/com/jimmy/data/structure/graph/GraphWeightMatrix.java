package com.jimmy.data.structure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import com.jimmy.data.structure.heap.Heap;
import com.jimmy.data.structure.queue.ArrayQueue;

public class GraphWeightMatrix {

	private int adjMatrix[][];
	private VertexNode[] vertexNode;
	private int vertex;
	
	public GraphWeightMatrix(int vertex) {
		this.vertex=vertex;
		this.adjMatrix=new int[vertex][vertex];
		this.vertexNode=new VertexNode[vertex];
		for(int i=0;i<vertex;i++) {
			char data=(char)(i+'a');
			VertexNode node=new VertexNode(data);
			vertexNode[i]=node;
		}
	}
	
	public void addRelation(char source,char dest,int weight) {
		int i=source-'a';
		int j=dest-'a';
		if(i<vertex&&i>=0&&j<vertex&&j>=0) {
			adjMatrix[i][j]=weight;
		}
		
	}
	
	public void removeRelation(char source,char dest) {
		int i=source-'a';
		int j=dest-'a';
		if(i<vertex&&i>=0&&j<vertex&&j>=0) {
			adjMatrix[i][j]=0;
		}
	}
	
	public boolean hasRelation(char source,char dest) {
		int i=source-'a';
		int j=dest-'a';
		if(i<vertex&&i>=0&&j<vertex&&j>=0) {
			return adjMatrix[i][j]>0;
		}
		return false;
	}
	
	public int getNextAdj(int i) {
		for(int j=0;j<vertex;j++) {
			if(adjMatrix[i][j]>0&&!vertexNode[j].isVisited()) {
				return  j;
			}
		}
		return -1;
		
	}
	public int getNextAdj2(int i) {
		for(int j=0;j<vertex;j++) {
			if(adjMatrix[i][j]>0&&!vertexNode[j].isVisited()) {
				return  j;
			}
		}
		return -1;
		
	}
	public int outDegree(char source) {
		int j=source-'a';
		int sum=0;
		if(j<vertex&&j>=0) {
			for(int i=0;i<vertex;i++) {
				if(adjMatrix[j][i]>0) {
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
				if(adjMatrix[i][j]>0) {
					sum++;
				}
			}

		}
		return sum;
	}
	
	public void Dijkstra(char s) {
		
		for(VertexNode node :vertexNode ) {
			node.setPath(-1);
		}
		int pos=s-'a';
		PriorityQueue<VertexNode> pq=new PriorityQueue<VertexNode>();
	
		pq.add(vertexNode[pos]);
		while(!pq.isEmpty()) {
			VertexNode next=pq.poll();
			vertexNode[next.getLabel()-'a'].setVisited(true);
			int tem;
			ArrayList<Integer> list=new ArrayList<Integer>();
			
			while((tem=getNextAdj(next.getLabel()-'a'))!=-1) {
				vertexNode[tem].setVisited(true);
				list.add(tem);
				if((next.getLabel()-'a')!=pos) {
					int newDis=next.getPath()+adjMatrix[next.getLabel()-'a'][tem];
					if(vertexNode[tem].getPath()==-1) {
						vertexNode[tem].setPath(newDis);
					}else {
						if(vertexNode[tem].getPath()>newDis) {
							vertexNode[tem].setPath(newDis);
						}
					}
				}else {
					if(vertexNode[tem].getPath()==-1) {
						vertexNode[tem].setPath(adjMatrix[next.getLabel()-'a'][tem]);
					}
				}
				
				pq.add(vertexNode[tem]);
			}
			for(Integer i:list ) {
				vertexNode[i].setVisited(false);
				
			}
			
		}
		vertexNode[pos].setPath(0);
		for(VertexNode node : vertexNode) {
			System.out.print(node.getPath()+",");

		}
	}
	
	
	
	public static void main(String[] args) {
		GraphWeightMatrix gm=new GraphWeightMatrix(5);
		gm.addRelation('a', 'b',4);
		gm.addRelation('a', 'c',1);
		gm.addRelation('c', 'b',2);
		gm.addRelation('b', 'e',4);
		gm.addRelation('c', 'd',4);
		gm.addRelation('b', 'e',4);
		gm.addRelation('d', 'e',4);
		gm.Dijkstra('a');

	}

}
