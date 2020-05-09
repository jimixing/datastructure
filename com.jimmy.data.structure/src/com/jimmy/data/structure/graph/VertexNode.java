package com.jimmy.data.structure.graph;

import lombok.Data;

@Data
public class VertexNode implements Comparable<VertexNode> {
	
	private char label;
	private boolean visited;
	private int path;
	

	public VertexNode(char label) {
		this.label=label;
		this.visited=false;
	}


	@Override
	public int compareTo(VertexNode arg0) {
		// TODO Auto-generated method stub
		return this.path>arg0.path?1:-1;
	}
	
}
