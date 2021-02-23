package com.jimmy.data.structure.string;

import lombok.Data;

@Data
public class TripleSearchNode {
	
	private char data;
	private boolean isEndofStr;
	
	private TripleSearchNode left;
	private TripleSearchNode eq;
	private TripleSearchNode right;
	public char getData() {
		return data;
	}
	public void setData(char data) {
		this.data = data;
	}
	public boolean isEndofStr() {
		return isEndofStr;
	}
	public void setEndofStr(boolean isEndofStr) {
		this.isEndofStr = isEndofStr;
	}
	public TripleSearchNode getLeft() {
		return left;
	}
	public void setLeft(TripleSearchNode left) {
		this.left = left;
	}
	public TripleSearchNode getEq() {
		return eq;
	}
	public void setEq(TripleSearchNode eq) {
		this.eq = eq;
	}
	public TripleSearchNode getRight() {
		return right;
	}
	public void setRight(TripleSearchNode right) {
		this.right = right;
	}
	

	
}
