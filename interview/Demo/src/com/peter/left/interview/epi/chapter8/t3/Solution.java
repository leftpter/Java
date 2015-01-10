package com.peter.left.interview.epi.chapter8.t3;

import com.peter.left.interview.epi.chapter8.t1.Node;

public class Solution
{
	public Node reverseSubList(final Node head, final int start, final int end)
	{
		final Node newHead = new Node(0);
		newHead.next = head;
		
		if (head != null && start < end)
		{
			Node o = newHead;
			for (int i = 0; o != null && i < start; ++i)
			{
				o = o.next;
			}
			
			if (o != null && o.next != null)
			{
				final Node preHead = o;
				final Node newEnd = o.next;
				o = newEnd.next;
				for (int i = 0; o != null && i < end - start; ++i)
				{
					final Node next = o.next;
					o.next = preHead.next;
					preHead.next = o;
					o = next;
				}
				
				newEnd.next = o;
			}
		}
		
		return newHead.next;
	}
}
