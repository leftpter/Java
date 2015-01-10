package com.peter.left.interview.epi.chapter8.t1;

import lombok.ToString;

@ToString
public class Node
{
	public final int value;
	public Node next;
	
	public Node(final int value)
	{
		this.value = value;
		next = null;
	}
	
}
