package com.jimmy.data.structure.graph;

public class GraphMatrix {
	private boolean adjMatrix[][];
	private int vertex;
	
	public GraphMatrix(int vertex) {
		this.vertex=vertex;
		this.adjMatrix=new boolean[vertex][vertex];
	}
	
	public void addRelation(int i,int j) {
		if(i<vertex&&i>=0&&j<vertex&&j>=0) {
			adjMatrix[i][j]=true;
			adjMatrix[j][i]=true;
		}
		
	}
	
	public void removeRelation(int i,int j) {
		if(i<vertex&&i>=0&&j<vertex&&j>=0) {
			adjMatrix[i][j]=false;
			adjMatrix[j][i]=false;
		}
	}
	
	public boolean hasRelation(int i,int j) {
		if(i<vertex&&i>=0&&j<vertex&&j>=0) {
			return adjMatrix[i][j];
		}
		return false;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
