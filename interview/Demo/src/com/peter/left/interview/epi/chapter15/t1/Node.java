package com.peter.left.interview.epi.chapter15.t1;

import lombok.ToString;

@ToString
public class Node
{
	public final int value;
	public Node left;
	public Node right;
	
	public Node(final int value)
	{
		this.value = value;
		left = null;
		right = null;
	}
}
