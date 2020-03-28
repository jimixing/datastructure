package com.jimmy.data.structure.tree;

import lombok.Data;

@Data
public class ThreadedBinaryTreeNode {
	private ThreadedBinaryTreeNode left;
	private int LTag;
	private int data;
	private int RTag;
	private ThreadedBinaryTreeNode right;
	
	
}
