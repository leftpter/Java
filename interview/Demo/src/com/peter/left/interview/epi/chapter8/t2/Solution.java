package com.peter.left.interview.epi.chapter8.t2;

import com.peter.left.interview.epi.chapter8.t1.Node;

public class Solution
{
	public Node reverse(final Node head)
	{
		final Node newHead = new Node(0);
		for (Node next = head; next != null; )
		{
			final Node temp = next.next;
			next.next = newHead.next;
			newHead.next = next;
			next = temp;
		}
		
		return newHead.next;
	}
}
