package com.peter.left.interview.epi.chapter8.t9;

import com.peter.left.interview.epi.chapter8.t1.Node;

public class Solution
{
	Node remove(final Node head, final int index)
	{
		final Node newHead = new Node(0);
		newHead.next = head;
		
		if (index >= 1)
		{
			Node front = head;
			for (int i = 1; i < index && front != null; ++i)
			{
				front = front.next;
			}
			
			if (front != null)
			{
				Node end = newHead;
				for (; front.next != null; front = front.next)
				{
					end = end.next;
				}
				
				end.next = end.next.next;
			}
		}
		
		return newHead.next;
	}
}
