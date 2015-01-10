package com.peter.left.interview.epi.chapter8.t18;

import com.peter.left.interview.epi.chapter8.t1.Node;

public class InsertionSolution
{
	Node sort(final Node head)
	{
		final Node newHead = new Node(0);
		newHead.next = head;
		
		if (head != null && head.next != null)
		{
			Node o = head.next;
			head.next = null;
			while (o != null)
			{
				final Node next = o.next;
				final Node insert = o;
				Node item;
				for (item = newHead;
						item.next != null && insert.value >= item.next.value;
						item = item.next)
				{
					
				}
				
				insert.next = item.next;
				item.next = insert;
				
				o = next;
			}
		}
		
		return newHead.next;
	}
}
