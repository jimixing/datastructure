package com.jimmy.data.structure.tree;

import lombok.Data;

@Data
public class AVLTreeNode {
	private int height;
	private int data;
	private AVLTreeNode left;
	private AVLTreeNode right;
}
