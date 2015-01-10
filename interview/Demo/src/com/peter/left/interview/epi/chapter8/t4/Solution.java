package com.peter.left.interview.epi.chapter8.t4;

import com.peter.left.interview.epi.chapter8.t1.Node;

public class Solution
{
	Node reverseAll(final Node head, final int length)
	{
		final Node newHead = new Node(0);
		newHead.next = head;
		
		if (head != null && length > 1)
		{
			Node preHead;
			for (preHead = newHead; preHead.next != null && preHead.next.next != null; )
			{
				int i = 1;
				final Node tail = preHead.next;
				Node o;
				for (o = tail.next; o != null && i < length; ++i)
				{
					final Node next = o.next;
					o.next = preHead.next;
					preHead.next = o;
					o = next;
				}
				
				tail.next = o;
				
				if (i < length)
				{
					o = preHead.next;
					preHead.next = null;
					
					while (o != null)
					{
						final Node next = o.next;
						o.next = preHead.next;
						preHead.next = o;
						o = next;
					}
					
					break;
				}
				else
				{
					preHead = tail;
				}
			}
		}
		
		return newHead.next;
	}
}
