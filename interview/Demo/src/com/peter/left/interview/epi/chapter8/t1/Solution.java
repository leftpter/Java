package com.peter.left.interview.epi.chapter8.t1;

public class Solution
{
	public Node merge(final Node h1, final Node h2)
	{
		final Node head = new Node(0);
		
		Node o1, o2;
		Node o;
		for (o1 = h1, o2 = h2, o = head; o1 != null && o2 != null; o = o.next)
		{
			if (o1.value <= o2.value)
			{
				o.next = o1;
				o1 = o1.next;
			}
			else
			{
				o.next = o2;
				o2 = o2.next;
			}
		}
		
		o.next = (o1 != null) ? o1 : o2;
		
		return head.next;
	}
}
