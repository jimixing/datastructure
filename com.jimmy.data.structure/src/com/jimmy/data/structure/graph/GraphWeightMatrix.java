package com.jimmy.data.structure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import com.jimmy.data.structure.heap.Heap;
import com.jimmy.data.structure.queue.ArrayQueue;

import lombok.Data;

public class GraphWeightMatrix {

	private int adjMatrix[][];
	private VertexNode[] vertexNode;
	private int vertex;
	private ArrayList<EdgeAndWeight> edgeweightList=new ArrayList<EdgeAndWeight>();
	
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
	
	public void addUnRelation(char source,char dest,int weight) {
		int i=source-'a';
		int j=dest-'a';
		if(i<vertex&&i>=0&&j<vertex&&j>=0) {
			adjMatrix[i][j]=weight;
			adjMatrix[j][i]=weight;
			EdgeAndWeight eaw=new EdgeAndWeight();
			eaw.setSource(i);
			eaw.setDest(j);
			eaw.setWeight(weight);
			edgeweightList.add(eaw);
		}
		
	}
	
	
	public void removeRelation(char source,char dest) {
		int i=source-'a';
		int j=dest-'a';
		if(i<vertex&&i>=0&&j<vertex&&j>=0) {
			adjMatrix[i][j]=0;
		}
	}
	
	public void removeUnRelation(char source,char dest) {
		int i=source-'a';
		int j=dest-'a';
		if(i<vertex&&i>=0&&j<vertex&&j>=0) {
			adjMatrix[i][j]=0;
			adjMatrix[j][i]=0;
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
	
	
	public void prim(char s) {
		ArrayList<VertexNode>  res=new ArrayList<VertexNode>();
		for(VertexNode node :vertexNode ) {
			node.setPath(-1);
		}
		int pos=s-'a';
		PriorityQueue<VertexNode> pq=new PriorityQueue<VertexNode>();
	
		pq.add(vertexNode[pos]);
		while(!pq.isEmpty()) {
			VertexNode next=pq.poll();
			vertexNode[next.getLabel()-'a'].setVisited(true);
			if(res.indexOf(next)<0) {
				res.add(next);
			}
			
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
		for(VertexNode node : res) {
			System.out.print(node.getLabel()+",");

		}
		
	}
	
	private int getend(int[] ends, int i) {
		while(ends[i]!=0) {
			i=ends[i];
		}
		return i;
	}
	
	public void kruskal() {
		
		int[] vender=new int[edgeweightList.size()];
		Collections.sort(edgeweightList);
		List<EdgeAndWeight> res=new ArrayList<EdgeAndWeight>();
	 //   System.out.print(edgeweightList.get(0).getWeight());
	    for(EdgeAndWeight edge:edgeweightList) {
	    	int m=getend(vender,edge.getSource());
	    	int n=getend(vender,edge.getDest());
	    	if(m!=n) {
	    		vender[m]=n;
	    		res.add(edge);
	    	}
	    	
	    }
	    System.out.print(res.toString());
	    
	    
	}
	
	
	
	@Data
	public class EdgeAndWeight implements Comparable<EdgeAndWeight>{
		private int source;
		private int dest;
		private int weight;
		@Override
		public int compareTo(EdgeAndWeight arg0) {
			// TODO Auto-generated method stub
			return this.weight>arg0.getWeight()?1:-1;
		}
		
		public String toString() {
			return "<"+(char)(source+'a')+","+(char)(dest+'a')+">";
		}
	}
	
	
	public static void main(String[] args) {
		GraphWeightMatrix gm=new GraphWeightMatrix(7);
		gm.addUnRelation('a', 'b', 12);
		gm.addUnRelation('b', 'c', 10);
		gm.addUnRelation('a', 'g', 14);
		gm.addUnRelation('a', 'f', 16);
		gm.addUnRelation('b', 'f', 7);
		gm.addUnRelation('g', 'f', 9);
		gm.addUnRelation('f', 'e', 2);
		gm.addUnRelation('f', 'c', 6);
		gm.addUnRelation('c', 'e', 5);
		gm.addUnRelation('c', 'd', 3);
		gm.addUnRelation('e', 'd', 4);


		
//		gm.addRelation('a', 'b',4);
//		gm.addRelation('a', 'c',1);
//		gm.addRelation('c', 'a',1);
//
//		gm.addRelation('c', 'b',2);
//		gm.addRelation('b', 'e',4);
//		gm.addRelation('c', 'd',4);
//		gm.addRelation('b', 'e',4);
//		gm.addRelation('d', 'e',4);
		gm.kruskal();

	}

}
