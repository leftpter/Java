package com.peter.left.interview.epi.chapter15.t11;

import com.peter.left.interview.epi.chapter15.t1.Node;

public class Solution
{
	private Node current;
	private Node helper(final int length)
	{
		if (length <= 0 || current == null)
		{
			return null;
		}
		else
		{
			final Node left = helper(length / 2);
			final Node temp = current;
			current = current.right;
			temp.left = left;
			temp.right = helper(length - 1 - length / 2);
			return temp;
		}
	}
	Node convert(final Node head)
	{
		int len = 0;
		for (Node o = head; o != null; o = o.right)
		{
			++len;
		}
		current = head;
		return helper(len);
	}
}
