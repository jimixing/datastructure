package com.jimmy.data.structure.string;

import lombok.Data;

@Data
public class TripleSearchNode {
	
	private char data;
	private boolean isEndofStr;
	
	private TripleSearchNode left;
	private TripleSearchNode eq;
	private TripleSearchNode right;
	

}
