package com.jimmy.data.structure.graph;

import lombok.Data;

@Data
public class VertexNode {
	
	private char label;
	private boolean visited;
	

	public VertexNode(char label) {
		this.label=label;
		this.visited=false;
	}
	
}
